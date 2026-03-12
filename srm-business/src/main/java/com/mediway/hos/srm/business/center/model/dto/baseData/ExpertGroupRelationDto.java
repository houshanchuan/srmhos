package com.mediway.hos.srm.business.center.model.dto.baseData;


import lombok.Data;
import com.mediway.hos.srm.business.base.model.entity.BasePO;

@Data
public class ExpertGroupRelationDto extends BasePO {
    private Long rowId;
    private String groupId;
    private String groupName;
    private String userId;
    private String userName;
}
