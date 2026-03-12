package com.mediway.hos.srm.business.center.model.vo.projectapply;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class ProjectSolicitEthicAuditVo {
    private Long rowId;
    private String sysNo;
    private Long soliProjectId;
    private Integer dataStatus;
    private String ethicExpert;
    private String ethicChkResult;
    private String ethicAuditDate;
    private String ethicAuditDesc;
    private Integer isFeedbacked;
    private String yearName;
    private String title;
    private String prjTypeName;
    private String applyUserName;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date subDate;
    private String auditStatus;
    private String note;


}
