package com.example.stocknews.Repository;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.stocknews.Bean.News;
import com.example.stocknews.Interface.NewsDao;

import java.util.List;

public class NewsRepository {
  private LiveData<List<News>> newsLive;
  private NewsDao mNewsDao;

  public NewsRepository(Context context) {
    NewsDatabase wordDatabase = NewsDatabase.getInstance(context);
    mNewsDao = wordDatabase.getNewsDao();
    newsLive = mNewsDao.getAllNewsLive();
  }

  //插入内容
  public void insertNews(News...news){
    new InsertAsyncTask(mNewsDao).execute(news);
  }

  //删除全部
  public void deleteAllNews(News...news){
    new DeleteAsyncTask(mNewsDao).execute();
  }

  //读取全部
  public LiveData<List<News>> getAllWordsLive() {
    return newsLive;
  }

  //查询
  public LiveData<List<News>> getNews(String title1){
    return mNewsDao.getNew(title1);
  }

  //插入内容
  static class InsertAsyncTask extends AsyncTask<News,Void,Void>{
    private NewsDao mNewsDao;
    public InsertAsyncTask(NewsDao newsDao){
      this.mNewsDao = newsDao;
    }

    @Override
    protected Void doInBackground(News... news) {
      mNewsDao.insertNews(news);
      return null;
    }
  }

  //删除内容
  static class DeleteAsyncTask extends AsyncTask<Void,Void,Void>{
    private NewsDao mNewsDao;

    public DeleteAsyncTask(NewsDao wordDao) {
      this.mNewsDao = wordDao;
    }

    @Override
    protected Void doInBackground(Void... news) {
      mNewsDao.deleteAllWords();
      return null;
    }
  }

}
