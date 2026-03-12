package com.mediway.hos.srm.business.center.mapper.systemConfig;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import java.util.List;

import com.mediway.hos.srm.business.center.model.dto.systemConfig.SystemModuleDto;
import com.mediway.hos.srm.business.center.model.vo.systemConfig.SystemModuleVo;
import com.mediway.hos.srm.business.center.model.entity.systemConfig.SrmSystemModule;
/**
 * <p>
 * 系统模块表 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-08-22
 */
public interface SrmSystemModuleMapper extends BaseMapper<SrmSystemModule> {
    List<CombVo> getSystemModule();

    Long getSystemModuleByCode(@Param("code") String code);

    IPage<SystemModuleVo> listSystemModule(@Param("page") Page<SystemModuleVo> page, @Param("systemModuleDto") SystemModuleDto systemModuleDto);

}