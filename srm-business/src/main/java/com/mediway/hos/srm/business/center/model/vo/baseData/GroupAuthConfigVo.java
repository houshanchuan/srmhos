package com.mediway.hos.srm.business.center.model.vo.baseData;

import lombok.Data;

@Data
public class GroupAuthConfigVo {
    private Long rowId;
    private String groupId;
    private Integer authMaintUser;
    private Integer dataModify;
    private Integer workbenchPermissionsid;
    private Integer requiredFieldSet;

}
