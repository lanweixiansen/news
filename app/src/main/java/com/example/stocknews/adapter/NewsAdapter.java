package com.example.stocknews.adapter;

import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.stocknews.R;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import cn.leancloud.AVObject;

public class NewsAdapter extends BaseQuickAdapter<AVObject, BaseViewHolder> implements LoadMoreModule {
  private static final String TAG = NewsAdapter.class.getSimpleName();

  public NewsAdapter(int layoutResId, @Nullable List<AVObject> data) {
    super(layoutResId, data);
  }

  @Override
  protected void convert(@NotNull BaseViewHolder baseViewHolder, AVObject dataDTO) {
    Log.d(TAG,"dataDTO------->" + dataDTO.getServerData());
    baseViewHolder.setText(R.id.news_title, dataDTO.getServerData().get("article_title").toString())
            .setText(R.id.news_origin, dataDTO.getServerData().get("article_source").toString())
            .setText(R.id.news_time, dataDTO.getServerData().get("article_time").toString().substring(0, 10))
    .setImageResource(R.id.news_image, R.mipmap.login3);
    if (dataDTO.getServerData().get("article_img") != null){
      Glide.with(getContext())
              .load(dataDTO.getServerData().get("article_img").toString())
              .into((ImageView) baseViewHolder.getView(R.id.news_image));
    }



  }
}
