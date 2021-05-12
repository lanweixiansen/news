package com.example.stocknews.Repository;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.stocknews.Bean.AlertBean;
import com.example.stocknews.Bean.COVIDBean;
import com.example.stocknews.Bean.CalendarBean;
import com.example.stocknews.Bean.VideoBean;
import com.example.stocknews.Tools.DataUtil;
import com.example.stocknews.Bean.DehydrationBean;
import com.example.stocknews.Bean.EventDrivenBean;
import com.example.stocknews.Bean.IndexBean;
import com.example.stocknews.Bean.NewsBean;
import com.example.stocknews.Bean.PlateBean;
import com.example.stocknews.Bean.ReportBean;
import com.example.stocknews.Interface.ServiceApi;
import com.example.stocknews.Tools.ToastUtil;
import com.example.stocknews.adapter.RetrofitManger;

import java.net.HttpURLConnection;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Repository {
  final MutableLiveData<List<COVIDBean.NewslistDTO>> mCOVID = new MutableLiveData<>();

  private Context mContext;
  public  Repository(Context context){
    this.mContext = context;
  }


  //疫情


  public MutableLiveData<List<COVIDBean.NewslistDTO>> getCOVID() {
    Retrofit retrofit = RetrofitManger.getRetrofit2();
    ServiceApi api = retrofit.create(ServiceApi.class);
    Call<COVIDBean> call = api.getCOVID("274f44ae7fc5934f4eb3c1430603aaf6");
    call.enqueue(new Callback<COVIDBean>() {
      @Override
      public void onResponse(Call<COVIDBean> call, Response<COVIDBean> response) {
        if (response.code() == HttpURLConnection.HTTP_OK) {
          mCOVID.setValue(response.body().getNewslist());
        }
      }

      @Override
      public void onFailure(Call<COVIDBean> call, Throwable t) {
        ToastUtil.showMessage(mContext, "疫情数据加载失败，请稍后重试！");
      }
    });


    return mCOVID;
  }


}
