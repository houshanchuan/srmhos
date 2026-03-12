package com.mediway.hos.srm.business.center.controller.baseData;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.base.model.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataLearningDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mediway.hos.srm.business.center.service.baseData.SrmScopeTypeService;
import com.mediway.hos.srm.business.center.model.dto.baseData.ScopeTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ScopeTypeVo;

/**
 * <p>
 * 范围类型
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/scopeType")
@Api(tags = "范围类型")
public class SrmScopeTypeController {
    @Autowired
    private SrmScopeTypeService srmScopeTypeService;

    @PostMapping({"/saveOrUpdateScopeType"})
    public BaseResponse saveOrUpdateScopeType(@RequestBody BaseDataLearningDto baseDataLearningDto) {
        Long RowId = srmScopeTypeService.saveOrUpdateScopeType(baseDataLearningDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailScopeType(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        ScopeTypeVo scopeTypeVo = srmScopeTypeService.getDetailScopeType(RowId);
        return BaseResponse.success(scopeTypeVo);
    }

    @PostMapping({"/listScopeType"})
    public BaseResponse listScopeType(@RequestBody ScopeTypeDto scopeTypeDto) {
        IPage<ScopeTypeVo> list = srmScopeTypeService.listScopeType(scopeTypeDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteScopeType"})
    public BaseResponse deleteScopeType(@RequestBody BaseDto baseDto) {
        srmScopeTypeService.deleteScopeType(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
