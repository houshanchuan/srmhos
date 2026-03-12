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
import com.mediway.hos.srm.business.center.service.baseData.SrmPatentTypeService;
import com.mediway.hos.srm.business.center.model.dto.baseData.PatentTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.PatentTypeVo;

/**
 * <p>
 * 专利类型
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/patentType")
@Api(tags = "专利类型")
public class SrmPatentTypeController {
    @Autowired
    private SrmPatentTypeService srmPatentTypeService;

    @PostMapping({"/saveOrUpdatePatentType"})
    public BaseResponse saveOrUpdatePatentType(@RequestBody BaseDataLearningDto baseDataLearningDto) {
        Long RowId = srmPatentTypeService.saveOrUpdatePatentType(baseDataLearningDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailPatentType(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        PatentTypeVo patentTypeVo = srmPatentTypeService.getDetailPatentType(RowId);
        return BaseResponse.success(patentTypeVo);
    }

    @PostMapping({"/listPatentType"})
    public BaseResponse listPatentType(@RequestBody PatentTypeDto patentTypeDto) {
        IPage<PatentTypeVo> list = srmPatentTypeService.listPatentType(patentTypeDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deletePatentType"})
    public BaseResponse deletePatentType(@RequestBody BaseDto baseDto) {
        srmPatentTypeService.deletePatentType(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
