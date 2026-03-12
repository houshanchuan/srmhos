package com.mediway.hos.srm.business.center.mapper.systemConfig;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.mediway.hos.srm.business.center.model.dto.systemConfig.SysParameterTypeDto;
import com.mediway.hos.srm.business.center.model.vo.systemConfig.SysParameterTypeVo;
import com.mediway.hos.srm.business.center.model.entity.systemConfig.SrmSysParameterType;
/**
 * <p>
 * 系统参数 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-13
 */
public interface SrmSysParameterTypeMapper extends BaseMapper<SrmSysParameterType> {

    IPage<SysParameterTypeVo> listSysParameterType(@Param("page") Page<SysParameterTypeVo> page, @Param("sysParameterTypeDto") SysParameterTypeDto sysParameterTypeDto);

}
