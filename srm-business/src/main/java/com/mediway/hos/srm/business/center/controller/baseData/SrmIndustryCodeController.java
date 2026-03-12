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

import com.mediway.hos.srm.business.center.model.dto.baseData.IndustryCodeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.IndustryCodeVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmIndustryCodeService;


/**
 * <p>
 * 行业代码
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/industryCode")
@Api(tags = "行业代码")
public class SrmIndustryCodeController {

    @Autowired
    private SrmIndustryCodeService srmIndustryCodeService;

    @PostMapping({"/saveOrUpdateIndustryCode"})
    public BaseResponse saveOrUpdateIndustryCode(@RequestBody BaseDataProjDto baseDataProjDto) {
        Long RowId = srmIndustryCodeService.saveOrUpdateIndustryCode(baseDataProjDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailIndustryCode(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        IndustryCodeVo industryCodeVo = srmIndustryCodeService.getDetailIndustryCode(RowId);
        return BaseResponse.success(industryCodeVo);
    }

    @PostMapping({"/listIndustryCode"})
    public BaseResponse listIndustryCode(@RequestBody IndustryCodeDto industryCodeDto) {
        IPage<IndustryCodeVo> list = srmIndustryCodeService.listIndustryCode(industryCodeDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteIndustryCode"})
    public BaseResponse deleteIndustryCode(@RequestBody BaseDto baseDto) {
        srmIndustryCodeService.deleteIndustryCode(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
