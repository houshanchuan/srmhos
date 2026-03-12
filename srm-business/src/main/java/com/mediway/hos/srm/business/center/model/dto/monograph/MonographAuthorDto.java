package com.mediway.hos.srm.business.center.model.dto.monograph;

import lombok.Data;

@Data
public class MonographAuthorDto {
    //@JsonProperty(value = "RowId")
    private Long rowId;
    private String typerowid;
    private String typename;
    private String authorrowid;
    private String authorname;
    private String rangerowid;
    private String rangename;
    private String sexdr;
    private String sexName;
    private String titleName;
    private String title;
    private String isthehosrowid;
    private String isthehos;
    private String wordRatio;
    private String remark2;
    private String eduLevel;
    private String eduLevelName;
    private String eduDegree;
    private String eduDegreeName;
    private String deptname;
}
