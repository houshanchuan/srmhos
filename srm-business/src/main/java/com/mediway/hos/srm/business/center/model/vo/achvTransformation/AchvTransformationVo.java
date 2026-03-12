package com.mediway.hos.srm.business.center.model.vo.achvTransformation;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class AchvTransformationVo {
    private Long rowId;
    private String transformNo;
    private String transformDesc;
    private String sysNo;
    private CombVo deptId;
    private String deptName;
    private CombVo year;
    private String yearName;
    private String achievement;
    private CombVo sourceProj;
    private String sourceProjName;
    private CombVo sourcePatent;
    private String sourcePatentName;
    private CombVo transformType;
    private String transformTypeName;
    private CombVo agrType;
    private String agrTypeName;
    private String agrNo;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date agrDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date agrStartDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date agrEndDate;
    private BigDecimal feeAmt;
    private CombVo payMode;
    private String payModeName;
    private BigDecimal achvUnitProp;
    private BigDecimal partnerUnitProp;
    private CombVo transformants;
    private String transformantsName;
    private CombVo achvUnit;
    private String achvUnitName;
    private String achvAddr;
    private String achvPostCode;
    private CombVo achvHead;
    private String achvHeadName;
    private String achvHeadtel;
    private CombVo partnerUnit;
    private String partnerUnitName;
    private String partnerUnitAddr;
    private String partnerUnitPostcode;
    private String partnerUnitTel;
    private String agentName;
    private String agentUnit;
    private String agentUnitTel;
    private String agentUnitAddr;
    private String agentUnitPostcode;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createDate;
    private String createTime;
    private String createUserName;
    private String createUserId;
    private String subUserId;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date subDate;
    private String subTime;
    private Integer dataStatus;
    private String chkStatus;
    private String chkUserId;
    private String chkDate;
    private String chkTime;
    private String chkDesc;
    private String remark;
    private String checkList;
    private String chkResultlist;
}
