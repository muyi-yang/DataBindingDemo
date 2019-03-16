package com.example.databindingdemo.util;

import android.databinding.InverseMethod;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author yanglijun
 * @date 19-3-13
 */
public class Converter {
    /**
     * 绑定方法
     * @param value
     * @return
     */
    @InverseMethod("stringToDate")
    public static String dateToString(long value) {
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return s.format(new Date(value));
    }

    /**
     * 逆转换器方法
     * @param value
     * @return
     */
    public static long stringToDate(String value) {
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long time = 0;
        try {
            Date date = s.parse(value);
            time = date.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return time;
    }
}
