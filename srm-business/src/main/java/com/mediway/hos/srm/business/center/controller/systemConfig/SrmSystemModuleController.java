package com.mediway.hos.srm.business.center.controller.systemConfig;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.base.model.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataCommonDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import java.util.List;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mediway.hos.srm.business.center.model.dto.systemConfig.SystemModuleDto;
import com.mediway.hos.srm.business.center.model.vo.systemConfig.SystemModuleVo;
import com.mediway.hos.srm.business.center.service.systemConfig.SrmSystemModuleService;
/**
 * <p>
 * 系统模块表
 * </p>
 *
 * @author 代码生成器
 * @since 2024-08-22
 */
@RestController
@RequestMapping("srm/systemModule")
@Api(tags = "系统模块表")
public class SrmSystemModuleController {

    @Autowired
    private SrmSystemModuleService srmSystemModuleService;

    @PostMapping({"/saveOrUpdateSystemModule"})
    public BaseResponse saveOrUpdateSystemModule(@RequestBody BaseDataCommonDto baseDataCommonDto) {
        Long RowId = srmSystemModuleService.saveOrUpdateSystemModule(baseDataCommonDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getSystemModule"})
    public List<CombVo> getSystemModule() {
        return srmSystemModuleService.getSystemModule();

    }
    @PostMapping({"/getDetail"})
    public BaseResponse getDetailSystemModule(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        SystemModuleVo systemModuleVo = srmSystemModuleService.getDetailSystemModule(RowId);
        return BaseResponse.success(systemModuleVo);
    }

    @PostMapping({"/listSystemModule"})
    public BaseResponse listSystemModule(@RequestBody SystemModuleDto systemModuleDto) {
        IPage<SystemModuleVo> list = srmSystemModuleService.listSystemModule(systemModuleDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteSystemModule"})
    public BaseResponse deleteSystemModule(@RequestBody BaseDto baseDto) {
        srmSystemModuleService.deleteSystemModule(baseDto);
        return BaseResponse.success("删除成功!");

    }

}
