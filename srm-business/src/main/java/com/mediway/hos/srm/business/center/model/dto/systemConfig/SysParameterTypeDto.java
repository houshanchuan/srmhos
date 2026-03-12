package com.mediway.hos.srm.business.center.model.dto.systemConfig;
import lombok.Data;
import com.mediway.hos.srm.business.base.model.entity.BasePO;
@Data
public class SysParameterTypeDto extends BasePO {
    private Long rowId ;
    private String code ;
    private String name ;
    private String remark;

}
