package com.example.stocknews.Bean;

import java.util.List;

public class PlateBean {

  /**
   * count : 12
   * data : [{"changeRate":"3.54%","changeValue":25.39,"downStocks":1,"lastPrice":743.26,"leaderChangeRate":"9.99%","leaderStock":"中水渔业","plateName":"水产养殖","turnOver":"3.81%","upStocks":10},{"changeRate":"3.45%","changeValue":47.58,"downStocks":0,"lastPrice":1426.6,"leaderChangeRate":"10.04%","leaderStock":"新安股份","plateName":"转基因","turnOver":"4.81%","upStocks":9},{"changeRate":"1.36%","changeValue":10.85,"downStocks":3,"lastPrice":807.03,"leaderChangeRate":"6.0%","leaderStock":"新 希 望","plateName":"鸡肉概念","turnOver":"1.5%","upStocks":10},{"changeRate":"1.33%","changeValue":45.68,"downStocks":5,"lastPrice":3485.65,"leaderChangeRate":"8.06%","leaderStock":"海航控股","plateName":"油价相关","turnOver":"0.23%","upStocks":7},{"changeRate":"1.09%","changeValue":16.87,"downStocks":12,"lastPrice":1567.16,"leaderChangeRate":"9.81%","leaderStock":"牧原股份","plateName":"猪肉概念","turnOver":"2.18%","upStocks":21},{"changeRate":"1.04%","changeValue":9.41,"downStocks":10,"lastPrice":917.07,"leaderChangeRate":"10.01%","leaderStock":"合盛硅业","plateName":"有机硅","turnOver":"3.27%","upStocks":10},{"changeRate":"0.92%","changeValue":10.47,"downStocks":6,"lastPrice":1143.67,"leaderChangeRate":"10.04%","leaderStock":"新安股份","plateName":"草甘膦","turnOver":"1.58%","upStocks":6},{"changeRate":"0.88%","changeValue":156.73,"downStocks":7,"lastPrice":18038.9,"leaderChangeRate":"10.07%","leaderStock":"陕西黑猫","plateName":"昨日连板","turnOver":"4.4%","upStocks":12},{"changeRate":"0.63%","changeValue":7.49,"downStocks":6,"lastPrice":1197.51,"leaderChangeRate":"6.05%","leaderStock":"众信旅游","plateName":"在线旅游","turnOver":"1.89%","upStocks":9},{"changeRate":"0.54%","changeValue":8.38,"downStocks":39,"lastPrice":1552.4,"leaderChangeRate":"10.06%","leaderStock":"新纶科技","plateName":"昨日涨停","turnOver":"4.67%","upStocks":51},{"changeRate":"0.47%","changeValue":6.46,"downStocks":26,"lastPrice":1379.27,"leaderChangeRate":"9.99%","leaderStock":"盛和资源","plateName":"稀土永磁","turnOver":"4.56%","upStocks":27},{"changeRate":"0.36%","changeValue":3.64,"downStocks":5,"lastPrice":1023.76,"leaderChangeRate":"7.69%","leaderStock":"圣济堂","plateName":"阿兹海默","turnOver":"1.37%","upStocks":5}]
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
     * changeRate : 3.54%
     * changeValue : 25.39
     * downStocks : 1
     * lastPrice : 743.26
     * leaderChangeRate : 9.99%
     * leaderStock : 中水渔业
     * plateName : 水产养殖
     * turnOver : 3.81%
     * upStocks : 10
     */

    private String changeRate;
    private double changeValue;
    private int downStocks;
    private double lastPrice;
    private String leaderChangeRate;
    private String leaderStock;
    private String plateName;
    private String turnOver;
    private int upStocks;

    public String getChangeRate() {
      return changeRate;
    }

    public void setChangeRate(String changeRate) {
      this.changeRate = changeRate;
    }

    public double getChangeValue() {
      return changeValue;
    }

    public void setChangeValue(double changeValue) {
      this.changeValue = changeValue;
    }

    public int getDownStocks() {
      return downStocks;
    }

    public void setDownStocks(int downStocks) {
      this.downStocks = downStocks;
    }

    public double getLastPrice() {
      return lastPrice;
    }

    public void setLastPrice(double lastPrice) {
      this.lastPrice = lastPrice;
    }

    public String getLeaderChangeRate() {
      return leaderChangeRate;
    }

    public void setLeaderChangeRate(String leaderChangeRate) {
      this.leaderChangeRate = leaderChangeRate;
    }

    public String getLeaderStock() {
      return leaderStock;
    }

    public void setLeaderStock(String leaderStock) {
      this.leaderStock = leaderStock;
    }

    public String getPlateName() {
      return plateName;
    }

    public void setPlateName(String plateName) {
      this.plateName = plateName;
    }

    public String getTurnOver() {
      return turnOver;
    }

    public void setTurnOver(String turnOver) {
      this.turnOver = turnOver;
    }

    public int getUpStocks() {
      return upStocks;
    }

    public void setUpStocks(int upStocks) {
      this.upStocks = upStocks;
    }
  }
}
