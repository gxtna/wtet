package com.gxtna.wtet.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * @author gxtna
 * @date 2022/12/2 下午3:33
 * @desciption: 时间类工具
 */
public class DateTimeUtil {

    private static final DateTimeFormatter DATE_TIME= DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final DateTimeFormatter DATE= DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter TIME= DateTimeFormatter.ofPattern("HH:mm:ss");
    public DateTimeUtil() {}

    public static String formatString(LocalDateTime localDateTime){
        return localDateTime ==null ? null : localDateTime.format(DATE_TIME);
    }
    public static String formatString(LocalDate localDate){
        return localDate ==null ? null : localDate.format(DATE);
    }
    public static String formatString(LocalTime localTime){
        return localTime ==null ? null : localTime.format(TIME);
    }
    public static LocalDateTime formatLocalDateTime(String str){
        str = str.trim();
        return str.isEmpty() ? null : LocalDateTime.parse(str,DATE_TIME);
    }
    public static LocalDate formatLocalDate(String str){
        return Objects.requireNonNull(formatLocalDateTime(str)).toLocalDate();
    }
    public static LocalTime formatLocalTime(String str){
        return Objects.requireNonNull(formatLocalDateTime(str)).toLocalTime();
    }
}
