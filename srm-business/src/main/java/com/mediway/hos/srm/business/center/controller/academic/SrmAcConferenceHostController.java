package com.mediway.hos.srm.business.center.controller.academic;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.base.model.BaseResponse;
import com.mediway.hos.srm.business.center.model.dto.academic.AcConferenceHostDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mediway.hos.srm.business.center.model.vo.academic.AcConferenceHostVo;
import com.mediway.hos.srm.business.center.service.academic.SrmAcConferenceHostService;

/**
 * <p>
 * 学术会议表(主办)
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/srmAcConferenceHost")
@Api(tags = "学术会议表(主办)")
public class SrmAcConferenceHostController {
    @Autowired
    private SrmAcConferenceHostService srmAcConferenceHostService;
    @PostMapping({"/saveAcConferenceHost"})
    public BaseResponse saveAcConferenceHost(@RequestBody AcConferenceHostDto acConferenceHostDto) {
        System.out.println(acConferenceHostDto);
        Long RowId= srmAcConferenceHostService.saveAcConferenceHost(acConferenceHostDto);
        return BaseResponse.success(RowId);
    }
    @PostMapping({"/getDetail"})
    public BaseResponse getDetail(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        AcConferenceHostVo acConferenceHostVo = srmAcConferenceHostService.getDetail(RowId);
        return BaseResponse.success(acConferenceHostVo);
    }

    @PostMapping({"/listAcConferenceHost"})
    public BaseResponse listAcConferenceHost(@RequestBody AcConferenceHostDto acConferenceHostDto) {
        IPage<AcConferenceHostVo> list = srmAcConferenceHostService.listAcConferenceHost(acConferenceHostDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteAcConferenceHost"})
    public BaseResponse deleteAcConferenceHost(@RequestBody BaseDto baseDto) {
        srmAcConferenceHostService.deleteAcConferenceHost(baseDto);
        return BaseResponse.success("删除成功!");

    }
    @PostMapping({"/subMit"})
    public BaseResponse subMit(@RequestBody BaseDto baseDto) {
        System.out.println(baseDto.toString());
        srmAcConferenceHostService.subMit(baseDto);
        return BaseResponse.success("提交成功!");

    }
    @PostMapping({"/listAuditAcConferenceHost"})
    public BaseResponse listAuditAcConferenceHost(@RequestBody AcConferenceHostDto acConferenceHostDto) {
        IPage<AcConferenceHostVo> list = srmAcConferenceHostService.listAuditAcConferenceHost(acConferenceHostDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/audit"})
    public BaseResponse audit(@RequestBody BaseDto baseDto) {
        srmAcConferenceHostService.audit(baseDto);
        return BaseResponse.success("审批成功!");

    }



}
