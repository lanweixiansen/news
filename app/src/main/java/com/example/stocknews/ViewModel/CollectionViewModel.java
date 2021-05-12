package com.example.stocknews.ViewModel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import cn.leancloud.AVObject;
import cn.leancloud.AVQuery;
import cn.leancloud.AVUser;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class CollectionViewModel extends AndroidViewModel {

  private static final String TAG = CollectionViewModel.class.getSimpleName();
  private MutableLiveData<List<AVObject>> mLiveData;
  private final List<AVObject> mData = new ArrayList<>();
  private final List<AVObject> mData2 = new ArrayList<>();

  public CollectionViewModel(@NonNull Application application) {
    super(application);
  }

  public MutableLiveData<List<AVObject>> getLiveData() {
    if (mLiveData == null){
      mLiveData = new MutableLiveData<>();
    }
    return mLiveData;
  }

  //获取收藏文章信息
  public void requestData(){
    //首先通过收藏信息获取文章id
    AVQuery<AVObject> avQuery = new AVQuery<>("NewsInfo");
    avQuery.whereEqualTo("user", AVUser.getCurrentUser());
    avQuery.whereEqualTo("collection", "1");
    avQuery.findInBackground().subscribe(new Observer<List<AVObject>>() {
      @Override
      public void onSubscribe(@io.reactivex.annotations.NonNull Disposable d) {}

      @Override
      public void onNext(@io.reactivex.annotations.NonNull List<AVObject> avObjects) {
        mData.addAll(avObjects);
        //获取文章id之后通过id查询文章
        for (int i=0 ; i<mData.size() ; i++){
          AVQuery<AVObject> avQuery1 = new AVQuery<>("news2");
          avQuery1.whereEqualTo("objectId", mData.get(i).getServerData().get("newsObject"));
          avQuery1.findInBackground().subscribe(new Observer<List<AVObject>>() {
            @Override
            public void onSubscribe(@io.reactivex.annotations.NonNull Disposable d) {}

            @Override
            public void onNext(@io.reactivex.annotations.NonNull List<AVObject> avObjects) {
              mData2.addAll(avObjects);
              mLiveData.setValue(mData2);
            }

            @Override
            public void onError(@io.reactivex.annotations.NonNull Throwable e) {}

            @Override
            public void onComplete() {}
          });
        }
      }

      @Override
      public void onError(@io.reactivex.annotations.NonNull Throwable e) {}

      @Override
      public void onComplete() {}
    });
  }

  //清空收藏文章
  public void deleteAllNews(){

      new Thread(new Runnable() {
        @Override
        public void run() {
          for (int i=0 ; i<mData.size(); i++) {
            AVObject todo = AVObject.createWithoutData("NewsInfo", mData.get(i).getObjectId());
            todo.put("collection", "0");
            todo.save();
          }
        }
      }).start();
  }

}
