package com.mediway.hos.srm.business.center.mapper.baseData;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import java.util.List;

import com.mediway.hos.srm.business.center.model.dto.baseData.JournalDictDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmJournal;
import com.mediway.hos.srm.business.center.model.vo.baseData.JournalDictVo;

/**
 * <p>
 * 期刊表 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmJournalMapper extends BaseMapper<SrmJournal> {
    List<CombVo> getJournal(@Param("journalDictDto") JournalDictDto journalDictDto);

    IPage<JournalDictVo> listJournalDict(@Param("page") Page<JournalDictVo> page, @Param("journalDictDto") JournalDictDto journalDictDto);
}
