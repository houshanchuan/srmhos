package com.mediway.hos.srm.business.center.model.vo.patent;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import lombok.Data;

import java.util.Date;

@Data
public class PatentApplyVo {
    private Long rowId;
    private Long applyInfoId;
    private String name;
    private CombVo patentType;
    private String patentTypeName;
    private CombVo deptId;
    private String deptName;
    private CombVo year;
    private String yearName;
    private String patentee;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date appDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date subDate;
    private String subTime;
    private Integer dataStatus;
    private String sysNo;
    private CombVo subUserId;
    private String subUserName;
    private CombVo subUserDeptId;
    private String subUserDeptName;
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
    private String patentStateName;
    private String patentId;
    private String fileIds;
    private String note;
    private CombVo unitRanking;
    private String unitRankingName;
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
    private CombVo agencyUnit;
    private String agencyUnitName;
    private CombVo agencyFeeSource;
    private String agencyFeeSourceName;
    private String signFlag;
    private String checkList;
    private String createTime;
    // 下面是查询条件
    private int page;
    private int rows;
    private String startDate;
    private String endDate;
    private Long userId;
    private String userCode;
}
