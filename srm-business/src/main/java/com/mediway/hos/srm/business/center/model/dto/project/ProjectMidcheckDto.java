package com.mediway.hos.srm.business.center.model.dto.project;

import lombok.Data;

@Data

public class ProjectMidcheckDto {
    private Long rowId;
    private Long projId;
    private String projName;
    private String detail;
    private String apply;
    private String midDate;
    private String midcheckFlag;
    private String midcheckState;
    private String midcheckOpinion;
    private String checker;
    private String checkDate;
    private String checkNo;
    private Long midcheckInfoId;
    private Long userId;
    private String userCode;
    private String prjSysNo;
    private String sysNo;
    private String deptId;
    private String projType;
    private String projHead;
    private String midcheckOpinion2;
    private String midcheckOpinion3;
    private String midcheckOpinion4;
    private String auditState;
    private int page;
    private int rows;
}
