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

import com.mediway.hos.srm.business.center.model.dto.fund.FundCheckResultStateDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundCheckResultStateVo;
import com.mediway.hos.srm.business.center.service.fund.FundCheckResultStateService;

/**
 * <p>
 * 审批结果状态代码表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
@RestController
@RequestMapping("srm/fundCheckResultState")
@Api(tags = "审批结果状态代码表")
public class FundCheckResultStateController {

    @Autowired
    private FundCheckResultStateService fundCheckResultStateService;

    @PostMapping({"/saveOrUpdateFundCheckResultState"})
    public BaseResponse saveOrUpdateFundCheckResultState(@RequestBody BaseDataFundDto baseDataFundDto) {
        Long RowId = fundCheckResultStateService.saveOrUpdateFundCheckResultState(baseDataFundDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailFundCheckResultState(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        FundCheckResultStateVo fundCheckResultStateVo = fundCheckResultStateService.getDetailFundCheckResultState(RowId);
        return BaseResponse.success(fundCheckResultStateVo);
    }

    @PostMapping({"/listFundCheckResultState"})
    public BaseResponse listFundCheckResultState(@RequestBody FundCheckResultStateDto fundCheckResultStateDto) {
        IPage<FundCheckResultStateVo> list = fundCheckResultStateService.listFundCheckResultState(fundCheckResultStateDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteFundCheckResultState"})
    public BaseResponse deleteFundCheckResultState(@RequestBody BaseDto baseDto) {
        fundCheckResultStateService.deleteFundCheckResultState(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
