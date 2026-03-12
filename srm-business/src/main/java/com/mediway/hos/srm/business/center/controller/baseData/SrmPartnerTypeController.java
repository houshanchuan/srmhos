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

import com.mediway.hos.srm.business.center.model.dto.baseData.PartnerTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.PartnerTypeVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmPartnerTypeService;

/**
 * <p>
 * 对方类型表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/partnerType")
@Api(tags = "对方类型表")
public class SrmPartnerTypeController {

    @Autowired
    private SrmPartnerTypeService srmPartnerTypeService;

    @PostMapping({"/saveOrUpdatePartnerType"})
    public BaseResponse saveOrUpdatePartnerType(@RequestBody BaseDataProjDto baseDataProjDto) {
        Long RowId = srmPartnerTypeService.saveOrUpdatePartnerType(baseDataProjDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailPartnerType(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        PartnerTypeVo partnerTypeVo = srmPartnerTypeService.getDetailPartnerType(RowId);
        return BaseResponse.success(partnerTypeVo);
    }

    @PostMapping({"/listPartnerType"})
    public BaseResponse listPartnerType(@RequestBody PartnerTypeDto partnerTypeDto) {
        IPage<PartnerTypeVo> list = srmPartnerTypeService.listPartnerType(partnerTypeDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deletePartnerType"})
    public BaseResponse deletePartnerType(@RequestBody BaseDto baseDto) {
        srmPartnerTypeService.deletePartnerType(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
