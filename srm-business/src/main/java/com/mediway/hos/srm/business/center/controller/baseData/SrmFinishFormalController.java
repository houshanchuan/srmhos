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

import com.mediway.hos.srm.business.center.model.dto.baseData.FinishFormalDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.FinishFormalVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmFinishFormalService;

/**
 * <p>
 * 完成形式代码
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/finishFormal")
@Api(tags = "完成形式代码")
public class SrmFinishFormalController {

    @Autowired
    private SrmFinishFormalService srmFinishFormalService;

    @PostMapping({"/saveOrUpdateFinishFormal"})
    public BaseResponse saveOrUpdateFinishFormal(@RequestBody BaseDataProjDto baseDataProjDto) {
        Long RowId = srmFinishFormalService.saveOrUpdateFinishFormal(baseDataProjDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailFinishFormal(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        FinishFormalVo finishFormalVo = srmFinishFormalService.getDetailFinishFormal(RowId);
        return BaseResponse.success(finishFormalVo);
    }

    @PostMapping({"/listFinishFormal"})
    public BaseResponse listFinishFormal(@RequestBody FinishFormalDto finishFormalDto) {
        IPage<FinishFormalVo> list = srmFinishFormalService.listFinishFormal(finishFormalDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteFinishFormal"})
    public BaseResponse deleteFinishFormal(@RequestBody BaseDto baseDto) {
        srmFinishFormalService.deleteFinishFormal(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
