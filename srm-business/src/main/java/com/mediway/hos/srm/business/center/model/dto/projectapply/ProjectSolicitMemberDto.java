package com.mediway.hos.srm.business.center.model.dto.projectapply;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProjectSolicitMemberDto {
    private Long rowId;
    private Long soliProjId;
    private String memberId;
    private String memberName;
    private String memberCode;
    private String deptCode;
    private String unitName;
    private String discipline;
    private String titleCode;
    private String eduLevelCode;
    private String workTime;
    private BigDecimal workRatio;
    private String ranking;
    private String note;
    private String sex;
    private String authorTypeCode;
    private String memberRoleCode;
    private String secretLevel;

}
