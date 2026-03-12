package com.mediway.hos.srm.business.center.model.vo.paper;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class PaperSubmissionExpertAuditVo {
    private Long rowId;
    private String appRowId;
    private Integer dataStatus;
    private String note;
    private String auditStatus;
    private String sysNo;
    private String subUserId;
    private String subUserCode;
    private String subUserName;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date subDate;
    // 论文模块

    private String title;

    private String sendDate;
    private String firstAuthor;
    private String firstAuthorName;
    private String firstAuthorCode;
    private String firstAuthorDept;
    private String firstAuthorType;
    private String firstAuthorPosition;
    private String corrAuthor;
    private String corrAuthorName;
    private String corrAuthorCode;
    private String corrAuthorType;
    private String corrAuthorPosition;
    private String corrAuthorDept;
    // 专利模块
    private String name;
    private String patentTypeName;
    private String deptName;
    // 获奖模块
    private String awardName;
    private String creatorName;
    private String createTime;

    private String startDate;
    private String endDate;
    private Long userId;
    private String userCode;
}
