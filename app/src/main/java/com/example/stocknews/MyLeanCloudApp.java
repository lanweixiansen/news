package com.example.stocknews;

import android.app.Application;

import cn.leancloud.AVOSCloud;

public class MyLeanCloudApp extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    AVOSCloud.initialize(this,"dDlqrHpTCHacC9SuFrqiAqGK-gzGzoHsz","oynmByChVOY8MzQJ5EI9A7o0");
  }
}
