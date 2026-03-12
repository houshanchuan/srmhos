package com.mediway.hos.srm.business.center.model.dto.fund;


import lombok.Data;
import com.mediway.hos.srm.business.base.model.entity.BasePO;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class FundProjectInfoDto extends BasePO {
    private Long rowId;
    private String code;
    private String name;
    private Integer isValid;
    private String year;
    private String hospCode;
    private String alias;
    private String headCode;
    private LocalDate issuedDate;
    private String deptCode;
    private String state;
    private String category;
    private Integer isGovBuy;
    private BigDecimal fundGov;
    private BigDecimal fundOwn;
    private BigDecimal fundTotal;
    private String budgetDept;
    private String budgetMode;
    private String chkFlowId;
    private String blanceType;
    private BigDecimal accountTotal;
    private String srmProjectId;
}
