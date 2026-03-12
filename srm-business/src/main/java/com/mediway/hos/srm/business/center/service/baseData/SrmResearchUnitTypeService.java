package com.mediway.hos.srm.business.center.service.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataPlatformDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;

import com.mediway.hos.srm.business.center.model.dto.baseData.ResearchUnitTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ResearchUnitTypeVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmResearchUnitType;



/**
 * <p>
 * 科研机构类型 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmResearchUnitTypeService extends BaseService<SrmResearchUnitType> {
    @Transactional
    Long saveOrUpdateResearchUnitType(BaseDataPlatformDto baseDataPlatformDto);

    ResearchUnitTypeVo getDetailResearchUnitType(Long RowId);
    IPage<ResearchUnitTypeVo> listResearchUnitType(ResearchUnitTypeDto researchUnitTypeDto);

    void deleteResearchUnitType(BaseDto baseDto);

    Long getIdByName(String name);
}
