package com.mediway.hos.srm.business.center.model.dto.academic;

import lombok.Data;

@Data
public class AcParttimeApplyDto {
    private Long rowId;
    private String userId;
    private String deptId;
    private String committee;
    private String position;
    private String startDate;
    private String endDate;
    private String subUserId;
    private String subDate;
    private Integer dataStatus;
    private String sysNo;
    private String branch;
    private String auditStatus;
    private String auditDesc;
    private String auditUserId;
    private String auditDate;
    private Integer committeeBranch;
    private String partTimeType;
    private String year;
    private String createUserId;
    private String createDate;
    private String createTime;
    private String submitTime;
    // 下面是查询条件
    private int page;
    private int rows;
    private String userCode;
    private String auditState;
}
