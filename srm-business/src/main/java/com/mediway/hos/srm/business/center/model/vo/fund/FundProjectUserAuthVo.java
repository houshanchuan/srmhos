package com.mediway.hos.srm.business.center.model.vo.fund;

import lombok.Data;

@Data
public class FundProjectUserAuthVo {
    private Long rowId;
    private String projectId;
    private String userId;
    private Integer isSubmit;
    private Integer isAudit;

}
