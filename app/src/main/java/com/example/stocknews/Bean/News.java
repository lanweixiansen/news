package com.example.stocknews.Bean;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.PropertyKey;

@Entity
public class News {

  @PrimaryKey(autoGenerate = true)
  private int id;
  private String newsID;
  private String origin;
  private String pubTime;
  private String title;
  private String content;
  private String pic;

  @Override
  public String toString() {
    return "News{" +
            "newsID='" + newsID + '\'' +
            ", origin='" + origin + '\'' +
            ", pubTime='" + pubTime + '\'' +
            ", title='" + title + '\'' +
            ", content='" + content + '\'' +
            ", pic='" + pic + '\'' +
            '}';
  }

  public News(String newsID, String origin, String pubTime, String title, String content, String pic) {
    this.newsID = newsID;
    this.origin = origin;
    this.pubTime = pubTime;
    this.title = title;
    this.content = content;
    this.pic = pic;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNewsID() {
    return newsID;
  }

  public void setNewsID(String newsID) {
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

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getPic() {
    return pic;
  }

  public void setPic(String pic) {
    this.pic = pic;
  }
}
