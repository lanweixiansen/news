package com.example.stocknews.Base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.dueeeke.videoplayer.player.VideoViewManager;
import com.example.stocknews.databinding.ViewMoreBinding;

public abstract class BaseFragment extends Fragment {
  private View mRootView;

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

    if (mRootView == null) {
      mRootView = inflater.inflate(loadRootView(), container, false);
      initView();
    }
    return mRootView;

  }

  public <T extends View> T findViewById(@IdRes int id) {
    return mRootView.findViewById(id);
  }

  protected void initView() {
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
  }

  protected abstract int loadRootView();

  protected VideoViewManager getVideoViewManager() {
    return VideoViewManager.instance();
  }
}
