package com.yuk.java;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        Date nowDate=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String nowDateStr = simpleDateFormat.format(nowDate);
        // nowDateStr:2020-05-19 06:40:43
        System.out.println("nowDateStr:" + nowDateStr);

        simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        nowDateStr = simpleDateFormat.format(nowDate);
        // nowDateStr:2020-05-19 18:40:43
        System.out.println("nowDateStr:" + nowDateStr);

        String currentTime = getCurrectData();
        // 8点这个点的时间戳
        Integer currentTimeSteamp = hourMinuteString2Timestamp(currentTime.substring(0, 16)) % 86400;
        System.out.println("currentTimeSteamp:" + currentTimeSteamp);
        if (currentTimeSteamp > 57600) {
            currentTimeSteamp -= 86400;
        }
        System.out.println("currentTime:" + currentTime);
        System.out.println("currentTimeSteamp:" + currentTimeSteamp);

        System.out.println("--new---");
        System.out.println(hourMinuteString2Timestamp("2018-11-23 10:56") % 86400);// 10560
        System.out.println(hourMinuteString2Timestamp("2018-11-23 10:56") / 86400);// 17858
        // 17858*86400 + 10560=1,542,931,200(2018/11/23 8:0:0) + 10560 = 1,542,941,760


        System.out.println(hourMinuteString2Timestamp("2018-11-23 16:56") % 86400);// 32160
        System.out.println(hourMinuteString2Timestamp("2018-11-23 16:56") / 86400);// 17858
        // 17858*86400 + 32160=1,542,931,200(2018/11/23 8:0:0) + 32160 = 1,542,963,360


        System.out.println(hourMinuteString2Timestamp("2018-11-23 21:56") % 86400);// 50160
        System.out.println(hourMinuteString2Timestamp("2018-11-23 21:56") / 86400);// 17858
        // 17858*86400 + 50160=1,542,931,200(2018/11/23 8:0:0) + 50160 = 1,542,981,360

        System.out.println(hourMinuteString2Timestamp("2018-11-24 00:00") % 86400);// 57600
        System.out.println(hourMinuteString2Timestamp("2018-11-24 00:00") / 86400);// 17858
        // 17858*86400 + 57600=1,542,931,200(2018/11/23 8:0:0) + 57600 = 1,542,988,800

        Integer currentTimeSteamp2 = hourMinuteString2Timestamp("2018-11-24 05:56") % 86400;
        System.out.println(hourMinuteString2Timestamp("2018-11-24 05:56") % 86400);// 78960
        System.out.println(hourMinuteString2Timestamp("2018-11-24 05:56") / 86400);// 17858
        // 17858*86400 + 78960=1,542,931,200(2018/11/23 8:0:0) + 78960 = 1,543,010,160
        if (currentTimeSteamp2 > 57600) {
            currentTimeSteamp2 -= 86400;
        }
        System.out.println("currentTimeSteamp2:"+currentTimeSteamp2);

        // 17859*86400=1,543,017,600(2018-11-24 08:00:00)
    }

    public static String getCurrectData() {
        return getFormatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
    }

    public static String getFormatDate(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    public static Integer hourMinuteString2Timestamp(String str) {
        System.out.println("[hourMinuteString2Timestamp]str:" + str);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            Date date = format.parse(str);
            Long dt = date.getTime() / 1000;
            System.out.println("[hourMinuteString2Timestamp]dt:" + dt);
            return Integer.parseInt(dt.toString());
        } catch (Exception e) {
            System.out.println("时间转换出错");
        }
        return null;
    }

}
