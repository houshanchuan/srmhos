package com.mediway.hos.srm.business.center.model.dto.baseData;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class UploadInfoDto {
    private Long rowId;
    private String recId;
    private String sysNo;
    private String fileName;
    private String subUserId;
    private String subDate;
    private String fileUrl;
    private String appxFileType;
    private BigDecimal fileSize;
    private String fileType;
    private String serialId;
    private String note;
}
