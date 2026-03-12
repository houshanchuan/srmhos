package com.mediway.hos.srm.business.center.model.vo.project;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import lombok.Data;

import java.util.Date;

@Data
public class ProjectMidcheckListInfoVo {
    private Long rowId;
    private CombVo projTypeCode;
    private String projTypeName;
    private String midCheckInfo;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date beginDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
    private String midCheckState;
    private String note;
    private String fileId;
    private String notifyPlan;
}
