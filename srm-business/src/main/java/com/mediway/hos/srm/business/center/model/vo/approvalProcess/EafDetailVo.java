package com.mediway.hos.srm.business.center.model.vo.approvalProcess;

import lombok.Data;

@Data
public class EafDetailVo {
    private Long id;
    private Long rowId;
    private Long eafMain;
    private Integer stepNo;
    private String chkProcdesc;
    private String checkerString;
    private String dept;
    private String deptName;
    private Integer isDirector;
    private String isDirectorName;
    private Integer isSecretary;
    private String isSecretaryName;

    private Integer isCorrAuthor;
    private String isCorrAuthorName;
    private String auditPassStatus;
    private String auditPassStatusName;
    private String auditNopassStatus;
    private String auditNopassStatusName;
    private Integer isHead;
    private Integer isMentor;
    //用于审批人的显示
    private String checkerId;
    private String checkerName;
}
