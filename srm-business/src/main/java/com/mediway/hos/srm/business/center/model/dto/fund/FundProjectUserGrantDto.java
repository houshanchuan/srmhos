package com.mediway.hos.srm.business.center.model.dto.fund;


import lombok.Data;
import com.mediway.hos.srm.business.base.model.entity.BasePO;

@Data
public class FundProjectUserGrantDto extends BasePO {
    private Long rowId;
    private String  expType;
    private String  projectType;
    private String projectId ;
    private String userId;
    private Integer isGranted;

}
