package com.example.stocknews.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.List;

public class FragmentAdapter extends FragmentStatePagerAdapter {

  private List<Fragment> mFragments;
  private String[] mTabs;

  public FragmentAdapter(@NonNull FragmentManager fm, List<Fragment> mFragments, String[] mTabs) {
    super(fm);
    this.mFragments = mFragments;
    this.mTabs = mTabs;

  }

  @NonNull
  @Override
  public Fragment getItem(int position) {
    return mFragments.get(position);
  }

  @Override
  public int getCount() {
    return mFragments.size();
  }

  @Nullable
  @Override
  public CharSequence getPageTitle(int position) {
    return mTabs[position];
  }

}
