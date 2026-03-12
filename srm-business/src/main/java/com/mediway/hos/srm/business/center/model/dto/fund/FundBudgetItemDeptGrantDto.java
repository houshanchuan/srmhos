package com.mediway.hos.srm.business.center.model.dto.fund;


import lombok.Data;
import com.mediway.hos.srm.business.base.model.entity.BasePO;

@Data
public class FundBudgetItemDeptGrantDto extends BasePO {
    private Long rowId;

    private String itemCode ;
    private String deptCode;
    private String hospCode;

}
