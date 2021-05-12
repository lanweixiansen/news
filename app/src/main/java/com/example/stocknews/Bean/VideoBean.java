package com.example.stocknews.Bean;

import java.util.List;

public class VideoBean {

  private List<DataDTO> data;
  /**
   * count : 3
   * message : 获取成功
   * success : true
   */

  private int count;
  private String message;
  private boolean success;

  public List<DataDTO> getData() {
    return data;
  }

  public void setData(List<DataDTO> data) {
    this.data = data;
  }

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

  public static class DataDTO {
    private String title;
    private String video_addr;
    private String pic_addr;
    private String author;
    private String insertTime;
    private String origin;

    public String getAuthor() {
    return author;
  }

    public void setAuthor(String author) {
    this.author = author;
  }

    public String getInsertTime() {
    return insertTime;
  }

    public void setInsertTime(String insertTime) {
    this.insertTime = insertTime;
  }

    public String getOrigin() {
    return origin;
  }

    public void setOrigin(String origin) {
    this.origin = origin;
  }

    public String getTitle() {
    return title;
  }

    public void setTitle(String title) {
    this.title = title;
  }

    public String getVideo_addr() {
    return video_addr;
  }

    public void setVideo_addr(String video_addr) {
    this.video_addr = video_addr;
  }

    public String getPic_addr() {
    return pic_addr;
  }

    public void setPic_addr(String pic_addr) {
    this.pic_addr = pic_addr;
  }
  }


}
