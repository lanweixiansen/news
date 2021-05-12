package com.example.stocknews.Bean;

import java.util.List;

public class IndexBean {


  /**
   * count : 1
   * data : [{"code":"sh000001","current_point":"3495.1280","current_price":"-6.7312","index_name":"上证指数","money":"36409034","rate":"-0.19","volume":"2645273"},{"code":"sz399001","current_point":"15015.93","current_price":"-90.010","index_name":"深证成指","money":"44944689","rate":"-0.60","volume":"289815427"},{"code":"sh000016","current_point":"3836.7739","current_price":"35.1561","index_name":"上证50","money":"9806217","rate":"0.92","volume":"381477"},{"code":"sz399905","current_point":"6239.30","current_price":"-89.485","index_name":"中证 500","money":"14885532","rate":"-1.41","volume":"122745072"},{"code":"sz399300","current_point":"5481.49","current_price":"7.543","index_name":"沪深300","money":"36221327","rate":"0.14","volume":"173222557"},{"code":"sz399102","current_point":"3068.25","current_price":"-25.800","index_name":"创业板综","money":"14638275","rate":"-0.83","volume":"67839286"}]
   * success : true
   */

  private int count;
  private boolean success;
  private List<DataDTO> data;

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
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
     * code : sh000001
     * current_point : 3495.1280
     * current_price : -6.7312
     * index_name : 上证指数
     * money : 36409034
     * rate : -0.19
     * volume : 2645273
     */

    private String code;
    private String current_point;
    private String current_price;
    private String index_name;
    private String money;
    private String rate;
    private String volume;

    public String getCode() {
      return code;
    }

    public void setCode(String code) {
      this.code = code;
    }

    public String getCurrent_point() {
      return current_point;
    }

    public void setCurrent_point(String current_point) {
      this.current_point = current_point;
    }

    public String getCurrent_price() {
      return current_price;
    }

    public void setCurrent_price(String current_price) {
      this.current_price = current_price;
    }

    public String getIndex_name() {
      return index_name;
    }

    public void setIndex_name(String index_name) {
      this.index_name = index_name;
    }

    public String getMoney() {
      return money;
    }

    public void setMoney(String money) {
      this.money = money;
    }

    public String getRate() {
      return rate;
    }

    public void setRate(String rate) {
      this.rate = rate;
    }

    public String getVolume() {
      return volume;
    }

    public void setVolume(String volume) {
      this.volume = volume;
    }
  }
}
