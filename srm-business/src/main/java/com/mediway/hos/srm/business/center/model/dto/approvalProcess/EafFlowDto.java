package com.mediway.hos.srm.business.center.model.dto.approvalProcess;

import lombok.Data;

@Data
public class EafFlowDto {
    private Long id;
    private Long rowId;
    private Integer sysType;
    private String sysModuleId;
    private String eafMainId;
    private String serialNo;
}
