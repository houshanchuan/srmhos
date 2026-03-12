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

import com.mediway.hos.srm.business.center.model.dto.fund.FundProjBudgetStandardDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundProjBudgetStandardVo;
import com.mediway.hos.srm.business.center.service.fund.FundProjBudgetStandardService;
/**
 * <p>
 * 项目分类预算标准
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
@RestController
@RequestMapping("srm/fundProjBudgetStandard")
@Api(tags = "项目分类预算标准")
public class FundProjBudgetStandardController {

    @Autowired
    private FundProjBudgetStandardService fundProjBudgetStandardService;

    @PostMapping({"/saveOrUpdateFundProjBudgetStandard"})
    public BaseResponse saveOrUpdateFundProjBudgetStandard(@RequestBody BaseDataFundDto baseDataFundDto) {
        Long RowId = fundProjBudgetStandardService.saveOrUpdateFundProjBudgetStandard(baseDataFundDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailFundProjBudgetStandard(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        FundProjBudgetStandardVo fundProjBudgetStandardVo = fundProjBudgetStandardService.getDetailFundProjBudgetStandard(RowId);
        return BaseResponse.success(fundProjBudgetStandardVo);
    }

    @PostMapping({"/listFundProjBudgetStandard"})
    public BaseResponse listFundProjBudgetStandard(@RequestBody FundProjBudgetStandardDto fundProjBudgetStandardDto) {
        IPage<FundProjBudgetStandardVo> list = fundProjBudgetStandardService.listFundProjBudgetStandard(fundProjBudgetStandardDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteFundProjBudgetStandard"})
    public BaseResponse deleteFundProjBudgetStandard(@RequestBody BaseDto baseDto) {
        fundProjBudgetStandardService.deleteFundProjBudgetStandard(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
