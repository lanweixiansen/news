package com.example.stocknews.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.example.stocknews.Base.BaseActivity2;
import com.example.stocknews.NewsActivity;
import com.example.stocknews.R;
import com.example.stocknews.ViewModel.CollectionViewModel;
import com.example.stocknews.adapter.NewsAdapter;
import com.example.stocknews.databinding.ActivityCollectionBinding;

import java.util.ArrayList;
import java.util.List;

import cn.leancloud.AVObject;

public class CollectionActivity extends BaseActivity2<ActivityCollectionBinding> {
  private static final String TAG = CollectionActivity.class.getSimpleName();
  private final List<AVObject> mList = new ArrayList<>();
  private NewsAdapter mAdapter;
  private CollectionViewModel mViewModel;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    initView();
    initData();
    onClick();
  }

  private void initView() {
    mViewModel = new ViewModelProvider(this).get(CollectionViewModel.class);
    LinearLayoutManager layoutManager = new LinearLayoutManager(this);
    layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
    mAdapter = new NewsAdapter(R.layout.item_news, mList);
    binding.recycle.setLayoutManager(layoutManager);
    binding.recycle.setAdapter(mAdapter);
  }

  private void initData() {
    if (mViewModel.getLiveData().getValue() == null){
      mViewModel.requestData();
    }
    mViewModel.getLiveData().observe(this , new Observer<List<AVObject>>() {
      @Override
      public void onChanged(List<AVObject> avObjects) {
        Log.d(TAG,"查看文章列表" + avObjects.toString());
        mList.addAll(avObjects);
        Log.d(TAG,"text---->" + avObjects.size());
        if (avObjects.size() != 0){
          binding.progressBar.setVisibility(View.GONE);
          binding.textView11.setVisibility(View.GONE);
          binding.recycle.setVisibility(View.VISIBLE);
          mAdapter.setList(avObjects);
          mAdapter.notifyDataSetChanged();
        } else {
          binding.progressBar.setVisibility(View.GONE);
          binding.recycle.setVisibility(View.GONE);
          binding.textView11.setVisibility(View.VISIBLE);
        }

      }
    });

  }

  private void onClick() {
    //列表点击操作
    mAdapter.setOnItemClickListener(new OnItemClickListener() {
      @Override
      public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
        Intent intent = new Intent(CollectionActivity.this, NewsActivity.class);
        intent.putExtra("title", (String) mList.get(position).getServerData().get("article_title"));
        intent.putExtra("origin", (String) mList.get(position).getServerData().get("article_source"));
        intent.putExtra("time", (String) mList.get(position).getServerData().get("article_time"));
        intent.putExtra("content", (String) mList.get(position).getServerData().get("article_content"));
        intent.putExtra("objectId", mList.get(position).getObjectId());
        Log.d(TAG,"查看传值-------》" + mList.get(position).getServerData().get("article_title") + mList.get(position).getObjectId());
        startActivity(intent);
      }
    });

    //点击返回
    binding.ivBack.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        finish();
      }
    });

    //点击清空收藏
    binding.ivActivity.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(CollectionActivity.this);
        builder.setTitle("清空历史记录");
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialogInterface, int i) {
            mViewModel.deleteAllNews();
            mList.clear();
            mAdapter.setList(mList);
            mAdapter.notifyDataSetChanged();
          }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialogInterface, int i) {
            builder.setCancelable(false);
          }
        });
        builder.create();
        builder.show();
      }
    });

  }


}
