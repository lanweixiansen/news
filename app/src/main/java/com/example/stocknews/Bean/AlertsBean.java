package com.example.stocknews.Bean;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class AlertsBean {

  /**
   * count : 10
   * data : [{"newsID":364,"origin":"证券时报","pubTime":"2021-01-24 12:54","summary":"近日，上交所发布第15批业务规则和指南废止公告，并上线全新业务规则体系导览图，标志着\u201c简明友好型\u201d规则体系建设取得阶段性成效。相关负责人介绍，新证券法明确了业务规则的普适性效力，要求证券交易所按照业务规则来运行和管理市场。为落实新形势下\u201c建制度\u201d的根本要求，上交所深入开展业务规则清理评估和立改废工作，全年共新增制定规则43项，修改21项，废止77项，废止业务指南134件，业务规则和指南总量减少25%，促进业务规则体系更加成熟定型。","title":"上交所着力打造简明友好型规则体系"},{"newsID":360,"origin":"第一财经","pubTime":"2021-01-22 22:50","summary":" 2020年，中国集成电路产业在2月短暂承压后，快速反弹后稳步增长，全年总指数提升51个点，上升36.8%。 ","title":"CICDI总指数2020年上升36.8%，中国集成电路产业双循环新格局初现"}]
   * message : 获取成功
   * success : true
   */

  private int count;
  private String message;
  private boolean success;
  private List<DataDTO> data;

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public boolean isSuccess() {
    return success;
  }

  public void setSuccess(boolean success) {
    this.success = success;
  }

  public List<DataDTO> getData() {
    return data;
  }

  public void setData(List<DataDTO> data) {
    this.data = data;
  }

  public static class DataDTO {
    /**
     * newsID : 364
     * origin : 证券时报
     * pubTime : 2021-01-24 12:54
     * summary : 近日，上交所发布第15批业务规则和指南废止公告，并上线全新业务规则体系导览图，标志着“简明友好型”规则体系建设取得阶段性成效。相关负责人介绍，新证券法明确了业务规则的普适性效力，要求证券交易所按照业务规则来运行和管理市场。为落实新形势下“建制度”的根本要求，上交所深入开展业务规则清理评估和立改废工作，全年共新增制定规则43项，修改21项，废止77项，废止业务指南134件，业务规则和指南总量减少25%，促进业务规则体系更加成熟定型。
     * title : 上交所着力打造简明友好型规则体系
     */

    private int newsID;
    private String origin;
    private String pubTime;
    private String summary;
    private String title;

    public int getNewsID() {
      return newsID;
    }

    public void setNewsID(int newsID) {
      this.newsID = newsID;
    }

    public String getOrigin() {
      return origin;
    }

    public void setOrigin(String origin) {
      this.origin = origin;
    }

    public String getPubTime() {
      return pubTime;
    }

    public void setPubTime(String pubTime) {
      this.pubTime = pubTime;
    }

    public String getSummary() {
      return summary;
    }

    public void setSummary(String summary) {
      this.summary = summary;
    }

    public String getTitle() {
      return title;
    }

    public void setTitle(String title) {
      this.title = title;
    }
  }
}
