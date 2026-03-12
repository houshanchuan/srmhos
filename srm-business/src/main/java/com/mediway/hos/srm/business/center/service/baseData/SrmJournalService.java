package com.mediway.hos.srm.business.center.service.baseData;

import com.mediway.hos.srm.business.center.model.entity.baseData.SrmJournal;
import com.mediway.hos.srm.business.base.service.BaseService;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataLearningDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;

import java.util.List;

import com.mediway.hos.srm.business.center.model.dto.baseData.JournalDictDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.JournalDictVo;

/**
 * <p>
 * 期刊表 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmJournalService extends BaseService<SrmJournal> {
    List<CombVo> getJournal(JournalDictDto journalDictDto);

    @Transactional
    Long saveOrUpdateJournalDict(BaseDataLearningDto baseDataLearningDto);

    JournalDictVo getDetailJournalDict(Long RowId);
    IPage<JournalDictVo> listJournalDict(JournalDictDto journalDictDto);

    void deleteJournalDict(BaseDto baseDto);

    Long getIdByName(String name);
}
