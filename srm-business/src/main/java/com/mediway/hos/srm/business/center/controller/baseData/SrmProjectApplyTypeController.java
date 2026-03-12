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

import com.mediway.hos.srm.business.center.model.dto.baseData.ProjectApplyTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ProjectApplyTypeVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmProjectApplyTypeService;

/**
 * <p>
 * 项目申报类型
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/projectApplyType")
@Api(tags = "项目申报类型")
public class SrmProjectApplyTypeController {

    @Autowired
    private SrmProjectApplyTypeService srmProjectApplyTypeService;

    @PostMapping({"/saveOrUpdateProjectApplyType"})
    public BaseResponse saveOrUpdateProjectApplyType(@RequestBody BaseDataProjDto baseDataProjDto) {
        Long RowId = srmProjectApplyTypeService.saveOrUpdateProjectApplyType(baseDataProjDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailProjectApplyType(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        ProjectApplyTypeVo projectApplyTypeVo = srmProjectApplyTypeService.getDetailProjectApplyType(RowId);
        return BaseResponse.success(projectApplyTypeVo);
    }

    @PostMapping({"/listProjectApplyType"})
    public BaseResponse listProjectApplyType(@RequestBody ProjectApplyTypeDto projectApplyTypeDto) {
        IPage<ProjectApplyTypeVo> list = srmProjectApplyTypeService.listProjectApplyType(projectApplyTypeDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteProjectApplyType"})
    public BaseResponse deleteProjectApplyType(@RequestBody BaseDto baseDto) {
        srmProjectApplyTypeService.deleteProjectApplyType(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
