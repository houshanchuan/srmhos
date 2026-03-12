package com.mediway.hos.srm.business.center.controller.baseData;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.base.model.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataPlatformDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mediway.hos.srm.business.center.model.dto.baseData.SciUnitFormDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.SciUnitFormVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmSciUnitFormService;


/**
 * <p>
 * 组织形式(科技统计用)
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/sciUnitForm")
@Api(tags = "组织形式(科技统计用)")
public class SrmSciUnitFormController {

    @Autowired
    private SrmSciUnitFormService srmSciUnitFormService;

    @PostMapping({"/saveOrUpdateSciUnitForm"})
    public BaseResponse saveOrUpdateSciUnitForm(@RequestBody BaseDataPlatformDto baseDataPlatformDto) {
        Long RowId = srmSciUnitFormService.saveOrUpdateSciUnitForm(baseDataPlatformDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailSciUnitForm(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        SciUnitFormVo sciUnitFormVo = srmSciUnitFormService.getDetailSciUnitForm(RowId);
        return BaseResponse.success(sciUnitFormVo);
    }

    @PostMapping({"/listSciUnitForm"})
    public BaseResponse listSciUnitForm(@RequestBody SciUnitFormDto sciUnitFormDto) {
        IPage<SciUnitFormVo> list = srmSciUnitFormService.listSciUnitForm(sciUnitFormDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteSciUnitForm"})
    public BaseResponse deleteSciUnitForm(@RequestBody BaseDto baseDto) {
        srmSciUnitFormService.deleteSciUnitForm(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
