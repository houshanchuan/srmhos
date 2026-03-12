package com.mediway.hos.srm.business.center.model.vo.fund;

import lombok.Data;

@Data
public class FundRmbsConfigVehicleVo {
    private Long rowId;
    private String addrStart;
    private String addrEnd;
    private String travelVehicle;
    private String travelVehicleName;
    private String travelFee;
    private String category;
    private String hospCode;
    private String hospName;
    private String isValid;
}
