package com.example.stocknews.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.stocknews.Bean.AlertsBean;
import com.example.stocknews.R;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class EducationAdapter extends BaseQuickAdapter<AlertsBean.DataDTO, BaseViewHolder> {
  public EducationAdapter(int layoutResId, @Nullable List<AlertsBean.DataDTO> data) {
    super(layoutResId, data);
  }

  @Override
  protected void convert(@NotNull BaseViewHolder baseViewHolder, AlertsBean.DataDTO dataDTO) {
    baseViewHolder.setText(R.id.edu_title, dataDTO.getTitle());

  }
}
