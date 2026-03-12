package com.mediway.hos.srm.business.center.model.vo.projectapply;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ProjectSolicitVo {
    private Long rowId;
    private CombVo year;
    private String yearName;
    private CombVo projType;
    private String projTypeName;
    private String title;
    private Integer isEthic;
    private String expertList;
    private String ethicExpertList;
    private String subUserId;
    private String subUserName;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date subDate;
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
    private CombVo head;
    private String headName;
    private String contacts;
    private String reschCategory;
    private String indicRange;
    private String participationType;
    private CombVo subDept;
    private String subDeptName;
    private String leaderDept;
    private String involvedDept;
    private String funds;
    private CombVo discipline;
    private String disciplineName;
    private String researchField;
    private String finaChkResult;
    private String finaChkDesc;
    private String finaChkUserId;
    private String finaChkDateTime;
    private String projectApplyInfo;
    private String projectApplyInfoName
            ;
    private String division;
    private CombVo projectClass;
    private String projectClassName;
    private String creatorName;
    private String applierEduLevel;
    private String applierTitle;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date planedEndDate;
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
    private CombVo applyBookType;
    private String applyBookTypeName;
    private String classCode;
    private String creator;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;
    private Long applyId;
    private String note;
    private String progrp;
    private String ranking;
    private String type;
    private String checkList;
    private String expertAuditStatus;
    private String ethicExpertAuditStatus;
    private String isAllot;
    private String isEthicAllot;
    private String allotState;
    private String ethicAllotState;
}
