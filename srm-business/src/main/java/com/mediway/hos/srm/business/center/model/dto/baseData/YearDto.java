package com.mediway.hos.srm.business.center.model.dto.baseData;

import lombok.Data;

@Data
public class YearDto extends BaseListDto {
    private String pStartDate;
    private String pEndDate;
    private String pName;
    private String pProjStatus;
    private int page;
    private int rows;

    private Long rowId;
    private String code;
    private String name;
    private Integer isValid;



}
