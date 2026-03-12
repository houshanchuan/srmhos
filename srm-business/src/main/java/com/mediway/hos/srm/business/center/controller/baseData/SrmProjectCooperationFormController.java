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

import com.mediway.hos.srm.business.center.model.dto.baseData.ProjectCooprateFormDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ProjectCooprateFormVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmProjectCooperationFormService;
/**
 * <p>
 * 项目合作形式
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/projectCooperationForm")
@Api(tags = "项目合作形式")
public class SrmProjectCooperationFormController {

    @Autowired
    private SrmProjectCooperationFormService srmProjectCooperationFormService;

    @PostMapping({"/saveOrUpdateProjectCooprateForm"})
    public BaseResponse saveOrUpdateProjectCooprateForm(@RequestBody BaseDataProjDto baseDataProjDto) {
        Long RowId = srmProjectCooperationFormService.saveOrUpdateProjectCooprateForm(baseDataProjDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailProjectCooprateForm(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        ProjectCooprateFormVo projectCooprateFormVo = srmProjectCooperationFormService.getDetailProjectCooprateForm(RowId);
        return BaseResponse.success(projectCooprateFormVo);
    }

    @PostMapping({"/listProjectCooprateForm"})
    public BaseResponse listProjectCooprateForm(@RequestBody ProjectCooprateFormDto projectCooprateFormDto) {
        IPage<ProjectCooprateFormVo> list = srmProjectCooperationFormService.listProjectCooprateForm(projectCooprateFormDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteProjectCooprateForm"})
    public BaseResponse deleteProjectCooprateForm(@RequestBody BaseDto baseDto) {
        srmProjectCooperationFormService.deleteProjectCooprateForm(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
