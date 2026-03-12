package com.mediway.hos.srm.business.center.model.dto.award;

import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import lombok.Data;


import java.math.BigDecimal;
@Data
public class AchievementAuthorDto extends BaseDto {
    private Long rowId;
    private Long achievementId;
    private String authorId;
    private String authorCode;
    private String authorName;
    private String authorType;
    private String authorUnitName;
    private String authorRanking;
    private BigDecimal workRatio;
    private Integer isFirst;
    private String authorUnitId;
    private String authordivisionId;
    private String sex;
    private String eduLevel;
    private String eduDegree;
    private String title;
    private String note;
}
