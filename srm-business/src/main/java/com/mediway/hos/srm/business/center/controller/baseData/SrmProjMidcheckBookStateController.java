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

import com.mediway.hos.srm.business.center.model.dto.baseData.ProjMidCheckBookStateDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ProjMidCheckBookStateVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmProjMidcheckBookStateService;


/**
 * <p>
 * 项目中检状态表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/projMidcheckBookState")
@Api(tags = "项目中检状态表")
public class SrmProjMidcheckBookStateController {

    @Autowired
    private SrmProjMidcheckBookStateService srmProjMidCheckBookStateService;

    @PostMapping({"/saveOrUpdateProjMidCheckBookState"})
    public BaseResponse saveOrUpdateProjMidCheckBookState(@RequestBody BaseDataCommonDto baseDataCommonDto) {
        Long RowId = srmProjMidCheckBookStateService.saveOrUpdateProjMidCheckBookState(baseDataCommonDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailProjMidCheckBookState(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        ProjMidCheckBookStateVo projMidCheckBookStateVo = srmProjMidCheckBookStateService.getDetailProjMidCheckBookState(RowId);
        return BaseResponse.success(projMidCheckBookStateVo);
    }

    @PostMapping({"/listProjMidCheckBookState"})
    public BaseResponse listProjMidCheckBookState(@RequestBody ProjMidCheckBookStateDto projMidCheckBookStateDto) {
        IPage<ProjMidCheckBookStateVo> list = srmProjMidCheckBookStateService.listProjMidCheckBookState(projMidCheckBookStateDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteProjMidCheckBookState"})
    public BaseResponse deleteProjMidCheckBookState(@RequestBody BaseDto baseDto) {
        srmProjMidCheckBookStateService.deleteProjMidCheckBookState(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
