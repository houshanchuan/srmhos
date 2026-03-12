package com.mediway.hos.srm.business.center.controller.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.base.model.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataProjDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mediway.hos.srm.business.center.model.dto.baseData.ProjectApplyBookTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ProjectApplyBookTypeVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmProjectApplyBookTypeService;


/**
 * <p>
 * 项目申报类别
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/projectApplyBookType")
@Api(tags = "项目申报类别")
public class SrmProjectApplyBookTypeController {

    @Autowired
    private SrmProjectApplyBookTypeService srmProjectApplyBookTypeService;

    @PostMapping({"/saveOrUpdateProjectApplyBookType"})
    public BaseResponse saveOrUpdateProjectApplyBookType(@RequestBody BaseDataProjDto baseDataProjDto) {
        Long RowId = srmProjectApplyBookTypeService.saveOrUpdateProjectApplyBookType(baseDataProjDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailProjectApplyBookType(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        ProjectApplyBookTypeVo projectApplyBookTypeVo = srmProjectApplyBookTypeService.getDetailProjectApplyBookType(RowId);
        return BaseResponse.success(projectApplyBookTypeVo);
    }

    @PostMapping({"/listProjectApplyBookType"})
    public BaseResponse listProjectApplyBookType(@RequestBody ProjectApplyBookTypeDto projectApplyBookTypeDto) {
        IPage<ProjectApplyBookTypeVo> list = srmProjectApplyBookTypeService.listProjectApplyBookType(projectApplyBookTypeDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteProjectApplyBookType"})
    public BaseResponse deleteProjectApplyBookType(@RequestBody BaseDto baseDto) {
        srmProjectApplyBookTypeService.deleteProjectApplyBookType(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
