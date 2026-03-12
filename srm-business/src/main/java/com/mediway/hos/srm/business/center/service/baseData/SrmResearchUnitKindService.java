package com.mediway.hos.srm.business.center.service.baseData;


import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataPlatformDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;

import com.mediway.hos.srm.business.center.model.dto.baseData.ResearchUnitKindDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ResearchUnitKindVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmResearchUnitKind;



/**
 * <p>
 * 科研机构性质 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmResearchUnitKindService extends BaseService<SrmResearchUnitKind> {


    @Transactional
    Long saveOrUpdateResearchUnitKind(BaseDataPlatformDto baseDataPlatformDto);

    ResearchUnitKindVo getDetailResearchUnitKind(Long RowId);
    IPage<ResearchUnitKindVo> listResearchUnitKind(ResearchUnitKindDto researchUnitKindDto);

    void deleteResearchUnitKind(BaseDto baseDto);

    Long getIdByName(String name);
}
