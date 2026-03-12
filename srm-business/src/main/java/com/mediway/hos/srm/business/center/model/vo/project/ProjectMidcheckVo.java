package com.mediway.hos.srm.business.center.model.vo.project;

import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import lombok.Data;

@Data
public class ProjectMidcheckVo {
    private Long rowId;
    private CombVo projId;
    private String projRowId;
    private String sysNo;
    private String projName;
    private String detail;
    private String apply;
    private String applyName;
    private String midDate;
    private String midcheckFlag;
    private String midcheckState;
    private String midcheckOpinion;
    private String checker;
    private String checkDate;
    private String checkNo;
    private CombVo midcheckInfoId;
    private String midcheckInfoRowId;
    private String midcheckInfoName;
    private String midcheckOpinion2;
    private String midcheckOpinion3;
    private String midcheckOpinion4;
    private String chkResultList;

}
