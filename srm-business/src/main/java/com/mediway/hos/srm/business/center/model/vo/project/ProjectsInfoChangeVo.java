package com.mediway.hos.srm.business.center.model.vo.project;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import lombok.Data;

import java.util.Date;

@Data
public class ProjectsInfoChangeVo {
    private Long rowId;
    private CombVo projId;
    private String initProjId;
    private String initProjName;
    private String initHeadName;
    private String initProjStatus;
    private CombVo changeitem;
    private String changeitemName;
    private CombVo oldValueComVo;
    private String oldValue;
    private CombVo newValueComVo;
    private String newValue;
    private CombVo reason;
    private String reasonName;
    private String intro;
    private Integer dataStatus;
    private CombVo subUserId;
    private CombVo subUserName;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date subDate;
    private String subNo;
    private String headName;
    private String checkStatus;
    private String checkUserId;
    private String checkDate;
    private String serialNo;
    private String creator;
    private String creatorName;
    private String createTime;
    private String operateTime;
    private String sysNo;
    private String note;
    private String oldValueDesc;
    private String newValueDesc;
    private String chkResultList;
    private CombVo newHeadType;
    private String newHeadAccount;

}
