package com.mediway.hos.srm.business.center.mapper.systemConfig;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.mediway.hos.srm.business.center.model.vo.systemConfig.SysParameterVo;
import com.mediway.hos.srm.business.center.model.entity.systemConfig.SrmSysParameter;
/**
 * <p>
 * 系统参数明细 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-13
 */
public interface SrmSysParameterMapper extends BaseMapper<SrmSysParameter> {

    IPage<SysParameterVo> listSysParameter(@Param("page") Page<SysParameterVo> page, @Param("paraType") String paraType);

}
