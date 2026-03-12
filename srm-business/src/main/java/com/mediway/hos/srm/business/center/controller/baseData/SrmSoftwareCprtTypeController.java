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

import com.mediway.hos.srm.business.center.service.baseData.SrmSoftwareCprtTypeService;
import com.mediway.hos.srm.business.center.model.dto.baseData.SoftwareCpRtTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.SoftwareCpRtTypeVo;

/**
 * <p>
 * 软著类型
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/softwareCprtType")
@Api(tags = "软著类型")
public class SrmSoftwareCprtTypeController {

    @Autowired
    private SrmSoftwareCprtTypeService srmSoftwareCprtTypeService;

    @PostMapping({"/saveOrUpdateSoftwareCprtType"})
    public BaseResponse saveOrUpdateSoftwareCprtType(@RequestBody BaseDataLearningDto baseDataLearningDto) {
        Long RowId = srmSoftwareCprtTypeService.saveOrUpdateSoftwareCprtType(baseDataLearningDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailSoftwareCprtType(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        SoftwareCpRtTypeVo softwareCprtTypeVo = srmSoftwareCprtTypeService.getDetailSoftwareCprtType(RowId);
        return BaseResponse.success(softwareCprtTypeVo);
    }

    @PostMapping({"/listSoftwareCprtType"})
    public BaseResponse listSoftwareCprtType(@RequestBody SoftwareCpRtTypeDto softwareCprtTypeDto) {
        IPage<SoftwareCpRtTypeVo> list = srmSoftwareCprtTypeService.listSoftwareCprtType(softwareCprtTypeDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteSoftwareCprtType"})
    public BaseResponse deleteSoftwareCprtType(@RequestBody BaseDto baseDto) {
        srmSoftwareCprtTypeService.deleteSoftwareCprtType(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
