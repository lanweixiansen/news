package com.example.stocknews.adapter;

import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.stocknews.Bean.News;
import com.example.stocknews.R;
import com.example.stocknews.ui.HistoryActivity;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class HistoryAdapter extends BaseQuickAdapter<News, BaseViewHolder> {
  private static final String TAG = HistoryAdapter.class.getSimpleName();

  public HistoryAdapter(int layoutResId, @Nullable List<News> data) {
    super(layoutResId, data);
  }

  @Override
  protected void convert(@NotNull BaseViewHolder baseViewHolder, News news) {
    Log.d(TAG,"text--->" + news.getTitle());
    baseViewHolder.setText(R.id.news_title, news.getTitle())
            .setText(R.id.news_origin, news.getOrigin())
            .setText(R.id.news_time, news.getPubTime().substring(0, 10))
            .setImageResource(R.id.news_image, R.mipmap.login3);
    if (news.getPic() != null) {
      Glide.with(getContext())
              .load(news.getPic())
              .into((ImageView) baseViewHolder.getView(R.id.news_image));

    }
  }
}
