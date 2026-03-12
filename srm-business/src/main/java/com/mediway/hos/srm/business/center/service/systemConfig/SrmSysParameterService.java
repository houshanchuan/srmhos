package com.mediway.hos.srm.business.center.service.systemConfig;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataCommonDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;

import com.mediway.hos.srm.business.center.model.dto.systemConfig.SysParameterDto;
import com.mediway.hos.srm.business.center.model.vo.systemConfig.SysParameterVo;
import com.mediway.hos.srm.business.center.model.entity.systemConfig.SrmSysParameter;
/**
 * <p>
 * 系统参数明细 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-13
 */
public interface SrmSysParameterService extends BaseService<SrmSysParameter> {

    @Transactional
    Long saveOrUpdateSysParameter(BaseDataCommonDto baseDataProjDto);

    SysParameterVo getDetailSysParameter(Long RowId);
    IPage<SysParameterVo> listSysParameter(SysParameterDto sysParameterDto);

    void deleteSysParameter(BaseDto baseDto);

    Long getIdByName(String name);
    String getParamVaule(String typeCode,String code);
}
