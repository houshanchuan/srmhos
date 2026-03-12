package com.mediway.hos.srm.business.center.model.vo.baseData;

import lombok.Data;

@Data
public class ProjTypeVo {
    private Long rowId;
    private String code;
    private String name;
    private Integer isValid;
    private String projClass;
    private String projClassName;
    private String projLevel;
    private String projLevelName;
    private String techSource;
    private String socialSource;


}
