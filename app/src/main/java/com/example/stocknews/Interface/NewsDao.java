package com.example.stocknews.Interface;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.stocknews.Bean.News;

import java.util.List;

@Dao
public interface NewsDao {

  @Insert
  void insertNews(News... news);


  @Query("SELECT * FROM NEWS WHERE newsID = :title1")
  LiveData<List<News>> getNew(String title1);

  @Query("SELECT * FROM NEWS ORDER BY ID DESC")
//        List<Word> getAllWords();
  LiveData<List<News>> getAllNewsLive();//获取数据库中的数据

  @Query("DELETE FROM NEWS")
  void deleteAllWords();



}
