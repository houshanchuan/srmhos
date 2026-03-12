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

import com.mediway.hos.srm.business.center.model.dto.baseData.ParttimeTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ParttimeTypeVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmParttimeTypeService;

/**
 * <p>
 * 兼职类型
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/parttimeType")
@Api(tags = "兼职类型")
public class SrmParttimeTypeController {

    @Autowired
    private SrmParttimeTypeService srmParttimeTypeService;

    @PostMapping({"/saveOrUpdateParttimeType"})
    public BaseResponse saveOrUpdateParttimeType(@RequestBody BaseDataLearningDto baseDataLearningDto) {
        Long RowId = srmParttimeTypeService.saveOrUpdateParttimeType(baseDataLearningDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailParttimeType(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        ParttimeTypeVo parttimeTypeVo = srmParttimeTypeService.getDetailParttimeType(RowId);
        return BaseResponse.success(parttimeTypeVo);
    }

    @PostMapping({"/listParttimeType"})
    public BaseResponse listParttimeType(@RequestBody ParttimeTypeDto parttimeTypeDto) {
        IPage<ParttimeTypeVo> list = srmParttimeTypeService.listParttimeType(parttimeTypeDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteParttimeType"})
    public BaseResponse deleteParttimeType(@RequestBody BaseDto baseDto) {
        srmParttimeTypeService.deleteParttimeType(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
