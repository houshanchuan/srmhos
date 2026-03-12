package com.mediway.hos.srm.business.center.aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DataChangeLog {
    String tableName();
    String sysNo();
    String idField() default "id";  // ID字段名

    String title() default "";

}
