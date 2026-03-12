package com.mediway.hos.srm.business.center.model.vo.patent;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class PatentApplyInfoVo {
    private Long rowId;
    private String applyInfoNo;
    private String applyInfoName;
    private String patentType;
    private String patentTypeName;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
    private String applyInfoState;
    private String applyInfoStateName;
    private String note;
    private String creatorId;
    private String creatorName;
    private String patentState;
    private String patentStateName;
    private String toReviewState;
    private String reviewState;
}
