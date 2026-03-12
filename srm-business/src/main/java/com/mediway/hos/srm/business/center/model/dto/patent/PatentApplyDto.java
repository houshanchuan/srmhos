package com.mediway.hos.srm.business.center.model.dto.patent;

import lombok.Data;

@Data
public class PatentApplyDto {
    private Long rowId;
    private Long applyInfoId;
    private String name;
    private String patentType;
    private String deptId;
    private String year;
    private String patentee;
    private String appDate;
    private String subDate;
    private String subTime;
    private Integer dataStatus;
    private String sysNo;
    private String subUserId;
    private String subUserDeptId;
    private String phone;
    private String email;
    private Integer isApproved;
    private String approvedDate;
    private String techFields;
    private String relaItemName;
    private String techBased;
    private String purpose;
    private String content;
    private String effect;
    private String digest;
    private Integer isRegistered;
    private String applyCode;
    private String patentState;
    private String patentId;
    private String fileIds;
    private String note;
    private String unitRanking;
    private String fauthorName;
    private String fauthorTitle;
    private String fauthorType;
    private String fauthorSex;
    private String fauthorEduLevel;
    private String fauthorEduDegree;
    private String fauthorCode;
    private String checkStatus;
    private String inFauthorCode;
    private String creatorName;
    private String operateTime;
    private String agencyUnit;
    private String agencyFeeSource;
    // 下面是查询条件
    private int page;
    private int rows;
    private String startDate;
    private String endDate;
    private Long userId;
    private String userCode;
    private String auditState;
}
