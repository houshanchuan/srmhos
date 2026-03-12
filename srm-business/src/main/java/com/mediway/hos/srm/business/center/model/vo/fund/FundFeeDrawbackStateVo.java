package com.mediway.hos.srm.business.center.model.vo.fund;

import lombok.Data;

@Data
public class FundFeeDrawbackStateVo {
    private Long rowId;
    private String code;
    private String name;
    private Integer isValid;
}
