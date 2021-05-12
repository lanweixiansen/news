package com.example.stocknews.Repository;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.stocknews.Bean.News;
import com.example.stocknews.Interface.NewsDao;
import com.google.protobuf.compiler.PluginProtos;

@Database(entities = {News.class}, version = 2, exportSchema = false)
public abstract class NewsDatabase extends RoomDatabase {
  private static NewsDatabase INSTANCE;

  static synchronized NewsDatabase getInstance(Context context){
    if (INSTANCE == null){
      INSTANCE = Room.databaseBuilder(context, NewsDatabase.class, "news_dataBase")
              .fallbackToDestructiveMigration()
              .build();
    }
    return INSTANCE;
  }

  public abstract NewsDao getNewsDao();






}
