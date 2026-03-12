package com.mediway.hos.srm.business.base.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mediway.hos.base.exception.BaseExceptionEnum;
import com.mediway.hos.base.exception.SysExceptionEnum;

public class SRMBaseResponse<T> {
    private String code;
    private String msg;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    private int total;
    @JsonIgnore
    private Boolean isIntercept;
    private T data;

    public SRMBaseResponse() {
    }

    public SRMBaseResponse(String code, String msg, T data) {
        this.setCode(code);
        this.setMsg(msg);
        this.setData(data);
        this.setIsIntercept(true);
    }

    public SRMBaseResponse(String code, String msg, boolean isIntercept, T data) {
        this.setCode(code);
        this.setMsg(msg);
        this.setData(data);
        this.setIsIntercept(isIntercept);
    }
    public SRMBaseResponse(String code, String msg, boolean isIntercept,int total, T data) {
        this.setCode(code);
        this.setMsg(msg);
        this.setData(data);
        this.setTotal(total);
        this.setIsIntercept(isIntercept);
    }
    public static <T> SRMBaseResponse<T> success() {
        return new SRMBaseResponse(SysExceptionEnum.SUCCESS.getCode(), SysExceptionEnum.SUCCESS.getMsg(), (Object)null);
    }

    public static <T> SRMBaseResponse<T> success(T data) {
        return new SRMBaseResponse(SysExceptionEnum.SUCCESS.getCode(), SysExceptionEnum.SUCCESS.getMsg(), data);
    }
    public static <T> SRMBaseResponse<T> success(int total,T data) {
        return new SRMBaseResponse(SysExceptionEnum.SUCCESS.getCode(), SysExceptionEnum.SUCCESS.getMsg(),true,total, data);
    }
    public static <T> SRMBaseResponse<T> success(String message, T data) {
        return new SRMBaseResponse(SysExceptionEnum.SUCCESS.getCode(), message, data);
    }

    public static <T> SRMBaseResponse<T> success(String message, boolean isIntercept, T data) {
        return new SRMBaseResponse(SysExceptionEnum.SUCCESS.getCode(), message, isIntercept, data);
    }

    public static <T> SRMBaseResponse<T> paramError() {
        return new SRMBaseResponse(SysExceptionEnum.PARAM_ERROR.getCode(), SysExceptionEnum.PARAM_ERROR.getMsg(), (Object)null);
    }

    public static <T> SRMBaseResponse<T> error() {
        return new SRMBaseResponse(SysExceptionEnum.ERROR.getCode(), SysExceptionEnum.ERROR.getMsg(), (Object)null);
    }

    public static <T> SRMBaseResponse<T> error(String message) {
        return new SRMBaseResponse(SysExceptionEnum.ERROR.getCode(), message, (Object)null);
    }

    public static <T> SRMBaseResponse<T> error(String message, boolean isIntercept) {
        return new SRMBaseResponse(SysExceptionEnum.ERROR.getCode(), message, isIntercept, (Object)null);
    }

    public static <T> SRMBaseResponse<T> error(BaseExceptionEnum baseExceptionEnum) {
        return new SRMBaseResponse(baseExceptionEnum.getCode(), baseExceptionEnum.getMsg(), (Object)null);
    }

    public static <T> SRMBaseResponse<T> error(BaseExceptionEnum baseExceptionEnum, boolean isIntercept) {
        return new SRMBaseResponse(baseExceptionEnum.getCode(), baseExceptionEnum.getMsg(), isIntercept, (Object)null);
    }

    public static <T> SRMBaseResponse<T> error(String code, String message) {
        return new SRMBaseResponse(code, message, (Object)null);
    }

    public static <T> SRMBaseResponse<T> error(String code, String message, boolean isIntercept) {
        return new SRMBaseResponse(code, message, isIntercept, (Object)null);
    }

    public static <T> SRMBaseResponse<T> error(String code, String message, T data) {
        return new SRMBaseResponse(code, message, data);
    }

    public static <T> SRMBaseResponse<T> error(String code, String message, boolean isIntercept, T data) {
        return new SRMBaseResponse(code, message, isIntercept, data);
    }

    public boolean isSuccess() {
        return SysExceptionEnum.SUCCESS.getCode().equals(this.code);
    }

    public String getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public Boolean getIsIntercept() {
        return this.isIntercept;
    }

    public T getData() {
        return this.data;
    }

    public void setCode(final String code) {
        this.code = code;
    }

    public void setMsg(final String msg) {
        this.msg = msg;
    }
    @JsonIgnore
    public void setIsIntercept(final Boolean isIntercept) {
        this.isIntercept = isIntercept;
    }

    public void setData(final T data) {
        this.data = data;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof SRMBaseResponse)) {
            return false;
        } else {
            SRMBaseResponse<?> other = (SRMBaseResponse)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label59: {
                    Object this$isIntercept = this.getIsIntercept();
                    Object other$isIntercept = other.getIsIntercept();
                    if (this$isIntercept == null) {
                        if (other$isIntercept == null) {
                            break label59;
                        }
                    } else if (this$isIntercept.equals(other$isIntercept)) {
                        break label59;
                    }

                    return false;
                }

                Object this$code = this.getCode();
                Object other$code = other.getCode();
                if (this$code == null) {
                    if (other$code != null) {
                        return false;
                    }
                } else if (!this$code.equals(other$code)) {
                    return false;
                }

                Object this$msg = this.getMsg();
                Object other$msg = other.getMsg();
                if (this$msg == null) {
                    if (other$msg != null) {
                        return false;
                    }
                } else if (!this$msg.equals(other$msg)) {
                    return false;
                }

                Object this$data = this.getData();
                Object other$data = other.getData();
                if (this$data == null) {
                    if (other$data != null) {
                        return false;
                    }
                } else if (!this$data.equals(other$data)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof SRMBaseResponse;
    }

    public int hashCode() {
        int result = 1;
        Object $isIntercept = this.getIsIntercept();
        result = result * 59 + ($isIntercept == null ? 43 : $isIntercept.hashCode());
        Object $code = this.getCode();
        result = result * 59 + ($code == null ? 43 : $code.hashCode());
        Object $msg = this.getMsg();
        result = result * 59 + ($msg == null ? 43 : $msg.hashCode());
        Object $data = this.getData();
        result = result * 59 + ($data == null ? 43 : $data.hashCode());
        return result;
    }

    public String toString() {
        return "SRMBaseResponse(code=" + this.getCode() + ", msg=" + this.getMsg() + ", isIntercept=" + this.getIsIntercept() + ", data=" + this.getData() + ")";
    }

}
