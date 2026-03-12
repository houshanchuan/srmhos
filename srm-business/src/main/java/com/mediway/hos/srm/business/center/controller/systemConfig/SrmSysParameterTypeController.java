package com.mediway.hos.srm.business.center.controller.systemConfig;


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

import com.mediway.hos.srm.business.center.model.dto.systemConfig.SysParameterTypeDto;
import com.mediway.hos.srm.business.center.model.vo.systemConfig.SysParameterTypeVo;
import com.mediway.hos.srm.business.center.service.systemConfig.SrmSysParameterTypeService;
/**
 * <p>
 * 系统参数
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-13
 */
@RestController
@RequestMapping("srm/sysPara")
@Api(tags = "系统参数")
public class SrmSysParameterTypeController {

    @Autowired
    private SrmSysParameterTypeService srmSysParameterTypeService;

    @PostMapping({"/saveOrUpdateSysParameterType"})
    public BaseResponse saveOrUpdateSysParameterType(@RequestBody BaseDataCommonDto baseDataCommonDto) {
        Long RowId = srmSysParameterTypeService.saveOrUpdateSysParameterType(baseDataCommonDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetail"})
    public BaseResponse getDetailSysParameterType(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        SysParameterTypeVo sysParameterTypeVo = srmSysParameterTypeService.getDetailSysParameterType(RowId);
        return BaseResponse.success(sysParameterTypeVo);
    }

    @PostMapping({"/listSysParameterType"})
    public BaseResponse listSysParameterType(@RequestBody SysParameterTypeDto sysParameterTypeDto) {
        IPage<SysParameterTypeVo> list = srmSysParameterTypeService.listSysParameterType(sysParameterTypeDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteSysParameterType"})
    public BaseResponse deleteSysParameterType(@RequestBody BaseDto baseDto) {
        srmSysParameterTypeService.deleteSysParameterType(baseDto);
        return BaseResponse.success("删除成功!");

    }
}
