package com.mediway.hos.srm.business.center.service.app;

import com.mediway.hos.base.model.BaseResponse;
import com.mediway.hos.srm.business.center.model.dto.app.AppBaseDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.FileDto;

public interface SrmAppService {
    public BaseResponse Operate(AppBaseDto appBaseDto);
    public BaseResponse upload(FileDto fileDto);
}
