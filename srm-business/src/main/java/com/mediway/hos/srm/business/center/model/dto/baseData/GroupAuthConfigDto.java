package com.mediway.hos.srm.business.center.model.dto.baseData;
import lombok.Data;

@Data
public class GroupAuthConfigDto {
    private Long rowId;
    private String groupId;
    private Integer authMaintUser;
    private Integer dataModify;
    private Integer workbenchPermissionsid;
    private Integer requiredFieldSet;

    // 下面是查询条件
    private int page;
    private int rows;

}
