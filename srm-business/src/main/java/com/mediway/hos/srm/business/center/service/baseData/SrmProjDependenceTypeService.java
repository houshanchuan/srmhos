package com.mediway.hos.srm.business.center.service.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataProjDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;

import com.mediway.hos.srm.business.center.model.dto.baseData.ProjDependenceTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ProjDependenceTypeVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmProjDependenceType;
/**
 * <p>
 * 项目依赖类型代码表 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmProjDependenceTypeService extends BaseService<SrmProjDependenceType> {

    @Transactional
    Long saveOrUpdateProjDependenceType(BaseDataProjDto baseDataProjDto);

    ProjDependenceTypeVo getDetailProjDependenceType(Long RowId);
    IPage<ProjDependenceTypeVo> listProjDependenceType(ProjDependenceTypeDto projDependenceTypeDto);

    void deleteProjDependenceType(BaseDto baseDto);

    Long getIdByName(String name);
}
