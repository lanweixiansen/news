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


public class HistoryViewModel extends AndroidViewModel {
  private static final String TAG = HistoryViewModel.class.getSimpleName();
  private NewsRepository mRepository;

  public HistoryViewModel(@NonNull Application application) {
    super(application);
    mRepository = new NewsRepository(application);
  }

  public LiveData<List<News>> getAllNews(){
    return mRepository.getAllWordsLive();
  }

  public void deleteAllNews(){
    mRepository.deleteAllNews();
  }






}
