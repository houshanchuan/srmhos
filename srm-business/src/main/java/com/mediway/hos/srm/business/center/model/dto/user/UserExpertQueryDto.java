package com.mediway.hos.srm.business.center.model.dto.user;
import lombok.Data;
import com.mediway.hos.srm.business.base.model.entity.BasePO;

@Data
public class UserExpertQueryDto extends BasePO {
    // 查询条件
    private String paUserCode;
    private String paUserName;
    private String paUserType;
    private String paUserSex;
    private String paAuditStatus;
    private String paUserDegree;
    private String paUserEduLevel;
    private String paUserTitle;
    private String paUserDirection;
    private String paOccuCategory;
    private String paDept;
    private String paHonorTitle;
    private String paJobType;
    private String paPartTimePos;
    //
}
