package com.mediway.hos.srm.business.center.service.baseData;

import com.mediway.hos.base.model.BaseResponse;
import com.mediway.hos.srm.business.center.model.dto.baseData.FileDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmFtpInfoConfig;

import javax.servlet.http.HttpServletResponse;

public interface SrmUploadSFtpService {
    public BaseResponse upload(FileDto fileDto, SrmFtpInfoConfig srmFtpInfoConfig);
    void download(FileDto fileDto, SrmFtpInfoConfig srmFtpInfoConfig, HttpServletResponse paramHttpServletResponse);
    void downloadTxt(FileDto fileDto, SrmFtpInfoConfig srmFtpInfoConfig, HttpServletResponse paramHttpServletResponse);
    void downloadWord(FileDto fileDto, SrmFtpInfoConfig srmFtpInfoConfig, HttpServletResponse paramHttpServletResponse);


}
