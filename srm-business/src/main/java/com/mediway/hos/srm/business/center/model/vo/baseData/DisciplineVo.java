package com.mediway.hos.srm.business.center.model.vo.baseData;

import lombok.Data;

@Data
public class DisciplineVo {
    private Long rowId;
    private String code;
    private String name;
    private Integer isValid;
    private String categoryName;
    private String upCode;
    private String upName;
    private String classCode;
    private String className;
    private String note;
    private String alias;
}
