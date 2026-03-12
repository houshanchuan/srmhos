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

import com.mediway.hos.srm.business.center.model.dto.baseData.EquipBookexeStateDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.EquipBookexeStateVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmEquipBookexeStateService;

/**
 * <p>
 * 设备预约执行状态
 * </p>
 *
 * @author 代码生成器
 * @since 2024-12-09
 */
@RestController
@RequestMapping("srm/equipBookexeState")
@Api(tags = "设备预约执行状态")
public class SrmEquipBookexeStateController {

    @Autowired
    private SrmEquipBookexeStateService srmEquipBookexeStateService;

    @PostMapping({"/saveOrUpdateEquipBookexeState"})
    public BaseResponse saveOrUpdateEquipBookexeState(@RequestBody BaseDataPlatformDto baseDataPlatformDto) {
        Long RowId = srmEquipBookexeStateService.saveOrUpdateEquipBookexeState(baseDataPlatformDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailEquipBookexeState(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        EquipBookexeStateVo equipBookexeStateVo = srmEquipBookexeStateService.getDetailEquipBookexeState(RowId);
        return BaseResponse.success(equipBookexeStateVo);
    }

    @PostMapping({"/listEquipBookexeState"})
    public BaseResponse listEquipBookexeState(@RequestBody EquipBookexeStateDto equipBookexeStateDto) {
        IPage<EquipBookexeStateVo> list = srmEquipBookexeStateService.listEquipBookexeState(equipBookexeStateDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteEquipBookexeState"})
    public BaseResponse deleteEquipBookexeState(@RequestBody BaseDto baseDto) {
        srmEquipBookexeStateService.deleteEquipBookexeState(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
