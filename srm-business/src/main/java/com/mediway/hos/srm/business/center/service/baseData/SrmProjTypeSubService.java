package com.mediway.hos.srm.business.center.service.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataProjDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;

import com.mediway.hos.srm.business.center.model.dto.baseData.ProjTypeSubDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ProjTypeSubVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmProjTypeSub;



/**
 * <p>
 * 项目类型(子类) 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmProjTypeSubService extends BaseService<SrmProjTypeSub> {
    @Transactional
    Long saveOrUpdateProjTypeSub(BaseDataProjDto baseDataProjDto);

    ProjTypeSubVo getDetailProjTypeSub(Long RowId);

    IPage<ProjTypeSubVo> listProjTypeSub(ProjTypeSubDto projTypeSubDto);
    void deleteProjTypeSub(BaseDto baseDto);

    Long getIdByName(String name);
}
