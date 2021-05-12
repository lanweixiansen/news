package com.example.stocknews.Bean;

import java.util.List;

public class AlertBean {

  /**
   * count : 10
   * data : [{"content":"新装置投产以及终端开工率大幅下挫    PTA后势略显悲观2021.01.22","newsid":579,"origin":"点金直通车","pubtime":"2021-01-22"},{"content":"尿素甲醇反弹 原油小幅震荡 (2021.1.22)","newsid":583,"origin":"点金直通车","pubtime":"2021-01-22"},{"content":"美棉持续走强，支撑郑棉期价20210122","newsid":584,"origin":"点金直通车","pubtime":"2021-01-22"},{"content":"临储小麦填补玉米缺口施压高位，鸡蛋备货临近尾声上冲乏力（2021.01.22）","newsid":585,"origin":"点金直通车","pubtime":"2021-01-22"},{"content":"海外综述和宏观提示（2020.01.22）","newsid":586,"origin":"点金直通车","pubtime":"2021-01-22"},{"content":"拜登就任美国总统，铜铝震荡收涨20210121","newsid":580,"origin":"点金直通车","pubtime":"2021-01-21"}]
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
    @Override
    public String toString() {
      return "DataDTO{" +
              "content='" + content + '\'' +
              ", newsid=" + newsid +
              ", origin='" + origin + '\'' +
              ", pubtime='" + pubtime + '\'' +
              '}';
    }

    /**
     * content : 新装置投产以及终端开工率大幅下挫    PTA后势略显悲观2021.01.22
     * newsid : 579
     * origin : 点金直通车
     * pubtime : 2021-01-22
     */

    private String content;
    private int newsid;
    private String origin;
    private String pubtime;

    public String getContent() {
      return content;
    }

    public void setContent(String content) {
      this.content = content;
    }

    public int getNewsid() {
      return newsid;
    }

    public void setNewsid(int newsid) {
      this.newsid = newsid;
    }

    public String getOrigin() {
      return origin;
    }

    public void setOrigin(String origin) {
      this.origin = origin;
    }

    public String getPubtime() {
      return pubtime;
    }

    public void setPubtime(String pubtime) {
      this.pubtime = pubtime;
    }
  }
}
