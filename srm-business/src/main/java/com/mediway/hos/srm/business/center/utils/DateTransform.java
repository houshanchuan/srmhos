package com.mediway.hos.srm.business.center.utils;

import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public  class DateTransform {
    public static LocalDateTime getLocalDateTime(String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime=null;
        if(!StringUtils.isEmpty(date) ){
            if(date!=null&&date.length()==10)
                date+=" 00:00:00";
            localDateTime = LocalDateTime.parse(date, formatter);
        }
        return localDateTime;
    }

}
