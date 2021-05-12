package com.example.stocknews;

import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.example.stocknews.Base.BaseActivity2;
import com.example.stocknews.adapter.FragmentAdapter;
import com.example.stocknews.databinding.ActivityLoginBinding;
import com.example.stocknews.ui.LoginFragment;
import com.example.stocknews.ui.RegisteredFragment;

import java.util.ArrayList;

public class LoginActivity extends BaseActivity2<ActivityLoginBinding> {
  private ArrayList<Fragment> mFragments = new ArrayList<>();
  private final String[] mTitles = {"帐户登陆", "账户注册"};

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    initView();
    onClick();
  }

  private void initView() {
    binding.ivLoginIn.setImageResource(R.mipmap.left);
    binding.ivLogo.setImageResource(R.mipmap.denglu);
    mFragments.add(new LoginFragment());
    mFragments.add(new RegisteredFragment());
    binding.vpPageNotice.setAdapter(new FragmentAdapter(getSupportFragmentManager(),mFragments, mTitles));
    binding.tlNotice.setViewPager(binding.vpPageNotice);
  }


  private void onClick() {
    binding.ivLoginIn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
      }
    });

  }

  @Override
  public void onBackPressed() {
    super.onBackPressed();
    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
    startActivity(intent);
    finish();
  }
}