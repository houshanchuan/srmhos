package com.mediway.hos.srm.business.center.model.dto.baseData;


import lombok.Data;
import com.mediway.hos.srm.business.base.model.entity.BasePO;

@Data
public class TemplateDownloadDto extends BasePO {
    private Long rowId;
    private String year;
    private String sysNo;
    private String sysName;
    private String title;
    private String tempType;

}
