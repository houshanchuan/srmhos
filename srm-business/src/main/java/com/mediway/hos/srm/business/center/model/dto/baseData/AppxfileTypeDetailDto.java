package com.mediway.hos.srm.business.center.model.dto.baseData;

import lombok.Data;

@Data
public class AppxfileTypeDetailDto extends BaseDto{
    private Long rowId;
    private String code;
    private String name;
    private Integer isValid;
    private String sysNo;
    private String fileType;
    private Integer isRequired;
    //
    private int page;
    private int rows;
    private int limit;
}
