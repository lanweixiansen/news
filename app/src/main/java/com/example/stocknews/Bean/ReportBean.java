package com.example.stocknews.Bean;

import java.util.List;

public class ReportBean {

  /**
   * count : 1
   * data : [{"advise":"强烈推荐/维持","author":"王健辉","company":"东兴证券","content":"http://121.4.60.190/static/pdf/20210201-%E4%B8%9C%E5%85%B4%E8%AF%81%E5%88%B8-%E5%AE%9D%E5%85%B0%E5%BE%B7-688058-2020%E5%B9%B4%E4%B8%9A%E7%BB%A9%E9%A2%84%E5%91%8A%E7%82%B9%E8%AF%84%EF%BC%9A%E5%B8%82%E5%9C%BA%E6%8B%93%E5%B1%95%E4%B8%8E%E4%BA%A7%E5%93%81%E7%A0%94%E5%8F%91%E5%8F%8C%E9%87%8D%E5%8F%91%E5%","jobCode":"S1480519050004","origin":"：Wind、东兴证券研究所","pubTime":"Mon, 01 Feb 2021 00:00:00 GMT","title":"市场拓展与产\r\n品研发双重发力，未来增长可期"}]
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
     * advise : 强烈推荐/维持
     * author : 王健辉
     * company : 东兴证券
     * content : http://121.4.60.190/static/pdf/20210201-%E4%B8%9C%E5%85%B4%E8%AF%81%E5%88%B8-%E5%AE%9D%E5%85%B0%E5%BE%B7-688058-2020%E5%B9%B4%E4%B8%9A%E7%BB%A9%E9%A2%84%E5%91%8A%E7%82%B9%E8%AF%84%EF%BC%9A%E5%B8%82%E5%9C%BA%E6%8B%93%E5%B1%95%E4%B8%8E%E4%BA%A7%E5%93%81%E7%A0%94%E5%8F%91%E5%8F%8C%E9%87%8D%E5%8F%91%E5%
     * jobCode : S1480519050004
     * origin : ：Wind、东兴证券研究所
     * pubTime : Mon, 01 Feb 2021 00:00:00 GMT
     * title : 市场拓展与产
     品研发双重发力，未来增长可期
     */

    private String advise;
    private String author;
    private String company;
    private String content;
    private String jobCode;
    private String origin;
    private String pubTime;
    private String title;

    public String getAdvise() {
      return advise;
    }

    public void setAdvise(String advise) {
      this.advise = advise;
    }

    public String getAuthor() {
      return author;
    }

    public void setAuthor(String author) {
      this.author = author;
    }

    public String getCompany() {
      return company;
    }

    public void setCompany(String company) {
      this.company = company;
    }

    public String getContent() {
      return content;
    }

    public void setContent(String content) {
      this.content = content;
    }

    public String getJobCode() {
      return jobCode;
    }

    public void setJobCode(String jobCode) {
      this.jobCode = jobCode;
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

    public String getTitle() {
      return title;
    }

    public void setTitle(String title) {
      this.title = title;
    }
  }
}
