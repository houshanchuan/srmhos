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

import com.mediway.hos.srm.business.center.model.dto.baseData.TitleLevelDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.TitleLevelVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmTitleLevelService;
/**
 * <p>
 * 职称级别
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/titleLevel")
@Api(tags = "职称级别")
public class SrmTitleLevelController {

    @Autowired
    private SrmTitleLevelService srmTitleLevelService;

    @PostMapping({"/saveOrUpdateTitleLevel"})
    public BaseResponse saveOrUpdateTitleLevel(@RequestBody BaseDataUserDto baseDataUserDto) {
        Long RowId = srmTitleLevelService.saveOrUpdateTitleLevel(baseDataUserDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailTitleLevel(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        TitleLevelVo titleLevelVo = srmTitleLevelService.getDetailTitleLevel(RowId);
        return BaseResponse.success(titleLevelVo);
    }

    @PostMapping({"/listTitleLevel"})
    public BaseResponse listTitleLevel(@RequestBody TitleLevelDto titleLevelDto) {
        IPage<TitleLevelVo> list = srmTitleLevelService.listTitleLevel(titleLevelDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteTitleLevel"})
    public BaseResponse deleteTitleLevel(@RequestBody BaseDto baseDto) {
        srmTitleLevelService.deleteTitleLevel(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
