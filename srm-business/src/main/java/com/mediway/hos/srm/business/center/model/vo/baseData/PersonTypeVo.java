package com.mediway.hos.srm.business.center.model.vo.baseData;

import lombok.Data;

@Data
public class PersonTypeVo {
    private Long rowId;
    private String code;
    private String name;
    private Integer isValid;
    private Integer  isExternal;
    private Integer isGraduate;
    private Integer isInStaff;

}
