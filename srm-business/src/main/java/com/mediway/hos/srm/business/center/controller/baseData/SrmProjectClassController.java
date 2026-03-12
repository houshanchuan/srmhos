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

import com.mediway.hos.srm.business.center.model.dto.baseData.ProjectClassDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ProjectClassVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmProjectClassService;


/**
 * <p>
 * 项目性质
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/projectClass")
@Api(tags = "项目性质")
public class SrmProjectClassController {

    @Autowired
    private SrmProjectClassService srmProjectClassService;

    @PostMapping({"/saveOrUpdateProjectClass"})
    public BaseResponse saveOrUpdateProjectClass(@RequestBody BaseDataProjDto baseDataProjDto) {
        Long RowId = srmProjectClassService.saveOrUpdateProjectClass(baseDataProjDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailProjectClass(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        ProjectClassVo projectClassVo = srmProjectClassService.getDetailProjectClass(RowId);
        return BaseResponse.success(projectClassVo);
    }

    @PostMapping({"/listProjectClass"})
    public BaseResponse listProjectClass(@RequestBody ProjectClassDto projectClassDto) {
        IPage<ProjectClassVo> list = srmProjectClassService.listProjectClass(projectClassDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteProjectClass"})
    public BaseResponse deleteProjectClass(@RequestBody BaseDto baseDto) {
        srmProjectClassService.deleteProjectClass(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
