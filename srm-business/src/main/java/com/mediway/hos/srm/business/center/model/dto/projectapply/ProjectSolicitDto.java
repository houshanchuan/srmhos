package com.mediway.hos.srm.business.center.model.dto.projectapply;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProjectSolicitDto {
    private Long rowId;
    private String year;
    private String projType;
    private String title;
    private Integer isEthic;
    private String expertList;
    private String ethicExpertList;

    private String subUserId;
    private String subDate;
    private Integer dataStatus;
    private String headerAuditStatus;
    private String auditStatus;
    private String checkResult;
    private String auditDate;
    private String checkDesc;
    private String sysNo;
    private String outExpertResult;
    private String ethicResult;
    private String preAuditor;
    private String preAuditState;
    private String preAuditDesc;
    private String preAuditDate;
    private String phone;
    private String email;
    private Integer isHumanGeneticResRequired;
    private String head;
    private String contacts;
    private String reschCategory;
    private String indicRange;
    private String participationType;
    private String subDept;
    private String leaderDept;
    private String involvedDept;
    private String funds;
    private String discipline;
    private String researchField;
    private String finaChkResult;
    private String finaChkDesc;
    private String finaChkUserId;
    private String finaChkDateTime;
    private String projectApplyInfo;
    private String division;
    private String projectClass;
    private String creatorName;
    private String applierEduLevel;
    private String applierTitle;
    private String planedEndDate;
    private String earlyResearchInfo;
    private String approvalStatus;
    private String projectSourceUnit;
    private String projectKeyword;
    private String projectApplyType;
    private String firstUnitType;
    private String fileIds;
    private BigDecimal avgScore;
    private BigDecimal agreeCount;
    private BigDecimal avgScore2;
    private BigDecimal agreeCount2;
    private String applyBookType;
    private String classCode;
    private String subuserName;
    private String creator;
    private String createTime;
    private Long applyId;
    private String note;
    private String progrp;
    private String ranking;
    private String type;
    private String needFinalFlag;
    // 下面是查询条件
    private int page;
    private int rows;
    private String startDate;
    private String endDate;
    private Long userId;
    private String userCode;
    private String auditState;
    private String allotExpertFlag;
    private String allotEthicExpertFlag;
}
