package com.example.stocknews.adapter;

import android.text.format.DateUtils;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.stocknews.Bean.CommentsBean;
import com.example.stocknews.R;
import com.example.stocknews.Tools.DataUtil;
import com.example.stocknews.Tools.DateUtil;
import com.example.stocknews.Tools.GetTimeAgo;
import com.google.protobuf.StringValue;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import cn.leancloud.AVObject;

public class CommentsAdapter extends BaseQuickAdapter<AVObject, BaseViewHolder> {
  private static final String TAG = CommentsAdapter.class.getSimpleName();
  private String mS;

  public CommentsAdapter(int layoutResId, @Nullable List<AVObject> data) {
    super(layoutResId, data);
  }

  @Override
  protected void convert(@NotNull BaseViewHolder baseViewHolder, AVObject avObject) {
      baseViewHolder.setImageResource(R.id.pl_head, R.mipmap.touxiang)
              .setText(R.id.pl_name, avObject.getServerData().get("pl_name").toString())
              .setText(R.id.pl_content, avObject.getServerData().get("pl_content").toString());
      if (avObject.getServerData().get("pl_head") != null) {
        Glide.with(getContext())
                .load(avObject.getServerData().get("pl_head"))
                .into((ImageView) baseViewHolder.getView(R.id.pl_head));
      }

      if (avObject.getServerData().get("pl_time") != null){
        baseViewHolder.setText(R.id.pl_time, setTime(avObject.getServerData().get("pl_time").toString()));
      }
  }

  private String setTime(String time) {
    return GetTimeAgo.getTimeAgo(DateUtil.parseStringToLong(time));
  }


}
