package com.mediway.hos.srm.business.center.model.dto.fund;


import lombok.Data;
import com.mediway.hos.srm.business.base.model.entity.BasePO;

@Data
public class FundBudgetItemDto extends BasePO {
    private Long rowId;
    private String code;
    private String upCode;
    private String name;
    private String nameAll;
    private String level;
    private String itemType;
    private String spell;
    private Integer direction;
    private Integer isLast;
    private Integer isSpecial;
    private Integer isCash;
    private Integer isResult;
    private String calUnitCode;
    private String deptDuty;
    private String auDeptFirst;
    private String auDeptSecond;
    private Integer isGovBuy;
    private String note;
    private Integer itemOrder;

}
