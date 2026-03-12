package com.mediway.hos.srm.business.center.model.dto.contract;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class ContractInfoMemberDto {
    private Long rowId;
    private Long projId;
    private String member;
    private String memberName;
    private String memberCode;
    private String deptCode;
    private String unitName;
    private String discipline;
    private String titleCode;
    private String eduLevel;
    private String workTime;
    private BigDecimal workRatio;
    private String ranking;
    private String note;
    private String sex;
    private String authorTypeCode;
    private String memberroleCode;
    private String secretLevel;
}
