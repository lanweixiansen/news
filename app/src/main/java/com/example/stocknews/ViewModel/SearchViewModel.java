package com.example.stocknews.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import cn.leancloud.AVObject;
import cn.leancloud.AVQuery;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class SearchViewModel extends AndroidViewModel {
  MutableLiveData<List<AVObject>> mLiveData;

  public SearchViewModel(@NonNull Application application) {
    super(application);
  }

  public MutableLiveData<List<AVObject>> getLiveData() {
    if (mLiveData == null){
      mLiveData = new MutableLiveData<>();
    }
    return mLiveData;
  }

  public void requestData(String Msg){
    AVQuery<AVObject> avQuery = new AVQuery<>("news2");
    avQuery.whereStartsWith("article_title", Msg);
    avQuery.findInBackground().subscribe(new Observer<List<AVObject>>() {
      @Override
      public void onSubscribe(@io.reactivex.annotations.NonNull Disposable d) {

      }

      @Override
      public void onNext(@io.reactivex.annotations.NonNull List<AVObject> avObjects) {
        mLiveData.setValue(avObjects);
      }

      @Override
      public void onError(@io.reactivex.annotations.NonNull Throwable e) {

      }

      @Override
      public void onComplete() {

      }
    });
  }


}
