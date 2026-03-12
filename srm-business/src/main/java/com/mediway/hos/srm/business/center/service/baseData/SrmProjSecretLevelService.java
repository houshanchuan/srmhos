package com.mediway.hos.srm.business.center.service.baseData;


import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataProjDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;

import com.mediway.hos.srm.business.center.model.dto.baseData.ProjSecretLevelDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ProjSecretLevelVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmProjSecretLevel;

/**
 * <p>
 * 项目密级代码表 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmProjSecretLevelService extends BaseService<SrmProjSecretLevel> {

    @Transactional
    Long saveOrUpdateProjSecretLevel(BaseDataProjDto baseDataProjDto);

    ProjSecretLevelVo getDetailProjSecretLevel(Long RowId);
    IPage<ProjSecretLevelVo> listProjSecretLevel(ProjSecretLevelDto projSecretLevelDto);

    void deleteProjSecretLevel(BaseDto baseDto);

    Long getIdByName(String name);
}
