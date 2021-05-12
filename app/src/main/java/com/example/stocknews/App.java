package com.example.stocknews;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import java.sql.Struct;

import cn.leancloud.AVOSCloud;
import cn.leancloud.AVObject;

public class App extends Application {
  private static SharedPreferences spUtils;
  private static Context mContext;


  public static Context getContext() {
    return mContext;
  }

  @Override
  public void onCreate() {
    super.onCreate();
    mContext = getApplicationContext();
    //LineCloud初始化
    AVOSCloud.initialize(this,
            "dDlqrHpTCHacC9SuFrqiAqGK-gzGzoHsz",
            "oynmByChVOY8MzQJ5EI9A7o0",
            "https://ddlqrhpt.lc-cn-n1-shared.com");

    //数据保存
    spUtils = getSharedPreferences("FIRST_OPEN", MODE_PRIVATE);
  }

  public static SharedPreferences getSpUtils() {
    return spUtils;
  }

  public static void setSpUtils(SharedPreferences spUtils) {
    App.spUtils = spUtils;
  }

  /**
   * 获取是否是第一次打开该App
   *
   * @return
   */
  public static String getFirstOpen() {
    return getSpUtils().getString("first_open","1");
  }

  /**
   * 设置是否是第一次打开该App
   *
   * @return
   */
  public static void setFirstOpen(String val) {
    SharedPreferences.Editor editor = getSpUtils().edit();
    editor.putString("first_open", val);
    editor.apply();
  }

  public static void setLoginToken(String val){
    SharedPreferences.Editor editor = getSpUtils().edit();
    editor.putString("app_token", val);
    editor.apply();
  }

  public static String getLoginToken(){
    return getSpUtils().getString("app_token", "0");
  }

  public static void setName(String val){
    SharedPreferences.Editor editor = getSpUtils().edit();
    editor.putString("user_name", val);
    editor.apply();
  }

  public static String getName(){
    return getSpUtils().getString("user_name", "0");
  }

  public static void setHead(String val){
    SharedPreferences.Editor editor = getSpUtils().edit();
    editor.putString("user_head", val);
    editor.apply();
  }

  public static String getHead(){
    return getSpUtils().getString("user_head", "0");
  }

  public static String getUserInfo(){
    return getSpUtils().getString("user_info", "0");
  }

  public static void setUserInfo(String val){
    SharedPreferences.Editor editor = getSpUtils().edit();
    editor.putString("user_info", val);
    editor.apply();
  }





}
