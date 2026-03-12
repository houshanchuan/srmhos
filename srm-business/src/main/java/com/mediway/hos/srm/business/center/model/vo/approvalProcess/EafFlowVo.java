package com.mediway.hos.srm.business.center.model.vo.approvalProcess;

import lombok.Data;

@Data
public class EafFlowVo {
    private Long id;
    private Long rowId;
    private Integer sysType;
    private String sysTypeName;
    private String sysModuleId;
    private String sysModuleName;
    private String eafMainId;
    private String eafMainName;
    private String serialNo;
}
