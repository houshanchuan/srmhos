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

import com.mediway.hos.srm.business.center.model.dto.baseData.TitleTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.TitleTypeVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmTitleTypeService;
/**
 * <p>
 * 职称类型
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/titleType")
@Api(tags = "职称类型")
public class SrmTitleTypeController {
    @Autowired
    private SrmTitleTypeService srmTitleTypeService;

    @PostMapping({"/saveOrUpdateTitleType"})
    public BaseResponse saveOrUpdateTitleType(@RequestBody BaseDataUserDto baseDataUserDto) {
        Long RowId = srmTitleTypeService.saveOrUpdateTitleType(baseDataUserDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailTitleType(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        TitleTypeVo titleTypeVo = srmTitleTypeService.getDetailTitleType(RowId);
        return BaseResponse.success(titleTypeVo);
    }

    @PostMapping({"/listTitleType"})
    public BaseResponse listTitleType(@RequestBody TitleTypeDto titleTypeDto) {
        IPage<TitleTypeVo> list = srmTitleTypeService.listTitleType(titleTypeDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteTitleType"})
    public BaseResponse deleteTitleType(@RequestBody BaseDto baseDto) {
        srmTitleTypeService.deleteTitleType(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
