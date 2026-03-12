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

import com.mediway.hos.srm.business.center.model.dto.baseData.RelyUnitDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.RelyUnitVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmRelyUnitService;

/**
 * <p>
 * 单位表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/relyUnit")
@Api(tags = "单位表")
public class SrmRelyUnitController {
    @Autowired
    private SrmRelyUnitService srmRelyUnitService;

    @PostMapping({"/saveOrUpdateRelyUnit"})
    public BaseResponse saveOrUpdateRelyUnit(@RequestBody BaseDataUserDto baseDataUserDto) {
        Long RowId = srmRelyUnitService.saveOrUpdateRelyUnit(baseDataUserDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailRelyUnit(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        RelyUnitVo relyUnitVo = srmRelyUnitService.getDetailRelyUnit(RowId);
        return BaseResponse.success(relyUnitVo);
    }

    @PostMapping({"/listRelyUnit"})
    public BaseResponse listRelyUnit(@RequestBody RelyUnitDto relyUnitDto) {
        IPage<RelyUnitVo> list = srmRelyUnitService.listRelyUnit(relyUnitDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteRelyUnit"})
    public BaseResponse deleteRelyUnit(@RequestBody BaseDto baseDto) {
        srmRelyUnitService.deleteRelyUnit(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
