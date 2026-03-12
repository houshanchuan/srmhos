package com.mediway.hos.srm.business.center.exception;

import com.mediway.hos.base.model.BaseResponse;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice("com.mediway.hos.srm")
@Order(0)
public class GlobalExceptionHandler {
    @ExceptionHandler(ErrorException.class)

    public BaseResponse handleErrorException(ErrorException e){
        return BaseResponse.error(e.getCode(),e.getMsg());
    }

}
