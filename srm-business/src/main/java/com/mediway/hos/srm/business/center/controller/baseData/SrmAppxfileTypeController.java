package com.mediway.hos.srm.business.center.controller.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.base.model.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.mediway.hos.srm.business.center.model.dto.baseData.AppxfileTypeDetailDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mediway.hos.srm.business.center.model.dto.baseData.AppxfileTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.AppxfileTypeVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmAppxfileTypeService;

/**
 * <p>
 * 附件文件类型定义表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/appxfileType")
@Api(tags = "附件文件类型定义表")
public class SrmAppxfileTypeController {

    @Autowired
    private SrmAppxfileTypeService srmAppxfileTypeService;

    @PostMapping({"/saveOrUpdateAppxfileType"})
    public BaseResponse saveOrUpdateAppxfileType(@RequestBody AppxfileTypeDto appxfileTypeDto) {
        Long RowId = srmAppxfileTypeService.saveOrUpdateAppxfileType(appxfileTypeDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailAppxfileType(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        AppxfileTypeVo appxfileTypeVo = srmAppxfileTypeService.getDetailAppxfileType(RowId);
        return BaseResponse.success(appxfileTypeVo);
    }

    @PostMapping({"/listAppxfileType"})
    public BaseResponse listAppxfileType(@RequestBody AppxfileTypeDetailDto appxfileTypeDetailDto) {
        IPage<AppxfileTypeVo> list = srmAppxfileTypeService.listAppxfileType(appxfileTypeDetailDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteAppxfileType"})
    public BaseResponse deleteAppxfileType(@RequestBody BaseDto baseDto) {
        srmAppxfileTypeService.deleteAppxfileType(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
