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

import com.mediway.hos.srm.business.center.model.dto.baseData.ProjectOrgFormDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ProjectOrgFormVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmProjectOrgFormService;

/**
 * <p>
 * 项目组织形式
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/projectOrgForm")
@Api(tags = "项目组织形式")
public class SrmProjectOrgFormController {

    @Autowired
    private SrmProjectOrgFormService srmProjectOrgFormService;

    @PostMapping({"/saveOrUpdateProjectOrgForm"})
    public BaseResponse saveOrUpdateProjectOrgForm(@RequestBody BaseDataProjDto baseDataProjDto) {
        Long RowId = srmProjectOrgFormService.saveOrUpdateProjectOrgForm(baseDataProjDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailProjectOrgForm(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        ProjectOrgFormVo projectOrgFormVo = srmProjectOrgFormService.getDetailProjectOrgForm(RowId);
        return BaseResponse.success(projectOrgFormVo);
    }

    @PostMapping({"/listProjectOrgForm"})
    public BaseResponse listProjectOrgForm(@RequestBody ProjectOrgFormDto projectOrgFormDto) {
        IPage<ProjectOrgFormVo> list = srmProjectOrgFormService.listProjectOrgForm(projectOrgFormDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteProjectOrgForm"})
    public BaseResponse deleteProjectOrgForm(@RequestBody BaseDto baseDto) {
        srmProjectOrgFormService.deleteProjectOrgForm(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
