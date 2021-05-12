package com.example.stocknews.Bean;

import java.util.List;

public class CalendarBean {


  /**
   * count : 10
   * data : [{"country":"美国","forcastValue":79.2,"frontValue":79.2,"indicator":"美国密歇根大学消费者信心指数终值","pubValue":0,"s_date":"2021-01-29","s_time":"15:00:00","star":4,"unit":""},{"country":"美国","forcastValue":-0.1,"frontValue":-2.6,"indicator":"美国成屋签约销售指数月率","pubValue":0,"s_date":"2021-01-29","s_time":"15:00:00","star":3,"unit":"%"},{"country":"美国","forcastValue":2.9,"frontValue":3,"indicator":"美国一年期通胀率预期","pubValue":0,"s_date":"2021-01-29","s_time":"15:00:00","star":2,"unit":"%"},{"country":"美国","forcastValue":87.7,"frontValue":87.7,"indicator":"美国密歇根大学现况指数终值","pubValue":0,"s_date":"2021-01-29","s_time":"15:00:00","star":2,"unit":""},{"country":"美国","forcastValue":74.1,"frontValue":73.8,"indicator":"美国密歇根大学预期指数终值","pubValue":0,"s_date":"2021-01-29","s_time":"15:00:00","star":2,"unit":""},{"country":"美国","forcastValue":0,"frontValue":125.7,"indicator":"美国成屋签约销售指数","pubValue":0,"s_date":"2021-01-29","s_time":"15:00:00","star":2,"unit":""},{"country":"美国","forcastValue":20.3,"frontValue":16,"indicator":"美国成屋签约销售指数年率","pubValue":0,"s_date":"2021-01-29","s_time":"15:00:00","star":2,"unit":"%"},{"country":"美国","forcastValue":0,"frontValue":2.7,"indicator":"美国五至十年期通胀率预期","pubValue":0,"s_date":"2021-01-29","s_time":"15:00:00","star":1,"unit":"%"},{"country":"美国","forcastValue":58.5,"frontValue":59.5,"indicator":"美国芝加哥PMI","pubValue":0,"s_date":"2021-01-29","s_time":"14:45:00","star":3,"unit":""},{"country":"美国","forcastValue":1.3,"frontValue":1.4,"indicator":"美国核心PCE物价指数年率","pubValue":0,"s_date":"2021-01-29","s_time":"13:30:00","star":4,"unit":"%"}]
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
     * country : 美国
     * forcastValue : 79.2
     * frontValue : 79.2
     * indicator : 美国密歇根大学消费者信心指数终值
     * pubValue : 0.0
     * s_date : 2021-01-29
     * s_time : 15:00:00
     * star : 4
     * unit :
     */

    private String country;
    private double forcastValue;
    private double frontValue;
    private String indicator;
    private double pubValue;
    private String s_date;
    private String s_time;
    private int star;
    private String unit;

    public String getCountry() {
      return country;
    }

    public void setCountry(String country) {
      this.country = country;
    }

    public double getForcastValue() {
      return forcastValue;
    }

    public void setForcastValue(double forcastValue) {
      this.forcastValue = forcastValue;
    }

    public double getFrontValue() {
      return frontValue;
    }

    public void setFrontValue(double frontValue) {
      this.frontValue = frontValue;
    }

    public String getIndicator() {
      return indicator;
    }

    public void setIndicator(String indicator) {
      this.indicator = indicator;
    }

    public double getPubValue() {
      return pubValue;
    }

    public void setPubValue(double pubValue) {
      this.pubValue = pubValue;
    }

    public String getS_date() {
      return s_date;
    }

    public void setS_date(String s_date) {
      this.s_date = s_date;
    }

    public String getS_time() {
      return s_time;
    }

    public void setS_time(String s_time) {
      this.s_time = s_time;
    }

    public int getStar() {
      return star;
    }

    public void setStar(int star) {
      this.star = star;
    }

    public String getUnit() {
      return unit;
    }

    public void setUnit(String unit) {
      this.unit = unit;
    }
  }
}
