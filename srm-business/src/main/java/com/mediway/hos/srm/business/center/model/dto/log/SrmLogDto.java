package com.mediway.hos.srm.business.center.model.dto.log;

import com.mediway.hos.srm.business.base.model.entity.BasePO;
import lombok.Data;

@Data
public class SrmLogDto extends BasePO {
    private String rowId;
    private String title;
    private String type;
    private String bussinessId;
    private String startDate;
    private String endDate;


}
