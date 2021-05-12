package com.example.stocknews.adapter;

import com.example.stocknews.Tools.ConnUrls;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitManger {


  private static final Retrofit retrofit = new Retrofit.Builder()
          .baseUrl(ConnUrls.CONTENT)
          .addConverterFactory(GsonConverterFactory.create())
          .build();

  public static Retrofit getRetrofit(){
    return retrofit;
  }


  private static final Retrofit retrofit2 = new Retrofit.Builder()
          .baseUrl(ConnUrls.YIQING)
          .addConverterFactory(GsonConverterFactory.create())
          .build();

  public static Retrofit getRetrofit2(){
    return retrofit2;
  }



}
