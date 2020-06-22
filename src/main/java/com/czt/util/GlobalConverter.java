package com.czt.util;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//String ：源类型，传入的参数的类型
//Date：目标类型，转换后的类型
public class GlobalConverter implements Converter<String, Date> {
    @Override
    public Date convert(String s) {
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        try {
            //是否支持宽松的格式化转化（不支持）
            format.setLenient(false);
            return format.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
