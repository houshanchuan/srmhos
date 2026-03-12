package com.mediway.hos.srm.business.center.model.dto.projectapply;

import lombok.Data;

@Data
public class ProjectSolicitAuditDto {
    private String sysNo;
    private Long rowId;
    private Long ywRowId;
    private String projType;
    private String type;
    private String allotCount;
    private String userStr;
    private String userName;
    private String groupId;
}
