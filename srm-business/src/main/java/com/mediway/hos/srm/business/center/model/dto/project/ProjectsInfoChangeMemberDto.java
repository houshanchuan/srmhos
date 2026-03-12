package com.mediway.hos.srm.business.center.model.dto.project;

import lombok.Data;


import java.math.BigDecimal;
@Data
public class ProjectsInfoChangeMemberDto {
    private Long rowId;
    private Long changeParrefId;
    private String changeType;
    private String member;
    private String name;
    private String workCode;
    private String personType;
    private String ranking;
    private String title;
    private String eduLevel;
    private String sex;
    private String deptId;
    private String relyUnit;
    private String deptUnitName;
    private String origMemberId;
    private String note;
    private BigDecimal workRatio;
}
