package com.mediway.hos.srm.business.center.model.vo.patent;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import lombok.Data;

import java.util.Date;

@Data
public class PatentInfoVo {
    private Long rowId;
    private String sysNo;
    private String bizType;
    private String name;
    private String applyPatentName;
    private CombVo patentType;
    private String patentTypeName;
    private CombVo deptId;
    private String deptName;
    private CombVo year;
    private String yearName;
    private String patentNo;
    private String certificateNo;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date applyDate;
    private String applyNo;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date annDate;
    private String annNo;
    private CombVo subUserId;
    private String subUserName;
    private String subDate;
    private Integer dataStatus;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date registerDate;
    private String annOrganization;
    private Integer score;
    private CombVo ourUnitRanking;
    private String ourUnitRankingName;
    private String researchField;
    private String keyWords;
    private CombVo patentCountry;
    private String division;
    private String scope;
    private CombVo state;
    private String stateName;
    private String checkStatus;
    private String note;
    private Integer authorNumbers;
    private Integer isDuty;
    private String signType;
    private String firstAuthorName;
    private String firstAuthorTitle;
    private String firstAuthorSex;
    private String firstAuthorType;
    private String inFirstAuthorId;
    private String inFirstAuthorCode;
    private String inFirstAuthorEduLevel;
    private String inFirstAuthorEduDegree;
    private String operateTime;
    private String fileIds;
    private Integer isPct;
    private String pctCode;
    private String pctName;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date pctDate;

    private String pctPriorityDate;
    private String pctEnterCountry;
    private String applyInfo;
    private String cooperationType;
    private Integer isValid;
    private String endReason;
    private String applyId;
    private String serialNo;
    private String creatorCode;
    private String creatorName;
    private String createTime;
    private String checkList;
}
