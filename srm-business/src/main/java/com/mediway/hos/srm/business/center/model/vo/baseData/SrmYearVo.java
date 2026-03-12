package com.mediway.hos.srm.business.center.model.vo.baseData;

import lombok.Data;

@Data
public class SrmYearVo {
    private String id;
    private String code;
    private String name;
    private String startDate;
    private String endDate;
    private Integer isValid;
}
