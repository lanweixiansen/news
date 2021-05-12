package com.example.stocknews.Bean;

import java.util.List;

public class EventDrivenBean {

  /**
   * count : 4
   * data : [{"content":"高景气赛道，国产化加速","insertTime":"Mon, 08 Feb 2021 15:34:17 GMT","label":"机会,利好","stocks":"迈瑞医疗,药明康德","title":"医美板块"},{"content":"前期提到李录大手笔买入邮储银行并且4季报银行财报回暖","insertTime":"Mon, 08 Feb 2021 15:34:15 GMT","label":"机会,利好","stocks":"招商银行,紫金银行","title":"银行板块"},{"content":"春节因为疫情，返乡人数减少","insertTime":"Mon, 08 Feb 2021 15:34:12 GMT","label":"机会,利好","stocks":"锦江酒店,华天酒店","title":"酒店餐饮"},{"content":"券商收益预增，行业平均盈利50亿","insertTime":"Mon, 08 Feb 2021 15:23:42 GMT","label":"机会,利好","stocks":"中信建投,中信证券,东方财富","title":"券商概念"}]
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
     * content : 高景气赛道，国产化加速
     * insertTime : Mon, 08 Feb 2021 15:34:17 GMT
     * label : 机会,利好
     * stocks : 迈瑞医疗,药明康德
     * title : 医美板块
     */

    private String content;
    private String insertTime;
    private String label;
    private String stocks;
    private String title;

    public String getContent() {
      return content;
    }

    public void setContent(String content) {
      this.content = content;
    }

    public String getInsertTime() {
      return insertTime;
    }

    public void setInsertTime(String insertTime) {
      this.insertTime = insertTime;
    }

    public String getLabel() {
      return label;
    }

    public void setLabel(String label) {
      this.label = label;
    }

    public String getStocks() {
      return stocks;
    }

    public void setStocks(String stocks) {
      this.stocks = stocks;
    }

    public String getTitle() {
      return title;
    }

    public void setTitle(String title) {
      this.title = title;
    }
  }
}
