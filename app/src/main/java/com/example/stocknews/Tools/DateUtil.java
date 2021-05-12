package com.example.stocknews.Tools;

public class DateUtil {

  public static long parseStringToLong(String dateStr) {
    dateStr = dateStr.trim();
    if (dateStr.length() == 19) {
      try {
        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.set(Integer.parseInt(dateStr.substring(0, 4)),
                Integer.parseInt(dateStr.substring(5, 7)) - 1,
                Integer.parseInt(dateStr.substring(8, 10)),
                Integer.parseInt(dateStr.substring(11, 13)),
                Integer.parseInt(dateStr.substring(14, 16)),
                Integer.parseInt(dateStr.substring(17, 19)));
        cal.set(java.util.Calendar.MILLISECOND, 0);
        return (cal.getTime().getTime());
      } catch (Exception e) {
        return 0;
      }

    } else if (dateStr.length() == 16) {
      try {
        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.set(Integer.parseInt(dateStr.substring(0, 4)),
                Integer.parseInt(dateStr.substring(5, 7)) - 1,
                Integer.parseInt(dateStr.substring(8, 10)),
                Integer.parseInt(dateStr.substring(11, 13)),
                Integer.parseInt(dateStr.substring(14, 16)));
        cal.set(java.util.Calendar.MILLISECOND, 0);
        return (cal.getTime().getTime());
      } catch (Exception e) {
        return 0;
      }
    } else if (dateStr.length() == 14) {
      try {
        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.set(Integer.parseInt(dateStr.substring(0, 4)),
                Integer.parseInt(dateStr.substring(4, 6)) - 1,
                Integer.parseInt(dateStr.substring(6, 8)),
                Integer.parseInt(dateStr.substring(8, 10)),
                Integer.parseInt(dateStr.substring(10, 12)),
                Integer.parseInt(dateStr.substring(12, 14)));
        cal.set(java.util.Calendar.MILLISECOND, 0);
        return (cal.getTime().getTime());
      } catch (Exception e) {
        return 0;
      }
    } else if (dateStr.length() == 10) {
      try {
        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.set(Integer.parseInt(dateStr.substring(0, 4)),
                Integer.parseInt(dateStr.substring(5, 7)) - 1,
                Integer.parseInt(dateStr.substring(8, 10)), 0, 0, 0);
        cal.set(java.util.Calendar.MILLISECOND, 0);
        return (cal.getTime().getTime());
      } catch (Exception e) {
        return 0;
      }
    } else {
      try {
        return Long.parseLong(dateStr);
      } catch (Exception e) {
        return 0;
      }

    }
  }
}