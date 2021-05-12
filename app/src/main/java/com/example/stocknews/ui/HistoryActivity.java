package com.example.stocknews.ui;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.example.stocknews.Base.BaseActivity2;
import com.example.stocknews.Bean.News;
import com.example.stocknews.NewsActivity;
import com.example.stocknews.R;
import com.example.stocknews.Repository.NewsRepository;
import com.example.stocknews.ViewModel.HistoryViewModel;
import com.example.stocknews.adapter.HistoryAdapter;
import com.example.stocknews.databinding.ActivityHistoryBinding;

import java.util.ArrayList;
import java.util.List;


public class HistoryActivity extends BaseActivity2<ActivityHistoryBinding> {
  private static final String TAG = HistoryActivity.class.getSimpleName();
  private LiveData<List<News>> mLiveData;
  private NewsRepository mRepository = new NewsRepository(this);
  private HistoryViewModel mViewModel;
  private final List<News> mList = new ArrayList<>();
  private HistoryAdapter mAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    initView();
    initData();
    onClick();
  }

  private void initView() {
    mViewModel = new ViewModelProvider(this).get(HistoryViewModel.class);
    LinearLayoutManager layoutManager = new LinearLayoutManager(this);
    layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
    mAdapter = new HistoryAdapter(R.layout.item_news, mList);
    binding.recycle.setLayoutManager(layoutManager);
    binding.recycle.setAdapter(mAdapter);

  }

  private void onClick() {
    binding.ivBack.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        finish();
      }
    });

    binding.ivActivity.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(HistoryActivity.this);
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

    mAdapter.setOnItemClickListener(new OnItemClickListener() {
      @Override
      public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {

        Intent intent = new Intent(HistoryActivity.this, NewsActivity.class);
        intent.putExtra("title", mList.get(position).getTitle());
        intent.putExtra("origin", mList.get(position).getOrigin());
        intent.putExtra("time", mList.get(position).getPubTime());
        intent.putExtra("content", mList.get(position).getContent());
        intent.putExtra("objectId", mList.get(position).getNewsID());
        startActivity(intent);
      }
    });
  }

  private void initData() {
    mLiveData = mViewModel.getAllNews();
    mLiveData.observe(this, new Observer<List<News>>() {
      @Override
      public void onChanged(List<News> news) {
        Log.d(TAG, "test---------->" + news.size());
        mList.addAll(news);
        mAdapter.setList(mList);
        mAdapter.notifyDataSetChanged();
      }
    });
  }


}