package com.mediway.hos.srm.business.center.model.vo.baseData;

import lombok.Data;

@Data
public class ProductTypeVo {
    private Long rowId;
    private String code;
    private String name;
    private Integer isValid;
    private String type;

}
