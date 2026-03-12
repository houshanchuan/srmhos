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

import com.mediway.hos.srm.business.center.service.baseData.SrmAchvAuthorTypeService;
import com.mediway.hos.srm.business.center.model.dto.baseData.AchvAuthorTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.AchvAuthorTypeVo;


/**
 * <p>
 * 科研成果作者类型
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/achvAuthorType")
@Api(tags = "科研成果作者类型")
public class SrmAchvAuthorTypeController {
    @Autowired
    private SrmAchvAuthorTypeService srmAchvAuthorTypeService;

    @PostMapping({"/saveOrUpdateAchvAuthorType"})
    public BaseResponse saveOrUpdateAchvAuthorType(@RequestBody BaseDataLearningDto baseDataLearningDto) {
        Long RowId = srmAchvAuthorTypeService.saveOrUpdateAchvAuthorType(baseDataLearningDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailAchvAuthorType(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        AchvAuthorTypeVo achvAuthorTypeVo = srmAchvAuthorTypeService.getDetailAchvAuthorType(RowId);
        return BaseResponse.success(achvAuthorTypeVo);
    }

    @PostMapping({"/listAchvAuthorType"})
    public BaseResponse listAchvAuthorType(@RequestBody AchvAuthorTypeDto achvAuthorTypeDto) {
        IPage<AchvAuthorTypeVo> list = srmAchvAuthorTypeService.listAchvAuthorType(achvAuthorTypeDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteAchvAuthorType"})
    public BaseResponse deleteAchvAuthorType(@RequestBody BaseDto baseDto) {
        srmAchvAuthorTypeService.deleteAchvAuthorType(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
