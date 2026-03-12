package com.mediway.hos.srm.business.center.model.vo.fund;

import lombok.Data;

@Data
public class FundProjectUserGrantVo {

    private Long rowId;
    private String  expType;
    private String  expTypeName;
    private String  projectType;
    private String  projectTypeName;
    private String projectId ;
    private String projectName ;
    private String userId;
    private String userName;
    private Integer isGranted;

}
