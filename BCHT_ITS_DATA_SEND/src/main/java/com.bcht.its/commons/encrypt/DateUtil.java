package com.bcht.its.commons.encrypt;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @desc:
 * @auth: taoshide
 * @time: 2016/7/19 9:56
 */
public class DateUtil{

    /**
     * 日期时间格式转换
     * @param dateStr
     * @return
     */
    public static Date  parse(String dateStr) throws ParseException{
        String format = "((19|20)[0-9]{2})-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])";
        Pattern pattern = Pattern.compile(format);
        Matcher matcher = pattern.matcher(dateStr);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if(matcher.matches()){
            Date date = sdf.parse(dateStr);
            return date;
        }else{
            format = "((19|20)[0-9]{2})-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01]) ([01]?[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]";
            pattern = Pattern.compile(format);
            matcher = pattern.matcher(dateStr);
            if(matcher.matches()){
                sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                Date date = sdf.parse(dateStr);
                return date;
            }
        }
        return null;
    }
}