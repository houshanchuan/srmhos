package com.mediway.hos.srm.business.center.model.dto.projectapply;

import lombok.Data;

@Data
public class ProjectSolicitEthicAuditDto {
    private Long rowId;
    private String sysNo;
    private Long soliProjectId;
    private Integer dataStatus;
    private String ethicExpert;
    private String ethicChkResult;
    private String ethicAuditDate;
    private String ethicAuditDesc;
    private Integer isFeedbacked;
    private String ethicAllotCount;
    private String allotCount;
    private String userId;
    private String userCode;
}
