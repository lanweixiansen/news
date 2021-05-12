package com.example.stocknews.ui;


import android.content.Context;
import android.content.Intent;
import android.hardware.input.InputManager;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.example.stocknews.Base.BaseActivity2;
import com.example.stocknews.NewsActivity;
import com.example.stocknews.R;
import com.example.stocknews.ViewModel.SearchViewModel;
import com.example.stocknews.adapter.NewsAdapter;
import com.example.stocknews.databinding.ActivitySearchBinding;

import java.util.ArrayList;
import java.util.List;

import cn.leancloud.AVObject;
import cn.leancloud.AVQuery;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class SearchActivity extends BaseActivity2<ActivitySearchBinding> {
  private List<AVObject> mList = new ArrayList<>();
  MutableLiveData<List<AVObject>> mLiveData = new MutableLiveData<>();
  private NewsAdapter mAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    initView();
    initData();
    onClick();

  }

  private void initView() {
    //自动获取焦点弹出键盘
    binding.editText.requestFocus();
    InputMethodManager methodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
    methodManager.showSoftInput(binding.editText, 0);
    LinearLayoutManager manager = new LinearLayoutManager(this);
    manager.setOrientation(LinearLayoutManager.VERTICAL);
    mAdapter = new NewsAdapter(R.layout.item_news, mList);
    binding.recycle.setLayoutManager(manager);
    binding.recycle.setAdapter(mAdapter);
    //监测搜索框中的内容，根据内容搜索文章
    TextWatcher textWatcher = new TextWatcher() {
      @Override
      public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

      @Override
      public void onTextChanged(CharSequence s, int start, int before, int count) {
        binding.progressBar4.setVisibility(View.VISIBLE);
        if (binding.editText.getText().toString().trim().equals("")){
          binding.recycle.setVisibility(View.GONE);
        }
        requestData(binding.editText.getText().toString().trim());
      }

      @Override
      public void afterTextChanged(Editable s) {}
    };
    binding.editText.addTextChangedListener(textWatcher);


  }

  private void requestData(String Msg) {
    AVQuery<AVObject> avQuery = new AVQuery<>("news2");
    avQuery.whereContains("article_title", Msg);
    avQuery.findInBackground().subscribe(new Observer<List<AVObject>>() {
      @Override
      public void onSubscribe(@io.reactivex.annotations.NonNull Disposable d) {

      }

      @Override
      public void onNext(@io.reactivex.annotations.NonNull List<AVObject> avObjects) {
        if (avObjects.size() == 0){
          binding.progressBar4.setVisibility(View.GONE);
          binding.textView8.setVisibility(View.VISIBLE);
        }
        mLiveData.setValue(avObjects);
      }

      @Override
      public void onError(@io.reactivex.annotations.NonNull Throwable e) {

      }

      @Override
      public void onComplete() {

      }
    });
  }

  private void initData() {
    mLiveData.observe(this , new androidx.lifecycle.Observer<List<AVObject>>() {
      @Override
      public void onChanged(List<AVObject> avObjects) {
        mList = avObjects;
        if (mList.size() != 0){
          binding.textView8.setVisibility(View.GONE);
          binding.progressBar4.setVisibility(View.GONE);
          binding.recycle.setVisibility(View.VISIBLE);
        }
        mAdapter.setList(avObjects);
        mAdapter.notifyDataSetChanged();
      }
    });

  }

  private void onClick() {
    //点击返回键
    binding.back.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        finish();
      }
    });
    //点击搜索
    binding.search.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        requestData(binding.editText.getText().toString().trim());
      }
    });
    //点击文章
    mAdapter.setOnItemClickListener(new OnItemClickListener() {
      @Override
      public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
        Intent intent = new Intent(SearchActivity.this, NewsActivity.class);
        intent.putExtra("title", (String) mList.get(position).getServerData().get("article_title"));
        intent.putExtra("origin", (String) mList.get(position).getServerData().get("article_source"));
        intent.putExtra("time", (String) mList.get(position).getServerData().get("article_time"));
        intent.putExtra("content", (String) mList.get(position).getServerData().get("article_content"));
        intent.putExtra("objectId", mList.get(position).getObjectId());
        startActivity(intent);
      }
    });


  }
}