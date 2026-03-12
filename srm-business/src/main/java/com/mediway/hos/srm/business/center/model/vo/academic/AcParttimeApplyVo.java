package com.mediway.hos.srm.business.center.model.vo.academic;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import lombok.Data;

import java.util.Date;

@Data
public class AcParttimeApplyVo {
    private Long rowId;
    private CombVo userId;
    private String userName;
    private CombVo deptId;
    private String deptName;
    private CombVo committee;
    private String committeeName;
    private CombVo position;
    private String positionName;
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
    private String auditStatus;
    private String auditDesc;
    private String auditUserId;
    private String auditDate;
    private Integer committeeBranch;
    private CombVo partTimeType;
    private String partTimeTypeName;
    private CombVo year;
    private String yearName;
    private String createUserId;
    private String createDate;
    private String createTime;
    private String submitTime;
    private String chkResultlist;
}
