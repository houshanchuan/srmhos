package com.mediway.hos.srm.business.center.exception;

import com.mediway.hos.base.exception.BaseBusinessException;
import com.mediway.hos.base.exception.BaseExceptionEnum;

public class SrmException extends BaseBusinessException {
    public SrmException(String message) {
        super(message);
    }

    public SrmException(BaseExceptionEnum baseEnum) {
        super(baseEnum);
    }

    public SrmException(String code, String message, Throwable cause) {
        super(code, message, cause);
    }

    public SrmException(String code, String message) {
        super(code, message);
    }
}
