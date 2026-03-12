package com.mediway.hos.srm.business.center.model.dto.fund;


import lombok.Data;
import com.mediway.hos.srm.business.base.model.entity.BasePO;

@Data
public class FundBudgetYearMonthDto extends BasePO {
    private Long rowId;
    private String yearMon ;
    private String startDate ;
    private String endDate;
}
