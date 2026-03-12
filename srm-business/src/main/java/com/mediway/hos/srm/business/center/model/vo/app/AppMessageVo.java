package com.mediway.hos.srm.business.center.model.vo.app;

import lombok.Data;

@Data
public class AppMessageVo {
    private Long rowId;
    private String sysNo;
    private String type;
    private String recId;
    private String title;
    private String content;
    private String note;
    private String createDate;
    private String userList;
    private Integer dataStatus;
    private String auditUserId;
    private String auditDate;
    private Integer checkStatus;
    private String auditAdvice;
    private String stepNo;
    private String hospitalId;
}
