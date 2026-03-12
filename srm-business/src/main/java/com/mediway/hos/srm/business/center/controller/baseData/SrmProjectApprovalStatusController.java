package com.mediway.hos.srm.business.center.controller.baseData;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.base.model.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataCommonDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mediway.hos.srm.business.center.model.dto.baseData.ProjectApprovalStatusDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ProjectApprovalStatusVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmProjectApprovalStatusService;

/**
 * <p>
 * 项目申报立项状态
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/projectApprovalStatus")
@Api(tags = "项目申报立项状态")
public class SrmProjectApprovalStatusController {

    @Autowired
    private SrmProjectApprovalStatusService srmProjectApprovalStatusService;

    @PostMapping({"/saveOrUpdateProjectApprovalStatus"})
    public BaseResponse saveOrUpdateProjectApprovalStatus(@RequestBody BaseDataCommonDto baseDataCommonDto) {
        Long RowId = srmProjectApprovalStatusService.saveOrUpdateProjectApprovalStatus(baseDataCommonDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailProjectApprovalStatus(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        ProjectApprovalStatusVo projectApprovalStatusVo = srmProjectApprovalStatusService.getDetailProjectApprovalStatus(RowId);
        return BaseResponse.success(projectApprovalStatusVo);
    }

    @PostMapping({"/listProjectApprovalStatus"})
    public BaseResponse listProjectApprovalStatus(@RequestBody ProjectApprovalStatusDto projectApprovalStatusDto) {
        IPage<ProjectApprovalStatusVo> list = srmProjectApprovalStatusService.listProjectApprovalStatus(projectApprovalStatusDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteProjectApprovalStatus"})
    public BaseResponse deleteProjectApprovalStatus(@RequestBody BaseDto baseDto) {
        srmProjectApprovalStatusService.deleteProjectApprovalStatus(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
