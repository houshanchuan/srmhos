package com.mediway.hos.srm.business.center.service.baseData;

import com.mediway.hos.base.model.BaseResponse;
import com.mediway.hos.srm.business.center.model.dto.baseData.FileDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmFileconfig;

public interface SrmUploadFtpService {
    public BaseResponse upload(FileDto fileDto, SrmFileconfig fileconfig);
    void download(FileDto fileDto, SrmFileconfig fileconfig);
}
