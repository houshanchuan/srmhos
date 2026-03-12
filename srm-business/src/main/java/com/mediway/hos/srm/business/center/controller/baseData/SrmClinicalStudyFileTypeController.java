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

import com.mediway.hos.srm.business.center.model.dto.baseData.ClinicalStudyFileTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ClinicalStudyFileTypeVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmClinicalStudyFileTypeService;


/**
 * <p>
 * 临床试验研究项目附件类型表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/clinicalStudyFileType")
@Api(tags = "临床试验研究项目附件类型表")
public class SrmClinicalStudyFileTypeController {

    @Autowired
    private SrmClinicalStudyFileTypeService srmClinicalStudyFileTypeService;

    @PostMapping({"/saveOrUpdateClinicalStudyFileType"})
    public BaseResponse saveOrUpdateClinicalStudyFileType(@RequestBody BaseDataProjDto baseDataProjDto) {
        Long RowId = srmClinicalStudyFileTypeService.saveOrUpdateClinicalStudyFileType(baseDataProjDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailClinicalStudyFileType(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        ClinicalStudyFileTypeVo clinicalStudyFileTypeVo = srmClinicalStudyFileTypeService.getDetailClinicalStudyFileType(RowId);
        return BaseResponse.success(clinicalStudyFileTypeVo);
    }

    @PostMapping({"/listClinicalStudyFileType"})
    public BaseResponse listClinicalStudyFileType(@RequestBody ClinicalStudyFileTypeDto clinicalStudyFileTypeDto) {
        IPage<ClinicalStudyFileTypeVo> list = srmClinicalStudyFileTypeService.listClinicalStudyFileType(clinicalStudyFileTypeDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteClinicalStudyFileType"})
    public BaseResponse deleteClinicalStudyFileType(@RequestBody BaseDto baseDto) {
        srmClinicalStudyFileTypeService.deleteClinicalStudyFileType(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
