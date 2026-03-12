package com.mediway.hos.srm.business.center.model.dto.user;
import com.mediway.hos.srm.business.center.model.dto.baseData.ExpertGroupDto;
import lombok.Data;
import com.mediway.hos.srm.business.base.model.entity.BasePO;

import java.util.List;

@Data
public class UserExpertDto extends BasePO {
    // 下面是查询条件
    private String pUserCode;
    private String pUserName;
    private String pUserType;
    private String pUserSex;
    private String pAuditStatus;
    private String pUserDegree;
    private String pUserEduLevel;
    private String pUserTitle;
    private String pUserDirection;
    private String pOccuCategory;
    private String pDept;
    private String pHonorTitle;
    private String pJobType;
    private String pPartTimePos;
    //
    private List<UserDto> userExperts;
    //
    private List<UserDto> usersForExperts;
    private List<ExpertGroupDto> expertGroups;

}
