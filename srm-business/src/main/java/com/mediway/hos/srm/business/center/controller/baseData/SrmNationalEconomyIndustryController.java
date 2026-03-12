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
import com.mediway.hos.srm.business.center.model.dto.baseData.NationalEconomyIndustryDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.NationalEconomyIndustryVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmNationalEconomyIndustryService;

/**
 * <p>
 * 国民经济行业
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/nationalEconomyIndustry")
@Api(tags = "国民经济行业")
public class SrmNationalEconomyIndustryController {

    @Autowired
    private SrmNationalEconomyIndustryService srmNationalEconomyIndustryService;

    @PostMapping({"/saveOrUpdateNationalEconomyIndustry"})
    public BaseResponse saveOrUpdateNationalEconomyIndustry(@RequestBody BaseDataProjDto baseDataProjDto) {
        Long RowId = srmNationalEconomyIndustryService.saveOrUpdateNationalEconomyIndustry(baseDataProjDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailNationalEconomyIndustry(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        NationalEconomyIndustryVo nationalEconomyIndustryVo = srmNationalEconomyIndustryService.getDetailNationalEconomyIndustry(RowId);
        return BaseResponse.success(nationalEconomyIndustryVo);
    }

    @PostMapping({"/listNationalEconomyIndustry"})
    public BaseResponse listNationalEconomyIndustry(@RequestBody NationalEconomyIndustryDto nationalEconomyIndustryDto) {
        IPage<NationalEconomyIndustryVo> list = srmNationalEconomyIndustryService.listNationalEconomyIndustry(nationalEconomyIndustryDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteNationalEconomyIndustry"})
    public BaseResponse deleteNationalEconomyIndustry(@RequestBody BaseDto baseDto) {
        srmNationalEconomyIndustryService.deleteNationalEconomyIndustry(baseDto);
        return BaseResponse.success("删除成功!");
    }

}
