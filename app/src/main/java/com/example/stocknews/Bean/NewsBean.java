package com.example.stocknews.Bean;

import java.util.List;

public class NewsBean {


  /**
   * count : 10
   * data : [{"newsID":994,"origin":"第一财经","pubTime":"2021-02-08 08:04","summary":" 银保监会消费者权益保护局发布风险提示，提醒广大消费者树立理性消费观，合理使用借贷产品，选择正规机构、正规渠道获取金融服务，警惕过度借贷营销。 ","title":"银保监会提示：警惕网络平台诱导过度借贷"},{"newsID":993,"origin":"证券时报","pubTime":"2021-02-08 09:40","summary":"\u201c今年是我们党建党100周年，是\u2018十四五\u2019开局之年，做好今年工作意义重大。\u201d","title":"牢记统帅关爱重托 在新的起点上 不断开创部队建设新局面 \u2014\u2014习近平主席春节前夕视察看望空军航空兵某师在全军引起强烈反响"},{"newsID":988,"origin":"第一财经","pubTime":"2021-02-06 22:43","summary":" 在京的非北京户籍人员也可预约，是鼓励\u201c就地过年\u201d开展的创新实践。 ","title":"\u201c就地过年\u201d有福利！北京1000万数字人民币红包7日0时开抢"},{"newsID":987,"origin":"证券时报","pubTime":"2021-02-07 17:30","summary":"春节将至，为保障节日期间市民群众的食品安全，深圳警方近期联合市场监督管理局、烟草专卖局等单位，从2020年12月底开始在全市范围内开展严厉打击食品安全违法犯罪的\u201c安全年夜饭\u201d专项行动。截至目前，专项行动共侦破食品药品刑事案件33宗，抓获犯罪嫌疑人61名，查获假冒伪劣产品价值总计1800余万元。","title":"深圳警方开展\u201c安全年夜饭\u201d专项行动，共抓获61名犯罪嫌疑人"},{"newsID":986,"origin":"证券时报","pubTime":"2021-02-07 13:50","summary":"近期，上海市高级人民法院对鲜言背信损害上市公司利益、操纵证券市场作出终审判决：鲜言犯背信损害上市公司利益罪判处有期徒刑一年八个月，并处罚金人民币180万元，犯操纵证券市场罪判处有期徒刑三年四个月，并处罚金人民币1000万元。二审期间，鲜言具有自愿认罪认罚并主动缴纳全部罚金等情况，二审法院依法对鲜言减轻处罚，最终决定执行有期徒刑四年三个月，并处罚金人民币1180万元。","title":"上海证监局：\u201c鲜言案\u201d终审判刑有望形成警示效应"}]
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
     * newsID : 994
     * origin : 第一财经
     * pubTime : 2021-02-08 08:04
     * summary :  银保监会消费者权益保护局发布风险提示，提醒广大消费者树立理性消费观，合理使用借贷产品，选择正规机构、正规渠道获取金融服务，警惕过度借贷营销。
     * title : 银保监会提示：警惕网络平台诱导过度借贷
     */

    private int newsID;
    private String origin;
    private String pubTime;
    private String summary;
    private String title;
    private String content;

    public String getContent() {
      return content;
    }

    public void setContent(String content) {
      this.content = content;
    }

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
