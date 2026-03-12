package com.mediway.hos.srm.business.center.controller.project;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.base.model.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;

import com.mediway.hos.srm.business.center.model.dto.project.ProjectMidcheckListInfoDto;

import io.swagger.annotations.Api;

import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import com.mediway.hos.srm.business.center.model.vo.project.ProjectMidcheckListInfoVo;

import com.mediway.hos.srm.business.center.service.project.SrmProjectMidcheckListInfoService;

import java.util.List;

/**
 * <p>
 * 中检批次信息表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/srmProjectMidcheckListInfo")
@Api(tags = "中检批次信息表")
public class SrmProjectMidcheckListInfoController {
    @Autowired
    private SrmProjectMidcheckListInfoService srmProjectMidcheckListInfoService;

    @PostMapping({"/saveProjectMidCheckListInfo"})
    public BaseResponse saveProjectMidCheckListInfo(@RequestBody ProjectMidcheckListInfoDto projectMidcheckListInfoDto) {
        Long RowId= srmProjectMidcheckListInfoService.saveProjectMidCheckListInfo(projectMidcheckListInfoDto);
        return BaseResponse.success(RowId);
    }
    @PostMapping({"/getDetail"})
    public BaseResponse getDetail(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        ProjectMidcheckListInfoVo projectMidcheckListInfoVo = srmProjectMidcheckListInfoService.getDetail(String.valueOf(RowId));
        return BaseResponse.success(projectMidcheckListInfoVo);
    }

    @PostMapping({"/listProjectMidCheckListInfo"})
    public BaseResponse listProjectMidCheckListInfo(@RequestBody ProjectMidcheckListInfoDto projectMidcheckListInfoDto) {
        IPage<ProjectMidcheckListInfoVo> list = srmProjectMidcheckListInfoService.listProjectMidCheckListInfo(projectMidcheckListInfoDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/getprojectMidcheckListInfo"})
    public List<CombVo> getprojectMidcheckListInfo(@RequestParam String name) {return srmProjectMidcheckListInfoService.getprojectMidcheckListInfo(name);}

}
