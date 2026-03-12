package com.mediway.hos.srm.business.center.model.dto.fund;


import lombok.Data;
import com.mediway.hos.srm.business.base.model.entity.BasePO;

@Data
public class FundBudgetDeptGrantDto extends BasePO {
    private Long rowId;
    private String userCode;
    private String deptCode;
    private String hospCode;

}
