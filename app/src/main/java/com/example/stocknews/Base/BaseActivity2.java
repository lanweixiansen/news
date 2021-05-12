package com.example.stocknews.Base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewbinding.ViewBinding;
import com.dueeeke.videoplayer.player.VideoViewManager;
import com.example.stocknews.R;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class BaseActivity2<T extends ViewBinding> extends AppCompatActivity {
  protected T binding;
  SweetAlertDialog pDialog;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    //状态栏沉浸
    changStatusIconCollor(true);
    Type superclass = getClass().getGenericSuperclass();
    Class<?> aClass = (Class<?>) ((ParameterizedType) superclass).getActualTypeArguments()[0];
    try {
      Method method = aClass.getDeclaredMethod("inflate", LayoutInflater.class);
      binding = (T) method.invoke(null, getLayoutInflater());
      setContentView(binding.getRoot());
    } catch (NoSuchMethodException | IllegalAccessException| InvocationTargetException e) {
      e.printStackTrace();
    }
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
