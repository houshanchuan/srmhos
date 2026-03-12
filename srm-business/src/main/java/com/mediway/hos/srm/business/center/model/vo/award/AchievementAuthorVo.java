package com.mediway.hos.srm.business.center.model.vo.award;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AchievementAuthorVo {
    private Long rowId;
    private Long achievementId;
    private String authorId;
    private String authorCode;
    private String authorName;
    private String authorType;
    private String authorTypeName;
    private String authorUnitName;
    private String authorRanking;
    private String authorRankingName;
    private BigDecimal workRatio;
    private Integer isFirst;
    private String authorUnitId;
    private String authordivisionId;
    private String sex;
    private String sexName;
    private String eduLevel;
    private String eduLevelName;
    private String eduDegree;
    private String eduDegreeName;
    private String title;
    private String titleName;
    private String note;
}
