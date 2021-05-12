package com.example.stocknews.ViewModel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.stocknews.Bean.News;
import com.example.stocknews.Repository.NewsRepository;

import java.util.List;

import cn.leancloud.AVObject;
import cn.leancloud.AVQuery;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class TechnologyViewModel extends AndroidViewModel {
  MutableLiveData<List<AVObject>> mLiveData;
  private final NewsRepository mRepository;

  public TechnologyViewModel(@NonNull Application application) {
    super(application);
    mRepository = new NewsRepository(application);
  }

  public MutableLiveData<List<AVObject>> getLiveData() {
    if (mLiveData == null){
      mLiveData = new MutableLiveData<>();
    }
    return mLiveData;
  }

  public void requestData(){
    AVQuery<AVObject> avQuery = new AVQuery<>("news2");
    avQuery.whereStartsWith("article_type", "科技");
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

  public LiveData<List<News>> getNews(String Msg){
    return mRepository.getNews(Msg);
  }

}
