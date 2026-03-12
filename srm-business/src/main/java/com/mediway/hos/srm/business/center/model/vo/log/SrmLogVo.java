package com.mediway.hos.srm.business.center.model.vo.log;

import lombok.Data;

@Data
public class SrmLogVo {
    private String rowId;
    private String title;
    private String type;
    private String tableName;
    private String createTime;
    private String deviceType;
    private String createBy;
    private String entityCode;
    private String methodName;

    private String bussinessId;

    private String bussinessName;
    private String ip;
    private String difData;

}
