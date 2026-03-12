package com.mediway.hos.srm.business.center.service.log;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.srm.business.base.service.BaseService;
import com.mediway.hos.srm.business.center.model.dto.log.SrmLogDto;
import com.mediway.hos.srm.business.center.model.entity.log.SrmLog;
import com.mediway.hos.srm.business.center.model.vo.log.SrmLogVo;

public interface SrmLogService extends BaseService<SrmLog> {

    IPage<SrmLogVo> listLog(SrmLogDto srmLogDto);

    SrmLogVo getDetail(Long rowId);

    int saveLog(SrmLog deptDto);
}
