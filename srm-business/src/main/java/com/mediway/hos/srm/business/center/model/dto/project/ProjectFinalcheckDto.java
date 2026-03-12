package com.mediway.hos.srm.business.center.model.dto.project;

import lombok.Data;

@Data
public class ProjectFinalcheckDto {
    private Long rowId;
    private Long projId;
    private String sysNo;
    private String subUser;
    private String subDate;
    private String auditStatus;
    private Integer dataStatus;
    private String situation1;
    private String situation2;
    private String situation3;
    private String situation4;
    private String situation5;
    private String situation6;
    private String situation7;
    private String situation8;
    private String situation9;
    private String situation10;
    private String situation11;
    private String situation12;
    private String situation13;
    private String situation14;
    private String situation15;
    // 查询条件
    private int page;
    private int rows;
    private String prjSysNo;
    private Long userId;
    private String userCode;
    private String name;
    private String head;
    private String projType;
    private String deptId;

}
