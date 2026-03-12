package com.mediway.hos.srm.business.center.controller.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.base.model.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataUserDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mediway.hos.srm.business.center.model.dto.baseData.OccupationCategoryDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.OccupationCategoryVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmOccupationCategoryService;


/**
 * <p>
 * 职业类别
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/occupationCategory")
@Api(tags = "职业类别")
public class SrmOccupationCategoryController {

    @Autowired
    private SrmOccupationCategoryService srmOccupationCategoryService;

    @PostMapping({"/saveOrUpdateOccupationCategory"})
    public BaseResponse saveOrUpdateOccupationCategory(@RequestBody BaseDataUserDto baseDataUserDto) {
        Long RowId = srmOccupationCategoryService.saveOrUpdateOccupationCategory(baseDataUserDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailOccupationCategory(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        OccupationCategoryVo occupationCategoryVo = srmOccupationCategoryService.getDetailOccupationCategory(RowId);
        return BaseResponse.success(occupationCategoryVo);
    }

    @PostMapping({"/listOccupationCategory"})
    public BaseResponse listOccupationCategory(@RequestBody OccupationCategoryDto occupationCategoryDto) {
        IPage<OccupationCategoryVo> list = srmOccupationCategoryService.listOccupationCategory(occupationCategoryDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteOccupationCategory"})
    public BaseResponse deleteOccupationCategory(@RequestBody BaseDto baseDto) {
        srmOccupationCategoryService.deleteOccupationCategory(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
