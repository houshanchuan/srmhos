package com.mediway.hos.srm.business.center.model.dto.achvTransformation;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AchvTransformationDto {
    private Long rowId;
    private String transformNo;
    private String transformDesc;
    private String sysNo;
    private String deptId;
    private String year;
    private String achievement;
    private String sourceProj;
    private String sourceProjName;
    private String sourcePatent;
    private String sourcePatentName;
    private String transformType;
    private String agrType;
    private String agrNo;
    private String agrDate;
    private String agrStartDate;
    private String agrEndDate;
    private BigDecimal feeAmt;
    private String payMode;
    private BigDecimal achvUnitProp;
    private BigDecimal partnerUnitProp;
    private String transformants;
    private String achvUnit;
    private String achvAddr;
    private String achvPostCode;
    private String achvHead;
    private String achvHeadtel;
    private String partnerUnit;
    private String partnerUnitAddr;
    private String partnerUnitPostcode;
    private String partnerUnitTel;
    private String agentName;
    private String agentUnit;
    private String agentUnitTel;
    private String agentUnitAddr;
    private String agentUnitPostcode;
    private String createDate;
    private String createTime;
    private String createUserId;
    private String subUserId;
    private String subDate;
    private String subTime;
    private Integer dataStatus;
    private String chkStatus;
    private String chkUserId;
    private String chkDate;
    private String chkTime;
    private String chkDesc;
    private String remark;
    // 查询条件
    private int page;
    private int rows;
    private Long userId;
    private String userCode;
    private String startDate;
    private String endDate;
    private String auditState;
}
