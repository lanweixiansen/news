package com.example.stocknews;

import android.content.Context;
import android.content.Intent;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.example.stocknews.Base.BaseActivity2;
import com.example.stocknews.Tools.DataUtil;
import com.example.stocknews.adapter.CommentsAdapter;
import com.example.stocknews.databinding.ActivityNewsBinding;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.leancloud.AVException;
import cn.leancloud.AVObject;
import cn.leancloud.AVQuery;
import cn.leancloud.AVUser;
import cn.leancloud.livequery.AVLiveQuery;
import cn.leancloud.livequery.AVLiveQueryEventHandler;
import cn.leancloud.livequery.AVLiveQuerySubscribeCallback;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

public class NewsActivity extends BaseActivity2<ActivityNewsBinding> {
  private static final String TAG = NewsActivity.class.getSimpleName();
  private List<AVObject> mBeanList = new ArrayList<>();
  private CommentsAdapter mCommentsAdapter;
  private String title, origin, time, content, newsObject;
  private String newsInfoObject;
  String like = "0", collection = "0";
  //给发送按钮添加监听，内容为空不能发送内容
  private final TextWatcher mWatcher = new TextWatcher() {
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
      boolean ok = binding.newsPinglun.getText().toString().trim().isEmpty();
      binding.buttonPost.setEnabled(!ok);
    }

    @Override
    public void afterTextChanged(Editable s) {}
  };
  private View mViewPL;
  private ImageView mZan;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    DataUtil.NEWSINFO = false;
    //接收文章信息
    Intent intent = getIntent();
    title = intent.getStringExtra("title");
    origin = intent.getStringExtra("origin");
    time = intent.getStringExtra("time");
    content = intent.getStringExtra("content");
    newsObject = intent.getStringExtra("objectId");
    //评论框添加观察
    binding.newsPinglun.addTextChangedListener(mWatcher);
    binding.buttonPost.setEnabled(false);
    //添加评论视图
    LinearLayoutManager layoutManager = new LinearLayoutManager(this);
    layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
    //添加评论区视图
    mViewPL = LayoutInflater.from(NewsActivity.this).inflate(R.layout.item_pinglun, null);
    mZan = mViewPL.findViewById(R.id.pl_dianzan);
    mCommentsAdapter = new CommentsAdapter(R.layout.item_pinglun, mBeanList);
    binding.newRecycle.setLayoutManager(layoutManager);
    binding.newRecycle.setAdapter(mCommentsAdapter);
    binding.webView2.getSettings().setJavaScriptEnabled(true);
    binding.webView2.getSettings().setBuiltInZoomControls(true);
    binding.webView2.getSettings().setDisplayZoomControls(false);
    binding.webView2.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY); //取消滚动条白边效果
    binding.webView2.getSettings().setDefaultTextEncodingName("UTF-8") ;
    binding.webView2.getSettings().setBlockNetworkImage(false);
    initData();
    onClick();
  }



  /**
   * 初始化新闻详情数据
   */
  private void initData() {
    binding.newsTitle1.setText(title);
    binding.newsTitle2.setText(title);
    binding.newsOrigin1.setText(origin);
    binding.newsTime1.setText(time);
    if (content != null){
      binding.webView2.loadDataWithBaseURL("http://avatar.csdn.net",setWebVIewImage(content),
              "text/html", "UTF-8", null);
    }
    //加载点赞收藏评论信息
    if (!App.getLoginToken().equals("0")){
      AVQuery<AVObject> avQuery = new AVQuery<>("NewsInfo");
      avQuery.whereEqualTo("user", AVUser.getCurrentUser());
      avQuery.whereEqualTo("newsObject", newsObject);
      avQuery.findInBackground().subscribe(new Observer<List<AVObject>>() {
        @Override
        public void onSubscribe(@NonNull Disposable d) {}
        @Override
        public void onNext(@NonNull List<AVObject> avObjects) {
          Log.d(TAG,"查看新闻信息------》" + avObjects.toString());
          if (avObjects.size() != 0){
            Log.d(TAG,"进来没有");
            like = (String) avObjects.get(0).getServerData().get("like");
            collection = (String) avObjects.get(0).getServerData().get("collection");
            newsInfoObject = avObjects.get(0).getObjectId();
            mBeanList = avObjects;
            DataUtil.NEWSINFO = true;
            changeCollectionInfo();
            changeLikeInfo();
          }
        }
        @Override
        public void onError(@NonNull Throwable e) {}
        @Override
        public void onComplete() {}
      });
    }
    //加载评论信息
    loadCommentInfo();

  }


  /**
   * 处理用户点击事件
   */
  private void onClick() {
    //点击返回键返回
    binding.newsBack.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        finish();
      }
    });
    //点击输入评论弹出输入框
    binding.newsPost.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        //判断是否是免登陆，如果是，跳转到登陆页面
        if (App.getLoginToken().equals("0")){
          goToLogin();
        } else {
          showSoftInput(NewsActivity.this, R.id.news_pinglun);
          binding.clDianji.setVisibility(View.GONE);
          binding.clShuru.setVisibility(View.VISIBLE);
          focusKeywordView(binding.newsPinglun);
          binding.newsPinglun.setSelection(binding.newsPinglun.getText().length());
        }
      }
    });
    //点赞
    binding.newsZan.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        if (App.getLoginToken().equals("0")){
          goToLogin();
        } else {
          setLikeInfo();
        }
      }
    });
    //收藏
    binding.newsShouCang.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        if (App.getLoginToken().equals("0")){
          goToLogin();
        } else {
          setCollectionInfo();
        }
      }
    });
    //点击发送评论
    binding.buttonPost.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        String time = getTime();
        postComment(App.getName(), binding.newsPinglun.getText().toString(), time);
        binding.newsPinglun.setText("");
        binding.clShuru.setVisibility(View.GONE);
        binding.clDianji.setVisibility(View.VISIBLE);
        loadCommentInfo();
      }
    });
//    //评论点赞
//    mZan.setOnClickListener(new View.OnClickListener() {
//      @Override
//      public void onClick(View v) {
//
//      }
//    });

  }

  private String getTime() {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// HH:mm:ss
    Date date = new Date(System.currentTimeMillis());
    return simpleDateFormat.format(date);
  }

  /**
   * 加载评论信息
   */
  private void loadCommentInfo() {
    AVQuery<AVObject> avQuery = new AVQuery<>("NewsInfo");
    avQuery.whereEqualTo("newsObject", newsObject);
    avQuery.whereEqualTo("user", null);
    avQuery.findInBackground().subscribe(new Observer<List<AVObject>>() {
      @Override
      public void onSubscribe(@NonNull Disposable d) {}
      @Override
      public void onNext(@NonNull List<AVObject> avObjects) {
        Log.d(TAG,"查看评论信息------》" + avObjects.toString());
        if (!avObjects.toString().equals("[]")){
          newsInfoObject = avObjects.get(0).getObjectId();
          mBeanList = avObjects;
          mCommentsAdapter.setList(avObjects);
          mCommentsAdapter.notifyDataSetChanged();
          binding.plCount.setText(String.valueOf(avObjects.size()));
        }
      }
      @Override
      public void onError(@NonNull Throwable e) {}
      @Override
      public void onComplete() {}
    });
    AVLiveQuery liveQuery = AVLiveQuery.initWithQuery(avQuery);
    liveQuery.subscribeInBackground(new AVLiveQuerySubscribeCallback() {
      @Override
      public void done(AVException e) {
        //TODO:订阅成功
        Log.d(TAG,"订阅成功！");
      }
    });
    liveQuery.setEventHandler(new AVLiveQueryEventHandler() {
      @Override
      public void onObjectCreated(AVObject avObject) {
        super.onObjectCreated(avObject);
        mBeanList.add(avObject);
        mCommentsAdapter.setList(mBeanList);
      }
    });
  }

  /**
   * 发送评论
   * @param name
   * @param content
   */
  private void postComment(String name, String content, String time) {
    AVObject object = new AVObject("NewsInfo");
    object.put("newsObject", newsObject);
    object.put("pl_name", name);
    object.put("pl_content", content);
    object.put("pl_time", time);
    if (!App.getHead().equals("0")){
      object.put("pl_head", App.getHead());
    }
    object.saveInBackground().subscribe(new Observer<AVObject>() {
      @Override
      public void onSubscribe(@NonNull Disposable d) {}
      @Override
      public void onNext(@NonNull AVObject avObject) {
        loadCommentInfo();
      }
      @Override
      public void onError(@NonNull Throwable e) {
        Log.d(TAG,"错误-->" + e.toString());
      }
      @Override
      public void onComplete() {}
    });
  }

  //更改收藏状态
  private void setCollectionInfo() {
    if (!DataUtil.NEWSINFO){
      Log.d(TAG,"one");
      AVObject object = new AVObject("NewsInfo");
      object.put("user", AVUser.getCurrentUser());
      object.put("newsObject", newsObject);
      object.put("collection", "1");
      object.saveInBackground().subscribe(new Observer<AVObject>() {
        @Override
        public void onSubscribe(@NonNull Disposable d) {}
        @Override
        public void onNext(@NonNull AVObject avObject) {
          collection = "1";
          DataUtil.NEWSINFO = true;
          changeCollectionInfo();
        }
        @Override
        public void onError(@NonNull Throwable e) {
          Log.d(TAG,"错误-->" + e.toString());
        }
        @Override
        public void onComplete() {}
      });

    }else {
      Log.d(TAG,"two");
      new Thread(new Runnable() {
        @Override
        public void run() {
          AVObject todo = AVObject.createWithoutData("NewsInfo", newsInfoObject);
          if (collection.equals("0")){
            collection = "1";
            todo.put("collection", collection);
          }else {
            collection = "0";
            todo.put("collection", collection);
          }
          changeCollectionInfo();
          todo.save();
        }
      }).start();
    }
  }

  //更改收藏状态
  private void changeCollectionInfo() {
    if (collection.equals("1")){
      binding.newsShouCang.setImageResource(R.mipmap.shoucang2);
    }
    else {
      binding.newsShouCang.setImageResource(R.mipmap.shoucang1);
    }
  }

  //更改点赞状态
  private void changeLikeInfo() {
    if (like.equals("1")){
      binding.newsZan.setImageResource(R.mipmap.like);
    }else {
      binding.newsZan.setImageResource(R.mipmap.like2);
    }
  }

  //文章点赞
  private void setLikeInfo() {
    if (!DataUtil.NEWSINFO){
      Log.d(TAG,"one");
      AVObject object = new AVObject("NewsInfo");
      object.put("user", AVUser.getCurrentUser());
      object.put("newsObject", newsObject);
      object.put("like", "1");
      object.saveInBackground().subscribe(new Observer<AVObject>() {
        @Override
        public void onSubscribe(@NonNull Disposable d) {}
        @Override
        public void onNext(@NonNull AVObject avObject) {
          like = "1";
          DataUtil.NEWSINFO = true;
          changeLikeInfo();
        }
        @Override
        public void onError(@NonNull Throwable e) {
          Log.d(TAG,"错误-->" + e.toString());
        }
        @Override
        public void onComplete() {}
      });

    }else {
      Log.d(TAG,"two");
      new Thread(new Runnable() {
        @Override
        public void run() {
          AVObject todo = AVObject.createWithoutData("NewsInfo", newsInfoObject);
          if (like.equals("0")){
            like = "1";
            todo.put("like", like);
          }else {
            like = "0";
            todo.put("like",like);
          }
          changeLikeInfo();
          todo.save();
        }
      }).start();
    }
  }

//  //评论点赞
//  public void setPLLikeInfo(){
//    new Thread(new Runnable() {
//      @Override
//      public void run() {
//        AVObject todo = AVObject.createWithoutData("NewsInfo", newsInfoObject);
//
//      }
//    }).start();
//  }

  private void focusKeywordView(EditText edt) {
    if (edt != null) {
      edt.requestFocus();
    }
  }

  // 显示软键盘
  public void showSoftInput(Context context, int viewComment) {
    InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
    imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
  }

  private void goToLogin() {
    App.setLoginToken(null);
    App.setName(null);
    Intent intent = new Intent(NewsActivity.this, LoginActivity.class);
    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
    startActivity(intent);
    finish();
  }

  public static String setWebVIewImage(String star) {
    String head = "<head>"
            + "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, user-scalable=no\"> "
            + "<style>img{max-width: 100%; width:auto; height:auto;}</style>"
            + "<style>table{max-width: 100%; width:auto; height:auto;}</style>"
            + "</head>";
    return "<html>" + head + "<body>" + star + "</body></html>";
  }


}