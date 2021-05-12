package com.example.stocknews.Bean;

import java.util.List;

public class COVIDBean {


  /**
   * code : 200
   * msg : success
   * newslist : [{"news":[{"id":130952,"pubDate":1618272984000,"pubDateStr":"13小时前","title":"全国｜新增确诊 9 例 其中本土 1 例","summary":"4月12日0\u201424时，31个省（自治区、直辖市）和新疆生产建设兵团报告新增确诊病例9例，其中境外输入病例8例（浙江2例，广东2例，四川2例，上海1例，福建1例），本土病例1例（在云南）；无新增死亡病例；无新增疑似病例。\n当日新增治愈出院病例11例，解除医学观察的密切接触者62人，重症病例较前一日增加1例。\n境外输入现有确诊病例206例（其中重症病例4例），无现有疑似病例。累计确诊病例5443例，累","infoSource":"央视新闻app","sourceUrl":"http://app.cctv.com/special/cportal/detail/arti/index.html?id=ArtincorrOkVoGeULytnQi8n210413&isfromapp=1","provinceId":"","articleId":41445,"category":1,"jumpUrl":""},{"id":130942,"pubDate":1618266345000,"pubDateStr":"15小时前","title":"云南｜新增确诊 1 例 ","summary":"4月12日0时至24时，云南省新增确诊病例1例，为瑞丽市在第三轮全员核酸检测中检出。6例境外输入无症状感染者解除隔离医学观察。\n截至4月12日24时，云南省现有确诊病例91例（境外输入4例，本土87例），无症状感染者33例（境外输入8例，本土25例），均在定点医疗机构隔离治疗和医学观察。\n新增确诊病例：\n女，32岁，缅甸籍，普通型。","infoSource":"央视新闻app","sourceUrl":"http://app.cctv.com/special/cportal/detail/arti/index.html?id=ArtiDGgP8fPnYArTgIJjzLRG210413&isfromapp=1","provinceId":"","articleId":41450,"category":1,"jumpUrl":""}],"desc":{"id":1,"createTime":1579537899000,"modifyTime":1618316916000,"summary":"","deleted":false,"countRemark":"","currentConfirmedCount":494,"confirmedCount":103153,"suspectedCount":5443,"curedCount":97805,"deadCount":4854,"seriousCount":299,"suspectedIncr":8,"currentConfirmedIncr":4,"confirmedIncr":26,"curedIncr":22,"deadIncr":0,"seriousIncr":-2,"yesterdayConfirmedCountIncr":23,"yesterdaySuspectedCountIncr":8,"remark1":"易感人群：人群普遍易感。老年人及有基础疾病者感染后病情较重，儿童及婴幼儿也有发病","remark2":"潜伏期：一般为 3～7 天，最长不超过 14 天，潜伏期内可能存在传染性，其中无症状病例传染性非常罕见","remark3":"宿主：野生动物，可能为中华菊头蝠","remark4":"","remark5":"","note1":"病毒：SARS-CoV-2，其导致疾病命名 COVID-19","note2":"传染源：新冠肺炎的患者。无症状感染者也可能成为传染源。","note3":"传播途径：经呼吸道飞沫、接触传播是主要的传播途径。气溶胶传播和消化道等传播途径尚待明确。","generalRemark":"","abroadRemark":"","foreignStatistics":{"currentConfirmedCount":31748405,"confirmedCount":136523994,"suspectedCount":4,"curedCount":101806628,"deadCount":2968961,"suspectedIncr":0,"currentConfirmedIncr":109866,"confirmedIncr":562543,"curedIncr":443561,"deadIncr":9116},"globalStatistics":{"currentConfirmedCount":31748899,"confirmedCount":136627147,"curedCount":101904433,"deadCount":2973815,"currentConfirmedIncr":109870,"confirmedIncr":562569,"curedIncr":443583,"deadIncr":9116,"yesterdayConfirmedCountIncr":562566},"highDangerCount":3,"midDangerCount":6}}]
   */

  private int code;
  private String msg;
  private List<NewslistDTO> newslist;

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public List<NewslistDTO> getNewslist() {
    return newslist;
  }

  public void setNewslist(List<NewslistDTO> newslist) {
    this.newslist = newslist;
  }

  public static class NewslistDTO {
    /**
     * news : [{"id":130952,"pubDate":1618272984000,"pubDateStr":"13小时前","title":"全国｜新增确诊 9 例 其中本土 1 例","summary":"4月12日0\u201424时，31个省（自治区、直辖市）和新疆生产建设兵团报告新增确诊病例9例，其中境外输入病例8例（浙江2例，广东2例，四川2例，上海1例，福建1例），本土病例1例（在云南）；无新增死亡病例；无新增疑似病例。\n当日新增治愈出院病例11例，解除医学观察的密切接触者62人，重症病例较前一日增加1例。\n境外输入现有确诊病例206例（其中重症病例4例），无现有疑似病例。累计确诊病例5443例，累","infoSource":"央视新闻app","sourceUrl":"http://app.cctv.com/special/cportal/detail/arti/index.html?id=ArtincorrOkVoGeULytnQi8n210413&isfromapp=1","provinceId":"","articleId":41445,"category":1,"jumpUrl":""},{"id":130942,"pubDate":1618266345000,"pubDateStr":"15小时前","title":"云南｜新增确诊 1 例 ","summary":"4月12日0时至24时，云南省新增确诊病例1例，为瑞丽市在第三轮全员核酸检测中检出。6例境外输入无症状感染者解除隔离医学观察。\n截至4月12日24时，云南省现有确诊病例91例（境外输入4例，本土87例），无症状感染者33例（境外输入8例，本土25例），均在定点医疗机构隔离治疗和医学观察。\n新增确诊病例：\n女，32岁，缅甸籍，普通型。","infoSource":"央视新闻app","sourceUrl":"http://app.cctv.com/special/cportal/detail/arti/index.html?id=ArtiDGgP8fPnYArTgIJjzLRG210413&isfromapp=1","provinceId":"","articleId":41450,"category":1,"jumpUrl":""}]
     * desc : {"id":1,"createTime":1579537899000,"modifyTime":1618316916000,"summary":"","deleted":false,"countRemark":"","currentConfirmedCount":494,"confirmedCount":103153,"suspectedCount":5443,"curedCount":97805,"deadCount":4854,"seriousCount":299,"suspectedIncr":8,"currentConfirmedIncr":4,"confirmedIncr":26,"curedIncr":22,"deadIncr":0,"seriousIncr":-2,"yesterdayConfirmedCountIncr":23,"yesterdaySuspectedCountIncr":8,"remark1":"易感人群：人群普遍易感。老年人及有基础疾病者感染后病情较重，儿童及婴幼儿也有发病","remark2":"潜伏期：一般为 3～7 天，最长不超过 14 天，潜伏期内可能存在传染性，其中无症状病例传染性非常罕见","remark3":"宿主：野生动物，可能为中华菊头蝠","remark4":"","remark5":"","note1":"病毒：SARS-CoV-2，其导致疾病命名 COVID-19","note2":"传染源：新冠肺炎的患者。无症状感染者也可能成为传染源。","note3":"传播途径：经呼吸道飞沫、接触传播是主要的传播途径。气溶胶传播和消化道等传播途径尚待明确。","generalRemark":"","abroadRemark":"","foreignStatistics":{"currentConfirmedCount":31748405,"confirmedCount":136523994,"suspectedCount":4,"curedCount":101806628,"deadCount":2968961,"suspectedIncr":0,"currentConfirmedIncr":109866,"confirmedIncr":562543,"curedIncr":443561,"deadIncr":9116},"globalStatistics":{"currentConfirmedCount":31748899,"confirmedCount":136627147,"curedCount":101904433,"deadCount":2973815,"currentConfirmedIncr":109870,"confirmedIncr":562569,"curedIncr":443583,"deadIncr":9116,"yesterdayConfirmedCountIncr":562566},"highDangerCount":3,"midDangerCount":6}
     */

    private DescDTO desc;
    private List<NewsDTO> news;

    public DescDTO getDesc() {
      return desc;
    }

    public void setDesc(DescDTO desc) {
      this.desc = desc;
    }

    public List<NewsDTO> getNews() {
      return news;
    }

    public void setNews(List<NewsDTO> news) {
      this.news = news;
    }

    public static class DescDTO {
      /**
       * id : 1
       * createTime : 1579537899000
       * modifyTime : 1618316916000
       * summary :
       * deleted : false
       * countRemark :
       * currentConfirmedCount : 494
       * confirmedCount : 103153
       * suspectedCount : 5443
       * curedCount : 97805
       * deadCount : 4854
       * seriousCount : 299
       * suspectedIncr : 8
       * currentConfirmedIncr : 4
       * confirmedIncr : 26
       * curedIncr : 22
       * deadIncr : 0
       * seriousIncr : -2
       * yesterdayConfirmedCountIncr : 23
       * yesterdaySuspectedCountIncr : 8
       * remark1 : 易感人群：人群普遍易感。老年人及有基础疾病者感染后病情较重，儿童及婴幼儿也有发病
       * remark2 : 潜伏期：一般为 3～7 天，最长不超过 14 天，潜伏期内可能存在传染性，其中无症状病例传染性非常罕见
       * remark3 : 宿主：野生动物，可能为中华菊头蝠
       * remark4 :
       * remark5 :
       * note1 : 病毒：SARS-CoV-2，其导致疾病命名 COVID-19
       * note2 : 传染源：新冠肺炎的患者。无症状感染者也可能成为传染源。
       * note3 : 传播途径：经呼吸道飞沫、接触传播是主要的传播途径。气溶胶传播和消化道等传播途径尚待明确。
       * generalRemark :
       * abroadRemark :
       * foreignStatistics : {"currentConfirmedCount":31748405,"confirmedCount":136523994,"suspectedCount":4,"curedCount":101806628,"deadCount":2968961,"suspectedIncr":0,"currentConfirmedIncr":109866,"confirmedIncr":562543,"curedIncr":443561,"deadIncr":9116}
       * globalStatistics : {"currentConfirmedCount":31748899,"confirmedCount":136627147,"curedCount":101904433,"deadCount":2973815,"currentConfirmedIncr":109870,"confirmedIncr":562569,"curedIncr":443583,"deadIncr":9116,"yesterdayConfirmedCountIncr":562566}
       * highDangerCount : 3
       * midDangerCount : 6
       */

      private int id;
      private long createTime;
      private long modifyTime;
      private String summary;
      private boolean deleted;
      private String countRemark;
      private int currentConfirmedCount;
      private int confirmedCount;
      private int suspectedCount;
      private int curedCount;
      private int deadCount;
      private int seriousCount;
      private int suspectedIncr;
      private int currentConfirmedIncr;
      private int confirmedIncr;
      private int curedIncr;
      private int deadIncr;
      private int seriousIncr;
      private int yesterdayConfirmedCountIncr;
      private int yesterdaySuspectedCountIncr;
      private String remark1;
      private String remark2;
      private String remark3;
      private String remark4;
      private String remark5;
      private String note1;
      private String note2;
      private String note3;
      private String generalRemark;
      private String abroadRemark;
      private ForeignStatisticsDTO foreignStatistics;
      private GlobalStatisticsDTO globalStatistics;
      private int highDangerCount;
      private int midDangerCount;

      public int getId() {
        return id;
      }

      public void setId(int id) {
        this.id = id;
      }

      public long getCreateTime() {
        return createTime;
      }

      public void setCreateTime(long createTime) {
        this.createTime = createTime;
      }

      public long getModifyTime() {
        return modifyTime;
      }

      public void setModifyTime(long modifyTime) {
        this.modifyTime = modifyTime;
      }

      public String getSummary() {
        return summary;
      }

      public void setSummary(String summary) {
        this.summary = summary;
      }

      public boolean isDeleted() {
        return deleted;
      }

      public void setDeleted(boolean deleted) {
        this.deleted = deleted;
      }

      public String getCountRemark() {
        return countRemark;
      }

      public void setCountRemark(String countRemark) {
        this.countRemark = countRemark;
      }

      public int getCurrentConfirmedCount() {
        return currentConfirmedCount;
      }

      public void setCurrentConfirmedCount(int currentConfirmedCount) {
        this.currentConfirmedCount = currentConfirmedCount;
      }

      public int getConfirmedCount() {
        return confirmedCount;
      }

      public void setConfirmedCount(int confirmedCount) {
        this.confirmedCount = confirmedCount;
      }

      public int getSuspectedCount() {
        return suspectedCount;
      }

      public void setSuspectedCount(int suspectedCount) {
        this.suspectedCount = suspectedCount;
      }

      public int getCuredCount() {
        return curedCount;
      }

      public void setCuredCount(int curedCount) {
        this.curedCount = curedCount;
      }

      public int getDeadCount() {
        return deadCount;
      }

      public void setDeadCount(int deadCount) {
        this.deadCount = deadCount;
      }

      public int getSeriousCount() {
        return seriousCount;
      }

      public void setSeriousCount(int seriousCount) {
        this.seriousCount = seriousCount;
      }

      public int getSuspectedIncr() {
        return suspectedIncr;
      }

      public void setSuspectedIncr(int suspectedIncr) {
        this.suspectedIncr = suspectedIncr;
      }

      public int getCurrentConfirmedIncr() {
        return currentConfirmedIncr;
      }

      public void setCurrentConfirmedIncr(int currentConfirmedIncr) {
        this.currentConfirmedIncr = currentConfirmedIncr;
      }

      public int getConfirmedIncr() {
        return confirmedIncr;
      }

      public void setConfirmedIncr(int confirmedIncr) {
        this.confirmedIncr = confirmedIncr;
      }

      public int getCuredIncr() {
        return curedIncr;
      }

      public void setCuredIncr(int curedIncr) {
        this.curedIncr = curedIncr;
      }

      public int getDeadIncr() {
        return deadIncr;
      }

      public void setDeadIncr(int deadIncr) {
        this.deadIncr = deadIncr;
      }

      public int getSeriousIncr() {
        return seriousIncr;
      }

      public void setSeriousIncr(int seriousIncr) {
        this.seriousIncr = seriousIncr;
      }

      public int getYesterdayConfirmedCountIncr() {
        return yesterdayConfirmedCountIncr;
      }

      public void setYesterdayConfirmedCountIncr(int yesterdayConfirmedCountIncr) {
        this.yesterdayConfirmedCountIncr = yesterdayConfirmedCountIncr;
      }

      public int getYesterdaySuspectedCountIncr() {
        return yesterdaySuspectedCountIncr;
      }

      public void setYesterdaySuspectedCountIncr(int yesterdaySuspectedCountIncr) {
        this.yesterdaySuspectedCountIncr = yesterdaySuspectedCountIncr;
      }

      public String getRemark1() {
        return remark1;
      }

      public void setRemark1(String remark1) {
        this.remark1 = remark1;
      }

      public String getRemark2() {
        return remark2;
      }

      public void setRemark2(String remark2) {
        this.remark2 = remark2;
      }

      public String getRemark3() {
        return remark3;
      }

      public void setRemark3(String remark3) {
        this.remark3 = remark3;
      }

      public String getRemark4() {
        return remark4;
      }

      public void setRemark4(String remark4) {
        this.remark4 = remark4;
      }

      public String getRemark5() {
        return remark5;
      }

      public void setRemark5(String remark5) {
        this.remark5 = remark5;
      }

      public String getNote1() {
        return note1;
      }

      public void setNote1(String note1) {
        this.note1 = note1;
      }

      public String getNote2() {
        return note2;
      }

      public void setNote2(String note2) {
        this.note2 = note2;
      }

      public String getNote3() {
        return note3;
      }

      public void setNote3(String note3) {
        this.note3 = note3;
      }

      public String getGeneralRemark() {
        return generalRemark;
      }

      public void setGeneralRemark(String generalRemark) {
        this.generalRemark = generalRemark;
      }

      public String getAbroadRemark() {
        return abroadRemark;
      }

      public void setAbroadRemark(String abroadRemark) {
        this.abroadRemark = abroadRemark;
      }

      public ForeignStatisticsDTO getForeignStatistics() {
        return foreignStatistics;
      }

      public void setForeignStatistics(ForeignStatisticsDTO foreignStatistics) {
        this.foreignStatistics = foreignStatistics;
      }

      public GlobalStatisticsDTO getGlobalStatistics() {
        return globalStatistics;
      }

      public void setGlobalStatistics(GlobalStatisticsDTO globalStatistics) {
        this.globalStatistics = globalStatistics;
      }

      public int getHighDangerCount() {
        return highDangerCount;
      }

      public void setHighDangerCount(int highDangerCount) {
        this.highDangerCount = highDangerCount;
      }

      public int getMidDangerCount() {
        return midDangerCount;
      }

      public void setMidDangerCount(int midDangerCount) {
        this.midDangerCount = midDangerCount;
      }

      public static class ForeignStatisticsDTO {
        /**
         * currentConfirmedCount : 31748405
         * confirmedCount : 136523994
         * suspectedCount : 4
         * curedCount : 101806628
         * deadCount : 2968961
         * suspectedIncr : 0
         * currentConfirmedIncr : 109866
         * confirmedIncr : 562543
         * curedIncr : 443561
         * deadIncr : 9116
         */

        private int currentConfirmedCount;
        private int confirmedCount;
        private int suspectedCount;
        private int curedCount;
        private int deadCount;
        private int suspectedIncr;
        private int currentConfirmedIncr;
        private int confirmedIncr;
        private int curedIncr;
        private int deadIncr;

        public int getCurrentConfirmedCount() {
          return currentConfirmedCount;
        }

        public void setCurrentConfirmedCount(int currentConfirmedCount) {
          this.currentConfirmedCount = currentConfirmedCount;
        }

        public int getConfirmedCount() {
          return confirmedCount;
        }

        public void setConfirmedCount(int confirmedCount) {
          this.confirmedCount = confirmedCount;
        }

        public int getSuspectedCount() {
          return suspectedCount;
        }

        public void setSuspectedCount(int suspectedCount) {
          this.suspectedCount = suspectedCount;
        }

        public int getCuredCount() {
          return curedCount;
        }

        public void setCuredCount(int curedCount) {
          this.curedCount = curedCount;
        }

        public int getDeadCount() {
          return deadCount;
        }

        public void setDeadCount(int deadCount) {
          this.deadCount = deadCount;
        }

        public int getSuspectedIncr() {
          return suspectedIncr;
        }

        public void setSuspectedIncr(int suspectedIncr) {
          this.suspectedIncr = suspectedIncr;
        }

        public int getCurrentConfirmedIncr() {
          return currentConfirmedIncr;
        }

        public void setCurrentConfirmedIncr(int currentConfirmedIncr) {
          this.currentConfirmedIncr = currentConfirmedIncr;
        }

        public int getConfirmedIncr() {
          return confirmedIncr;
        }

        public void setConfirmedIncr(int confirmedIncr) {
          this.confirmedIncr = confirmedIncr;
        }

        public int getCuredIncr() {
          return curedIncr;
        }

        public void setCuredIncr(int curedIncr) {
          this.curedIncr = curedIncr;
        }

        public int getDeadIncr() {
          return deadIncr;
        }

        public void setDeadIncr(int deadIncr) {
          this.deadIncr = deadIncr;
        }
      }

      public static class GlobalStatisticsDTO {
        /**
         * currentConfirmedCount : 31748899
         * confirmedCount : 136627147
         * curedCount : 101904433
         * deadCount : 2973815
         * currentConfirmedIncr : 109870
         * confirmedIncr : 562569
         * curedIncr : 443583
         * deadIncr : 9116
         * yesterdayConfirmedCountIncr : 562566
         */

        private int currentConfirmedCount;
        private int confirmedCount;
        private int curedCount;
        private int deadCount;
        private int currentConfirmedIncr;
        private int confirmedIncr;
        private int curedIncr;
        private int deadIncr;
        private int yesterdayConfirmedCountIncr;

        public int getCurrentConfirmedCount() {
          return currentConfirmedCount;
        }

        public void setCurrentConfirmedCount(int currentConfirmedCount) {
          this.currentConfirmedCount = currentConfirmedCount;
        }

        public int getConfirmedCount() {
          return confirmedCount;
        }

        public void setConfirmedCount(int confirmedCount) {
          this.confirmedCount = confirmedCount;
        }

        public int getCuredCount() {
          return curedCount;
        }

        public void setCuredCount(int curedCount) {
          this.curedCount = curedCount;
        }

        public int getDeadCount() {
          return deadCount;
        }

        public void setDeadCount(int deadCount) {
          this.deadCount = deadCount;
        }

        public int getCurrentConfirmedIncr() {
          return currentConfirmedIncr;
        }

        public void setCurrentConfirmedIncr(int currentConfirmedIncr) {
          this.currentConfirmedIncr = currentConfirmedIncr;
        }

        public int getConfirmedIncr() {
          return confirmedIncr;
        }

        public void setConfirmedIncr(int confirmedIncr) {
          this.confirmedIncr = confirmedIncr;
        }

        public int getCuredIncr() {
          return curedIncr;
        }

        public void setCuredIncr(int curedIncr) {
          this.curedIncr = curedIncr;
        }

        public int getDeadIncr() {
          return deadIncr;
        }

        public void setDeadIncr(int deadIncr) {
          this.deadIncr = deadIncr;
        }

        public int getYesterdayConfirmedCountIncr() {
          return yesterdayConfirmedCountIncr;
        }

        public void setYesterdayConfirmedCountIncr(int yesterdayConfirmedCountIncr) {
          this.yesterdayConfirmedCountIncr = yesterdayConfirmedCountIncr;
        }
      }
    }

    public static class NewsDTO {
      /**
       * id : 130952
       * pubDate : 1618272984000
       * pubDateStr : 13小时前
       * title : 全国｜新增确诊 9 例 其中本土 1 例
       * summary : 4月12日0—24时，31个省（自治区、直辖市）和新疆生产建设兵团报告新增确诊病例9例，其中境外输入病例8例（浙江2例，广东2例，四川2例，上海1例，福建1例），本土病例1例（在云南）；无新增死亡病例；无新增疑似病例。
       当日新增治愈出院病例11例，解除医学观察的密切接触者62人，重症病例较前一日增加1例。
       境外输入现有确诊病例206例（其中重症病例4例），无现有疑似病例。累计确诊病例5443例，累
       * infoSource : 央视新闻app
       * sourceUrl : http://app.cctv.com/special/cportal/detail/arti/index.html?id=ArtincorrOkVoGeULytnQi8n210413&isfromapp=1
       * provinceId :
       * articleId : 41445
       * category : 1
       * jumpUrl :
       */

      private int id;
      private long pubDate;
      private String pubDateStr;
      private String title;
      private String summary;
      private String infoSource;
      private String sourceUrl;
      private String provinceId;
      private int articleId;
      private int category;
      private String jumpUrl;

      public int getId() {
        return id;
      }

      public void setId(int id) {
        this.id = id;
      }

      public long getPubDate() {
        return pubDate;
      }

      public void setPubDate(long pubDate) {
        this.pubDate = pubDate;
      }

      public String getPubDateStr() {
        return pubDateStr;
      }

      public void setPubDateStr(String pubDateStr) {
        this.pubDateStr = pubDateStr;
      }

      public String getTitle() {
        return title;
      }

      public void setTitle(String title) {
        this.title = title;
      }

      public String getSummary() {
        return summary;
      }

      public void setSummary(String summary) {
        this.summary = summary;
      }

      public String getInfoSource() {
        return infoSource;
      }

      public void setInfoSource(String infoSource) {
        this.infoSource = infoSource;
      }

      public String getSourceUrl() {
        return sourceUrl;
      }

      public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
      }

      public String getProvinceId() {
        return provinceId;
      }

      public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
      }

      public int getArticleId() {
        return articleId;
      }

      public void setArticleId(int articleId) {
        this.articleId = articleId;
      }

      public int getCategory() {
        return category;
      }

      public void setCategory(int category) {
        this.category = category;
      }

      public String getJumpUrl() {
        return jumpUrl;
      }

      public void setJumpUrl(String jumpUrl) {
        this.jumpUrl = jumpUrl;
      }
    }
  }
}
