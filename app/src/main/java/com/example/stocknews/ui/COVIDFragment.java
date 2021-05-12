package com.example.stocknews.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.example.stocknews.App;
import com.example.stocknews.Base.BaseFragment2;
import com.example.stocknews.Bean.COVIDBean;
import com.example.stocknews.Bean.News;
import com.example.stocknews.NewsActivity;
import com.example.stocknews.R;
import com.example.stocknews.Repository.NewsRepository;
import com.example.stocknews.Tools.ConnUrls;
import com.example.stocknews.ViewModel.COVIDVIewModel;
import com.example.stocknews.ViewModel.NewsViewModel;
import com.example.stocknews.WebViewActivity;
import com.example.stocknews.adapter.NewsAdapter;
import com.example.stocknews.databinding.FragmentCOVIDBinding;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.leancloud.AVObject;

/**
 * 抗击肺炎
 */
public class COVIDFragment extends BaseFragment2<FragmentCOVIDBinding> {
  private static final String TAG = COVIDFragment.class.getSimpleName();
  private final List<AVObject> mList = new ArrayList<>();
  private NewsAdapter mAdapter;
  private NewsViewModel mViewModel;
  private COVIDVIewModel mCOVIDVIewModel;
  private final NewsRepository mRepository = new NewsRepository(App.getContext());
  TextView mTextView1,mTextView2,mTextView3,mTextView4,mTextView5,mTextView6,
          mTextView7,mTextView8,mTextView9,mTextView10,mTextView11,mTextView12,mTextView13;
  private final String title = "抗击肺炎";
  private Handler mHandler = new Handler();
  //定时刷新
  private Runnable mRunnable = new Runnable() {
    @Override
    public void run() {
      mCOVIDVIewModel.requestData();
      mHandler.postDelayed(this,600000);
    }
  };
  private LiveData<List<News>> mLiveData = new MutableLiveData<>();
  private CardView mCardView;

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
    initView();
    initData();
    onClick();
  }

  private void onClick() {
    //点击文章列表进入详情页，点击列表记录历史记录
    mAdapter.setOnItemClickListener(new OnItemClickListener() {
      @Override
      public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
        Log.e(TAG,"点击列表----》");
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

        //向新闻详情页传递内容
        Intent intent = new Intent(getContext(), NewsActivity.class);
        intent.putExtra("title", (String) mList.get(position).getServerData().get("article_title"));
        intent.putExtra("origin", (String) mList.get(position).getServerData().get("article_source"));
        intent.putExtra("time", (String) mList.get(position).getServerData().get("article_time"));
        intent.putExtra("content", (String) mList.get(position).getServerData().get("article_content"));
        intent.putExtra("objectId", mList.get(position).getObjectId());
        Log.d(TAG,"查看传值-------》" + mList.get(position).getServerData().get("article_title") + mList.get(position).getObjectId());
        startActivity(intent);
      }
    });

    mCardView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(getActivity(), WebViewActivity.class);
        intent.putExtra("web", ConnUrls.YIQING2);
        startActivity(intent);
      }
    });
  }

  private void addHistory(String objectId, String origin, String title, String time, String content, String pic) {
    News news = new News(objectId, origin, time, title, content, pic);
    mRepository.insertNews(news);
    Log.e(TAG,"插入历史记录----》");
    mLiveData.removeObservers(getViewLifecycleOwner());
  }

  private void initView() {
    View header = LayoutInflater.from(getContext()).inflate(R.layout.item_covid, null);
    mViewModel = new ViewModelProvider(requireActivity()).get(NewsViewModel.class);
    mCOVIDVIewModel = new ViewModelProvider(requireActivity()).get(COVIDVIewModel.class);
    LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
    layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
    mAdapter = new NewsAdapter(R.layout.item_news, mList);
    mAdapter.setHeaderView(header);
    binding.recycle.setLayoutManager(layoutManager);
    binding.recycle.setAdapter(mAdapter);
    mCardView = header.findViewById(R.id.yi_qing);
    mTextView1 = header.findViewById(R.id.jingwai);
    mTextView2 = header.findViewById(R.id.jingwai1);
    mTextView3 = header.findViewById(R.id.wuzheng);
    mTextView4 = header.findViewById(R.id.wuzheng1);
    mTextView5 = header.findViewById(R.id.xianyou);
    mTextView6 = header.findViewById(R.id.xianyou1);
    mTextView7 = header.findViewById(R.id.quezhen);
    mTextView8 = header.findViewById(R.id.quezhen1);
    mTextView9 = header.findViewById(R.id.siwang);
    mTextView10 = header.findViewById(R.id.siwang1);
    mTextView11 = header.findViewById(R.id.zhiyu);
    mTextView12 = header.findViewById(R.id.zhiyu1);
    mTextView13 = header.findViewById(R.id.textView13);
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");// HH:mm:ss
    Date date = new Date(System.currentTimeMillis());
    mTextView13.setText("截止到:" + simpleDateFormat.format(date));
  }

  private void initData() {
    //新闻数据
    if (mViewModel.getNewsData().getValue() == null){
      mViewModel.requestData();
    }
    mViewModel.getNewsData().observe(getViewLifecycleOwner(), new Observer<List<AVObject>>() {
      @Override
      public void onChanged(List<AVObject> avObjects) {
        mList.addAll(avObjects);
        Log.d(TAG,"查看新闻数据--->" + mList.toString());
        if (mList.size() != 0){
          binding.progressBar.setVisibility(View.GONE);
          binding.recycle.setVisibility(View.VISIBLE);
        }
        mAdapter.setList(avObjects);
        mAdapter.notifyDataSetChanged();
      }
    });
    //疫情图
    if (mCOVIDVIewModel.getLiveData().getValue() == null){
      mCOVIDVIewModel.requestData();
    }
    mCOVIDVIewModel.getLiveData().observe(getViewLifecycleOwner(), new Observer<List<COVIDBean.NewslistDTO>>() {
      @Override
      public void onChanged(List<COVIDBean.NewslistDTO> newslistDTOS) {
        if (newslistDTOS.size() != 0){
          mTextView1.setText(newslistDTOS.get(0).getDesc().getSuspectedCount() + "");
          mTextView2.setText("+" + newslistDTOS.get(0).getDesc().getSuspectedIncr());
          mTextView3.setText(newslistDTOS.get(0).getDesc().getSeriousCount()+ "");
          mTextView4.setText("+" + newslistDTOS.get(0).getDesc().getSeriousIncr());
          mTextView5.setText(newslistDTOS.get(0).getDesc().getCurrentConfirmedCount()+ "");
          mTextView6.setText("+" + newslistDTOS.get(0).getDesc().getCurrentConfirmedIncr());
          mTextView7.setText(newslistDTOS.get(0).getDesc().getConfirmedCount()+ "");
          mTextView8.setText("+" + newslistDTOS.get(0).getDesc().getConfirmedIncr());
          mTextView9.setText(newslistDTOS.get(0).getDesc().getDeadCount()+ "");
          mTextView10.setText("+" + newslistDTOS.get(0).getDesc().getDeadIncr());
          mTextView11.setText(newslistDTOS.get(0).getDesc().getCuredCount()+ "");
          mTextView12.setText("+" + newslistDTOS.get(0).getDesc().getCuredIncr());
        }
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
            mCOVIDVIewModel.requestData();
            mViewModel.requestData();
            mAdapter.setList(mList);
          }
        }, 1000);
      }
    });
  }

  @Override
  public void onResume() {
    super.onResume();
    mHandler.removeCallbacks(mRunnable);
    mHandler.postDelayed(mRunnable,600000);
  }

  @Override
  public void onPause() {
    super.onPause();
    mHandler.removeCallbacks(mRunnable);
  }

}