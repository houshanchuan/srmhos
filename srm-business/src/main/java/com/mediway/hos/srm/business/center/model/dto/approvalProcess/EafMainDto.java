package com.mediway.hos.srm.business.center.model.dto.approvalProcess;

import lombok.Data;

@Data
public class EafMainDto {
    private Long rowId;
    private String code;
    private String name;
    private Integer isValid;
}
