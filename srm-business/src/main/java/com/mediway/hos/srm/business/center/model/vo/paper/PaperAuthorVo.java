package com.mediway.hos.srm.business.center.model.vo.paper;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class PaperAuthorVo {
    private Long rowId;
    private Long paperId;
    private String inOut;
    private String author;
    private String authorName;
    private String authorUnit;
    private String authorUnitName;
    private String authorCode;
    private String authorType;
    private String authorTypeName;
    private String authorDeptId;
    private String authorDeptName;
    private String authorAccount;
    private String authorDivision;
    private String sex;
    private String sexName;
    private String ranking;
    private String rankingName;
    private Integer isCorrAuthor;
    private String eduDegree;
    private String eduDegreeName;
    private String eduLevel;
    private String eduLevelName;
    private String title;
    private String titleName;
    private BigDecimal workRatio;
    private String note;
    private Integer isStudent;
    private String idNo;
    private String bank;
    private String bankAccount;
    private String contactTel;
    private Integer isTiedCorrAuthor;
}
