package com.src.main.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateTimeUtil {
    static final long ONE_MINUTE_IN_MILLIS = 60000;

    public static Date getCurrentDate() {
        return new Date();
    }

    public static String fetchDateStringFromDate(Date date, String dateFormat) {
        return new SimpleDateFormat(dateFormat).format(date);
    }
    public static String fetchDateStringFromDate(Date date, String dateFormat, String timeZoneOffSet) {
        SimpleDateFormat df = new SimpleDateFormat();
        try {
            df.setTimeZone(TimeZone.getTimeZone("GMT" + timeZoneOffSet));
        }catch (Exception ex){

        }
        return new SimpleDateFormat(dateFormat).format(date);
    }
    public static Date clearTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public static Date convertToDate(String dateFormat, String dateValue) {
        Date date = null;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
            date = simpleDateFormat.parse(dateValue);
        } catch (Exception exc) {
            exc.printStackTrace(System.out);
        }
        return date;
    }

    public static Date addMinutesToDate(int minutes) {
        Calendar date = Calendar.getInstance();
        long t = date.getTimeInMillis();
        return new Date(t + (minutes * ONE_MINUTE_IN_MILLIS));
    }
}
