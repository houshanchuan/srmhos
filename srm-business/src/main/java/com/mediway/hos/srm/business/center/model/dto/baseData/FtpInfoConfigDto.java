package com.mediway.hos.srm.business.center.model.dto.baseData;


import lombok.Data;
import com.mediway.hos.srm.business.base.model.entity.BasePO;

@Data
public class FtpInfoConfigDto extends BasePO {
    private Long rowId;
    private String ftpUser;
    private String ftpPassword;
    private String ftpIp;
    private String ftpDesc;
    private String ftpType;
    private String  ftpSrc;
    private String ftpSsl;
    private String  kkFileViewFlag;

}
