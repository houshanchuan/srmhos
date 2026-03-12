package com.mediway.hos.srm.business.center.controller.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.base.model.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataCommonDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mediway.hos.srm.business.center.model.dto.baseData.ProjMidCheckListInfoStateDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ProjMidCheckListInfoStateVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmProjMidcheckListInfoStateService;

/**
 * <p>
 * 项目中检批次状态表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/projMidcheckListInfoState")
@Api(tags = "项目中检批次状态表")
public class SrmProjMidcheckListInfoStateController {

    @Autowired
    private SrmProjMidcheckListInfoStateService srmProjMidCheckListInfoStateService;

    @PostMapping({"/saveOrUpdateProjMidCheckListInfoState"})
    public BaseResponse saveOrUpdateProjMidCheckListInfoState(@RequestBody BaseDataCommonDto baseDataCommonDto) {
        Long RowId = srmProjMidCheckListInfoStateService.saveOrUpdateProjMidCheckListInfoState(baseDataCommonDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailProjMidCheckListInfoState(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        ProjMidCheckListInfoStateVo projMidCheckListInfoStateVo = srmProjMidCheckListInfoStateService.getDetailProjMidCheckListInfoState(RowId);
        return BaseResponse.success(projMidCheckListInfoStateVo);
    }

    @PostMapping({"/listProjMidCheckListInfoState"})
    public BaseResponse listProjMidCheckListInfoState(@RequestBody ProjMidCheckListInfoStateDto projMidCheckListInfoStateDto) {
        IPage<ProjMidCheckListInfoStateVo> list = srmProjMidCheckListInfoStateService.listProjMidCheckListInfoState(projMidCheckListInfoStateDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteProjMidCheckListInfoState"})
    public BaseResponse deleteProjMidCheckListInfoState(@RequestBody BaseDto baseDto) {
        srmProjMidCheckListInfoStateService.deleteProjMidCheckListInfoState(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
