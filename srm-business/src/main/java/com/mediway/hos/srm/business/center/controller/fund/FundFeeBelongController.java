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

import com.mediway.hos.srm.business.center.model.dto.fund.FundFeeBelongDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundFeeBelongVo;
import com.mediway.hos.srm.business.center.service.fund.FundFeeBelongService;


/**
 * <p>
 * 经费归属
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
@RestController
@RequestMapping("srm/fundFeeBelong")
@Api(tags = "经费归属")
public class FundFeeBelongController {

    @Autowired
    private FundFeeBelongService fundFeeBelongService;

    @PostMapping({"/saveOrUpdateFundFeeBelong"})
    public BaseResponse saveOrUpdateFundFeeBelong(@RequestBody BaseDataFundDto baseDataFundDto) {
        Long RowId = fundFeeBelongService.saveOrUpdateFundFeeBelong(baseDataFundDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailFundFeeBelong(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        FundFeeBelongVo fundFeeBelongVo = fundFeeBelongService.getDetailFundFeeBelong(RowId);
        return BaseResponse.success(fundFeeBelongVo);
    }

    @PostMapping({"/listFundFeeBelong"})
    public BaseResponse listFundFeeBelong(@RequestBody FundFeeBelongDto fundFeeBelongDto) {
        IPage<FundFeeBelongVo> list = fundFeeBelongService.listFundFeeBelong(fundFeeBelongDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteFundFeeBelong"})
    public BaseResponse deleteFundFeeBelong(@RequestBody BaseDto baseDto) {
        fundFeeBelongService.deleteFundFeeBelong(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
