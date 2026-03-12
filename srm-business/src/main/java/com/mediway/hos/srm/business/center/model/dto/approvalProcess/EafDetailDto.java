package com.mediway.hos.srm.business.center.model.dto.approvalProcess;

import lombok.Data;
import com.mediway.hos.srm.business.base.model.entity.BasePO;

@Data
public class EafDetailDto extends BasePO {
    private Long id;
    private Long eafMain;
    private Integer stepNo;
    private String chkProcdesc;
    private String checkerString;
    private String dept;
    private Integer isDirector;
    private Integer isSecretary;
    private Integer isCorrAuthor;
    private String auditPassStatus;
    private String auditNopassStatus;
    private Integer isHead;
    private Integer isMentor;

}
