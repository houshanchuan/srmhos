package com.mediway.hos.srm.business.center.model.vo.baseData;

import lombok.Data;

@Data
public class FtpInfoConfigVo {
    private Long rowId;
    private String ftpUser;
    private String ftpPassword;
    private String ftpIp;
    private String ftpDesc;
    private String ftpType;
    private String ftpTypeName;
    private String  ftpSrc;
    private String ftpSsl;
    private Integer  kkFileViewFlag;
}
