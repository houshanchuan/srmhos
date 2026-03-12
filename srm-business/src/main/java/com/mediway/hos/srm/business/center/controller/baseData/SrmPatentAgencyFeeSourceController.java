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

import com.mediway.hos.srm.business.center.service.baseData.SrmPatentAgencyFeeSourceService;
import com.mediway.hos.srm.business.center.model.dto.baseData.PatentAgencyFeeSourceDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.PatentAgencyFeeSourceVo;
/**
 * <p>
 * 专利代理费用来源
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/patentAgencyFeeSource")
@Api(tags = "专利代理费用来源")
public class SrmPatentAgencyFeeSourceController {
    @Autowired
    private SrmPatentAgencyFeeSourceService srmPatentAgencyFeeSourceService;

    @PostMapping({"/saveOrUpdatePatentAgencyFeeSource"})
    public BaseResponse saveOrUpdatePatentAgencyFeeSource(@RequestBody BaseDataLearningDto baseDataLearningDto) {
        Long RowId = srmPatentAgencyFeeSourceService.saveOrUpdatePatentAgencyFeeSource(baseDataLearningDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailPatentAgencyFeeSource(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        PatentAgencyFeeSourceVo patentAgencyFeeSourceVo = srmPatentAgencyFeeSourceService.getDetailPatentAgencyFeeSource(RowId);
        return BaseResponse.success(patentAgencyFeeSourceVo);
    }

    @PostMapping({"/listPatentAgencyFeeSource"})
    public BaseResponse listPatentAgencyFeeSource(@RequestBody PatentAgencyFeeSourceDto patentAgencyFeeSourceDto) {
        IPage<PatentAgencyFeeSourceVo> list = srmPatentAgencyFeeSourceService.listPatentAgencyFeeSource(patentAgencyFeeSourceDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deletePatentAgencyFeeSource"})
    public BaseResponse deletePatentAgencyFeeSource(@RequestBody BaseDto baseDto) {
        srmPatentAgencyFeeSourceService.deletePatentAgencyFeeSource(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
