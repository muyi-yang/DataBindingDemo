package com.example.databindingdemo.util

import android.databinding.InverseMethod

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Date

/**
 * @author yanglijun
 * @date 19-3-13
 */
object Converter {
    /**
     * 绑定方法
     * @param value
     * @return
     */
    @InverseMethod("stringToDate")
    @JvmStatic
    fun dateToString(value: Long): String {
        val s = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        return s.format(Date(value))
    }

    /**
     * 逆转换器方法
     * @param value
     * @return
     */
    @JvmStatic
    fun stringToDate(value: String): Long {
        val s = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        var time: Long = 0
        try {
            val date = s.parse(value)
            time = date.time
        } catch (e: ParseException) {
            e.printStackTrace()
        }

        return time
    }
}
