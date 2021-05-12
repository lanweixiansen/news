package com.example.stocknews.adapter;

import android.util.Log;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.stocknews.R;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import cn.leancloud.AVObject;

public class HotInfoAdapter extends BaseQuickAdapter<AVObject, BaseViewHolder> {
  public HotInfoAdapter(int layoutResId, @Nullable List<AVObject> data) {
    super(layoutResId, data);
  }

  @Override
  protected void convert(@NotNull BaseViewHolder baseViewHolder, AVObject avObject) {
    baseViewHolder.setText(R.id.textView, avObject.getServerData().get("title").toString());
    int num = baseViewHolder.getLayoutPosition();

    switch (num){
      case 0:
        baseViewHolder.setImageResource(R.id.imageView5, R.mipmap.no1);
        baseViewHolder.setImageResource(R.id.imageView6, R.mipmap.no00);
        break;
      case 1:
        baseViewHolder.setImageResource(R.id.imageView5, R.mipmap.no2);
        baseViewHolder.setImageResource(R.id.imageView6, R.mipmap.no00);
        break;
      case 2:
        baseViewHolder.setImageResource(R.id.imageView5, R.mipmap.no3);
        baseViewHolder.setImageResource(R.id.imageView6, R.mipmap.no00);
        break;
      case 3:
        baseViewHolder.setImageResource(R.id.imageView5, R.mipmap.no4);
        baseViewHolder.setImageResource(R.id.imageView6, R.mipmap.no00);
        break;
      case 4:
        baseViewHolder.setImageResource(R.id.imageView5, R.mipmap.no5);
        baseViewHolder.setImageResource(R.id.imageView6, R.mipmap.no00);
        break;
      case 5:
        baseViewHolder.setImageResource(R.id.imageView5, R.mipmap.no6);
        baseViewHolder.setImageResource(R.id.imageView6, R.mipmap.no00);
        break;
      case 6:
        baseViewHolder.setImageResource(R.id.imageView5, R.mipmap.no7);
        baseViewHolder.setImageResource(R.id.imageView6, R.mipmap.no00);
        break;
      case 7:
        baseViewHolder.setImageResource(R.id.imageView5, R.mipmap.no8);
        baseViewHolder.setImageResource(R.id.imageView6, R.mipmap.no00);
        break;
      case 8:
        baseViewHolder.setImageResource(R.id.imageView5, R.mipmap.no9);
        baseViewHolder.setImageResource(R.id.imageView6, R.mipmap.no00);
        break;
      case 9:
        baseViewHolder.setImageResource(R.id.imageView5, R.mipmap.no11);
        baseViewHolder.setImageResource(R.id.imageView6, R.mipmap.no0);
        break;
      case 10:
        baseViewHolder.setImageResource(R.id.imageView5, R.mipmap.no11);
        baseViewHolder.setImageResource(R.id.imageView6, R.mipmap.no11);
        break;
      case 11:
        baseViewHolder.setImageResource(R.id.imageView5, R.mipmap.no11);
        baseViewHolder.setImageResource(R.id.imageView6, R.mipmap.no22);
        break;
      case 12:
        baseViewHolder.setImageResource(R.id.imageView5, R.mipmap.no11);
        baseViewHolder.setImageResource(R.id.imageView6, R.mipmap.no33);
        break;
      case 13:
        baseViewHolder.setImageResource(R.id.imageView5, R.mipmap.no11);
        baseViewHolder.setImageResource(R.id.imageView6, R.mipmap.no4);
        break;
      case 14:
        baseViewHolder.setImageResource(R.id.imageView5, R.mipmap.no11);
        baseViewHolder.setImageResource(R.id.imageView6, R.mipmap.no5);
        break;
      case 15:
        baseViewHolder.setImageResource(R.id.imageView5, R.mipmap.no11);
        baseViewHolder.setImageResource(R.id.imageView6, R.mipmap.no6);
        break;
      case 16:
        baseViewHolder.setImageResource(R.id.imageView5, R.mipmap.no11);
        baseViewHolder.setImageResource(R.id.imageView6, R.mipmap.no7);
        break;
      case 17:
        baseViewHolder.setImageResource(R.id.imageView5, R.mipmap.no11);
        baseViewHolder.setImageResource(R.id.imageView6, R.mipmap.no7);
        break;
      case 18:
        baseViewHolder.setImageResource(R.id.imageView5, R.mipmap.no11);
        baseViewHolder.setImageResource(R.id.imageView6, R.mipmap.no8);
        break;
      case 19:
        baseViewHolder.setImageResource(R.id.imageView5, R.mipmap.no11);
        baseViewHolder.setImageResource(R.id.imageView6, R.mipmap.no9);
        break;
      case 20:
        baseViewHolder.setImageResource(R.id.imageView5, R.mipmap.no22);
        baseViewHolder.setImageResource(R.id.imageView6, R.mipmap.no0);
        break;
      case 21:
        baseViewHolder.setImageResource(R.id.imageView5, R.mipmap.no22);
        baseViewHolder.setImageResource(R.id.imageView6, R.mipmap.no11);
        break;
      case 22:
        baseViewHolder.setImageResource(R.id.imageView5, R.mipmap.no22);
        baseViewHolder.setImageResource(R.id.imageView6, R.mipmap.no22);
        break;
      case 23:
        baseViewHolder.setImageResource(R.id.imageView5, R.mipmap.no22);
        baseViewHolder.setImageResource(R.id.imageView6, R.mipmap.no33);
        break;
      case 24:
        baseViewHolder.setImageResource(R.id.imageView5, R.mipmap.no22);
        baseViewHolder.setImageResource(R.id.imageView6, R.mipmap.no4);
        break;
      case 25:
        baseViewHolder.setImageResource(R.id.imageView5, R.mipmap.no22);
        baseViewHolder.setImageResource(R.id.imageView6, R.mipmap.no5);
        break;
      case 26:
        baseViewHolder.setImageResource(R.id.imageView5, R.mipmap.no22);
        baseViewHolder.setImageResource(R.id.imageView6, R.mipmap.no6);
        break;
      case 27:
        baseViewHolder.setImageResource(R.id.imageView5, R.mipmap.no22);
        baseViewHolder.setImageResource(R.id.imageView6, R.mipmap.no7);
        break;
      case 28:
        baseViewHolder.setImageResource(R.id.imageView5, R.mipmap.no22);
        baseViewHolder.setImageResource(R.id.imageView6, R.mipmap.no8);
        break;
      case 29:
        baseViewHolder.setImageResource(R.id.imageView5, R.mipmap.no22);
        baseViewHolder.setImageResource(R.id.imageView6, R.mipmap.no9);
        break;
      case 30:
        baseViewHolder.setImageResource(R.id.imageView5, R.mipmap.no33);
        baseViewHolder.setImageResource(R.id.imageView6, R.mipmap.no0);
        break;
      case 31:
        baseViewHolder.setImageResource(R.id.imageView5, R.mipmap.no33);
        baseViewHolder.setImageResource(R.id.imageView6, R.mipmap.no11);
        break;
      case 32:
        baseViewHolder.setImageResource(R.id.imageView5, R.mipmap.no33);
        baseViewHolder.setImageResource(R.id.imageView6, R.mipmap.no22);
        break;
      case 33:
        baseViewHolder.setImageResource(R.id.imageView5, R.mipmap.no33);
        baseViewHolder.setImageResource(R.id.imageView6, R.mipmap.no33);
        break;
      case 34:
        baseViewHolder.setImageResource(R.id.imageView5, R.mipmap.no33);
        baseViewHolder.setImageResource(R.id.imageView6, R.mipmap.no4);
        break;
      case 35:
        baseViewHolder.setImageResource(R.id.imageView5, R.mipmap.no33);
        baseViewHolder.setImageResource(R.id.imageView6, R.mipmap.no5);
        break;
      case 36:
        baseViewHolder.setImageResource(R.id.imageView5, R.mipmap.no33);
        baseViewHolder.setImageResource(R.id.imageView6, R.mipmap.no6);
        break;
      case 37:
        baseViewHolder.setImageResource(R.id.imageView5, R.mipmap.no33);
        baseViewHolder.setImageResource(R.id.imageView6, R.mipmap.no7);
        break;
      case 38:
        baseViewHolder.setImageResource(R.id.imageView5, R.mipmap.no33);
        baseViewHolder.setImageResource(R.id.imageView6, R.mipmap.no8);
        break;
      case 39:
        baseViewHolder.setImageResource(R.id.imageView5, R.mipmap.no33);
        baseViewHolder.setImageResource(R.id.imageView6, R.mipmap.no9);
        break;
      case 40:
        baseViewHolder.setImageResource(R.id.imageView5, R.mipmap.no4);
        baseViewHolder.setImageResource(R.id.imageView6, R.mipmap.no0);
        break;
      case 41:
        baseViewHolder.setImageResource(R.id.imageView5, R.mipmap.no4);
        baseViewHolder.setImageResource(R.id.imageView6, R.mipmap.no11);
        break;
      case 42:
        baseViewHolder.setImageResource(R.id.imageView5, R.mipmap.no4);
        baseViewHolder.setImageResource(R.id.imageView6, R.mipmap.no22);
        break;
      case 43:
        baseViewHolder.setImageResource(R.id.imageView5, R.mipmap.no4);
        baseViewHolder.setImageResource(R.id.imageView6, R.mipmap.no33);
        break;
      case 44:
        baseViewHolder.setImageResource(R.id.imageView5, R.mipmap.no4);
        baseViewHolder.setImageResource(R.id.imageView6, R.mipmap.no4);
        break;
      case 45:
        baseViewHolder.setImageResource(R.id.imageView5, R.mipmap.no4);
        baseViewHolder.setImageResource(R.id.imageView6, R.mipmap.no5);
        break;
      case 46:
        baseViewHolder.setImageResource(R.id.imageView5, R.mipmap.no4);
        baseViewHolder.setImageResource(R.id.imageView6, R.mipmap.no6);
        break;
      case 47:
        baseViewHolder.setImageResource(R.id.imageView5, R.mipmap.no4);
        baseViewHolder.setImageResource(R.id.imageView6, R.mipmap.no8);
        break;
      case 48:
        baseViewHolder.setImageResource(R.id.imageView5, R.mipmap.no4);
        baseViewHolder.setImageResource(R.id.imageView6, R.mipmap.no9);
        break;
      case 49:
        baseViewHolder.setImageResource(R.id.imageView5, R.mipmap.no5);
        baseViewHolder.setImageResource(R.id.imageView6, R.mipmap.no0);
        break;
      default:
        break;
    }
  }
}
