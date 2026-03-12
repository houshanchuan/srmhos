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

import com.mediway.hos.srm.business.center.service.baseData.SrmPublishAddressTypeService;
import com.mediway.hos.srm.business.center.model.dto.baseData.PublishAddressTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.PublishAddressTypeVo;


/**
 * <p>
 * 发表地点类型表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/publishAddressType")
@Api(tags = "发表地点类型表")
public class SrmPublishAddressTypeController {
    @Autowired
    private SrmPublishAddressTypeService srmPublishAddressTypeService;

    @PostMapping({"/saveOrUpdatePublishAddressType"})
    public BaseResponse saveOrUpdatePublishAddressType(@RequestBody BaseDataLearningDto baseDataLearningDto) {
        Long RowId = srmPublishAddressTypeService.saveOrUpdatePublishAddressType(baseDataLearningDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailPublishAddressType(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        PublishAddressTypeVo publishAddressTypeVo = srmPublishAddressTypeService.getDetailPublishAddressType(RowId);
        return BaseResponse.success(publishAddressTypeVo);
    }

    @PostMapping({"/listPublishAddressType"})
    public BaseResponse listPublishAddressType(@RequestBody PublishAddressTypeDto publishAddressTypeDto) {
        IPage<PublishAddressTypeVo> list = srmPublishAddressTypeService.listPublishAddressType(publishAddressTypeDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deletePublishAddressType"})
    public BaseResponse deletePublishAddressType(@RequestBody BaseDto baseDto) {
        srmPublishAddressTypeService.deletePublishAddressType(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
