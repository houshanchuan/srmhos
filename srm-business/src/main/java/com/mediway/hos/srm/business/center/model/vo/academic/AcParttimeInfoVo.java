package com.mediway.hos.srm.business.center.model.vo.academic;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import lombok.Data;

import java.util.Date;

@Data
public class AcParttimeInfoVo {
    private Long rowId;
    private CombVo userId;
    private String userName;
    private CombVo deptId;
    private String deptName;
    private CombVo committee;
    private String committeeName;
    private CombVo position;
    private String positionName;
    private CombVo year;
    private String yearName;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
    private String subUserId;
    private String subUserName;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date subDate;
    private Integer dataStatus;
    private String sysNo;
    private String branch;
    private String resAudit;
    private String resDesc;
    private String auditUserId;
    private String auditDate;
    private CombVo committeeType;
    private String committeeTypeName;
    private CombVo bizType;
    private String bizTypeName;
    private String committeeBranch;
    private String committeeSubBranch;
    private CombVo parttimeType;
    private String parttimeTypeName;
    private String state;
    private String parttimeApply;
    private String chkResultlist;
    private String creatorId;
    private String createTime;
    private String creatorName;
}
