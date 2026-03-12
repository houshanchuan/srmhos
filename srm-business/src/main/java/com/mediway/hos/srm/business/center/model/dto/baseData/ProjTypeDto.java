package com.mediway.hos.srm.business.center.model.dto.baseData;


import lombok.Data;
import com.mediway.hos.srm.business.base.model.entity.BasePO;

@Data
public class ProjTypeDto extends BasePO {
    private Long rowId;
    private String code;
    private String name;
    private Integer isValid;
    private String projClass;
    private String projLevel;
    private String socialSource;
    private String techSource;
    private String alias;


}
