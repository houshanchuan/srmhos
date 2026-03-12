package com.mediway.hos.srm.business.center.controller.log;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.base.model.BaseResponse;
import com.mediway.hos.srm.business.center.model.dto.academic.AcConferenceHostDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.dto.log.SrmLogDto;
import com.mediway.hos.srm.business.center.model.entity.log.SrmLog;
import com.mediway.hos.srm.business.center.model.vo.academic.AcConferenceHostVo;
import com.mediway.hos.srm.business.center.model.vo.log.SrmLogVo;
import com.mediway.hos.srm.business.center.service.log.SrmLogService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("srm/srmLog")
@Api(tags = "日志操作")
public class SrmLogController {

    @Autowired
    private SrmLogService srmLogService;
    @PostMapping({"/listLog"})
    public BaseResponse listAcConferenceHost(@RequestBody SrmLogDto srmLogDto) {
        IPage<SrmLogVo> list = srmLogService.listLog(srmLogDto);
        return BaseResponse.success(list);

    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetail(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        SrmLogVo srmLogVo = srmLogService.getDetail(RowId);
        return BaseResponse.success(srmLogVo);
    }
}
