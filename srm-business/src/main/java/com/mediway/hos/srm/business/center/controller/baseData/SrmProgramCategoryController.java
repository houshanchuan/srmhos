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

import com.mediway.hos.srm.business.center.model.dto.baseData.ProgramCategoryDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ProgramCategoryVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmProgramCategoryService;


/**
 * <p>
 * 计划类别
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/programCategory")
@Api(tags = "计划类别")
public class SrmProgramCategoryController {

    @Autowired
    private SrmProgramCategoryService srmProgramCategoryService;

    @PostMapping({"/saveOrUpdateProgramCategory"})
    public BaseResponse saveOrUpdateProgramCategory(@RequestBody BaseDataProjDto baseDataProjDto) {
        Long RowId = srmProgramCategoryService.saveOrUpdateProgramCategory(baseDataProjDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailProgramCategory(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        ProgramCategoryVo programCategoryVo = srmProgramCategoryService.getDetailProgramCategory(RowId);
        return BaseResponse.success(programCategoryVo);
    }

    @PostMapping({"/listProgramCategory"})
    public BaseResponse listProgramCategory(@RequestBody ProgramCategoryDto programCategoryDto) {
        IPage<ProgramCategoryVo> list = srmProgramCategoryService.listProgramCategory(programCategoryDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteProgramCategory"})
    public BaseResponse deleteProgramCategory(@RequestBody BaseDto baseDto) {
        srmProgramCategoryService.deleteProgramCategory(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
