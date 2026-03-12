package com.mediway.hos.srm.business.center.controller.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.base.model.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataCommonDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mediway.hos.srm.business.center.model.dto.baseData.YearWorkMonthDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.YearWorkMonthVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmYearWorkmonthService;


/**
 * <p>
 * 年工作量
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/yearWorkmonth")
@Api(tags = "年工作量")
public class SrmYearWorkmonthController {

    @Autowired
    private SrmYearWorkmonthService srmYearWorkMonthService;

    @PostMapping({"/saveOrUpdateYearWorkMonth"})
    public BaseResponse saveOrUpdateYearWorkMonth(@RequestBody BaseDataCommonDto baseDataProjDto) {
        Long RowId = srmYearWorkMonthService.saveOrUpdateYearWorkMonth(baseDataProjDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailYearWorkMonth(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        YearWorkMonthVo yearWorkMonthVo = srmYearWorkMonthService.getDetailYearWorkMonth(RowId);
        return BaseResponse.success(yearWorkMonthVo);
    }

    @PostMapping({"/listYearWorkMonth"})
    public BaseResponse listYearWorkMonth(@RequestBody YearWorkMonthDto yearWorkMonthDto) {
        IPage<YearWorkMonthVo> list = srmYearWorkMonthService.listYearWorkMonth(yearWorkMonthDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteYearWorkMonth"})
    public BaseResponse deleteYearWorkMonth(@RequestBody BaseDto baseDto) {
        srmYearWorkMonthService.deleteYearWorkMonth(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
