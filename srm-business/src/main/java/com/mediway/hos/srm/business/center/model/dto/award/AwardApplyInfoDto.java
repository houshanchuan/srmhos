package com.mediway.hos.srm.business.center.model.dto.award;

import lombok.Data;

@Data
public class AwardApplyInfoDto {
    private Long rowId;
    private String applyName;
    private String awardName;
    private String awardLevel;
    private String startDate;
    private String endDate;
    private String state;
    private String creatorCode;
    private String creatorName;
    private String createTime;
    private String operateTime;
    private String note;
    // 下面是查询条件
    private int page;
    private int rows;
    private Long userId;
    private String userCode;
}
