package com.example.stocknews;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.stocknews.Base.BaseActivity2;
import com.example.stocknews.Bean.NewsBean;
import com.example.stocknews.databinding.ActivityReceiverBinding;
import com.google.gson.Gson;

public class ReceiverActivity extends BaseActivity2<ActivityReceiverBinding> {

  private static final String TAG = ReceiverActivity.class.getSimpleName();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    String message = this.getIntent().getStringExtra("com.avoscloud.Data");
    String channel = this.getIntent().getStringExtra("com.avoscloud.Channel");
    Log.d(TAG,"message=" + message + ", channel=" + channel);
    Gson gson = new Gson();
    NewsBean.DataDTO newsBean = gson.fromJson(message, NewsBean.DataDTO.class);
    if (newsBean != null){
      binding.newsTitle1.setText(newsBean.getTitle());
      binding.newsTitle2.setText(newsBean.getTitle());
      binding.newsOrigin1.setText(newsBean.getOrigin());
      binding.newsTime1.setText(newsBean.getPubTime());
    }
    binding.webView2.getSettings().setJavaScriptEnabled(true);
    binding.webView2.getSettings().setBuiltInZoomControls(true);
    binding.webView2.getSettings().setDisplayZoomControls(false);
    binding.webView2.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY); //取消滚动条白边效果
    binding.webView2.getSettings().setDefaultTextEncodingName("UTF-8") ;
    binding.webView2.getSettings().setBlockNetworkImage(false);
    if (newsBean.getContent() != null){
      binding.webView2.loadDataWithBaseURL("http://avatar.csdn.net",setWebVIewImage(newsBean.getContent()),
              "text/html", "UTF-8", null);
    }

  }

  public static String setWebVIewImage(String star) {
    String head = "<head>"
            + "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, user-scalable=no\"> "
            + "<style>img{max-width: 100%; width:auto; height:auto;}</style>"
            + "<style>table{max-width: 100%; width:auto; height:auto;}</style>"
            + "</head>";
    return "<html>" + head + "<body>" + star + "</body></html>";

  }




}