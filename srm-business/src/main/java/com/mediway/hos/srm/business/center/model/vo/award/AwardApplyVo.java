package com.mediway.hos.srm.business.center.model.vo.award;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import lombok.Data;

import java.util.Date;

@Data
public class AwardApplyVo {
    private Long rowId;
    private Long applyInfoId;
    private String awardName;
    private CombVo firstAuthorType;
    private String firstAuthorTypeName;
    private String firstAuthorCode;
    private String firstAuthorName;
    private String productName;
    private CombVo deptId;
    private String deptName;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date applyDate;
    private CombVo awardLevel;
    private String awardLevelName;
    private CombVo classCode;
    private String classCodeName;
    private CombVo discipline;
    private String disciplineName;
    private CombVo productprojEctsource;
    private String productprojEctsourceName;
    private CombVo productMode;
    private String productModeName;
    private Integer isRegistered;
    private CombVo ourUnitRanking;
    private String ourUnitRankingName;
    private String award;
    private String fileIds;
    private String note;
    private String checkStatus;
    private String creatorCode;
    private String creatorName;
    private String createTime;
    private String operateTime;
    private CombVo year;
    private String yearName;
    private CombVo rewardType;
    private String rewardTypeName;
    private CombVo mainCompleterId;
    private String mainCompleterName;
    private Integer dataStatus;
    private String checkList;
    private String subUserId;
    private String subUserName;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date subDate;
}
