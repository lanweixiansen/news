package com.example.stocknews;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.stocknews.Tools.ToastUtil;

import java.util.List;

import cn.leancloud.AVInstallation;
import cn.leancloud.AVObject;
import cn.leancloud.AVQuery;
import cn.leancloud.push.PushService;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class SplashActivity extends AppCompatActivity {
  private static final String TAG = SplashActivity.class.getSimpleName();
  private String mPrivacy;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
    setContentView(R.layout.activity_splash);
    PushService.setDefaultPushCallback(SplashActivity.this, ReceiverActivity.class);
    PushService.subscribe(this, "news", ReceiverActivity.class);
    PushService.setDefaultChannelId(this, "developer-default");
    useTuiSong();
    initView();
  }

  private void initView() {
    if (App.getFirstOpen().equals("1")) {
      privacyDialog();
    } else {
      getToMain();
    }
  }

  /**
   * 隐私弹窗
   */
  private void privacyDialog() {
    AVQuery<AVObject> avQuery = new AVQuery<>("privacy");
    avQuery.findInBackground().subscribe(new Observer<List<AVObject>>() {
      @Override
      public void onSubscribe(@io.reactivex.annotations.NonNull Disposable d) {
      }

      @Override
      public void onNext(@io.reactivex.annotations.NonNull List<AVObject> avObjects) {
        mPrivacy = (String) avObjects.get(0).getServerData().get("content");
      }

      @Override
      public void onError(@io.reactivex.annotations.NonNull Throwable e) {
        ToastUtil.showMessage(SplashActivity.this, "隐私政策获取失败！");
      }

      @Override
      public void onComplete() {
      }
    });
    final AlertDialog dialog = new AlertDialog.Builder(this).create();
    dialog.show();
    dialog.setCancelable(false); //对话框弹出后点击或按返回键不消失;

    final Window window = dialog.getWindow();
    if (window != null) {
      window.setContentView(R.layout.privacy_dialog2);
      window.setGravity(Gravity.CENTER); //对话框弹出后点击或按返回键不消失;
      window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
      //设置属性
      final WindowManager.LayoutParams params = window.getAttributes();
      params.width = WindowManager.LayoutParams.MATCH_PARENT;
      params.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
      params.dimAmount = 0.5f;
      window.setAttributes(params);
      TextView textView = window.findViewById(R.id.tv_1);
      TextView tvCancel = window.findViewById(R.id.tv_cancel);
      TextView tvAgree = window.findViewById(R.id.tv_agree);
      //用户点击取消退出应用
      tvCancel.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
          dialog.cancel();
          finish();
        }
      });
      //用户点击确定进入软件
      tvAgree.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
          dialog.cancel();
          //进入主界面
          App.setFirstOpen("0");
          getToMain();
        }
      });
      String str = "感谢您选择本APP!我们非常重视您的个人信息和隐私保护。" +
              "为了更好地保障您的个人权益，在您使用我们的产品前，" +
              "请务必审慎阅读《隐私政策》内的所有条款，" +
              "尤其是:1.我们对您的个人信息的收集/保存/使用/对外提供/保护等规则条款，以及您的用户权利等条款" +
              "2. 约定我们的限制责任、免责条款; " +
              "您点击\"同意并继续”的行为即表示您已阅读完毕并同意以上协议的全部内容。" +
              "如您同意以上协议内容，请点击\"同意并继续”，开始使用我们的产品和服务!";
      textView.setText(str);

      //对隐私政策和用户协议进行单独设置
      SpannableStringBuilder ssb = new SpannableStringBuilder();
      ssb.append(str);
      final int start = str.indexOf("《");
      ssb.setSpan(new ClickableSpan() {
        @Override
        public void onClick(View widget) {
          //这里需要添加展示隐私政策的webView
          Intent intent = new Intent(SplashActivity.this, WebViewActivity.class);
          intent.putExtra("content", mPrivacy);
          startActivity(intent);
        }

        @Override
        public void updateDrawState(@NonNull TextPaint ds) {
          super.updateDrawState(ds);
          ds.setColor(getResources().getColor(R.color.privacy_color));
          ds.setUnderlineText(false);
        }
      }, start, start + 6, 0);


      textView.setMovementMethod(LinkMovementMethod.getInstance());
      textView.setText(ssb, TextView.BufferType.SPANNABLE);
    }
  }

  /**
   * 进入主界面
   */
  private void getToMain() {
    if (App.getFirstOpen().equals("1")) {
      startActivity(new Intent(getApplicationContext(), LoginActivity.class));
      finish();
    } else {
      startActivity(new Intent(getApplicationContext(), MainActivity.class));
      finish();
    }
  }

  private void useTuiSong() {
    AVInstallation.getCurrentInstallation().saveInBackground().subscribe(new Observer<AVObject>() {
      @Override
      public void onSubscribe(Disposable d) {
      }

      @Override
      public void onNext(AVObject avObject) {
        // 关联 installationId 到用户表等操作。
        String installationId = AVInstallation.getCurrentInstallation().getInstallationId();
      }

      @Override
      public void onError(Throwable e) {
      }

      @Override
      public void onComplete() {
      }
    });
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