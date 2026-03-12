package com.mediway.hos.srm.business.center.controller.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.base.model.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataProjDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import java.util.List;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mediway.hos.srm.business.center.model.dto.baseData.YearDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.YearVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmYearService;

/**
 * <p>
 * 年度
 * </p>
 *
 * @author 代码生成器
 * @since 2024-07-19
 */
@RestController
@RequestMapping("srm/year")
@Api(tags = "年度")
public class SrmYearController {
    @Autowired
    private SrmYearService srmYearService;
    @PostMapping({"/getYear"})
    public List<CombVo> getYear(@RequestBody(required = false) YearDto yearDto) {
        return srmYearService.getYear(yearDto);
    }
    @PostMapping({"/test"})
    public String test() {
        srmYearService.test2();
        return  "111";
    }

    @PostMapping({"/saveOrUpdateYear"})
    public BaseResponse saveOrUpdateYear(@RequestBody BaseDataProjDto baseDataProjDto) {
        Long RowId = srmYearService.saveOrUpdateYear(baseDataProjDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailYear(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        YearVo yearVo = srmYearService.getDetailYear(RowId);
        return BaseResponse.success(yearVo);
    }

    @PostMapping({"/listYear"})
    public BaseResponse listYear(@RequestBody YearDto yearDto) {
        IPage<YearVo> list = srmYearService.listYear(yearDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteYear"})
    public BaseResponse deleteYear(@RequestBody BaseDto baseDto) {
        srmYearService.deleteYear(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
