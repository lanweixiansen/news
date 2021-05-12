package com.example.stocknews.Bean;

public class CommentsBean {

  private String headPic;
  private String commentName;
  private String commentContent;

  @Override
  public String toString() {
    return "CommentsBean{" +
            "headPic='" + headPic + '\'' +
            ", commentName='" + commentName + '\'' +
            ", commentContent='" + commentContent + '\'' +
            '}';
  }

  public String getHeadPic() {
    return headPic;
  }

  public void setHeadPic(String headPic) {
    this.headPic = headPic;
  }

  public String getCommentName() {
    return commentName;
  }

  public void setCommentName(String commentName) {
    this.commentName = commentName;
  }

  public String getCommentContent() {
    return commentContent;
  }

  public void setCommentContent(String commentContent) {
    this.commentContent = commentContent;
  }
}
