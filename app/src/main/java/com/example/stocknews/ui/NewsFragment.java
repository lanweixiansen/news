package com.example.stocknews.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.stocknews.Base.BaseFragment;
import com.example.stocknews.R;
import com.example.stocknews.adapter.FragmentAdapter;
import com.flyco.tablayout.SlidingTabLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

/**
 * 新闻
 */
public class NewsFragment extends BaseFragment {
  private static final String TAG = NewsFragment.class.getSimpleName();
  private final ArrayList<Fragment> mFragments = new ArrayList<>();
  private final String[] mTitles = {
          "抗击肺炎", "时尚", "科技"
          , "游戏", "军事", "财经", "汽车"
  };
  private FloatingActionButton mButton;

  @Override
  protected int loadRootView() {
    return R.layout.fragment_news2;
  }

  @Override
  public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    onClick();
  }

  private void onClick() {
    mButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        //TODO:跳转到搜索页面
        startActivity(new Intent(getContext(), SearchActivity.class));
      }
    });
  }


  @Override
  protected void initView() {
    super.initView();
    mFragments.add(new COVIDFragment());
    mFragments.add(new EntertainmentFragment());
    mFragments.add(new TechnologyFragment());
    mFragments.add(new FoodFragment());
    mFragments.add(new MilitaryFragment());
    mFragments.add(new MoneyFragment());
    mFragments.add(new CarFragment());
    Toolbar toolbar = findViewById(R.id.toolabr);
    SlidingTabLayout tabLayout = findViewById(R.id.news_tab);
    ViewPager viewPager = findViewById(R.id.news_viewPager);
    mButton = findViewById(R.id.floatingActionButton);
    toolbar.setTitle("");
    viewPager.setAdapter(new FragmentAdapter(getParentFragmentManager(),mFragments,mTitles));
    tabLayout.setViewPager(viewPager);
    viewPager.setOnScrollChangeListener(new View.OnScrollChangeListener() {
      @Override
      public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {

      }
    });



  }


}