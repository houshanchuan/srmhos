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

import com.mediway.hos.srm.business.center.model.dto.baseData.PatentStateDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.PatentStateVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmPatentStateService;
/**
 * <p>
 * 专利状态
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/patentState")
@Api(tags = "专利状态")
public class SrmPatentStateController {

    @Autowired
    private SrmPatentStateService srmPatentStateService;

    @PostMapping({"/saveOrUpdatePatentState"})
    public BaseResponse saveOrUpdatePatentState(@RequestBody BaseDataCommonDto baseDataCommonDto) {
        Long RowId = srmPatentStateService.saveOrUpdatePatentState(baseDataCommonDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailPatentState(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        PatentStateVo patentStateVo = srmPatentStateService.getDetailPatentState(RowId);
        return BaseResponse.success(patentStateVo);
    }

    @PostMapping({"/listPatentState"})
    public BaseResponse listPatentState(@RequestBody PatentStateDto patentStateDto) {
        IPage<PatentStateVo> list = srmPatentStateService.listPatentState(patentStateDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deletePatentState"})
    public BaseResponse deletePatentState(@RequestBody BaseDto baseDto) {
        srmPatentStateService.deletePatentState(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
