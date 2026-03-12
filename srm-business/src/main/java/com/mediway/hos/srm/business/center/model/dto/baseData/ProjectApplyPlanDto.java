package com.mediway.hos.srm.business.center.model.dto.baseData;

import lombok.Data;

@Data
public class ProjectApplyPlanDto extends BaseListDto{
    private String pStartDate;
    private String pEndDate;
    private String pName;
    private String pProjStatus;
    private int page;
    private int rows;
}
