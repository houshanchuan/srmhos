package com.mediway.hos.srm.business.center.model.vo.fund;

import lombok.Data;

@Data
public class FundBudgetYearVo {
    private Long rowId;
    private String hospCode;
    private String hospName;
    private String year ;
    private String note;
    private Integer isValid;
}
