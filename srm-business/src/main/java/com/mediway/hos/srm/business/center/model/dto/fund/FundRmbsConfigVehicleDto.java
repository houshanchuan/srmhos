package com.mediway.hos.srm.business.center.model.dto.fund;


import lombok.Data;
import com.mediway.hos.srm.business.base.model.entity.BasePO;

import java.math.BigDecimal;

@Data
public class FundRmbsConfigVehicleDto extends BasePO {
    private Long rowId;
    private String addrStart;
    private String addrEnd;
    private String travelVehicle;
    private BigDecimal travelFee;
    private String category;
    private String hospCode;
    private Integer isValid;

}
