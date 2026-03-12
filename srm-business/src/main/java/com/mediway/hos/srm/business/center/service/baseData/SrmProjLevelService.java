package com.mediway.hos.srm.business.center.service.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataProjDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;
import java.util.List;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;


import com.mediway.hos.srm.business.center.model.dto.baseData.ProjLevelDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ProjLevelVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmProjLevel;

/**
 * <p>
 * 项目级别代码 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmProjLevelService extends BaseService<SrmProjLevel> {

    @Transactional
    Long saveOrUpdateProjLevel(BaseDataProjDto baseDataProjDto);

    ProjLevelVo getDetailProjLevel(Long RowId);
    IPage<ProjLevelVo> listProjLevel(ProjLevelDto projLevelDto);

    void deleteProjLevel(BaseDto baseDto);

    Long getIdByName(String name);

    List<CombVo> getProjLevel();
}
