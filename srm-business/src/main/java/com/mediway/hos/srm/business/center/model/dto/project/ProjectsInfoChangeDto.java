package com.mediway.hos.srm.business.center.model.dto.project;

import lombok.Data;

@Data
public class ProjectsInfoChangeDto {
    private Long rowId;
    private Long projId;
    private String initProjName;
    private String initHeadName;
    private String initProjStatus;
    private String changeitem;
    private String oldValue;
    private String newValue;
    private String reason;
    private String intro;
    private Integer dataStatus;
    private String subUserId;
    private String subDate;
    private String checkStatus;
    private String checkUserId;
    private String checkDate;
    private String serialNo;
    private String creator;
    private String creatorName;
    private String createTime;
    private String operateTime;
    private String sysNo;
    private String note;
    private String oldValueDesc;
    private String newValueDesc;

    // 下面是查询条件
    private int page;
    private int rows;
    private String startDate;
    private String endDate;
    private Long userId;
    private String userCode;
    private String auditState;
    private String prjSysNo;
}
