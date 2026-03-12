package com.mediway.hos.srm.business.center.model.vo.baseData;

import lombok.Data;

@Data
public class PayTypeVo {
    private Long rowId;
    private String code;
    private String name;
    private Integer isValid;
}
