package com.mediway.hos.srm.business.center.mapper.baseData;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.mediway.hos.srm.business.center.model.dto.baseData.JournalSourceDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmJournalSource;
import com.mediway.hos.srm.business.center.model.vo.baseData.JournalSourceVo;


/**
 * <p>
 * 期刊源代码表 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmJournalSourceMapper extends BaseMapper<SrmJournalSource> {
    IPage<JournalSourceVo> listJournalSource (@Param("page") Page<JournalSourceVo> page, @Param("journalSourceDto") JournalSourceDto journalSourceDto);
}
