package com.mediway.hos.srm.business.center.model.dto.academic;

import lombok.Data;

@Data

public class AcParttimeInfoDto {
    private Long rowId;
    private String userId;
    private String deptId;
    private String committee;
    private String position;
    private String year;
    private String startDate;
    private String endDate;
    private String subUserId;
    private String subDate;
    private Integer dataStatus;
    private String sysNo;
    private String branch;
    private String resAudit;
    private String resDesc;
    private String auditUserId;
    private String auditDate;
    private String committeeType;
    private String bizType;
    private String committeeBranch;
    private String committeeSubBranch;
    private String parttimeType;
    private String state;
    private String parttimeApply;
    // 下面是查询条件
    private int page;
    private int rows;
    private String userCode;
    private String auditState;
}
