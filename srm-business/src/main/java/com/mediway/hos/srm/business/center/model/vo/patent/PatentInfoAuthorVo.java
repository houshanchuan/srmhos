package com.mediway.hos.srm.business.center.model.vo.patent;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PatentInfoAuthorVo {
    private Long rowId;
    private Long patentId;
    private String patentNo;
    private String author;
    private String authorCode;
    private String authorName;
    private String authorUnit;
    private String authorUnitName;
    private String authorRanking;
    private String authorRankingName;
    private String authorType;
    private String authorTypeName;
    private String authorDeptId;
    private String authorDeptName;
    private String authorDivision;
    private Integer isFirst;
    private BigDecimal workRatio;
    private String note;
    private String eduDegree;
    private String eduDegreeName;
    private String eduLevel;
    private String eduLevelName;
    private String title;
    private String titleName;
    private String sex;
    private String sexName;
}
