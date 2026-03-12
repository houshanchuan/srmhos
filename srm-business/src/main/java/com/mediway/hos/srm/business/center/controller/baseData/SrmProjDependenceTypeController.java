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
import com.mediway.hos.srm.business.center.model.dto.baseData.ProjDependenceTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ProjDependenceTypeVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmProjDependenceTypeService;
/**
 * <p>
 * 项目依赖类型代码表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/projDependenceType")
@Api(tags = "项目依赖类型代码表")
public class SrmProjDependenceTypeController {

    @Autowired
    private SrmProjDependenceTypeService srmProjDependenceTypeService;

    @PostMapping({"/saveOrUpdateProjDependenceType"})
    public BaseResponse saveOrUpdateProjDependenceType(@RequestBody BaseDataProjDto baseDataProjDto) {
        Long RowId = srmProjDependenceTypeService.saveOrUpdateProjDependenceType(baseDataProjDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailProjDependenceType(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        ProjDependenceTypeVo projDependenceTypeVo = srmProjDependenceTypeService.getDetailProjDependenceType(RowId);
        return BaseResponse.success(projDependenceTypeVo);
    }

    @PostMapping({"/listProjDependenceType"})
    public BaseResponse listProjDependenceType(@RequestBody ProjDependenceTypeDto projDependenceTypeDto) {
        IPage<ProjDependenceTypeVo> list = srmProjDependenceTypeService.listProjDependenceType(projDependenceTypeDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteProjDependenceType"})
    public BaseResponse deleteProjDependenceType(@RequestBody BaseDto baseDto) {
        srmProjDependenceTypeService.deleteProjDependenceType(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
