package com.mediway.hos.srm.business.center.controller.fund;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.base.model.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataFundDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mediway.hos.srm.business.center.model.dto.fund.FundItemCalUnitDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundItemCalUnitVo;
import com.mediway.hos.srm.business.center.service.fund.FundItemCalUnitService;

/**
 * <p>
 * 预算项计量单位
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
@RestController
@RequestMapping("srm/fundItemCalUnit")
@Api(tags = "预算项计量单位")
public class FundItemCalUnitController {

    @Autowired
    private FundItemCalUnitService fundItemCalUnitService;

    @PostMapping({"/saveOrUpdateFundItemCalUnit"})
    public BaseResponse saveOrUpdateFundItemCalUnit(@RequestBody BaseDataFundDto baseDataFundDto) {
        Long RowId = fundItemCalUnitService.saveOrUpdateFundItemCalUnit(baseDataFundDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailFundItemCalUnit(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        FundItemCalUnitVo fundItemCalUnitVo = fundItemCalUnitService.getDetailFundItemCalUnit(RowId);
        return BaseResponse.success(fundItemCalUnitVo);
    }

    @PostMapping({"/listFundItemCalUnit"})
    public BaseResponse listFundItemCalUnit(@RequestBody FundItemCalUnitDto fundItemCalUnitDto) {
        IPage<FundItemCalUnitVo> list = fundItemCalUnitService.listFundItemCalUnit(fundItemCalUnitDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteFundItemCalUnit"})
    public BaseResponse deleteFundItemCalUnit(@RequestBody BaseDto baseDto) {
        fundItemCalUnitService.deleteFundItemCalUnit(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
