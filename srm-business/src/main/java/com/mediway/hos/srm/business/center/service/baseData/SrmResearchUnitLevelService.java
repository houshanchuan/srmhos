package com.mediway.hos.srm.business.center.service.baseData;


import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataPlatformDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;

import com.mediway.hos.srm.business.center.model.dto.baseData.ResearchUnitLevelDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ResearchUnitLevelVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmResearchUnitLevel;



/**
 * <p>
 * 科研机构级别 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmResearchUnitLevelService extends BaseService<SrmResearchUnitLevel> {


    @Transactional
    Long saveOrUpdateResearchUnitLevel(BaseDataPlatformDto baseDataPlatformDto);

    ResearchUnitLevelVo getDetailResearchUnitLevel(Long RowId);
    IPage<ResearchUnitLevelVo> listResearchUnitLevel(ResearchUnitLevelDto researchUnitLevelDto);

    void deleteResearchUnitLevel(BaseDto baseDto);

    Long getIdByName(String name);
}
