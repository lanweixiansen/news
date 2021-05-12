
package com.example.stocknews.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.stocknews.App;
import com.example.stocknews.Base.BaseFragment2;
import com.example.stocknews.LoginActivity;
import com.example.stocknews.MainActivity;
import com.example.stocknews.R;
import com.example.stocknews.Tools.DataUtil;
import com.example.stocknews.Tools.ToastUtil;
import com.example.stocknews.databinding.FragmentRegisteredBinding;

import cn.leancloud.AVObject;
import cn.leancloud.AVUser;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * 注册界面
 */
public class RegisteredFragment extends BaseFragment2<FragmentRegisteredBinding> {
  private static final String TAG = RegisteredFragment.class.getSimpleName();

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
  }

  @Override
  public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    onRegist();
  }

  private void onRegist() {
    binding.rlConfirmationRegistration.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        if (binding.etPhone.getText().toString().trim().isEmpty()){
          ToastUtil.showMessage(getContext(), "请输入账号!");
          return;
        }
        if (binding.etPassword.getText().toString().trim().isEmpty()){
          ToastUtil.showMessage(getContext(), "请输入密码!");
          return;
        }
        if (binding.etPassword2.getText().toString().trim().isEmpty()){
          ToastUtil.showMessage(getContext(), "请确认密码!");
          return;
        }
        if (!binding.etPassword.getText().toString().trim().equals(binding.etPassword2.getText().toString().trim())){
          ToastUtil.showMessage(getContext(), "密码不一致，请重新输入！");
          return;
        }
        String count = binding.etPhone.getText().toString().trim();
        String paw = binding.etPassword.getText().toString().trim();
        AVUser user = new AVUser();
        user.setUsername(count);
        user.setPassword(paw);
        user.signUpInBackground().subscribe(new Observer<AVUser>() {
          @Override
          public void onSubscribe(@io.reactivex.annotations.NonNull Disposable d) {}

          @Override
          public void onNext(@io.reactivex.annotations.NonNull AVUser avUser) {
            ToastUtil.showMessage(getContext(), "注册成功，请登录。");
            startActivity(new Intent(getActivity(), LoginActivity.class));
            getActivity().finish();
          }

          @Override
          public void onError(@io.reactivex.annotations.NonNull Throwable e) {
            ToastUtil.showMessage(getContext(), "注册失败!" + e.toString());
          }

          @Override
          public void onComplete() {}
        });

      }
    });
  }
}