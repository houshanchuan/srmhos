package com.mediway.hos.srm.business.center.model.dto.baseData;


import lombok.Data;
import com.mediway.hos.srm.business.base.model.entity.BasePO;

@Data
public class AwardLevelDto extends BasePO {
    private Long rowId;
    private String code;
    private String name;
    private Integer isValid;

}
