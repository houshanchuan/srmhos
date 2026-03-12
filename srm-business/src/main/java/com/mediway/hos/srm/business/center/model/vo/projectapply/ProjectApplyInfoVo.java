package com.mediway.hos.srm.business.center.model.vo.projectapply;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import lombok.Data;

import java.util.Date;

@Data
public class ProjectApplyInfoVo {
    private Long rowId;
    private String code;
    private String name;
    private CombVo discipline;
    private String disciplineName;
    private CombVo projectClass;
    private String projectClassName;
    private CombVo projType;
    private String projTypeName;
    private String sourceUnitName;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
    private String state;
    private String note;
    private String createTime;
    private String creatorCode;
    private Integer isReviewNeeded;
    private String fileIds;
}
