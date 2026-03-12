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

import com.mediway.hos.srm.business.center.service.baseData.SrmAchvTransGranteeTypeService;
import com.mediway.hos.srm.business.center.model.dto.baseData.AchvTransGranteeTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.AchvTransGranteeTypeVo;

/**
 * <p>
 * 成果转化受让单位类型
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/achvTransGranteeType")
@Api(tags = "成果转化受让单位类型")
public class SrmAchvTransGranteeTypeController {
    @Autowired
    private SrmAchvTransGranteeTypeService srmAchvTransGranteeTypeService;

    @PostMapping({"/saveOrUpdateAchvTransGranteeType"})
    public BaseResponse saveOrUpdateAchvTransGranteeType(@RequestBody BaseDataLearningDto baseDataLearningDto) {
        Long RowId = srmAchvTransGranteeTypeService.saveOrUpdateAchvTransGranteeType(baseDataLearningDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailAchvTransGranteeType(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        AchvTransGranteeTypeVo achvTransGranteeTypeVo = srmAchvTransGranteeTypeService.getDetailAchvTransGranteeType(RowId);
        return BaseResponse.success(achvTransGranteeTypeVo);
    }

    @PostMapping({"/listAchvTransGranteeType"})
    public BaseResponse listAchvTransGranteeType(@RequestBody AchvTransGranteeTypeDto achvTransGranteeTypeDto) {
        IPage<AchvTransGranteeTypeVo> list = srmAchvTransGranteeTypeService.listAchvTransGranteeType(achvTransGranteeTypeDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteAchvTransGranteeType"})
    public BaseResponse deleteAchvTransGranteeType(@RequestBody BaseDto baseDto) {
        srmAchvTransGranteeTypeService.deleteAchvTransGranteeType(baseDto);
        return BaseResponse.success("删除成功!");

    }


}
