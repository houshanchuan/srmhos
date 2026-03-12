package com.mediway.hos.srm.business.center.model.dto.baseData;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class ProjectCooperativesDto {
    private Long rowId;
    private Long projId;
    private String compId;
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
