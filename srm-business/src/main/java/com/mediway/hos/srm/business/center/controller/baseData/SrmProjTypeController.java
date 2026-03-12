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
import com.mediway.hos.srm.business.center.model.dto.baseData.ProjTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ProjTypeVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmProjTypeService;


/**
 * <p>
 * 项目分类表（父）
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/projType")
@Api(tags = "项目分类表（父）")
public class SrmProjTypeController {

    @Autowired
    private SrmProjTypeService srmProjTypeService;

    @PostMapping({"/saveOrUpdateProjType"})
    public BaseResponse saveOrUpdateProjType(@RequestBody BaseDataProjDto baseDataProjDto) {
        Long RowId = srmProjTypeService.saveOrUpdateProjType(baseDataProjDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailProjType(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        ProjTypeVo projTypeVo = srmProjTypeService.getDetailProjType(RowId);
        return BaseResponse.success(projTypeVo);
    }

    @PostMapping({"/listProjType"})
    public BaseResponse listProjType(@RequestBody ProjTypeDto projTypeDto) {
        IPage<ProjTypeVo> list = srmProjTypeService.listProjType(projTypeDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteProjType"})
    public BaseResponse deleteProjType(@RequestBody BaseDto baseDto) {
        srmProjTypeService.deleteProjType(baseDto);
        return BaseResponse.success("删除成功!");

    }

}
