package com.mediway.hos.srm.business.center.service.baseData;


import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataLearningDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;

import com.mediway.hos.srm.business.center.model.dto.baseData.JournalSourceDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmJournalSource;
import com.mediway.hos.srm.business.center.model.vo.baseData.JournalSourceVo;

/**
 * <p>
 * 期刊源代码表 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmJournalSourceService extends BaseService<SrmJournalSource> {
    @Transactional
    Long saveOrUpdateJournalSource(BaseDataLearningDto baseDataLearningDto);

    JournalSourceVo getDetailJournalSource(Long RowId);
    IPage<JournalSourceVo> listJournalSource(JournalSourceDto journalSourceDto);

    void deleteJournalSource(BaseDto baseDto);

    Long getIdByName(String name);
}
