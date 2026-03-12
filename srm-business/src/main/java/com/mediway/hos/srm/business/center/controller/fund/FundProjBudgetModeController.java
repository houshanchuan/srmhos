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

import com.mediway.hos.srm.business.center.model.dto.fund.FundProjBudgetModeDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundProjBudgetModeVo;
import com.mediway.hos.srm.business.center.service.fund.FundProjBudgetModeService;

/**
 * <p>
 * 项目预算编制模式
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
@RestController
@RequestMapping("srm/fundProjBudgetMode")
@Api(tags = "项目预算编制模式")
public class FundProjBudgetModeController {

    @Autowired
    private FundProjBudgetModeService fundProjBudgetModeService;

    @PostMapping({"/saveOrUpdateFundProjBudgetMode"})
    public BaseResponse saveOrUpdateFundProjBudgetMode(@RequestBody BaseDataFundDto baseDataFundDto) {
        Long RowId = fundProjBudgetModeService.saveOrUpdateFundProjBudgetMode(baseDataFundDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailFundProjBudgetMode(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        FundProjBudgetModeVo fundProjBudgetModeVo = fundProjBudgetModeService.getDetailFundProjBudgetMode(RowId);
        return BaseResponse.success(fundProjBudgetModeVo);
    }

    @PostMapping({"/listFundProjBudgetMode"})
    public BaseResponse listFundProjBudgetMode(@RequestBody FundProjBudgetModeDto fundProjBudgetModeDto) {
        IPage<FundProjBudgetModeVo> list = fundProjBudgetModeService.listFundProjBudgetMode(fundProjBudgetModeDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteFundProjBudgetMode"})
    public BaseResponse deleteFundProjBudgetMode(@RequestBody BaseDto baseDto) {
        fundProjBudgetModeService.deleteFundProjBudgetMode(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
