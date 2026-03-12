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

import com.mediway.hos.srm.business.center.model.dto.baseData.LocationDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.LocationVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmLocationService;


/**
 * <p>
 * 省市县
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/location")
@Api(tags = "省市县")
public class SrmLocationController {

    @Autowired
    private SrmLocationService srmLocationService;

    @PostMapping({"/saveOrUpdateLocation"})
    public BaseResponse saveOrUpdateLocation(@RequestBody BaseDataProjDto baseDataProjDto) {
        Long RowId = srmLocationService.saveOrUpdateLocation(baseDataProjDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailLocation(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        LocationVo locationVo = srmLocationService.getDetailLocation(RowId);
        return BaseResponse.success(locationVo);
    }

    @PostMapping({"/listLocation"})
    public BaseResponse listLocation(@RequestBody LocationDto locationDto) {
        IPage<LocationVo> list = srmLocationService.listLocation(locationDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteLocation"})
    public BaseResponse deleteLocation(@RequestBody BaseDto baseDto) {
        srmLocationService.deleteLocation(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
