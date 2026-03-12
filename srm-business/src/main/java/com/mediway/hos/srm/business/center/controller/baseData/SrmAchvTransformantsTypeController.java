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
import com.mediway.hos.srm.business.center.service.baseData.SrmAchvTransformantsTypeService;
import com.mediway.hos.srm.business.center.model.dto.baseData.AchvTransformantsTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.AchvTransformantsTypeVo;

/**
 * <p>
 * 成果转化物类型
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-01
 */
@RestController
@RequestMapping("srm/achvTransformantsType")
@Api(tags = "成果转化物类型")
public class SrmAchvTransformantsTypeController {

    @Autowired
    private SrmAchvTransformantsTypeService srmAchvTransformantsTypeService;

    @PostMapping({"/saveOrUpdateAchvTransformantsType"})
    public BaseResponse saveOrUpdateAchvTransformantsType(@RequestBody BaseDataLearningDto baseDataLearningDto) {
        Long RowId = srmAchvTransformantsTypeService.saveOrUpdateAchvTransformantsType(baseDataLearningDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailAchvTransformantsType(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        AchvTransformantsTypeVo achvTransformantsTypeVo = srmAchvTransformantsTypeService.getDetailAchvTransformantsType(RowId);
        return BaseResponse.success(achvTransformantsTypeVo);
    }

    @PostMapping({"/listAchvTransformantsType"})
    public BaseResponse listAchvTransformantsType(@RequestBody AchvTransformantsTypeDto achvTransformantsTypeDto) {
        IPage<AchvTransformantsTypeVo> list = srmAchvTransformantsTypeService.listAchvTransformantsType(achvTransformantsTypeDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteAchvTransformantsType"})
    public BaseResponse deleteAchvTransformantsType(@RequestBody BaseDto baseDto) {
        srmAchvTransformantsTypeService.deleteAchvTransformantsType(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
