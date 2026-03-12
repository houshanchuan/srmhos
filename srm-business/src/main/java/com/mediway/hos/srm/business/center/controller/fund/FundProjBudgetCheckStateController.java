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

import com.mediway.hos.srm.business.center.model.dto.fund.FundProjBudgetCheckStateDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundProjBudgetCheckStateVo;
import com.mediway.hos.srm.business.center.service.fund.FundProjBudgetCheckStateService;



/**
 * <p>
 * 项目预算审核状态
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
@RestController
@RequestMapping("srm/fundProjBudgetCheckState")
@Api(tags = "项目预算审核状态")
public class FundProjBudgetCheckStateController {

    @Autowired
    private FundProjBudgetCheckStateService fundProjBudgetCheckStateService;

    @PostMapping({"/saveOrUpdateFundProjBudgetCheckState"})
    public BaseResponse saveOrUpdateFundProjBudgetCheckState(@RequestBody BaseDataFundDto baseDataFundDto) {
        Long RowId = fundProjBudgetCheckStateService.saveOrUpdateFundProjBudgetCheckState(baseDataFundDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailFundProjBudgetCheckState(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        FundProjBudgetCheckStateVo fundProjBudgetCheckStateVo = fundProjBudgetCheckStateService.getDetailFundProjBudgetCheckState(RowId);
        return BaseResponse.success(fundProjBudgetCheckStateVo);
    }

    @PostMapping({"/listFundProjBudgetCheckState"})
    public BaseResponse listFundProjBudgetCheckState(@RequestBody FundProjBudgetCheckStateDto fundProjBudgetCheckStateDto) {
        IPage<FundProjBudgetCheckStateVo> list = fundProjBudgetCheckStateService.listFundProjBudgetCheckState(fundProjBudgetCheckStateDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteFundProjBudgetCheckState"})
    public BaseResponse deleteFundProjBudgetCheckState(@RequestBody BaseDto baseDto) {
        fundProjBudgetCheckStateService.deleteFundProjBudgetCheckState(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
