package com.mediway.hos.srm.business.center.controller.baseData;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.base.model.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataCommonDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mediway.hos.srm.business.center.model.dto.baseData.HospitalDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.HospitalVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmHospitalService;
/**
 * <p>
 * 医疗机构(医院)表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-25
 */
@RestController
@RequestMapping("srm/hospital")
@Api(tags = "医疗机构(医院)表")
public class SrmHospitalController {

    @Autowired
    private SrmHospitalService srmHospitalService;

    @PostMapping({"/saveOrUpdateSrmHospital"})
    public BaseResponse saveOrUpdateSrmHospital(@RequestBody BaseDataCommonDto baseDataCommonDto) {
        Long RowId = srmHospitalService.saveOrUpdateSrmHospital(baseDataCommonDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailSrmHospital(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        HospitalVo srmHospitalVo = srmHospitalService.getDetailSrmHospital(RowId);
        return BaseResponse.success(srmHospitalVo);
    }

    @PostMapping({"/listSrmHospital"})
    public BaseResponse listSrmHospital(@RequestBody HospitalDto hospitalDto) {
        IPage<HospitalVo> list = srmHospitalService.listSrmHospital(hospitalDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteSrmHospital"})
    public BaseResponse deleteSrmHospital(@RequestBody BaseDto baseDto) {
        srmHospitalService.deleteSrmHospital(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
