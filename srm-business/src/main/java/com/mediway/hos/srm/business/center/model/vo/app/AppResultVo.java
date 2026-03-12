package com.mediway.hos.srm.business.center.model.vo.app;


public class AppResultVo {
    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    public String getRowid() {
        return rowid;
    }

    public void setRowid(String rowid) {
        this.rowid = rowid;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getKeyValue() {
        return keyValue;
    }

    public void setKeyValue(String keyValue) {
        this.keyValue = keyValue;
    }

    private int success=0;
    private String rowid;
    private String msg="";
    private String keyValue;
    public AppResultVo(){

    }
    public AppResultVo(int success,String rowid,String msg,String keyValue){
        this.success=success;
        this.rowid=rowid;
        this.msg=msg;
        this.keyValue=keyValue;
    }
}
