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

import com.mediway.hos.srm.business.center.model.dto.fund.FundRmbsTravelItemDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundRmbsTravelItemVo;
import com.mediway.hos.srm.business.center.service.fund.FundRmbsTravelItemService;
/**
 * <p>
 * 差旅报销项目
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
@RestController
@RequestMapping("srm/fundRmbsTravelItem")
@Api(tags = "差旅报销项目")
public class FundRmbsTravelItemController {

    @Autowired
    private FundRmbsTravelItemService fundRmbsTravelItemService;

    @PostMapping({"/saveOrUpdateFundRmbsTravelItem"})
    public BaseResponse saveOrUpdateFundRmbsTravelItem(@RequestBody BaseDataFundDto baseDataFundDto) {
        Long RowId = fundRmbsTravelItemService.saveOrUpdateFundRmbsTravelItem(baseDataFundDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailFundRmbsTravelItem(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        FundRmbsTravelItemVo fundRmbsTravelItemVo = fundRmbsTravelItemService.getDetailFundRmbsTravelItem(RowId);
        return BaseResponse.success(fundRmbsTravelItemVo);
    }

    @PostMapping({"/listFundRmbsTravelItem"})
    public BaseResponse listFundRmbsTravelItem(@RequestBody FundRmbsTravelItemDto fundRmbsTravelItemDto) {
        IPage<FundRmbsTravelItemVo> list = fundRmbsTravelItemService.listFundRmbsTravelItem(fundRmbsTravelItemDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteFundRmbsTravelItem"})
    public BaseResponse deleteFundRmbsTravelItem(@RequestBody BaseDto baseDto) {
        fundRmbsTravelItemService.deleteFundRmbsTravelItem(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
