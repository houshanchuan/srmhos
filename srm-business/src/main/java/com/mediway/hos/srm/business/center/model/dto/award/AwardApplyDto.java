package com.mediway.hos.srm.business.center.model.dto.award;

import lombok.Data;

@Data
public class AwardApplyDto {
    private Long rowId;
    private Long applyInfoId;
    private String awardName;
    private String firstAuthorType;
    private String firstAuthorCode;
    private String firstAuthorName;
    private String productName;
    private String deptId;
    private String applyDate;
    private String awardLevel;
    private String classCode;
    private String discipline;
    private String productprojEctsource;
    private String productMode;
    private Integer isRegistered;
    private String ourUnitRanking;
    private String award;
    private String fileIds;
    private String note;
    private String checkStatus;
    private String creatorCode;
    private String creatorName;
    private String createTime;
    private String operateTime;
    private String year;
    private String rewardType;
    private String mainCompleterId;
    private Integer dataStatus;
    private String applyInfoName;
    // 下面是查询条件
    private int page;
    private int rows;
    private String startDate;
    private String endDate;
    private Long userId;
    private String userCode;
    private String auditState;

}
