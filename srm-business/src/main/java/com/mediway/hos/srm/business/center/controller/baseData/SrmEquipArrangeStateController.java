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

import com.mediway.hos.srm.business.center.model.dto.baseData.EquipArrangeStateDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.EquipArrangeStateVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmEquipArrangeStateService;


/**
 * <p>
 * 设备排班状态
 * </p>
 *
 * @author 代码生成器
 * @since 2024-12-09
 */
@RestController
@RequestMapping("srm/equipArrangeState")
@Api(tags = "设备排班状态")
public class SrmEquipArrangeStateController {


    @Autowired
    private SrmEquipArrangeStateService srmEquipArrangeStateService;

    @PostMapping({"/saveOrUpdateEquipArrangeState"})
    public BaseResponse saveOrUpdateEquipArrangeState(@RequestBody BaseDataPlatformDto baseDataPlatformDto) {
        Long RowId = srmEquipArrangeStateService.saveOrUpdateEquipArrangeState(baseDataPlatformDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailEquipArrangeState(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        EquipArrangeStateVo equipArrangeStateVo = srmEquipArrangeStateService.getDetailEquipArrangeState(RowId);
        return BaseResponse.success(equipArrangeStateVo);
    }

    @PostMapping({"/listEquipArrangeState"})
    public BaseResponse listEquipArrangeState(@RequestBody EquipArrangeStateDto equipArrangeStateDto) {
        IPage<EquipArrangeStateVo> list = srmEquipArrangeStateService.listEquipArrangeState(equipArrangeStateDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteEquipArrangeState"})
    public BaseResponse deleteEquipArrangeState(@RequestBody BaseDto baseDto) {
        srmEquipArrangeStateService.deleteEquipArrangeState(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
