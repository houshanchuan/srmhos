package com.mediway.hos.srm.business.center.service.baseData;


import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataPlatformDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;

import com.mediway.hos.srm.business.center.model.dto.baseData.ResearchUnitStateDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ResearchUnitStateVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmResearchUnitState;


/**
 * <p>
 * 机构状态 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmResearchUnitStateService extends BaseService<SrmResearchUnitState> {

    @Transactional
    Long saveOrUpdateResearchUnitState(BaseDataPlatformDto baseDataPlatformDto);

    ResearchUnitStateVo getDetailResearchUnitState(Long RowId);
    IPage<ResearchUnitStateVo> listResearchUnitState(ResearchUnitStateDto researchUnitStateDto);

    void deleteResearchUnitState(BaseDto baseDto);

    Long getIdByName(String name);
}
