package com.mediway.hos.srm.business.center.controller.baseData;


import com.mediway.hos.base.model.BaseResponse;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;

import com.mediway.hos.srm.business.center.model.vo.baseData.ProjectCooperativesVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmProjectCooperativesService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 项目合作单位表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/srmProjectCooperatives")
@Api(tags = "项目合作单位表")
public class SrmProjectCooperativesController {
    @Autowired
    private SrmProjectCooperativesService srmProjectCooperativesService;
    @PostMapping({"/listProjectCooperatives"})
    public BaseResponse listProjectCooperatives(@RequestBody BaseDto baseDto) {
        List<ProjectCooperativesVo> list = srmProjectCooperativesService.listProjectCooperatives(baseDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteProjectCooperativesById"})
    public BaseResponse deleteProjectCooperativesById(@RequestBody BaseDto baseDto) {
        srmProjectCooperativesService.deleteProjectCooperativesById(baseDto);
        return BaseResponse.success("删除成功");

    }
}
