package com.mediway.hos.srm.business.center.model.vo.patent;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PatentApplyAuthorVo {
    private Long rowId;
    private Long applyPatentId;
    private String authorId;
    private String authorCode;
    private String authorName;
    private String authorType;
    private String authorTypeName;
    private String authorDeptName;
    private String authorDeptCode;
    private String authorDivisionCode;
    private String authorDivisionName;
    private String degree;
    private String degreeName;
    private String eduLevel;
    private String eduLevelName;
    private String title;
    private String titleName;
    private String sex;
    private String sexName;
    private String ranking;
    private String rankingName;
    private BigDecimal workRatio;
    private String note;
    private Integer isOurHosp;
    private String phone;
}
