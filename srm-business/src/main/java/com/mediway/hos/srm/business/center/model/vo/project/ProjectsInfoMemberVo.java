package com.mediway.hos.srm.business.center.model.vo.project;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProjectsInfoMemberVo {
    private Long rowId;
    private Long projId;
    private String member;
    private String memberName;
    private String memberCode;
    private String dept;
    private String deptName;
    private String unitName;
    private String discipline;
    private String disciplineName;
    private String title;
    private String titleName;
    private String eduLevel;
    private String eduLevelName;
    private String workTime;
    private BigDecimal workRatio;
    private String ranking;
    private String rankingName;
    private String note;
    private String sex;
    private String sexName;
    private String authorTypeCode;
    private String authorTypeName;
    private String memberroleCode;
    private String memberroleName;
    private String secretLevel;
    private String secretLevelName;
    private String account;
}
