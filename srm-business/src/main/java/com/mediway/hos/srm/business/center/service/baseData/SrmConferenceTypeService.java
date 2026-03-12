package com.mediway.hos.srm.business.center.service.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataLearningDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;
import java.util.List;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;


import com.mediway.hos.srm.business.center.model.dto.baseData.ConferenceTypeDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmConferenceType;
import com.mediway.hos.srm.business.center.model.vo.baseData.ConferenceTypeVo;



/**
 * <p>
 * 会议类型 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmConferenceTypeService extends BaseService<SrmConferenceType> {
    @Transactional
    Long saveOrUpdateConferenceType(BaseDataLearningDto baseDataLearningDto);

    ConferenceTypeVo getDetailConferenceType(Long RowId);

    IPage<ConferenceTypeVo> listConferenceType(ConferenceTypeDto conferenceTypeDto);

    void deleteConferenceType(BaseDto baseDto);

    Long getIdByName(String name);

    List<CombVo> getConferenceType();

}
