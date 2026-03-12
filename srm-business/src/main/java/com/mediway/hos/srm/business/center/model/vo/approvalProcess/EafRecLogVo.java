package com.mediway.hos.srm.business.center.model.vo.approvalProcess;

import lombok.Data;

@Data
public class EafRecLogVo {
    private Long id;
    private Long rowId;
    private String eafRecId;
    private String sysModuleId;
    private Long checkRecId;
    private String checkProcDesc;
    private String checkUserName;
    private String deptName;
    private String checkTime;
    private String checkDesc;
    private String checkResult;
    private String auditOpinion;
}
