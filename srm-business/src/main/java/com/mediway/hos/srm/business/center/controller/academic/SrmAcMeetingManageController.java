package com.mediway.hos.srm.business.center.controller.academic;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.base.model.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.mediway.hos.srm.business.center.model.dto.baseData.AcBaseDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mediway.hos.srm.business.center.model.dto.academic.AcMeetingManageDto;
import com.mediway.hos.srm.business.center.model.vo.academic.AcMeetingManageVo;
import com.mediway.hos.srm.business.center.service.academic.SrmAcMeetingManageService;

/**
 * <p>
 * 参加会议信息表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/acMeetingManage")

@Api(tags = "参加会议信息表")
public class SrmAcMeetingManageController {
    @Autowired
    private SrmAcMeetingManageService srmAcMeetingManageService;

    @PostMapping({"/saveOrUpdateAcMeetingManage"})
    public BaseResponse saveOrUpdateAcMeetingManage(@RequestBody AcMeetingManageDto acMeetingManageDto) {
        Long RowId = srmAcMeetingManageService.saveOrUpdateAcMeetingManage(acMeetingManageDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetail(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        AcMeetingManageVo acMeetingManageVo = srmAcMeetingManageService.getDetailAcMeetingManage(RowId);
        return BaseResponse.success(acMeetingManageVo);
    }

    @PostMapping({"/listAcMeetingManage"})
    public BaseResponse listAcMeetingManage(@RequestBody AcMeetingManageDto acMeetingManageDto) {
        IPage<AcMeetingManageVo> list = srmAcMeetingManageService.listAcMeetingManage(acMeetingManageDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteAcMeetingManage"})
    public BaseResponse deleteAcMeetingManage(@RequestBody BaseDto baseDto) {
        srmAcMeetingManageService.deleteAcMeetingManage(baseDto);
        return BaseResponse.success("删除成功!");
    }

    @PostMapping({"/submitAcMeetingManage"})
    public BaseResponse submitAcMeetingManage(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        String UserId=baseDto.getUserId();
        srmAcMeetingManageService.submitAcMeetingManage(baseDto);
        return BaseResponse.success("提交成功!");
    }

    @PostMapping({"/listAcMeetingManageForAudit"})
    public BaseResponse listAcMeetingManageForAudit(@RequestBody AcMeetingManageDto acMeetingManageDto) {
        IPage<AcMeetingManageVo> list = srmAcMeetingManageService.listAcMeetingManageForAudit(acMeetingManageDto);
        return BaseResponse.success(list);
    }


    @PostMapping({"/audit"})
    public BaseResponse audit(@RequestBody BaseDto baseDto) {
        srmAcMeetingManageService.audit(baseDto);
        return BaseResponse.success("审批成功!");

    }

}
