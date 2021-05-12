package com.example.stocknews.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.stocknews.App;
import com.example.stocknews.Base.BaseFragment2;
import com.example.stocknews.LoginActivity;
import com.example.stocknews.R;
import com.example.stocknews.Tools.DataUtil;
import com.example.stocknews.adapter.HistoryAdapter;
import com.example.stocknews.databinding.FragmentMineBinding;

import java.util.List;

import cn.leancloud.AVObject;
import cn.leancloud.AVQuery;
import cn.leancloud.AVUser;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * 我的
 */

public class MineFragment extends BaseFragment2<FragmentMineBinding> {

  private static final String TAG = MineFragment.class.getSimpleName();
  private final String path = App.getContext().getFilesDir().getAbsolutePath();

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
  }

  @Override
  public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    initData();
    onClick();
  }

  private void initData() {
    setUsrName();
    setUserHead();
  }

  private void setUserHead() {
    if (App.getHead().equals("0")){
      binding.mineImage.setImageResource(R.mipmap.touxiang);
    }else {
      Glide.with(getContext())
              .load(App.getHead())
              .into(binding.mineImage);
    }
  }

  private void setUsrName() {
    if (App.getLoginToken().equals("0")){
      binding.name.setText("请登录,");
    }else if (App.getName().equals("0")){
      binding.name.setText("设置昵称，");
    }else {
      binding.name.setText(App.getName());
    }
  }

  private void onClick() {
    //点击设置
    binding.cvShezhi.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        gotoSetUp();
      }
    });

    //点击昵称
    binding.name.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        if (App.getLoginToken().equals("0")) {
          loginOut();
        }else {
          gotoSetUp();
        }
      }
    });

    //点击收藏
    binding.cvShouCang.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        if (App.getLoginToken().equals("0")) {
          loginOut();
        }else {
          startActivity(new Intent(getContext(), CollectionActivity.class));
        }
      }
    });

    //点击更多
    binding.more.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        startActivity(new Intent(getContext(), MoreActivity.class));
      }
    });

    //点击历史记录
    binding.history.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        startActivity(new Intent(getContext(), HistoryActivity.class));
      }
    });



  }


  public void loginOut(){
    Intent intent = new Intent(getActivity(), LoginActivity.class);
    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
    startActivity(intent);
  }

  public void gotoSetUp(){
    Intent intent = new Intent(getActivity(), SetUpActivity.class);
    startActivity(intent);
  }



  @Override
  public void onPause() {
    super.onPause();
    Log.d(TAG,"1");
    setUsrName();
    setUserHead();
  }

  @Override
  public void onResume() {
    super.onResume();
    Log.d(TAG,"2");
    setUsrName();
    setUserHead();
  }
}