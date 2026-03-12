package com.mediway.hos.srm.business.center.model.dto.baseData;

import com.mediway.hos.srm.business.center.model.dto.fund.*;
import lombok.Data;

import java.util.List;

@Data
public class BaseDataFundDto {
    private List<FundBudgetDeptGrantDto> fundBudgetDeptGrants;
    private List<FundBudgetItemDeptGrantDto> fundBudgetItemDeptGrants;
    private List<FundBudgetYearDto> fundBudgetYears;
    private List<FundBudgetYearMonthDto> fundBudgetYearMonths;
    private List<FundProjectUserAuthDto> fundProjectUserAuths;
    private List<FundProjectUserGrantDto> fundProjectUserGrants;
    private List<FundRmbsConfigVehicleDto> fundRmbsConfigVehicles;
    private List<FundBillCheckStateDto> fundBillCheckStates;
    private List<FundBillStateDto> fundBillStates;
    private List<FundBudgetBalanceTypeDto> fundBudgetBalanceTypes;
    private List<FundBudgetEstablishTypeDto> fundBudgetEstablishTypes;
    private List<FundBudgetFeeTypeDto> fundBudgetFeeTypes;
    private List<FundBudgetItemDto> fundBudgetItems;
    private List<FundBudgetItemDetailDto> fundBudgetItemDetails;
    private List<FundBudgetItemTypeDto> fundBudgetItemTypes;
    private List<FundCheckIdentityDto> fundCheckIdentitys;
    private List<FundCheckResultStateDto> fundCheckResultStates;
    private List<FundExpTypeDto> fundExpTypes;
    private List<FundFeeBelongDto> fundFeeBelongs;
    private List<FundFeeDrawbackStateDto> fundFeeDrawbackStates;
    private List<FundItemCalUnitDto> fundItemCalUnits;
    private List<FundProjBudgetCheckStateDto> fundProjBudgetCheckStates;
    private List<FundProjBudgetModeDto> fundProjBudgetModes;
    private List<FundProjBudgetStandardDto> fundProjBudgetStandards;
    private List<FundProjectCategoryDto> fundProjectCategorys;
    private List<FundRmbsTravelItemDto> fundRmbsTravelItems;
    private List<FundTravelVehicleDto> fundTravelVehicles;
    private List<FundTypeDto> fundTypes;
    private List<FundProjectInfoDto> fundProjectInfos;

}
