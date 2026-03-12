package com.mediway.hos.srm.business.center.model.vo.monograph;

import lombok.Data;

@Data
public class MonographAuthorVo {
    private Long rowId;
    private String typerowid;
    private String typename;
    private String authorrowid;
    private String authorname;
    private String rangerowid;
    private String rangename;
    private String sexdr;
    private String sexName;
    //@JsonProperty(value = "TitleName")
    private String titleName;
    //@JsonProperty(value = "Title")
    private String title;
    private String isthehosrowid;
    private String isthehos;
    //@JsonProperty(value = "WordRatio")
    private String wordRatio;
    //@JsonProperty(value = "Remark2")
    private String remark2;
    //@JsonProperty(value = "EduLevel")
    private String eduLevel;
    //@JsonProperty(value = "EduLevelName")
    private String eduLevelName;
    // @JsonProperty(value = "EduDegree")
    private String eduDegree;
    //@JsonProperty(value = "EduDegreeName")
    private String eduDegreeName;
    private String deptname;
}
