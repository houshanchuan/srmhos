package com.mediway.hos.srm.business.base.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SrmDateAspect {
    @Around("@annotation(LocalDateToDate)")
    public Object DateTransField(ProceedingJoinPoint joinPoint) throws Throwable {
        // 在方法执行之前的逻辑
        //System.out.println("Before method execution with @LocalDateToDate annotation");
        Object result = joinPoint.proceed(); // 执行原方法获取返回值
        System.out.println("Before method execution with @LocalDateToDate annotation");
        /*


        if (result instanceof String) { // 确保返回值是数字类型，以便修改值
            if(!((String) result).isEmpty()){
                String str=(String) result;
                return str.substring(0, 10);
            }
            return result; // 对数字类型的返回值加1
        }
        */

        return result; // 对于非字符串类型，直接返回原结果
    }

}
