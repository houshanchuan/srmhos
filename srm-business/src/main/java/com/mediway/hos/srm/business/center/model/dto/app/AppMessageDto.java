package com.mediway.hos.srm.business.center.model.dto.app;

import lombok.Data;
@Data
public class AppMessageDto {
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
    private String isDelete;
    private String auditAdvice;
    private String stepNo;
    private String hospitalId;
    private String account;
    private Long userId;
    // 下面是查询条件
    private int page;
    private int rows;
    private int limit;
}
