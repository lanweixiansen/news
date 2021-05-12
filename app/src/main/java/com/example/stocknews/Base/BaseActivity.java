package com.example.stocknews.Base;

import androidx.appcompat.app.AppCompatActivity;
import com.dueeeke.videoplayer.player.VideoViewManager;
import com.example.stocknews.R;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class BaseActivity extends AppCompatActivity {
  SweetAlertDialog pDialog;

  protected VideoViewManager getVideoViewManager() {
    return VideoViewManager.instance();
  }

  /**
   * 打开自带对话框
   */
  public void showDialog(String text) {
    if (null == pDialog) {
      pDialog = new SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE).setTitleText(text);
    }
    pDialog.show();
    pDialog.setCancelable(false);
    pDialog.getProgressHelper().setBarColor(getResources().getColor(R.color.blue_btn_bg_color));
  }

  /**
   * 关闭加载对话框
   */
  public void dismissDialog() {
    if (null != pDialog) {
      pDialog.dismissWithAnimation();
      pDialog = null;
    }
  }



}
