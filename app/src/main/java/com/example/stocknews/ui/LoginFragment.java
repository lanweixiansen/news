package com.example.stocknews.ui;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import com.example.stocknews.App;
import com.example.stocknews.Base.BaseFragment2;
import com.example.stocknews.MainActivity;
import com.example.stocknews.R;
import com.example.stocknews.Tools.DataUtil;
import com.example.stocknews.Tools.ToastUtil;
import com.example.stocknews.databinding.FragmentLoginBinding;

import java.util.List;

import cn.leancloud.AVObject;
import cn.leancloud.AVQuery;
import cn.leancloud.AVUser;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * 登录界面
 */
public class LoginFragment extends BaseFragment2<FragmentLoginBinding> {
  private int i = 0;//1代表不隐藏，0代表隐藏
  private static final String TAG = LoginFragment.class.getSimpleName();

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
  }

  @Override
  public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    onClick();
  }

  private void onClick() {
    //当用户点击登录时
    binding.rlLogin.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        if (binding.etName.getText().toString().isEmpty()){
          ToastUtil.showMessage(getContext(), "请输入账号!");
          return;
        }
        if (binding.etPwd.getText().toString().isEmpty()){
          ToastUtil.showMessage(getContext(), "请输入密码!");
          return;
        }
        String count = binding.etName.getText().toString().trim();
        String pasw = binding.etPwd.getText().toString().trim();
        AVUser.logIn(count, pasw).subscribe(new Observer<AVUser>() {
          @Override
          public void onSubscribe(@io.reactivex.annotations.NonNull Disposable d) {}
          @Override
          public void onNext(@io.reactivex.annotations.NonNull AVUser avUser) {
            //登录成功之后保存APPtoken到本地
            App.setLoginToken(DataUtil.APPToken);
            //登录成功之后读取用户ID
            AVQuery<AVObject> query = new AVQuery<>("UserInfo");
            query.whereEqualTo("user",AVUser.getCurrentUser());
            query.findInBackground().subscribe(new Observer<List<AVObject>>() {
              @Override
              public void onSubscribe(@io.reactivex.annotations.NonNull Disposable d) {}
              @Override
              public void onNext(@io.reactivex.annotations.NonNull List<AVObject> avObjects) {
                Log.d(TAG, "用户信息-----》" + avObjects.toString());
                if (avObjects.size() != 0){
                  App.setName(avObjects.get(0).get("name").toString());
                  App.setUserInfo(avObjects.get(0).getObjectId());
                  Log.d(TAG,"用户昵称--》" + avObjects.get(0).get("name").toString());
                }
              }
              @Override
              public void onError(@io.reactivex.annotations.NonNull Throwable e) {}
              @Override
              public void onComplete() {}
            });

            AVQuery<AVObject> query1 = new AVQuery<>("UserInfo");
            query1.whereEqualTo("user",AVUser.getCurrentUser());
            query1.whereExists("head");
            query1.include("head");
            query1.findInBackground().subscribe(new Observer<List<AVObject>>() {
              @Override
              public void onSubscribe(@io.reactivex.annotations.NonNull Disposable d) {}

              @Override
              public void onNext(@io.reactivex.annotations.NonNull List<AVObject> avObjects) {
                if (avObjects.size() != 0){
                  App.setHead(avObjects.get(0).get("head").toString());
                }
              }

              @Override
              public void onError(@io.reactivex.annotations.NonNull Throwable e) {}

              @Override
              public void onComplete() {}
            });
            //进入主页面
            startActivity(new Intent(getActivity(), MainActivity.class));
            getActivity().finish();
          }

          @Override
          public void onError(@io.reactivex.annotations.NonNull Throwable e) {
            ToastUtil.showMessage(getContext(), "登录失败!" + e.toString());
          }

          @Override
          public void onComplete() {}
        });

      }
    });

    //当用户点击游客登录时跳到主界面
    binding.tvLoginIn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        startActivity(new Intent(getActivity(), MainActivity.class));
        getActivity().finish();
      }

    });

    //点击显示或者隐藏密码
    binding.ivLook.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        if (i == 0){
          binding.etPwd.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
          binding.etPwd.setSelection(binding.etPwd.length());
          binding.ivLook.setImageResource(R.mipmap.see);
          i = 1;
        }else {
          binding.etPwd.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
          binding.etPwd.setSelection(binding.etPwd.length());
          binding.ivLook.setImageResource(R.mipmap.unsee);
          i = 0;
        }
      }
    });
  }

}