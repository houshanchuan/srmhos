package com.mediway.hos.srm.business.center.model.vo.projectapply;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class ProjectSolicitMemberVo {
    private Long rowId;
    private Long soliProjId;
    private String memberId;
    private String memberName;
    private String memberCode;
    private String deptCode;
    private String deptName;
    private String unitName;
    private String discipline;
    private String disciplineName;
    private String titleCode;
    private String titleName;
    private String eduLevelCode;
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
    private String memberRoleCode;
    private String memberRoleName;
    private String secretLevel;
    private String secretLevelName;
}
