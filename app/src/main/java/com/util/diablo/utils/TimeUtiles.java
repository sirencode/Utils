package com.util.diablo.utils;

import android.text.format.Time;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Diablo on 2016/12/10.
 * 时间格式化工具
 */

public class TimeUtiles {

    /**
     * G 年代标志符
     * y 年
     * M 月
     * d 日
     * h 时 在上午或下午 (1~12)
     * H 时 在一天中 (0~23)
     * m 分
     * s 秒
     * S 毫秒
     * E 星期
     * D 一年中的第几天
     * F 一月中第几个星期几
     * w 一年中第几个星期
     * W 一月中第几个星期
     * a 上午 / 下午 标记符
     * k 时 在一天中 (1~24)
     * K 时 在上午或下午 (0~11)
     * z 时区
     */
    public static final String FORMAT1 = "yyyy年MM月dd日 HH时mm分ss秒";
    public static final String FORMAT2 = "yy/MM/dd HH:mm";
    public static final String FORMAT3 = "yyyy-MM-dd HH:mm:ss";
    public static final String FORMAT4 = "yyyy年MM月dd日 HH时mm分ss秒 E";


    public static String formatData(final long time, final String formate) {
        Date date = new Date(time);
        SimpleDateFormat dateFormat = new SimpleDateFormat(formate);
        return dateFormat.format(date);
    }

    public static String getYMDHMS(final long time) {
        Time t = new Time();
        t.set(time);
        int year = t.year;
        int month = t.month; // 0-11）此处值得注意
        int day = t.monthDay;
        int hour = t.hour; // 24小时制（0-23）
        int minute = t.minute;
        int second = t.second;
        return "year:" + year + "\n month:" + (month + 1) + "\nday:" + day + "\nhour:" + hour + "\nminute:" + minute + "\nsecond:" + second;
    }
}
