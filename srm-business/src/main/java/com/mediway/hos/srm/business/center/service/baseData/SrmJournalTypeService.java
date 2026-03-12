package com.mediway.hos.srm.business.center.service.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;

import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataLearningDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;

import com.mediway.hos.srm.business.center.model.dto.baseData.JournalTypeDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmJournalType;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import com.mediway.hos.srm.business.center.model.vo.baseData.JournalTypeVo;
import java.util.List;

/**
 * <p>
 * 期刊类型表 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmJournalTypeService extends BaseService<SrmJournalType> {
    @Transactional
    Long saveOrUpdateJournalType(BaseDataLearningDto baseDataLearningDto);

    JournalTypeVo getDetailJournalType(Long RowId);
    IPage<JournalTypeVo> listJournalType(JournalTypeDto journalTypeDto);

    void deleteJournalType(BaseDto baseDto);

    Long getIdByName(String name);
    List<CombVo> getJournalType();
}
