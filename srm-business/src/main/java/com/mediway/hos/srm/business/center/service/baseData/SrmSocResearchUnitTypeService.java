package com.mediway.hos.srm.business.center.service.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataPlatformDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;

import com.mediway.hos.srm.business.center.model.dto.baseData.SocResearchUnitTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.SocResearchUnitTypeVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmSocResearchUnitType;



/**
 * <p>
 * 机构类型（社科统计） 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmSocResearchUnitTypeService extends BaseService<SrmSocResearchUnitType> {

    @Transactional
    Long saveOrUpdateSocResearchUnitType(BaseDataPlatformDto baseDataPlatformDto);

    SocResearchUnitTypeVo getDetailSocResearchUnitType(Long RowId);
    IPage<SocResearchUnitTypeVo> listSocResearchUnitType(SocResearchUnitTypeDto socResearchUnitTypeDto);

    void deleteSocResearchUnitType(BaseDto baseDto);

    Long getIdByName(String name);
}
