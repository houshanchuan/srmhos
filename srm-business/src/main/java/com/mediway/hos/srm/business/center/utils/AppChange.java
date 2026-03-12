package com.mediway.hos.srm.business.center.utils;

import com.alibaba.fastjson.JSONObject;
import com.mediway.hos.srm.business.center.exception.ErrorException;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class AppChange <T>{
    public String changeToJson(T t)  {
        Class<?> tClass=t.getClass();
        Map<String, Object> appMap = new HashMap<String, Object>();
        try{
            for(Field field:tClass.getDeclaredFields()){
                //Object value = field.get(t); // 获取属性值
                field.setAccessible(true);
                String keyName=field.getName();

                Class<?> type=field.getType();
                if(type.equals(CombVo.class)){
                    CombVo value = (CombVo)field.get(t); // 获取属性值
                    if(value!=null){
                        appMap.put(keyName,value.getId());
                    }else{
                        appMap.put(keyName,"");
                    }


                }else if(type.equals(Date.class)){
                    Object value=field.get(t);
                    System.out.println(keyName+":"+value);
                    if(value==null||value==""){
                        appMap.put(keyName,"");
                    }else{
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // 定义日期时间格式
                        String dateString = sdf.format(value);
                        appMap.put(keyName,dateString);
                    }
                }else{

                    Object value=field.get(t);
                    if(value==null){
                        appMap.put(keyName,"");
                    }else{
                        appMap.put(keyName,value);
                    }

                }
            }
            return JSONObject.toJSONString(appMap);
        }catch (Exception e){
            throw new ErrorException("-201",e.getMessage());
        }

    }
}
