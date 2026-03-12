package com.mediway.hos.srm.business.center.mapper.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.mediway.hos.srm.business.center.model.dto.baseData.ProjSecretLevelDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ProjSecretLevelVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmProjSecretLevel;
/**
 * <p>
 * 项目密级代码表 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmProjSecretLevelMapper extends BaseMapper<SrmProjSecretLevel> {
    IPage<ProjSecretLevelVo> listProjSecretLevel(@Param("page") Page<ProjSecretLevelVo> page, @Param("projSecretLevelDto") ProjSecretLevelDto projSecretLevelDto);

}
