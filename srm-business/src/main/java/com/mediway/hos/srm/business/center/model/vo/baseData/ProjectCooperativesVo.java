package com.mediway.hos.srm.business.center.model.vo.baseData;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class ProjectCooperativesVo {
    private Long rowId;
    private Long projId;
    private String compId;
    private String compName;
    private String divideWork;
    private BigDecimal fundTotalAmt;
    private BigDecimal fundGovAmt;
    private String coopUnitType;
    private String coopUnitName;
    private String fileId;
    private String fileName;
    private String contactName;
    private String contactTel;
}
