package com.mediway.hos.srm.business.center.model.dto.projectapply;

import lombok.Data;
import com.mediway.hos.srm.business.base.model.entity.BasePO;

@Data
public class ProjectApplyInfoDto extends BasePO {
    private Long rowId;
    private String code;
    private String name;
    private String discipline;
    private String projectClass;
    private String projType;
    private String sourceUnitName;
    private String startDate;
    private String endDate;
    private String state;
    private String note;
    private String createTime;
    private String creatorCode;
    private Integer isReviewNeeded;
    private String fileIds;
    private String useCode;
}
