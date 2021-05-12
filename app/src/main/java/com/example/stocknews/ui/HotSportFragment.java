package com.example.stocknews.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;;
import android.util.Log;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.example.stocknews.Base.BaseFragment2;
import com.example.stocknews.R;
import com.example.stocknews.ViewModel.HotInfoViewModel;
import com.example.stocknews.WebViewActivity;
import com.example.stocknews.adapter.HotInfoAdapter;
import com.example.stocknews.databinding.FragmentHotSportBinding;

import java.util.ArrayList;
import java.util.List;

import cn.leancloud.AVObject;

public class HotSportFragment extends BaseFragment2<FragmentHotSportBinding> {
  private static final String TAG = HotSportFragment.class.getSimpleName();
  List<AVObject> mList = new ArrayList<>();
  private HotInfoAdapter mAdapter;
  private HotInfoViewModel mViewModel;


  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    mViewModel = new ViewModelProvider(requireActivity()).get(HotInfoViewModel.class);
    LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
    layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
    binding.recycle.setLayoutManager(layoutManager);
    mAdapter = new HotInfoAdapter(R.layout.item_hot, mList);
    binding.recycle.setAdapter(mAdapter);
  }

  @Override
  public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    initData();
    onClick();
  }

  private void onClick() {
    mAdapter.setOnItemClickListener(new OnItemClickListener() {
      @Override
      public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
        Intent intent = new Intent(getContext(), WebViewActivity.class);
        intent.putExtra("web", (String) mList.get(position).getServerData().get("content"));
        intent.putExtra("title", (String) mList.get(position).getServerData().get("title"));
        startActivity(intent);
      }
    });
  }

  private void initData() {
    if (mViewModel.getLiveData().getValue() == null){
      mViewModel.requestData();
    }
    mViewModel.getLiveData().observe(getViewLifecycleOwner(), new Observer<List<AVObject>>() {
      @Override
      public void onChanged(List<AVObject> avObjects) {
        mList.addAll(avObjects);
        if (mList.size() != 0){
          binding.progressBar3.setVisibility(View.GONE);
          binding.recycle.setVisibility(View.VISIBLE);
          mAdapter.setList(avObjects);
          mAdapter.notifyDataSetChanged();
        }
      }
    });
    //下拉刷新数据
    initRefreshLayout();
  }

  private void initRefreshLayout() {
    binding.swip.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
      @Override
      public void onRefresh() {
        //刷新时不允许加载更多
//        mAlertsAdapter.getLoadMoreModule().setEnableLoadMore(false);
//        page = 0;
//        DataUtil.setPage(page);
        binding.recycle.postDelayed(new Runnable() {
          @Override
          public void run() {
            binding.swip.setRefreshing(false);
            mViewModel.requestData();
            mAdapter.setList(mList);
          }
        }, 1000);
      }
    });
  }
}