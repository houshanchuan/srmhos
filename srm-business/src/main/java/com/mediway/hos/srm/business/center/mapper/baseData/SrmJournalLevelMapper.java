package com.mediway.hos.srm.business.center.mapper.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.mediway.hos.srm.business.center.model.dto.baseData.JournalLevelDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmJournalLevel;
import com.mediway.hos.srm.business.center.model.vo.baseData.JournalLevelVo;

/**
 * <p>
 * 期刊级别 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmJournalLevelMapper extends BaseMapper<SrmJournalLevel> {
    IPage<JournalLevelVo> listJournalLevel(@Param("page") Page<JournalLevelVo> page, @Param("journalLevelDto") JournalLevelDto journalLevelDto);
}
