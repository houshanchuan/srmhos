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

import com.mediway.hos.srm.business.center.model.dto.baseData.EquipStatusDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.EquipStatusVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmEquipStatusService;


/**
 * <p>
 * 机构设备状态
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/equipStatus")
@Api(tags = "机构设备状态")
public class SrmEquipStatusController {

    @Autowired
    private SrmEquipStatusService srmEquipStatusService;

    @PostMapping({"/saveOrUpdateEquipStatus"})
    public BaseResponse saveOrUpdateEquipStatus(@RequestBody BaseDataPlatformDto baseDataPlatformDto) {
        Long RowId = srmEquipStatusService.saveOrUpdateEquipStatus(baseDataPlatformDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailEquipStatus(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        EquipStatusVo equipStatusVo = srmEquipStatusService.getDetailEquipStatus(RowId);
        return BaseResponse.success(equipStatusVo);
    }

    @PostMapping({"/listEquipStatus"})
    public BaseResponse listEquipStatus(@RequestBody EquipStatusDto equipStatusDto) {
        IPage<EquipStatusVo> list = srmEquipStatusService.listEquipStatus(equipStatusDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteEquipStatus"})
    public BaseResponse deleteEquipStatus(@RequestBody BaseDto baseDto) {
        srmEquipStatusService.deleteEquipStatus(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
