package com.example.stocknews.Interface;

import com.example.stocknews.Bean.AlertBean;

import com.example.stocknews.Bean.COVIDBean;
import com.example.stocknews.Bean.CalendarBean;
import com.example.stocknews.Bean.DehydrationBean;
import com.example.stocknews.Bean.EventDrivenBean;
import com.example.stocknews.Bean.IndexBean;
import com.example.stocknews.Bean.NewsBean;
import com.example.stocknews.Bean.PlateBean;
import com.example.stocknews.Bean.ReportBean;
import com.example.stocknews.Bean.VideoBean;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ServiceApi {

  //疫情
  @GET("txapi/ncov/index")
  Call<COVIDBean> getCOVID(@Query("key") String key);









  //快讯
  @GET("news/flashes")
  Call<AlertBean> getAlertsJson(@Query("page") int page);

  //新闻
  @GET("/news/articles")
  Call<NewsBean> getNewsJson(@Query("page") int page);

  //日历
  @GET("/news/calendar")
  Call<CalendarBean> getCalendarJson(@Query("date") String data);

  //指数
  @GET("/stock/stock_indexes")
  Call<IndexBean> getIndexJson();

  //概念
  @GET("/stock/concepts")
  Call<PlateBean> getConceptJson(@Query("asc") String asc);

  //行业
  @GET("/stock/industrys")
  Call<PlateBean> getIndustryJson(@Query("asc") String asc);

  //地域
  @GET("/stock/regions")
  Call<PlateBean> getRegionJson(@Query("asc") String asc);

  //脱水研报
  @GET("/strategy/dried_report")
  Call<DehydrationBean> getDehyJson();

  //公司调研
  @GET("/data_center/research")
  Call<ReportBean> getReportJson();

  //热点追踪
  @GET("/strategy/hot_point")
  Call<EventDrivenBean> getEventJson();

  //投资圈
  @GET("/strategy/amusement")
  Call<DehydrationBean> getInvestment();

  //投资教育
  @GET("/strategy/short_video")
  Call<VideoBean> getVideo(@Query("page") int page);

}
