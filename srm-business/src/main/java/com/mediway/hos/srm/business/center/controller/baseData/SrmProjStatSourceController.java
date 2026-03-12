package com.mediway.hos.srm.business.center.controller.baseData;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.base.model.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataProjDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mediway.hos.srm.business.center.model.dto.baseData.ProjStatSourceDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ProjStatSourceVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmProjStatSourceService;
/**
 * <p>
 * 项目来源表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/projStatSource")
@Api(tags = "项目来源表")
public class SrmProjStatSourceController {

    @Autowired
    private SrmProjStatSourceService srmProjStatSourceService;

    @PostMapping({"/saveOrUpdateProjStatSource"})
    public BaseResponse saveOrUpdateProjStatSource(@RequestBody BaseDataProjDto baseDataProjDto) {
        Long RowId = srmProjStatSourceService.saveOrUpdateProjStatSource(baseDataProjDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailProjStatSource(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        ProjStatSourceVo projStatSourceVo = srmProjStatSourceService.getDetailProjStatSource(RowId);
        return BaseResponse.success(projStatSourceVo);
    }

    @PostMapping({"/listProjStatSource"})
    public BaseResponse listProjStatSource(@RequestBody ProjStatSourceDto projStatSourceDto) {
        IPage<ProjStatSourceVo> list = srmProjStatSourceService.listProjStatSource(projStatSourceDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteProjStatSource"})
    public BaseResponse deleteProjStatSource(@RequestBody BaseDto baseDto) {
        srmProjStatSourceService.deleteProjStatSource(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
