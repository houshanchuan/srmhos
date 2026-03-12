package com.mediway.hos.srm.business.center.model.vo.systemConfig;

import lombok.Data;

@Data
public class SystemModuleVo {
    private Long rowId;
    private String code;
    private String name;
    private String enName;
    private Integer isValid;
}
