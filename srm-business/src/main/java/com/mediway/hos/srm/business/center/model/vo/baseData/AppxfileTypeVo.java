package com.mediway.hos.srm.business.center.model.vo.baseData;

import lombok.Data;

@Data
public class AppxfileTypeVo {
    private Long rowId;
    private String code;
    private String name;
    private Integer isValid;
    private Integer isRequired;
    private String sysNo;
    private String sysName;
    private String fileType;

}
