package com.example.stocknews;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.example.stocknews.Base.BaseActivity;
import com.example.stocknews.Repository.Repository;
import com.example.stocknews.Tools.Tag;
import com.example.stocknews.ui.EducationFragment;
import com.example.stocknews.ui.HotSportFragment;
import com.example.stocknews.ui.MineFragment;
import com.example.stocknews.ui.NewsFragment;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {

  private RadioGroup mRgTabBar;
  private RadioButton mInf;
  private RadioButton mMarket;
  private RadioButton mData;
  private RadioButton mStrategy;
  private List<String> mFragmentTagList;
  public static int mCurrentIndex;
  private long exitTime = 0;//记录用户点击返回按钮的时间
  private static final String INF_FRAGMENT = "InformationFragment";
  private static final String MARKET_FRAGMENT = "MarketFragment";
  private static final String DATA_FRAGMENT = "DataFragment";
  private static final String STRATEGY_FRAGMENT = "MineFragment";
  Repository mRepository = new Repository(MainActivity.this);

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    changStatusIconCollor(true);
    //初始化控件
    initView();
    //初始化数据
    initData();
    //控件监听
    setListener();
  }

  private void initView() {
    mRgTabBar = findViewById(R.id.main_tab_bar);
    mInf = findViewById(R.id.main_ziXun);
    mMarket = findViewById(R.id.main_shiChang);
    mData = findViewById(R.id.main_data);
    mStrategy = findViewById(R.id.main_ceLue);
    mCurrentIndex = 0;
  }

  private void initData() {
    mFragmentTagList = new ArrayList<>();
    mFragmentTagList.add(INF_FRAGMENT);
    mFragmentTagList.add(MARKET_FRAGMENT);
    mFragmentTagList.add(DATA_FRAGMENT);
    mFragmentTagList.add(STRATEGY_FRAGMENT);
    //初始化fragment
    FragmentManager manager = getSupportFragmentManager();
    FragmentTransaction transaction = manager.beginTransaction();
    for (String tag : mFragmentTagList) {
      Fragment fragment = manager.findFragmentByTag(tag);
      if (fragment == null) {
        switch (tag) {
          case INF_FRAGMENT:
            fragment = new NewsFragment();
            //首页默认显示
            transaction.show(fragment);
            mInf.setChecked(true);
            break;
          case MARKET_FRAGMENT:
            fragment = new HotSportFragment();
            transaction.hide(fragment);
            mMarket.setChecked(false);
            break;
          case DATA_FRAGMENT:
            fragment = new EducationFragment();
            transaction.hide(fragment);
            mData.setChecked(false);
            break;
          case STRATEGY_FRAGMENT:
            fragment = new MineFragment();
            transaction.hide(fragment);
            mStrategy.setChecked(false);
          default:
            break;
        }
      }
      if (!fragment.isAdded()) {
        transaction.add(R.id.frame_layout, fragment, tag);
      }
    }
    //提交事务
    transaction.commitAllowingStateLoss();
  }
  

  private void setListener() {
    mRgTabBar.setOnCheckedChangeListener(this);
  }

  @Override
  public void onCheckedChanged(RadioGroup group, int checkedId) {
    int index = 0;
    switch (checkedId) {
      case R.id.main_ziXun:
        showFragmentByTag(INF_FRAGMENT);
        index = 0;
        break;
      case R.id.main_shiChang:
        showFragmentByTag(MARKET_FRAGMENT);
        index = 1;
        break;
      case R.id.main_data:
        showFragmentByTag(DATA_FRAGMENT);
        index = 2;
        break;
      case R.id.main_ceLue:
        showFragmentByTag(STRATEGY_FRAGMENT);
        index = 3;
      default:
        break;
    }
    //切换tab，释放正在播放的播放器
    getVideoViewManager().releaseByTag(Tag.LIST);
    getVideoViewManager().releaseByTag(Tag.SEAMLESS, false);//注意不能移除
    mCurrentIndex = index;

  }

  private void showFragmentByTag(String tag) {
    mInf.setChecked(false);
    mMarket.setChecked(false);
    mData.setChecked(false);
    mStrategy.setChecked(false);
    switch (tag) {
      case INF_FRAGMENT:
        mInf.setChecked(true);
        break;
      case MARKET_FRAGMENT:
        mMarket.setChecked(true);
        break;
      case DATA_FRAGMENT:
        mData.setChecked(true);
        break;
      case STRATEGY_FRAGMENT:
        mStrategy.setChecked(true);
      default:
        break;
    }
    startFragment(tag);
  }

  private void startFragment(String tag) {
    //初始化fragment
    FragmentManager manager = getSupportFragmentManager();
    FragmentTransaction transaction = manager.beginTransaction();
    for (String ftag : mFragmentTagList) {
      Fragment fragment = manager.findFragmentByTag(ftag);
      if (ftag.equals(tag)) {
        transaction.show(fragment);
      } else {
        transaction.hide(fragment);
      }
    }
    //提交事务
    transaction.commitAllowingStateLoss();
  }


  /**
   * 处理用户点击返回按钮事件
   *
   * @param keyCode
   * @param event
   * @return
   */
  @Override
  public boolean onKeyDown(int keyCode, KeyEvent event) {
    //判断是否在全屏播放视频
    if (getVideoViewManager().onBackPress(Tag.LIST))
      return false;
      //判断是否退出程序
    else if (keyCode == KeyEvent.KEYCODE_BACK) {
      exit();
      return false;
    }
    return super.onKeyDown(keyCode, event);
  }

  private void exit() {
    if ((System.currentTimeMillis() - exitTime) > 2000) {
      Toast.makeText(getApplicationContext(), "再按一次退出程序",
              Toast.LENGTH_SHORT).show();
      exitTime = System.currentTimeMillis();
    } else {
      finish();
      System.exit(0);
    }
  }

  @Override
  public void onClick(View v) {

  }

  public void changStatusIconCollor(boolean setDark) {
    Window window =this.getWindow();
    window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
    window.setStatusBarColor(ContextCompat.getColor(this,R.color.white));
    View decorView = getWindow().getDecorView();
    if(decorView != null){
      int vis = decorView.getSystemUiVisibility();
      if(setDark){
        vis |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
      } else{
        vis &= ~View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
      }
      decorView.setSystemUiVisibility(vis);
    }
  }

  @Override
  protected void onPause() {
    super.onPause();
  }

  @Override
  protected void onResume() {
    super.onResume();
  }
}
