package com.mediway.hos.srm.business.center.model.dto.project;

import lombok.Data;
@Data
public class ProjectMidcheckListInfoDto {
    private Long rowId;
    private String projTypeCode;
    private String midCheckInfo;
    private String beginDate;
    private String endDate;
    private String midCheckState;
    private String note;
    private String fileId;
    private String notifyPlan;
    private int page;
    private int rows;
}
