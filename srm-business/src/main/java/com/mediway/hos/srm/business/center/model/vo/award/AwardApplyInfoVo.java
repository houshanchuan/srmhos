package com.mediway.hos.srm.business.center.model.vo.award;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import lombok.Data;

import java.util.Date;

@Data
public class AwardApplyInfoVo {
    private String rowId;
    private String applyName;
    private String awardName;
    private CombVo awardLevel;
    private String awardLevelName;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
    private CombVo state;
    private String stateName;
    private String creatorCode;
    private String creatorName;
    private String createTime;
    private String operateTime;
    private String note;
}
