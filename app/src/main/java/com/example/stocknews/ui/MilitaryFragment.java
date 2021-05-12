package com.example.stocknews.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.example.stocknews.App;
import com.example.stocknews.Base.BaseFragment2;
import com.example.stocknews.Bean.News;
import com.example.stocknews.NewsActivity;
import com.example.stocknews.R;
import com.example.stocknews.Repository.NewsRepository;
import com.example.stocknews.ViewModel.MilitaryViewModel;
import com.example.stocknews.ViewModel.TechnologyViewModel;
import com.example.stocknews.adapter.NewsAdapter;
import com.example.stocknews.databinding.FragmentMilitaryBinding;

import java.util.ArrayList;
import java.util.List;

import cn.leancloud.AVObject;

/**
 * 军事
 */
public class MilitaryFragment extends BaseFragment2<FragmentMilitaryBinding> {
  private MilitaryViewModel mViewModel;
  private final List<AVObject> mList = new ArrayList<>();
  private NewsAdapter mAdapter;
  private final NewsRepository mRepository = new NewsRepository(App.getContext());
  private LiveData<List<News>> mLiveData = new MutableLiveData<>();

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    initView();
    initData();
    onClick();
  }

  private void onClick() {
    //点击文章列表进入详情页，点击列表记录历史记录
    mAdapter.setOnItemClickListener(new OnItemClickListener() {
      @Override
      public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
        //判断历史记录表中是否已经存在，不存在就存入
        mLiveData.removeObservers(getViewLifecycleOwner());
        mLiveData = mViewModel.getNews(mList.get(position).getObjectId());
        mLiveData.observe(getViewLifecycleOwner(), new Observer<List<News>>() {
                  @Override
                  public void onChanged(List<News> news) {
                    if (news.isEmpty()){
                      addHistory(mList.get(position).getObjectId(),
                              (String) mList.get(position).getServerData().get("article_source"),
                              (String) mList.get(position).getServerData().get("article_title"),
                              (String) mList.get(position).getServerData().get("article_time"),
                              (String) mList.get(position).getServerData().get("article_content"),
                              (String) mList.get(position).getServerData().get("article_img"));
                    }
                  }
                });

        Intent intent = new Intent(getContext(), NewsActivity.class);
        intent.putExtra("title", (String) mList.get(position).getServerData().get("article_title"));
        intent.putExtra("origin", (String) mList.get(position).getServerData().get("article_source"));
        intent.putExtra("time", (String) mList.get(position).getServerData().get("article_time"));
        intent.putExtra("content", (String) mList.get(position).getServerData().get("article_content"));
        intent.putExtra("objectId", mList.get(position).getObjectId());
        addHistory();
        startActivity(intent);
      }
    });

  }

  private void addHistory(String objectId, String origin, String title, String time, String content, String pic) {
    News news = new News(objectId, origin, time, title, content, pic);
    mRepository.insertNews(news);
    mLiveData.removeObservers(getViewLifecycleOwner());
  }

  private void initView() {
    mViewModel = new ViewModelProvider(requireActivity()).get(MilitaryViewModel.class);
    LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
    layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
    mAdapter = new NewsAdapter(R.layout.item_news, mList);
    binding.recycle.setLayoutManager(layoutManager);
    binding.recycle.setAdapter(mAdapter);
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
          binding.progressBar.setVisibility(View.GONE);
          binding.recycle.setVisibility(View.VISIBLE);
        }
        mAdapter.setList(avObjects);
        mAdapter.notifyDataSetChanged();
      }
    });
    //下拉刷新数据
    initRefreshLayout();
  }

  private void initRefreshLayout() {
    binding.swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
      @Override
      public void onRefresh() {
        //刷新时不允许加载更多
//        mAlertsAdapter.getLoadMoreModule().setEnableLoadMore(false);
//        page = 0;
//        DataUtil.setPage(page);
        binding.recycle.postDelayed(new Runnable() {
          @Override
          public void run() {
            binding.swipe.setRefreshing(false);
            mViewModel.requestData();
            mAdapter.setList(mList);
          }
        }, 1000);
      }
    });
  }

  //点击列表加入历史记录
  private void addHistory() {

  }


}