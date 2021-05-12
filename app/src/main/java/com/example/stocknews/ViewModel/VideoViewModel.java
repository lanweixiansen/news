package com.example.stocknews.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import com.example.stocknews.Bean.VideoBean;
import com.example.stocknews.Repository.Repository;
import com.example.stocknews.Tools.ToastUtil;

import java.util.List;

import cn.leancloud.AVObject;
import cn.leancloud.AVQuery;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class VideoViewModel extends AndroidViewModel {
  private MutableLiveData<List<AVObject>> mLiveData;

  public VideoViewModel(@NonNull Application application) {
    super(application);
  }

  public MutableLiveData<List<AVObject>> getLiveData() {
    if (mLiveData == null){
      mLiveData = new MutableLiveData<>();
    }
    return mLiveData;
  }

  public void requestData(){
    AVQuery<AVObject> avQuery = new AVQuery<>("VideoInfo");
    avQuery.findInBackground().subscribe(new Observer<List<AVObject>>() {
      @Override
      public void onSubscribe(@io.reactivex.annotations.NonNull Disposable d) {}

      @Override
      public void onNext(@io.reactivex.annotations.NonNull List<AVObject> avObjects) {
        mLiveData.setValue(avObjects);
      }

      @Override
      public void onError(@io.reactivex.annotations.NonNull Throwable e) {
        ToastUtil.showMessage(getApplication(), "数据获取失败！");
      }

      @Override
      public void onComplete() {}
    });
  }


}
