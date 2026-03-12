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
import com.mediway.hos.srm.business.center.model.dto.baseData.SocEconomicObjDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.SocEconomicObjVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmSocEconomicObjService;
/**
 * <p>
 * 社会经济目标
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/socEconomicObj")
@Api(tags = "社会经济目标")
public class SrmSocEconomicObjController {

    @Autowired
    private SrmSocEconomicObjService srmSocEconomicObjService;

    @PostMapping({"/saveOrUpdateSocEconomicObj"})
    public BaseResponse saveOrUpdateSocEconomicObj(@RequestBody BaseDataProjDto baseDataProjDto) {
        Long RowId = srmSocEconomicObjService.saveOrUpdateSocEconomicObj(baseDataProjDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailSocEconomicObj(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        SocEconomicObjVo socEconomicObjVo = srmSocEconomicObjService.getDetailSocEconomicObj(RowId);
        return BaseResponse.success(socEconomicObjVo);
    }

    @PostMapping({"/listSocEconomicObj"})
    public BaseResponse listSocEconomicObj(@RequestBody SocEconomicObjDto socEconomicObjDto) {
        IPage<SocEconomicObjVo> list = srmSocEconomicObjService.listSocEconomicObj(socEconomicObjDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteSocEconomicObj"})
    public BaseResponse deleteSocEconomicObj(@RequestBody BaseDto baseDto) {
        srmSocEconomicObjService.deleteSocEconomicObj(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
