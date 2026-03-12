package com.mediway.hos.srm.business.center.service.systemConfig;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataCommonDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;

import com.mediway.hos.srm.business.center.model.dto.systemConfig.SysParameterTypeDto;
import com.mediway.hos.srm.business.center.model.vo.systemConfig.SysParameterTypeVo;
import com.mediway.hos.srm.business.center.model.entity.systemConfig.SrmSysParameterType;

/**
 * <p>
 * 系统参数 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-13
 */
public interface SrmSysParameterTypeService extends BaseService<SrmSysParameterType> {

    @Transactional
    Long saveOrUpdateSysParameterType(BaseDataCommonDto baseDataCommonDto);

    SysParameterTypeVo getDetailSysParameterType(Long RowId);
    IPage<SysParameterTypeVo> listSysParameterType(SysParameterTypeDto sysParameterTypeDto);

    void deleteSysParameterType(BaseDto baseDto);

    Long getIdByName(String name);
}
