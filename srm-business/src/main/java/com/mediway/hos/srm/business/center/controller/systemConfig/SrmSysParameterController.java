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

import com.mediway.hos.srm.business.center.model.dto.systemConfig.SysParameterDto;
import com.mediway.hos.srm.business.center.model.vo.systemConfig.SysParameterVo;
import com.mediway.hos.srm.business.center.service.systemConfig.SrmSysParameterService;

/**
 * <p>
 * 系统参数明细
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-13
 */
@RestController
@RequestMapping("srm/sysPara")
@Api(tags = "系统参数明细")
public class SrmSysParameterController {

    @Autowired
    private SrmSysParameterService srmSysParameterService;

    @PostMapping({"/saveOrUpdateSysParameter"})
    public BaseResponse saveOrUpdateSysParameter(@RequestBody BaseDataCommonDto baseDataCommonDto) {
        Long RowId = srmSysParameterService.saveOrUpdateSysParameter(baseDataCommonDto);
        return BaseResponse.success(RowId);
    }

    @PostMapping({"/getDetailSysParameter"})
    public BaseResponse getDetailSysParameter(@RequestBody BaseDto baseDto) {
        Long RowId=baseDto.getId();
        SysParameterVo sysParameterVo = srmSysParameterService.getDetailSysParameter(RowId);
        return BaseResponse.success(sysParameterVo);
    }

    @PostMapping({"/listSysParameter"})
    public BaseResponse listSysParameter(@RequestBody SysParameterDto sysParameterDto) {
        IPage<SysParameterVo> list = srmSysParameterService.listSysParameter(sysParameterDto);
        return BaseResponse.success(list);

    }
    @PostMapping({"/deleteSysParameter"})
    public BaseResponse deleteSysParameter(@RequestBody BaseDto baseDto) {
        srmSysParameterService.deleteSysParameter(baseDto);
        return BaseResponse.success("删除成功!");
    }
}
