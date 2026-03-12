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

import com.mediway.hos.srm.business.center.model.dto.baseData.UnitOrderDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.UnitOrderVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmUnitOrderService;

/**
 * <p>
 * 单位排序
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/unitOrder")
@Api(tags = "单位排序")
public class SrmUnitOrderController {

    @Autowired
    private SrmUnitOrderService srmUnitOrderService;

    @PostMapping({"/saveOrUpdateUnitOrder"})
    public BaseResponse saveOrUpdateUnitOrder(@RequestBody BaseDataProjDto baseDataProjDto) {
        Long RowId = srmUnitOrderService.saveOrUpdateUnitOrder(baseDataProjDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailUnitOrder(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        UnitOrderVo unitOrderVo = srmUnitOrderService.getDetailUnitOrder(RowId);
        return BaseResponse.success(unitOrderVo);
    }

    @PostMapping({"/listUnitOrder"})
    public BaseResponse listUnitOrder(@RequestBody UnitOrderDto unitOrderDto) {
        IPage<UnitOrderVo> list = srmUnitOrderService.listUnitOrder(unitOrderDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteUnitOrder"})
    public BaseResponse deleteUnitOrder(@RequestBody BaseDto baseDto) {
        srmUnitOrderService.deleteUnitOrder(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
