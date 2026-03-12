package com.mediway.hos.srm.business.center.model.dto.patent;

import lombok.Data;

@Data
public class PatentApplyInfoDto {
    private Long rowId;
    private String applyInfoNo;
    private String applyInfoName;
    private String patentType;
    private String startDate;
    private String endDate;
    private String applyInfoState;
    private String note;
    private String creatorId;
    private String creatorName;
    private String patentState;
    private String toReviewState;
    private String reviewState;
    private int page;
    private int rows;
    private Long userId;
    private String userCode;
}
