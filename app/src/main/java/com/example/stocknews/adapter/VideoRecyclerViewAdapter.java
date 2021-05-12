package com.example.stocknews.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.dueeeke.videocontroller.component.PrepareView;
import com.example.stocknews.Bean.VideoBean;
import com.example.stocknews.Interface.OnItemChildClickListener;
import com.example.stocknews.Interface.OnItemClickListener;
import com.example.stocknews.R;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import cn.leancloud.AVObject;

public class VideoRecyclerViewAdapter extends BaseQuickAdapter<AVObject, BaseViewHolder> implements LoadMoreModule{

  private List<VideoBean.DataDTO> videos;
  private OnItemChildClickListener mOnItemChildClickListener;
  private OnItemClickListener mOnItemClickListener;
  static final int TYPE_COMMON_VIEW = 100001;//普通类型 Item
  private static final int TYPE_FOOTER_VIEW = 100002;//footer类型 Item

  public VideoRecyclerViewAdapter(int layoutResId, @Nullable List<AVObject> data) {
    super(layoutResId, data);
  }


  @Override
  protected void convert(@NotNull BaseViewHolder baseViewHolder, AVObject dataDTO) {
    Glide.with(getContext())
            .load((String) dataDTO.getServerData().get("pic"))
            .placeholder(android.R.color.darker_gray)
            .into((ImageView) baseViewHolder.getView(R.id.thumb));
    baseViewHolder.setText(R.id.edu_title, (String) dataDTO.getServerData().get("title"))
            .setImageResource(R.id.edu_img, R.mipmap.yuan2)
            .setText(R.id.edu_time, (String) dataDTO.getServerData().get("time"));


  }

}
