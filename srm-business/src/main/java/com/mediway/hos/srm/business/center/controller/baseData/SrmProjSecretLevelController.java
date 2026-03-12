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

import com.mediway.hos.srm.business.center.model.dto.baseData.ProjSecretLevelDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ProjSecretLevelVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmProjSecretLevelService;


/**
 * <p>
 * 项目密级代码表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@RestController
@RequestMapping("srm/projSecretLevel")
@Api(tags = "项目密级代码表")
public class SrmProjSecretLevelController {

    @Autowired
    private SrmProjSecretLevelService srmProjSecretLevelService;

    @PostMapping({"/saveOrUpdateProjSecretLevel"})
    public BaseResponse saveOrUpdateProjSecretLevel(@RequestBody BaseDataProjDto baseDataProjDto) {
        Long RowId = srmProjSecretLevelService.saveOrUpdateProjSecretLevel(baseDataProjDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailProjSecretLevel(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        ProjSecretLevelVo projSecretLevelVo = srmProjSecretLevelService.getDetailProjSecretLevel(RowId);
        return BaseResponse.success(projSecretLevelVo);
    }

    @PostMapping({"/listProjSecretLevel"})
    public BaseResponse listProjSecretLevel(@RequestBody ProjSecretLevelDto projSecretLevelDto) {
        IPage<ProjSecretLevelVo> list = srmProjSecretLevelService.listProjSecretLevel(projSecretLevelDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteProjSecretLevel"})
    public BaseResponse deleteProjSecretLevel(@RequestBody BaseDto baseDto) {
        srmProjSecretLevelService.deleteProjSecretLevel(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
