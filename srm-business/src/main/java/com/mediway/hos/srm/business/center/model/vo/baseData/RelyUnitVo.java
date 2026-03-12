package com.mediway.hos.srm.business.center.model.vo.baseData;

import lombok.Data;

@Data
public class RelyUnitVo {
    private Long rowId;
    private String code;
    private String name;
    private Integer isValid;
    private Integer isPatentAgency;
    private String unitType;
    private String unitTypeName;
    private String alias;
    private Integer isDefault;
    private String abbreviation;

}
