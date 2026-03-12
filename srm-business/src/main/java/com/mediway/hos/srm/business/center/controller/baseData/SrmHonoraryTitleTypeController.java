package com.mediway.hos.srm.business.center.controller.baseData;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.base.model.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataUserDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mediway.hos.srm.business.center.model.dto.baseData.HonoraryTitleTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.HonoraryTitleTypeVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmHonoraryTitleTypeService;


/**
 * <p>
 * 荣誉称号
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/honoraryTitleType")
@Api(tags = "荣誉称号")
public class SrmHonoraryTitleTypeController {

    @Autowired
    private SrmHonoraryTitleTypeService srmHonoraryTitleTypeService;

    @PostMapping({"/saveOrUpdateHonoraryTitleType"})
    public BaseResponse saveOrUpdateHonoraryTitleType(@RequestBody BaseDataUserDto baseDataUserDto) {
        Long RowId = srmHonoraryTitleTypeService.saveOrUpdateHonoraryTitleType(baseDataUserDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailHonoraryTitleType(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        HonoraryTitleTypeVo honoraryTitleTypeVo = srmHonoraryTitleTypeService.getDetailHonoraryTitleType(RowId);
        return BaseResponse.success(honoraryTitleTypeVo);
    }

    @PostMapping({"/listHonoraryTitleType"})
    public BaseResponse listHonoraryTitleType(@RequestBody HonoraryTitleTypeDto honoraryTitleTypeDto) {
        IPage<HonoraryTitleTypeVo> list = srmHonoraryTitleTypeService.listHonoraryTitleType(honoraryTitleTypeDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteHonoraryTitleType"})
    public BaseResponse deleteHonoraryTitleType(@RequestBody BaseDto baseDto) {
        srmHonoraryTitleTypeService.deleteHonoraryTitleType(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
