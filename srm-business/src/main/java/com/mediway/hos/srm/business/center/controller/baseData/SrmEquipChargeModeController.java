package com.mediway.hos.srm.business.center.controller.baseData;



import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.base.model.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataPlatformDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mediway.hos.srm.business.center.model.dto.baseData.EquipChargeModeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.EquipChargeModeVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmEquipChargeModeService;


/**
 * <p>
 * 设备收费模式
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/equipChargeMode")
@Api(tags = "设备收费模式")
public class SrmEquipChargeModeController {

    @Autowired
    private SrmEquipChargeModeService srmEquipChargeModeService;

    @PostMapping({"/saveOrUpdateEquipChargeMode"})
    public BaseResponse saveOrUpdateEquipChargeMode(@RequestBody BaseDataPlatformDto baseDataPlatformDto) {
        Long RowId = srmEquipChargeModeService.saveOrUpdateEquipChargeMode(baseDataPlatformDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailEquipChargeMode(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        EquipChargeModeVo equipChargeModeVo = srmEquipChargeModeService.getDetailEquipChargeMode(RowId);
        return BaseResponse.success(equipChargeModeVo);
    }

    @PostMapping({"/listEquipChargeMode"})
    public BaseResponse listEquipChargeMode(@RequestBody EquipChargeModeDto equipChargeModeDto) {
        IPage<EquipChargeModeVo> list = srmEquipChargeModeService.listEquipChargeMode(equipChargeModeDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteEquipChargeMode"})
    public BaseResponse deleteEquipChargeMode(@RequestBody BaseDto baseDto) {
        srmEquipChargeModeService.deleteEquipChargeMode(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
