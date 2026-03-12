package com.mediway.hos.srm.business.center.model.dto.fund;


import lombok.Data;
import com.mediway.hos.srm.business.base.model.entity.BasePO;

@Data
public class FundBudgetYearDto extends BasePO {
    private Long rowId;
    private String hospCode;
    private String year ;
    private String note;
    private Integer isValid;


}
