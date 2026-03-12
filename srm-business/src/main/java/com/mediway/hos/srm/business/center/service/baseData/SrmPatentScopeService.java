package com.mediway.hos.srm.business.center.service.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataLearningDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;
import com.mediway.hos.srm.business.center.model.dto.baseData.PatentScopeDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmPatentScope;
import com.mediway.hos.srm.business.center.model.vo.baseData.PatentScopeVo;

/**
 * <p>
 * 专利范围 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmPatentScopeService extends BaseService<SrmPatentScope> {
    @Transactional
    Long saveOrUpdatePatentScope(BaseDataLearningDto baseDataLearningDto);

    PatentScopeVo getDetailPatentScope(Long RowId);
    IPage<PatentScopeVo> listPatentScope(PatentScopeDto patentScopeDto);

    void deletePatentScope(BaseDto baseDto);

    Long getIdByName(String name);
}
