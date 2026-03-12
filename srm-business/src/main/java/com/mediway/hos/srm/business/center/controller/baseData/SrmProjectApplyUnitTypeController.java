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


import com.mediway.hos.srm.business.center.model.dto.baseData.ProjectApplyUnitTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ProjectApplyUnitTypeVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmProjectApplyUnitTypeService;

/**
 * <p>
 * 项目申报部门类型
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/projectApplyUnitType")
@Api(tags = "项目申报部门类型")
public class SrmProjectApplyUnitTypeController {

    @Autowired
    private SrmProjectApplyUnitTypeService srmProjectApplyUnitTypeService;

    @PostMapping({"/saveOrUpdateProjectApplyUnitType"})
    public BaseResponse saveOrUpdateProjectApplyUnitType(@RequestBody BaseDataProjDto baseDataProjDto) {
        Long RowId = srmProjectApplyUnitTypeService.saveOrUpdateProjectApplyUnitType(baseDataProjDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailProjectApplyUnitType(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        ProjectApplyUnitTypeVo projectApplyUnitTypeVo = srmProjectApplyUnitTypeService.getDetailProjectApplyUnitType(RowId);
        return BaseResponse.success(projectApplyUnitTypeVo);
    }

    @PostMapping({"/listProjectApplyUnitType"})
    public BaseResponse listProjectApplyUnitType(@RequestBody ProjectApplyUnitTypeDto projectApplyUnitTypeDto) {
        IPage<ProjectApplyUnitTypeVo> list = srmProjectApplyUnitTypeService.listProjectApplyUnitType(projectApplyUnitTypeDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteProjectApplyUnitType"})
    public BaseResponse deleteProjectApplyUnitType(@RequestBody BaseDto baseDto) {
        srmProjectApplyUnitTypeService.deleteProjectApplyUnitType(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
