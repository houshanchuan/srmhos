package com.mediway.hos.srm.business.center.model.dto.patent;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class PatentInfoAuthorDto {
    private Long rowId;
    private Long patentId;
    private String patentNo;
    private String author;
    private String authorCode;
    private String authorName;
    private String authorUnit;
    private String authorRanking;
    private String authorType;
    private String authorDeptId;
    private String authorDivision;
    private Integer isFirst;
    private BigDecimal workRatio;
    private String note;
    private String eduDegree;
    private String eduLevel;
    private String title;
    private String sex;
}
