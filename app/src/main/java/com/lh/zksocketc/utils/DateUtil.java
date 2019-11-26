package com.lh.zksocketc.utils;

import android.annotation.SuppressLint;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.TimeZone;

@SuppressLint("SimpleDateFormat")
public class DateUtil {

    /**
     * 获取当前时间,format = yyyy-MM-dd HH:mm:ss
     *
     * @return
     */
    public static String getNow() {
        return getNow("yyyy-MM-dd HH:mm:ss");
    }

    public static String getHHmmss() {
        return getNow("HH:mm:ss");
    }

    public static String getTimeyyyyMMdd() {
        return getNow("yyyy-MM-dd");
    }
    /**
     * 根据指定的format格式获取当前时间
     *
     * @param format
     * @return
     */
    public static String getNow(String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        Date date = new Date(System.currentTimeMillis());
        return dateFormat.format(date);
    }

    /**
     * 获取星期
     *
     * @return
     */
    public static String getWeek() {
        String mWay = "";
        final Calendar c = Calendar.getInstance();
        c.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        mWay = String.valueOf(c.get(Calendar.DAY_OF_WEEK));
        if ("1".equals(mWay)) {
            mWay = "星期日";
        } else if ("2".equals(mWay)) {
            mWay = "星期一 ";
        } else if ("3".equals(mWay)) {
            mWay = "星期二 ";
        } else if ("4".equals(mWay)) {
            mWay = "星期三";
        } else if ("5".equals(mWay)) {
            mWay = "星期四 ";
        } else if ("6".equals(mWay)) {
            mWay = "星期五";
        } else if ("7".equals(mWay)) {
            mWay = "星期六";
        }
        return mWay;
    }


    /**
     * 格式化时间（将时间转换成秒）
     *
     * @param dateFormat
     * @return 秒
     */
    public static Long ToMill(String dateFormat) {
        long todayLong = 0;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        try {
            Date date = simpleDateFormat.parse(dateFormat);
            todayLong = date.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return todayLong;
    }

    /**
     * 判断日期大小
     * @param DATE1
     * @param DATE2
     * @return
     */
    public static long compare_date(String DATE1, String DATE2) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ParsePosition pos1 = new ParsePosition(0);
        Date dt1 = df.parse(DATE1, pos1);
        long time1 = dt1.getTime();

        ParsePosition pos2 = new ParsePosition(0);
        Date dt2 = df.parse(DATE2, pos2);
        long time2 = dt2.getTime();

        long timecha = time1 - time2;

        return timecha;
    }

}
