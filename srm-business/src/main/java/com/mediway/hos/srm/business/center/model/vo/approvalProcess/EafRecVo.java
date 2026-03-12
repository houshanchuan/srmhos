package com.mediway.hos.srm.business.center.model.vo.approvalProcess;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EafRecVo {
    private Long id;
    private String eafDetailId;
    private String sysNo;
    private String checkRecId;
    private Integer stepNo;
    private String checkProcDesc;
    private String checker;
    private String dept;
    private LocalDateTime checkDatetime;
    private String checkResult;
    private String checkDesc;
    private Integer isCurrentStep;
    private String checkUser;
    private String checkerString;
    private Integer maxStepNo;

}
