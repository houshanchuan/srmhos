package com.mediway.hos.srm.business.center.model.vo.award;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class AwardApplyAuthorVo {
    private Long rowId;
    private Long awardApplyId;
    private String authorId;
    private String authorCode;
    private String authorName;
    private String authorType;
    private String authorTypeName;
    private String authorUnit;
    private String authorUnitName;
    private String authorDivision;
    private String eduDegree;
    private String eduDegreeName;
    private String eduLevel;
    private String eduLevelName;
    private String title;
    private String titleName;
    private String sex;
    private String sexName;
    private String authorRanking;
    private String authorRankingName;
    private BigDecimal workRatio;
    private String note;
}
