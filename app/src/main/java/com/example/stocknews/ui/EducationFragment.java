package com.example.stocknews.ui;

import android.content.pm.ActivityInfo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnLoadMoreListener;
import com.dueeeke.videocontroller.StandardVideoController;
import com.dueeeke.videocontroller.component.CompleteView;
import com.dueeeke.videocontroller.component.ErrorView;
import com.dueeeke.videocontroller.component.GestureView;
import com.dueeeke.videocontroller.component.PrepareView;
import com.dueeeke.videocontroller.component.TitleView;
import com.dueeeke.videocontroller.component.VodControlView;
import com.dueeeke.videoplayer.player.VideoView;
import com.example.stocknews.Base.VideoBaseFragment;
import com.example.stocknews.MainActivity;
import com.example.stocknews.Tools.DataUtil;
import com.example.stocknews.Tools.Tag;
import com.example.stocknews.Tools.Utils;
import com.example.stocknews.Bean.VideoBean;
import com.example.stocknews.Interface.OnItemChildClickListener;
import com.example.stocknews.R;
import com.example.stocknews.ViewModel.VideoViewModel;
import com.example.stocknews.adapter.VideoRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

import cn.leancloud.AVObject;

/**
 * 视频
 */
public class EducationFragment extends VideoBaseFragment {

  private static final String TAG = EducationFragment.class.getSimpleName();
  protected List<AVObject> mVideos = new ArrayList<>();
  protected VideoRecyclerViewAdapter mAdapter;
  protected RecyclerView mRecyclerView;
  protected LinearLayoutManager mLinearLayoutManager;
  protected VideoView mVideoView;
  protected StandardVideoController mController;
  protected ErrorView mErrorView;
  protected CompleteView mCompleteView;
  protected TitleView mTitleView;
  private SwipeRefreshLayout mRefreshLayout;
  private PrepareView mPrepareView;
  private FrameLayout mPlayerContainer;
  private ProgressBar mProgressBar;
  private int page2 = 0;
  private int first = 1;

  /**
   * 当前播放的位置
   */
  protected int mCurPos = -1;
  /**
   * 上次播放的位置，用于页面切回来之后恢复播放
   */
  protected int mLastPos = mCurPos;
  private VideoViewModel mVideoViewModel;
  private int page = 0;

  @Override
  protected int getLayoutResId() {
    return R.layout.fragment_education;
  }

  @Override
  protected void initView() {
    super.initView();
    first = 0;
    initVideoView();
    //保存进度
    //mVideoView.setProgressManager(new ProgressManagerImpl());
    mRefreshLayout = findViewById(R.id.swRefreshLayout);
    mProgressBar = findViewById(R.id.progressBar5);
    mVideoViewModel = new ViewModelProvider(requireActivity()).get(VideoViewModel.class);
    mRecyclerView = findViewById(R.id.edu_recycler);
    mLinearLayoutManager = new LinearLayoutManager(getContext());
    mRecyclerView.setLayoutManager(mLinearLayoutManager);
    mAdapter = new VideoRecyclerViewAdapter(R.layout.item_edu, mVideos);
    mRecyclerView.setAdapter(mAdapter);
    //当视频划出屏幕时停止播放
    mRecyclerView.addOnChildAttachStateChangeListener(new RecyclerView.OnChildAttachStateChangeListener() {
      @Override
      public void onChildViewAttachedToWindow(@NonNull View view) {

      }

      @Override
      public void onChildViewDetachedFromWindow(@NonNull View view) {
        FrameLayout frameLayout = view.findViewById(R.id.player_container);
        View v = frameLayout.getChildAt(0);
        if (v != null && v == mVideoView && !mVideoView.isFullScreen()) {
          Log.d(TAG,"test");
          releaseVideoView();
        }
      }
    });
    //点击按钮开始播放
    mAdapter.setOnItemClickListener(new OnItemClickListener() {
      @Override
      public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
        mPlayerContainer = view.findViewById(R.id.player_container);
        mPrepareView = view.findViewById(R.id.prepare_view);
        startPlay(position);
      }
    });
  }

  protected void initVideoView() {
    mVideoView = new VideoView(getActivity());
    mVideoView.setOnStateChangeListener(new VideoView.SimpleOnStateChangeListener() {
      @Override
      public void onPlayStateChanged(int playState) {
        //监听VideoViewManager释放，重置状态
        if (playState == VideoView.STATE_IDLE) {
          Utils.removeViewFormParent(mVideoView);
          mLastPos = mCurPos;
          mCurPos = -1;
        }
      }
    });
    mController = new StandardVideoController(getActivity());
    mErrorView = new ErrorView(getActivity());
    mController.addControlComponent(mErrorView);
    mCompleteView = new CompleteView(getActivity());
    mController.addControlComponent(mCompleteView);
    mTitleView = new TitleView(getActivity());
    mController.addControlComponent(mTitleView);
    mController.addControlComponent(new VodControlView(getActivity()));
    mController.addControlComponent(new GestureView(getActivity()));
    mController.setEnableOrientation(true);
    mVideoView.setVideoController(mController);
  }

  @Override
  protected void initData() {
    super.initData();
    DataUtil.setPage(page);
    if (mVideoViewModel.getLiveData().getValue() == null){
      mVideoViewModel.requestData();
    }
    mVideoViewModel.getLiveData().observe(getViewLifecycleOwner(), new Observer<List<AVObject>>() {
      @Override
      public void onChanged(List<AVObject> dataDTOS) {
        if (mVideos != null){
          mProgressBar.setVisibility(View.GONE);
          mRecyclerView.setVisibility(View.VISIBLE);
        }
        if (page2 == 0){
          mVideos.addAll(dataDTOS);
          mAdapter.setList(dataDTOS);
        }else {
          mAdapter.addData(dataDTOS);
        }

        mAdapter.notifyDataSetChanged();
      }
    });

    //下拉刷新数据
    initRefreshLayout();
    //加载更多
//    initLoadMore();

  }

  private void initLoadMore() {
    mAdapter.getLoadMoreModule().setOnLoadMoreListener(new OnLoadMoreListener() {
      @Override
      public void onLoadMore() {
        mRefreshLayout.setRefreshing(false);
        mAdapter.getLoadMoreModule().setEnableLoadMore(true);
        mRecyclerView.postDelayed(new Runnable() {
          @Override
          public void run() {
            page2++;
            DataUtil.setPage(page2);
            mVideoViewModel.requestData();
            if (mVideoViewModel.getLiveData().getValue().isEmpty()){
                mAdapter.getLoadMoreModule().loadMoreEnd();
                return;
            }
            mAdapter.getLoadMoreModule().loadMoreComplete();
          }
        },100);
      }
    });
    mAdapter.getLoadMoreModule().setAutoLoadMore(true);
    //当自动加载开启，同时数据不满一屏时，是否继续执行自动加载更多(默认为true)
    mAdapter.getLoadMoreModule().setEnableLoadMoreIfNotFullPage(true);
  }

  /**
   * 下拉刷新
   */
  private void initRefreshLayout() {
    mRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
      @Override
      public void onRefresh() {
        mAdapter.getLoadMoreModule().setEnableLoadMore(false);
        page2 = 0;
        DataUtil.setPage(page2);
        mRecyclerView.postDelayed(new Runnable() {
          @Override
          public void run() {
            mRefreshLayout.setRefreshing(false);
            mVideos.clear();
            mAdapter.notifyDataSetChanged();
            mVideoViewModel.requestData();
          }
        }, 1000);
      }
    });
  }

  @Override
  protected boolean isLazyLoad() {
    return true;
  }

  @Override
  public void onStop() {
    super.onStop();
  }

  @Override
  public void onPause() {
    super.onPause();
    pause();
  }

  /**
   * 由于onPause必须调用super。故增加此方法，
   * 子类将会重写此方法，改变onPause的逻辑
   */
  protected void pause() {
    releaseVideoView();
  }

  @Override
  public void onResume() {
    super.onResume();
    resume();
  }

  /**
   * 由于onResume必须调用super。故增加此方法，
   * 子类将会重写此方法，改变onResume的逻辑
   */
  protected void resume() {
    if (mLastPos == -1)
      return;
    if (MainActivity.mCurrentIndex != 2)
      return;
    //恢复上次播放的位置
    startPlay(mLastPos);
  }

  /**
   * PrepareView被点击
   */

  /**
   * 开始播放
   * @param position 列表位置
   */
  protected void startPlay(int position) {
    Log.d(TAG,"aaa");
    if (mCurPos == position) return;
    if (mCurPos != -1) {
      releaseVideoView();
    }
    AVObject videoBean = mVideos.get(position);
    mVideoView.setUrl((String) videoBean.getServerData().get("content"));
    mTitleView.setTitle((String) videoBean.getServerData().get("title"));
    View itemView = mLinearLayoutManager.findViewByPosition(position);
    if (itemView == null) return;
    mController.addControlComponent(mPrepareView, true);
    Utils.removeViewFormParent(mVideoView);
    mPlayerContainer.addView(mVideoView, 0);
    getVideoViewManager().add(mVideoView, Tag.LIST);
    mVideoView.start();
    mCurPos = position;
  }

  private void releaseVideoView() {
    mVideoView.release();
    if (mVideoView.isFullScreen()) {
      mVideoView.stopFullScreen();
    }
    if(getActivity().getRequestedOrientation() != ActivityInfo.SCREEN_ORIENTATION_PORTRAIT) {
      getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }
    mCurPos = -1;
  }

  @Override
  public void setUserVisibleHint(boolean isVisibleToUser) {
    super.setUserVisibleHint(isVisibleToUser);
    Log.d(TAG,"aaaaa------>" + first);
    if (first == 0){
      if (!isVisibleToUser){
        releaseVideoView();
      }
    }

  }
}
