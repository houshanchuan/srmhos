package com.mediway.hos.srm.business.center.model.vo.fund;

import lombok.Data;

@Data
public class FundProjectInfoVo {
    private Long rowId;
    private String code;
    private String name;
    private Integer isValid;
    private String year;
    private String hospCode;
    private String alias;
    private String headCode;
    private String issuedDate;
    private String deptCode;
    private String state;
    private String category;
    private Integer isGovBuy;
    private String fundGov;
    private String fundOwn;
    private String fundTotal;
    private String budgetDept;
    private String budgetMode;
    private String chkFlowId;
    private String blanceType;
    private String accountTotal;
    private String srmProjectId;
}
