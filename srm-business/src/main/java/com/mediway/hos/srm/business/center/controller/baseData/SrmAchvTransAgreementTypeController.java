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
import com.mediway.hos.srm.business.center.service.baseData.SrmAchvTransAgreementTypeService;
import com.mediway.hos.srm.business.center.model.dto.baseData.AchvTransAgreementTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.AchvTransAgreementTypeVo;
/**
 * <p>
 * 转化协议类型表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-01
 */
@RestController
@RequestMapping("srm/achvTransAgreementType")
@Api(tags = "转化协议类型表")
public class SrmAchvTransAgreementTypeController {
    @Autowired
    private SrmAchvTransAgreementTypeService srmAchvTransAgreementTypeService;

    @PostMapping({"/saveOrUpdateAchvTransAgreementType"})
    public BaseResponse saveOrUpdateAchvTransAgreementType(@RequestBody BaseDataLearningDto baseDataLearningDto) {
        Long RowId = srmAchvTransAgreementTypeService.saveOrUpdateAchvTransAgreementType(baseDataLearningDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailAchvTransAgreementType(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        AchvTransAgreementTypeVo achvTransAgreementTypeVo = srmAchvTransAgreementTypeService.getDetailAchvTransAgreementType(RowId);
        return BaseResponse.success(achvTransAgreementTypeVo);
    }

    @PostMapping({"/listAchvTransAgreementType"})
    public BaseResponse listAchvTransAgreementType(@RequestBody AchvTransAgreementTypeDto achvTransAgreementTypeDto) {
        IPage<AchvTransAgreementTypeVo> list = srmAchvTransAgreementTypeService.listAchvTransAgreementType(achvTransAgreementTypeDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteAchvTransAgreementType"})
    public BaseResponse deleteAchvTransAgreementType(@RequestBody BaseDto baseDto) {
        srmAchvTransAgreementTypeService.deleteAchvTransAgreementType(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
