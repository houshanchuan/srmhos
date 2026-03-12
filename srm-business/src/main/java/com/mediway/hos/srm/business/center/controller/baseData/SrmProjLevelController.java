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

import com.mediway.hos.srm.business.center.model.dto.baseData.ProjLevelDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ProjLevelVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmProjLevelService;
/**
 * <p>
 * 项目级别代码
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/projLevel")
@Api(tags = "项目级别代码")
public class SrmProjLevelController {

    @Autowired
    private SrmProjLevelService srmProjLevelService;

    @PostMapping({"/saveOrUpdateProjLevel"})
    public BaseResponse saveOrUpdateProjLevel(@RequestBody BaseDataProjDto baseDataProjDto) {
        Long RowId = srmProjLevelService.saveOrUpdateProjLevel(baseDataProjDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailProjLevel(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        ProjLevelVo projLevelVo = srmProjLevelService.getDetailProjLevel(RowId);
        return BaseResponse.success(projLevelVo);
    }

    @PostMapping({"/listProjLevel"})
    public BaseResponse listProjLevel(@RequestBody ProjLevelDto projLevelDto) {
        IPage<ProjLevelVo> list = srmProjLevelService.listProjLevel(projLevelDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteProjLevel"})
    public BaseResponse deleteProjLevel(@RequestBody BaseDto baseDto) {
        srmProjLevelService.deleteProjLevel(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
