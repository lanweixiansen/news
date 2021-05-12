package com.example.stocknews.Tools;


public class DataUtil {
    private static int page;
    private static String date;

    //APPtoken
    public final static String APPToken = "abcdefg";
    //记录用户是否已经点赞评论过文章
    public static boolean NEWSINFO  = false;

    //友盟AppKey
    private static final String AppKey = "6037076f425ec25f10034943";
    private static final String Channel = "ANDROID_GUPIAO";

    public static String getChannel() {
        return Channel;
    }

    public static String getAppKey() {
        return AppKey;
    }

    public static String getDate() {
        return date;
    }

    public static void setDate(String data) {
        DataUtil.date = data;
    }

    public static int getPage() {
        return page;
    }

    public static void setPage(int page) {
        DataUtil.page = page;
    }


}
