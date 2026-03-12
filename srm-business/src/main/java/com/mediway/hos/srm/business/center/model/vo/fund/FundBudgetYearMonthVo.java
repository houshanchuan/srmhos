package com.mediway.hos.srm.business.center.model.vo.fund;

import lombok.Data;

@Data
public class FundBudgetYearMonthVo {
    private Long rowId;
    private String yearMon ;
    private String startDate ;
    private String endDate;
}
