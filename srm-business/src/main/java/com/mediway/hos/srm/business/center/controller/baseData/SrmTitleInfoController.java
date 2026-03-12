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
import com.mediway.hos.srm.business.center.model.dto.baseData.TitleInfoDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.TitleInfoVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmTitleInfoService;
/**
 * <p>
 * 职称表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/titleInfo")
@Api(tags = "职称表")
public class SrmTitleInfoController {

    @Autowired
    private SrmTitleInfoService srmTitleInfoService;

    @PostMapping({"/saveOrUpdateTitleInfo"})
    public BaseResponse saveOrUpdateTitleInfo(@RequestBody BaseDataUserDto baseDataUserDto) {
        Long RowId = srmTitleInfoService.saveOrUpdateTitleInfo(baseDataUserDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailTitleInfo(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        TitleInfoVo titleInfoVo = srmTitleInfoService.getDetailTitleInfo(RowId);
        return BaseResponse.success(titleInfoVo);
    }

    @PostMapping({"/listTitleInfo"})
    public BaseResponse listTitleInfo(@RequestBody TitleInfoDto titleInfoDto) {
        IPage<TitleInfoVo> list = srmTitleInfoService.listTitleInfo(titleInfoDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteTitleInfo"})
    public BaseResponse deleteTitleInfo(@RequestBody BaseDto baseDto) {
        srmTitleInfoService.deleteTitleInfo(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
