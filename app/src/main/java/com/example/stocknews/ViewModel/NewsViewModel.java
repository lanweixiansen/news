package com.example.stocknews.ViewModel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.stocknews.Bean.News;
import com.example.stocknews.Bean.NewsBean;
import com.example.stocknews.Repository.NewsRepository;
import com.example.stocknews.Repository.Repository;

import java.util.List;

import cn.leancloud.AVObject;
import cn.leancloud.AVQuery;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class NewsViewModel extends AndroidViewModel {
  private static final String TAG = NewsViewModel.class.getSimpleName();
  private MutableLiveData<List<AVObject>> mNewsData;
  private final NewsRepository mRepository;

  public NewsViewModel(@NonNull Application application) {
    super(application);
    mRepository = new NewsRepository(application);
  }

  public MutableLiveData<List<AVObject>> getNewsData() {
    if (mNewsData == null){
      mNewsData = new MutableLiveData<>();
    }
    return mNewsData;
  }

  public void requestData() {
    AVQuery<AVObject> avQuery = new AVQuery<>("news2");
    avQuery.whereEqualTo("article_type", "抗肺炎");
    avQuery.findInBackground().subscribe(new Observer<List<AVObject>>() {
      @Override
      public void onSubscribe(@io.reactivex.annotations.NonNull Disposable d) {}

      @Override
      public void onNext(@io.reactivex.annotations.NonNull List<AVObject> avObjects) {
        mNewsData.setValue(avObjects);
        Log.d(TAG,"success------->" + avObjects.toString());
        Log.d(TAG,"success------->" + avObjects.size());
      }

      @Override
      public void onError(@io.reactivex.annotations.NonNull Throwable e) {

      }

      @Override
      public void onComplete() {}
    });
  }

  public LiveData<List<News>> getNews(String Msg){
    return mRepository.getNews(Msg);
  }

}
