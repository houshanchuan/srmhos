package com.mediway.hos.srm.business.center.model.vo.fund;

import lombok.Data;

@Data
public class FundBudgetItemDetailVo {
    private Long rowId;
    private String code;
    private String name;
    private Integer isValid;
    private String businessType;
}
