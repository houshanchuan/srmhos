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

import com.mediway.hos.srm.business.center.model.dto.baseData.ProjTypeSubDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ProjTypeSubVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmProjTypeSubService;

/**
 * <p>
 * 项目类型(子类)
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/projTypeSub")
@Api(tags = "项目类型(子类)")
public class SrmProjTypeSubController {

    @Autowired
    private SrmProjTypeSubService srmProjTypeSubService;

    @PostMapping({"/saveOrUpdateProjTypeSub"})
    public BaseResponse saveOrUpdateProjTypeSub(@RequestBody BaseDataProjDto baseDataProjDto) {
        Long RowId = srmProjTypeSubService.saveOrUpdateProjTypeSub(baseDataProjDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailProjTypeSub(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        ProjTypeSubVo projTypeSubVo = srmProjTypeSubService.getDetailProjTypeSub(RowId);
        return BaseResponse.success(projTypeSubVo);
    }

    @PostMapping({"/listProjTypeSub"})
    public BaseResponse listProjTypeSub(@RequestBody ProjTypeSubDto projTypeSubDto) {
        IPage<ProjTypeSubVo> list = srmProjTypeSubService.listProjTypeSub(projTypeSubDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteProjTypeSub"})
    public BaseResponse deleteProjTypeSub(@RequestBody BaseDto baseDto) {
        srmProjTypeSubService.deleteProjTypeSub(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
