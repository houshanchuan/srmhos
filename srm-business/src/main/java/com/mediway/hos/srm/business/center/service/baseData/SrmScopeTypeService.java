package com.mediway.hos.srm.business.center.service.baseData;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataLearningDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;

import com.mediway.hos.srm.business.center.model.dto.baseData.ScopeTypeDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmScopeType;
import com.mediway.hos.srm.business.center.model.vo.baseData.ScopeTypeVo;
/**
 * <p>
 * 范围类型 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmScopeTypeService extends BaseService<SrmScopeType> {
    @Transactional
    Long saveOrUpdateScopeType(BaseDataLearningDto baseDataLearningDto);

    ScopeTypeVo getDetailScopeType(Long RowId);
    IPage<ScopeTypeVo> listScopeType(ScopeTypeDto yyyyDto);

    void deleteScopeType(BaseDto baseDto);

    Long getIdByName(String name);
}
