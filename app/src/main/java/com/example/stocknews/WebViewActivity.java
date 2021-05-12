package com.example.stocknews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.just.agentweb.AgentWeb;
import com.just.agentweb.DefaultWebClient;
import com.just.agentweb.WebChromeClient;
import com.just.agentweb.WebViewClient;

import org.w3c.dom.Document;

public class WebViewActivity extends AppCompatActivity {

  private String mContent, mUrl, mTitle, mWeb;
  private WebView webView;
  private ConstraintLayout mLinearLayout;
  private static final String TAG = WebViewActivity.class.getCanonicalName();
  private TextView mTitle1;
  private ImageView mImageView;
  private AgentWeb mAgentWeb;

  @SuppressLint("SetJavaScriptEnabled")
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_web_view1);
    //状态栏沉浸
    changStatusIconCollor(true);
    mLinearLayout = this.findViewById(R.id.web);
    Intent intent = getIntent();
    mTitle = intent.getStringExtra("title");
    mContent = intent.getStringExtra("content");//接收富文本
    mUrl = intent.getStringExtra("Url");//接收pdf链接
    mWeb = intent.getStringExtra("web");//网站链接
    Log.d(TAG,"mContent------>" + mContent);
    initView();
    initData();
    onClick();
  }

  private void onClick() {
    mImageView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        finish();
      }
    });
  }

  private void initData() {
    mTitle1.setText(mTitle);
  }

  private void initView() {
    mTitle1 = findViewById(R.id.web_title);
    webView = findViewById(R.id.webView);
    mImageView = findViewById(R.id.web_image);
    webView.getSettings().setJavaScriptEnabled(true);
    webView.getSettings().setBuiltInZoomControls(true);
    webView.getSettings().setDisplayZoomControls(false);
    webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY); //取消滚动条白边效果
    webView.getSettings().setDefaultTextEncodingName("UTF-8") ;
    webView.getSettings().setBlockNetworkImage(false);
    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
      webView.getSettings().setMixedContentMode(webView.getSettings().MIXED_CONTENT_ALWAYS_ALLOW);  //注意安卓5.0以上的权限
    }
    if (mContent != null){
      //加载富文本
      webView.loadDataWithBaseURL("http://avatar.csdn.net",setWebVIewImage(mContent),
              "text/html", "UTF-8", null);
    }else if (mUrl != null){
      //加载pdf
      webView.loadUrl("file:///android_asset/pdf.html?" + mUrl);
    }else if (mWeb != null){
      LoadUrl(mWeb);
    }


  }

  private void LoadUrl(String web) {
    mAgentWeb = AgentWeb.with(this)
            .setAgentWebParent(mLinearLayout, new LinearLayout.LayoutParams(-1, -1))
            .useDefaultIndicator()
            .setWebChromeClient(mWebChromeClient)
            .setWebViewClient(mWebViewClient)
            .setMainFrameErrorView(R.layout.agentweb_error_page, -1)
            .setSecurityType(AgentWeb.SecurityType.STRICT_CHECK)
//            .setWebLayout(new WebLayout(this))
            .setOpenOtherPageWays(DefaultWebClient.OpenOtherPageWays.ASK)//打开其他应用时，弹窗咨询用户是否前往其他应用
            .interceptUnkownUrl() //拦截找不到相关页面的Scheme
            .createAgentWeb()
            .ready()
            .go(web);
  }

  public static String setWebVIewImage(String star) {
    String head = "<head>"
            + "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, user-scalable=no\"> "
            + "<style>img{max-width: 100%; width:auto; height:auto;}</style>"
            + "<style>table{max-width: 100%; width:auto; height:auto;}</style>"
            + "</head>";
    return "<html>" + head + "<body>" + star + "</body></html>";

  }

  public void changStatusIconCollor(boolean setDark) {
    Window window =this.getWindow();
    window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
    window.setStatusBarColor(ContextCompat.getColor(this,R.color.white));
    View decorView = getWindow().getDecorView();
    if(decorView != null){
      int vis = decorView.getSystemUiVisibility();
      if(setDark){
        vis |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
      } else{
        vis &= ~View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
      }
      decorView.setSystemUiVisibility(vis);
    }
  }

  private com.just.agentweb.WebChromeClient mWebChromeClient = new WebChromeClient() {
    @Override
    public void onReceivedTitle(WebView view, String title) {
      super.onReceivedTitle(view, title);
    }
  };
  private com.just.agentweb.WebViewClient mWebViewClient = new WebViewClient() {
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
      return super.shouldOverrideUrlLoading(view, request);
    }

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
      //do you  work
      Log.i("Info", "BaseWebActivity onPageStarted");
    }
  };

  @Override
  public boolean onKeyDown(int keyCode, KeyEvent event) {
    if (mContent != null){
      finish();
    }else if (mAgentWeb.handleKeyEvent(keyCode, event)) {
      return true;
    }
    return super.onKeyDown(keyCode, event);
  }

  @Override
  protected void onPause() {
    super.onPause();

  }

  @Override
  protected void onResume() {
    super.onResume();
  }

}