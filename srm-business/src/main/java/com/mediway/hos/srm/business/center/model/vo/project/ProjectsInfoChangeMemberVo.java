package com.mediway.hos.srm.business.center.model.vo.project;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class ProjectsInfoChangeMemberVo {
    private Long rowId;
    private Long changeParrefId;
    private String changeType;
    private String changeTypeName;
    private String member;
    private String name;
    private String workCode;
    private String personType;
    private String personTypeName;
    private String ranking;
    private String rankingName;
    private String title;
    private String titleName;
    private String eduLevel;
    private String eduLevelName;
    private String sex;
    private String sexName;
    private String deptId;
    private String relyUnit;
    private String deptUnitName;
    private String origMemberId;
    private String note;
    private BigDecimal workRatio;
}
