package com.biotag.cockowner.utils;

/**
 * Author: Caixx
 * Date: 2005-2-24
 * Time: 19:31:03
 */

import android.content.Context;
import android.graphics.Color;
import android.text.Html;
import android.text.Spannable;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;

import com.biotag.cockowner.R;
import com.biotag.cockowner.common.Log;
import com.biotag.cockowner.customview.RoundedBackgroundSpan;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    //public static final long millisInDay = 86400000;
    //public static final DateFormat DATE_FORMAT = new SimpleDateFormat("MM/dd/yyyy");
    //public static final DateFormat FULL_DATE_FORMAT = new SimpleDateFormat("EEE, MMM d, yyyyy hh:mm:ss aa z");
    //public static final DateFormat ISO8601_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SS z");
    private static SimpleDateFormat formatter;
    private static final SimpleDateFormat mFormat8chars = new SimpleDateFormat("yyyyMMdd");
    private static final SimpleDateFormat mFormatWeeks = new SimpleDateFormat("ww");
    private static final SimpleDateFormat mFormatDayInWeek = new SimpleDateFormat("EE");
    private static final SimpleDateFormat mFormatYear = new SimpleDateFormat("yyyy");

    public static int getWeek(Date date) {
        int week = Integer.parseInt(mFormatWeeks.format(date));
        String dayInWeek = mFormatDayInWeek.format(date);
        if (dayInWeek.toUpperCase().equals("������") || dayInWeek.toUpperCase().equals("SUNDAY")) {
            week = week - 1;
        }
        return week;
    }

    public static int getYear(Date date) {
        return Integer.parseInt(mFormatYear.format(date));
    }

    public static String shortDate(Date aDate) {
        if (aDate == null)
            return "";
        formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(aDate);
    }

    public static Date getEndOfDay(Date day) {
        return getEndOfDay(day, Calendar.getInstance());
    }

    public static Date getEndOfDay(Date day, Calendar cal) {
        if (day == null) day = new Date();
        cal.setTime(day);
        cal.set(Calendar.HOUR_OF_DAY, cal.getMaximum(Calendar.HOUR_OF_DAY));
        cal.set(Calendar.MINUTE, cal.getMaximum(Calendar.MINUTE));
        cal.set(Calendar.SECOND, cal.getMaximum(Calendar.SECOND));
        cal.set(Calendar.MILLISECOND, cal.getMaximum(Calendar.MILLISECOND));
        return cal.getTime();
    }

    public static Date getNoonOfDay(Date day, Calendar cal) {
        if (day == null) day = new Date();
        cal.setTime(day);
        cal.set(Calendar.HOUR_OF_DAY, 12);
        cal.set(Calendar.MINUTE, cal.getMinimum(Calendar.MINUTE));
        cal.set(Calendar.SECOND, cal.getMinimum(Calendar.SECOND));
        cal.set(Calendar.MILLISECOND, cal.getMinimum(Calendar.MILLISECOND));
        return cal.getTime();
    }

    public static java.text.SimpleDateFormat get8charDateFormat() {
        return DateUtil.mFormat8chars;
    }

    public static String mailDate(Date aDate) {
        if (aDate == null)
            return "";
        formatter = new SimpleDateFormat("yyyyMMddHHmm");
        return formatter.format(aDate);
    }

    public static String longDate(Date aDate) {
        if (aDate == null)
            return "";
        formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(aDate);
    }

    /**
     * 格式化活动创建界面选择的日期
     * @return
     */
    public static String formatDataForActCreate(Date date){
        if(null == date) return "";
        return new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date);
    }


    public static String shortDateGB(Date aDate) {
        if (aDate == null)
            return "";
        formatter = new SimpleDateFormat("yyyy年MM月dd日");
        return formatter.format(aDate);
    }

    /**
     * Returns a Date set to the first possible millisecond of the day, just
     * after midnight. If a null day is passed in, a new Date is created.
     * midnight (00m 00h 00s)
     */
    public static Date getStartOfDay(Date day) {
        return getStartOfDay(day, Calendar.getInstance());
    }

    /**
     * Returns a Date set to the first possible millisecond of the day, just
     * after midnight. If a null day is passed in, a new Date is created.
     * midnight (00m 00h 00s)
     */
    public static Date getStartOfDay(Date day, Calendar cal) {
        if (day == null) day = new Date();
        cal.setTime(day);
        cal.set(Calendar.HOUR_OF_DAY, cal.getMinimum(Calendar.HOUR_OF_DAY));
        cal.set(Calendar.MINUTE, cal.getMinimum(Calendar.MINUTE));
        cal.set(Calendar.SECOND, cal.getMinimum(Calendar.SECOND));
        cal.set(Calendar.MILLISECOND, cal.getMinimum(Calendar.MILLISECOND));
        return cal.getTime();
    }

    public static String longDateGB(Date aDate) {
        if (aDate == null)
            return "";
        formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(aDate);
    }

    public static String longDateLog(Date aDate) {
        if (aDate == null)
            return "";
        formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        return formatter.format(aDate);
    }

    public static String formatDate(Date aDate, String formatStr) {
        if (aDate == null)
            return "";
        formatter = new SimpleDateFormat(formatStr);
        return formatter.format(aDate);

    }

    public static String formatLongDate(long date) {
        if (date == 0)
            return "";
        formatter = new SimpleDateFormat("MM月dd日 HH:mm");
        return formatter.format(new Date(date));

    }

    public static String formatRewardDate(long date) {
        if (date == 0)
            return "";
        formatter = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
        return formatter.format(new Date(date));

    }

    public static String getLiveTime(long date) {
        if (date == 0)
            return "";
        formatter = new SimpleDateFormat("yyyy年MM月dd日 晚h点");
        return formatter.format(new Date(date));

    }

    public static String LDAPDate(Date aDate) {
        if (aDate == null)
            return "";
        return formatDate(aDate, "yyyyMMddHHmm'Z'");
    }

    public static Date getDate(String yyyymmdd) {
        if (yyyymmdd == null) return null;
        int year = Integer.parseInt(yyyymmdd.substring(0, yyyymmdd.indexOf("-")));
        int month = Integer.parseInt(yyyymmdd.substring(yyyymmdd.indexOf("-") + 1, yyyymmdd.lastIndexOf("-")));
        int day = Integer.parseInt(yyyymmdd.substring(yyyymmdd.lastIndexOf("-") + 1));
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, day);
        return cal.getTime();

    }

    public static Date getDateByMillisecond(String millisecond) {
        if (millisecond == null || millisecond.trim().length() == 0 || millisecond.equals("undefined")) {
            return null;
        }
        try {
            Date date = new Date(Long.parseLong(millisecond));
            return date;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Date parser(String strDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            return sdf.parse(strDate);
        } catch (Exception e) {
            return null;
        }
    }

    public static Date parser24(String strDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return sdf.parse(strDate);
        } catch (Exception e) {
            return null;
        }
    }
    public static Date parser24NoSecond(String strDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            return sdf.parse(strDate);
        } catch (Exception e) {
            return null;
        }
    }


    public static String getTime(Date aDate, String dateformat) {
        if (aDate == null)
            return "";
        formatter = new SimpleDateFormat(dateformat);
        return formatter.format(aDate);
    }


    public static String formatedate(String befTime, String befformat, String targetformat) {
        if (befTime == null) {
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(befformat);
        try {
            Date time = sdf.parse(befTime);
            return formatDate(time, targetformat);
        } catch (Exception e) {
            return "";
        }


    }


    public static Date getShortDate(String date) {
        Date shortDate = null;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            shortDate = formatter.parse(date);
        } catch (Exception e) {
            shortDate = null;
        }
        return shortDate;
    }

    public static boolean equals(Date date1, Date date2) {
        if (date1 == null && date2 == null)
            return true;
        if (date1 == null && date2 != null)
            return false;
        if (date1 != null && date2 == null)
            return false;
        return date1.equals(date2);
    }

    /**
     * @return java.util.Date
     */
    public static Date tomorrow() {
        java.util.Calendar calender = java.util.Calendar.getInstance();
        calender.roll(Calendar.DAY_OF_YEAR, true);
        return calender.getTime();
    }

    /**
     * @param date
     * @return java.util.Date
     */
    public static Date nextDate(java.util.Date date) {
        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.setTime(date);
        cal.roll(java.util.Calendar.DAY_OF_YEAR, 1);
        if (isEndOfYear(date, cal.getTime())) {
            cal.roll(Calendar.YEAR, true);
            cal.roll(java.util.Calendar.DAY_OF_YEAR, 1);
        }
        return cal.getTime();
    }

    /**
     * @param curDate
     * @param rollUpDate
     * @return boolean
     */
    private static boolean isEndOfYear(java.util.Date curDate, java.util.Date rollUpDate) {
        return (curDate.compareTo(rollUpDate) >= 0);
    }

    /**
     * @return java.util.Date
     */
    public static Date yesterday() {
        java.util.Calendar calender = java.util.Calendar.getInstance();
        calender.roll(Calendar.DAY_OF_YEAR, false);
        return calender.getTime();
    }

    /**
     * @param aDate
     * @return Personal
     */
    private static final String getDateFormat(java.util.Date aDate) {
        if (aDate == null)
            return null;
        SimpleDateFormat formatter
                = new SimpleDateFormat("M/d/yyyy");
        return formatter.format(aDate);
    }

    /**
     * @param date
     * @return Personal
     */
    public static String NVL(java.util.Date date) {
        if (date == null)
            return "";
        else
            return getDateFormat(date);
    }

    /**
     * @param baseDate
     * @param type
     * @param num
     * @return Date
     */
    public static Date addDate(Date baseDate, int type, int num) {
        Date lastDate = null;
        try {
            Calendar cale = Calendar.getInstance();
            cale.setTime(baseDate);
            if (type == 1) {
                cale.add(Calendar.YEAR, num);
            } else if (type == 2) {
                cale.add(Calendar.MONTH, num);
            } else if (type == 3) {
                cale.add(Calendar.DATE, num);
            }
            lastDate = cale.getTime();
            return lastDate;
        } catch (Exception e) {
            return null;
        }

    }

    public static Date getDate(String strDate, String formatter) {
        SimpleDateFormat sdf = new SimpleDateFormat(formatter);
        try {
            return sdf.parse(strDate);
        } catch (Exception e) {
            return null;
        }
    }

    public static Date getSysDate() {
        return new Date(System.currentTimeMillis());
    }

    public static Date getTheFirstDayOfCurMonth(Date date) {
        Calendar calender = Calendar.getInstance();
        calender.setTime(date);
        calender.set(Calendar.DAY_OF_MONTH, 1);
        return calender.getTime();
    }

    public static Date getTheFirstDayOfCurMonth(String date) {
        return getTheFirstDayOfCurMonth(getShortDate(date));
    }

    public static String getTheFirstDayOfCurMonthStr(Date date) {
        return shortDate(getTheFirstDayOfCurMonth(date));
    }

    public static String getTheFirstDayOfCurMonthStr(String date) {
        return shortDate(getTheFirstDayOfCurMonth(date));
    }

    public static Date getTheEndDayOfCurMonth(Date date) {
        Date firstDay = getTheFirstDayOfCurMonth(date);
        Calendar calender = Calendar.getInstance();
        calender.setTime(firstDay);
        calender.roll(Calendar.MONTH, 1);
        calender.roll(Calendar.DAY_OF_YEAR, -1);
        return calender.getTime();
    }

    public static Date getTheEndDayOfCurMonth(String date) {
        return getTheEndDayOfCurMonth(getShortDate(date));
    }

    public static String getTheEndDayOfCurMonthStr(Date date) {
        return shortDate(getTheEndDayOfCurMonth(date));
    }

    public static String getTheEndDayOfCurMonthStr(String date) {
        return shortDate(getTheEndDayOfCurMonth(date));
    }

    public static int getDateSpan(Date beginDate, Date endDate, int calType) {
        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.setTime(beginDate);
        int[] p1 = {cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 1, cal.get(Calendar.DAY_OF_MONTH)};
        cal.clear();
        cal.setTime(endDate);
        int[] p2 = {cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 1, cal.get(Calendar.DAY_OF_MONTH)};
        int[] s = {p2[0] - p1[0], p2[0] * 12 + p2[1] - p1[0] * 12 - p1[1], (int) ((endDate.getTime() - beginDate.getTime()) / (24 * 3600 * 1000))};
        if (calType <= 3 || calType >= 1) {
            return s[calType - 1];
        } else {
            return 0;
        }
    }

    public static String getTimestamp() {
        return String.valueOf(System.currentTimeMillis());
    }

    public static String formatDate(String content_createtime, String format) {
        String date = "";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String systemTime = sdf.format(new Date()).toString();
        try {
            Date begin = sdf.parse(content_createtime);
            Date end = sdf.parse(systemTime);
            long second = (end.getTime() - begin.getTime()) / 1000L;
            long l = 60L * 1000L;
            long l1 = (end.getTime() - begin.getTime()) / l; // 转换成分钟
            long hl = 60L * 60L * 1000L;
            long h1 = (end.getTime() - begin.getTime()) / hl;   //转换成小时
            if (second < 60) {
                if (second < 3) {
                    date = ("刚刚");
                } else {
                    date = (second + "秒前");
                }
            } else if (l1 < 60 && l1 > 0) {
                date = (l1 + "分钟前");
            } else if (h1 < 24 && h1 > 0) {               //24小时前
                date = (h1 + "小时前");
            }  else if (h1 < 48 && h1 >= 24) {               //48小时前
                date = "昨天";
            } else {
                String month = String.format("%tm", begin);
                String day = String.format("%td", begin);
                String hour = String.format("%tH", begin);
                String minutes = String.format("%tM", begin);
                date = month + "-" + day + " " + hour + ":"
                        + minutes;
            }
        } catch (ParseException e) {
            return date;
        }
        return date;

    }
    public static String transferLongToDate(Long millSec){
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd HH:mm");
        Date date= new Date(millSec);
        return sdf.format(date);
    }

    public static String formatDate(long content_createtime) {
        String date = "";
        try {
            long begin = content_createtime;
            long end = System.currentTimeMillis();
            long second = (end - begin) / 1000L;
            long l = 60L * 1000L;
            long l1 = (end - begin) / l; // 转换成分钟
            long hl = 60L * 60L * 1000L;
            long h1 = (end - begin) / hl;   //转换成小时
            long dl = 24 * 60L * 60L * 1000L;
            long d1 = (end - begin) / dl;   //转换成天
            long ml = 30 * 24 * 60L * 60L * 1000L;
            long m1 = (end - begin) / ml;   //转换成月
            long yl = 12 * 30 * 24 * 60L * 60L * 1000L;
            long y1 = (end - begin) / yl;   //转换成年
            if (m1 < 12) {
                if (second < 60) {
                    if (second < 3) {
                        date = ("刚刚");
                    } else {
                        date = (second + "秒前");
                    }
                } else if (l1 < 60 && l1 > 0) {
                    date = (l1 + "分钟前");
                } else if (h1 < 24 && h1 > 0) {               //24小时前
                    date = (h1 + "小时前");
                } else if (d1 < 31 && d1 > 0) {               //30天前
                    date = (d1 + "天前");
                } else if (m1 < 13 && m1 > 0) {               //12小时前
                    date = (m1 + "个月前");
                } else {
                    date = y1 + "年前";
                }
            } else {
                date = y1 + "年前";
            }
        } catch (Exception e) {
            return date;
        }
        return date;

    }

    public static String formatDate(String time1, String format, String targetFormat) {
        String targettime = null;
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            Date date1 = sdf.parse(time1);
            SimpleDateFormat targetsdf = new SimpleDateFormat(targetFormat);
            targettime = targetsdf.format(date1);
        } catch (ParseException e) {
            return null;
        }
        return targettime;
    }
    /**
     * 观看时间转换
     *
     * @param playedTime
     * @return
     */
    public static String parsePlayedTime(int playedTime) {
        String parsePt = "";
        int second = playedTime / 1000;
        int minute = 0;
        if (second > 60) {
            minute = second / 60;
            second = second % 60;
        }
        String seconds = String.valueOf(second);
        if (second < 10) {
            seconds = "0" + second;
        }
        String minutes = String.valueOf(minute);
        if (minute < 10) {
            minutes = "0" + minute;
        } else if (minute == 0) {
            minutes = "00";
        }
        parsePt = minutes + ":" + seconds;
        return parsePt;
    }

    /**
     * 与当前时间比较，如果晚于当前时间则返回true
     *
     * @param time1
     * @param currenttime
     * @return
     */
    public static boolean compareTime(String time1, String currenttime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date1 = sdf.parse(time1);
            Date currentDate = sdf.parse(currenttime);
            if (date1.before(currentDate) || date1.equals(currentDate)) {
                return false;
            } else {
                return true;
            }
        } catch (ParseException e) {
            return false;
        }
    }

    /**
     * 获取日期中的月份
     *
     * @param strDate
     * @return
     */
    public static String getMonthFromStr(String strDate) {
        String month = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date dt = sdf.parse(strDate);
            month = String.valueOf(dt.getMonth() + 1);
        } catch (ParseException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return month;
    }

    /**
     * 获取日期中的年份
     *
     * @param strDate
     * @return
     */
    public static String getYearFromStr(String strDate) {
        String year = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date dt = sdf.parse(strDate);
            year = String.valueOf(getYear(dt));
        } catch (ParseException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return year;
    }

    /**
     * 获取两个日期之间的月份间隔
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int getMonthBetweenDate(String date1, String date2) {
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        Date d1 = null;
        try {
            d1 = sd.parse(date1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date d2 = null;
        try {
            d2 = sd.parse(date2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int months = 0;//相差月份
        int y1 = d1.getYear();
        int y2 = d2.getYear();
        if (d1.getTime() < d2.getTime()) {
            months = d2.getMonth() - d1.getMonth() + (y2 - y1) * 12 + 1;
        }
        return months;
    }

    public static long parseTime4Long(String time) {
        long datetime = -1;
        Date date = parser24(time);
        if (date != null) {
            datetime = date.getTime();
        }
        return datetime;
    }


    public static long dateToLong(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.getTimeInMillis();
    }

    /**
     * 时分秒转成字符串
     *
     * @param time
     * @return
     */
    public static String getHms(long time) {
        String hms = "";
        long hour = 0l, minutes = 0l, seconds = 0l;
        hour = time / 3600;
        minutes = (time / 60) % 60;
        seconds = time % 60;
        hms = String.format("%02d:%02d:%02d", hour, minutes, seconds);
        return hms;
    }

    public static String[] getDateTime(String time) {
        String[] day = new String[2];

        Date date2 = parser24NoSecond(time);

        int month = date2.getMonth();
        int date = date2.getDate();
        int hour = date2.getHours();
        int minute = date2.getMinutes();
        day[0] = String.format("%02d-%02d", (month+1), date);
        day[1] = String.format("%02d:%02d", hour, minute);

        return day;
    }

    public static int compareDay(String time){
        int diff=-1;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            Date begindate= formatter.parse(time);
            Date end=new Date();
            int ey=end.getYear();
            int by=begindate.getYear();
            int ed=end.getDate();
            int bd=begindate.getDate();
            if(ey==by) {
                diff = ed - bd;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return diff;
    }

    public static long getAge(String birthday){
        if(birthday == null || birthday.trim().equals(""))
            return 0;
        long age = 0,day = 0;
        formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date now = new Date();
        Date birthdayDate;
        try {
            birthdayDate = formatter.parse(birthday);
            day = (now.getTime()-birthdayDate.getTime())/(24*60*60*1000);
            age = day / 365;
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
        return age;
    }


    public static String getShortDate(long aDate, String formatStr) {
        if (aDate == 0)
            return "";
        if(String.valueOf(aDate).length()==10){
            aDate = aDate*1000L;
        }
        SimpleDateFormat formatter = new SimpleDateFormat(formatStr);
        return formatter.format(new Date(aDate));
    }

    public static long getNextDate(long aDate,int nextPosition){
        if (aDate == 0)
            return aDate;
        if(String.valueOf(aDate).length()==10){
            aDate = aDate*1000L;
        }
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(aDate);
        c.add(Calendar.DATE, nextPosition);
        return c.getTimeInMillis();
    }


    /**
     * 根据时间绘制时钟
     * @param time
     * @return
     */
    public static Spanned drawTime(long time) {
        Spanned str;
        StringBuffer returnString = new StringBuffer();
        long day = time / (24 * 60 * 60);
        long hours = (time % (24 * 60 * 60)) / (60 * 60);
        long minutes = ((time % (24 * 60 * 60)) % (60 * 60)) / 60;
        long second = ((time % (24 * 60 * 60)) % (60 * 60)) % 60;
        String hoursStr = timeStrFormat(String.valueOf(hours));
        String minutesStr = timeStrFormat(String.valueOf(minutes));
        String secondStr = timeStrFormat(String.valueOf(second));

        String dayStr = timeStrFormat(String.valueOf(day));
        returnString.append(dayStr).append("天").append(hoursStr).append("时").append(minutesStr).append("分").append(secondStr).append("秒");

        //加字间距
        for (int i = 1; i < returnString.length(); i += 2) {
            returnString.insert(i, " ");
        }
        str = Html.fromHtml(returnString.toString());

        ((Spannable) str).setSpan(new RoundedBackgroundSpan(Color.WHITE, Color.BLACK), 0, 1,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        ((Spannable) str).setSpan(new RoundedBackgroundSpan(Color.WHITE, Color.BLACK), 2, 3,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        ((Spannable) str).setSpan(new AbsoluteSizeSpan(/*UIUtils.getContext().getResources().getDimensionPixelSize(R.dimen.dimen_12)*/UIUtils.getDimens(R.dimen.dimen_12)), 4, 5,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        ((Spannable) str).setSpan(new RoundedBackgroundSpan(Color.WHITE, Color.BLACK), 6, 7,
                Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        ((Spannable) str).setSpan(new RoundedBackgroundSpan(Color.WHITE, Color.BLACK), 8, 9,
                Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        ((Spannable) str).setSpan(new AbsoluteSizeSpan(UIUtils.getDimens(R.dimen.dimen_12)), 10, 11,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        ((Spannable) str).setSpan(new RoundedBackgroundSpan(Color.WHITE, Color.BLACK), 12, 13,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        ((Spannable) str).setSpan(new RoundedBackgroundSpan(Color.WHITE, Color.BLACK), 14, 15,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        ((Spannable) str).setSpan(new AbsoluteSizeSpan(UIUtils.getDimens(R.dimen.dimen_12)), 16, 17,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        ((Spannable) str).setSpan(new RoundedBackgroundSpan(Color.WHITE, Color.BLACK), 18, 19,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        ((Spannable) str).setSpan(new RoundedBackgroundSpan(Color.WHITE, Color.BLACK), 20, 21,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        ((Spannable) str).setSpan(new AbsoluteSizeSpan(UIUtils.getDimens(R.dimen.dimen_12)), 22, 23,
                Spannable.SPAN_EXCLUSIVE_INCLUSIVE);

        return str;
    }

    private static String timeStrFormat(String timeStr) {
        switch (timeStr.length()) {
            case 1:
                timeStr = "0" + timeStr;
                break;
        }
        return timeStr;
    }

    /**
     * 判断两个时间戳是否处于同一天
     * @return
     */
    public static boolean isSameDay(long date1, long date2){

        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");

        String time1 = sd.format(date1);
        String time2 = sd.format(date2);

        Log.d("test_flag","time1.."+time1+"...time2..."+time2);

        return time1.equals(time2);
    }

    /**
     * 根据月日计算星座
     * @param month
     * @param day
     * @return
     */
    public static String getAstro(int month, int day) {
        String[] astro = new String[] { "摩羯座", "水瓶座", "双鱼座", "白羊座", "金牛座",
                "双子座", "巨蟹座", "狮子座", "处女座", "天秤座", "天蝎座", "射手座", "摩羯座" };
        int[] arr = new int[] { 20, 19, 21, 21, 21, 22, 23, 23, 23, 23, 22, 22 };// 两个星座分割日
        int index = month;
        // 所查询日期在分割日之前，索引-1，否则不变
        if (day < arr[month - 1]) {
            index = index - 1;
        }
        // 返回索引指向的星座string
        return astro[index];
    }

    /**
     * 根据月日计算星座
     * @param date
     * @return
     */
    public static String getStar(Date date)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int month = cal.get(Calendar.MONTH) + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        String star = "";
        if (month == 1 && day >= 20 || month == 2 && day <= 18)
        {
            star = "水瓶座";
        }
        if (month == 2 && day >= 19 || month == 3 && day <= 20)
        {
            star = "双鱼座";
        }
        if (month == 3 && day >= 21 || month == 4 && day <= 19)
        {
            star = "白羊座";
        }
        if (month == 4 && day >= 20 || month == 5 && day <= 20)
        {
            star = "金牛座";
        }
        if (month == 5 && day >= 21 || month == 6 && day <= 21)
        {
            star = "双子座";
        }
        if (month == 6 && day >= 22 || month == 7 && day <= 22)
        {
            star = "巨蟹座";
        }
        if (month == 7 && day >= 23 || month == 8 && day <= 22)
        {
            star = "狮子座";
        }
        if (month == 8 && day >= 23 || month == 9 && day <= 22)
        {
            star = "处女座";
        }
        if (month == 9 && day >= 23 || month == 10 && day <= 22)
        {
            star = "天秤座";
        }
        if (month == 10 && day >= 23 || month == 11 && day <= 21)
        {
            star = "天蝎座";
        }
        if (month == 11 && day >= 22 || month == 12 && day <= 21)
        {
            star = "射手座";
        }
        if (month == 12 && day >= 22 || month == 1 && day <= 19)
        {
            star = "摩羯座";
        }
        return star;
    }

    /**
     * 根据月日计算星座
     * @param data
     * @return
     */
    public static String getStarAccordingToStringData(String data) {
        Date birthDate = DateUtil.getShortDate(data);
        if (null != birthDate) {
            return DateUtil.getStar(birthDate);
        }
        return "";
    }

    /**
     * 作者 : andy
     * 日期 : 16/1/21 12:07
     * 邮箱 : andyxialm@gmail.com
     * 描述 : 工具类
     */
    public static class CompatUtils {
        public static int dp2px(Context context, float dipValue) {
            final float scale = context.getResources().getDisplayMetrics().density;
            return (int) (dipValue * scale + 0.5f);
        }
    }
}

