package com.mediway.hos.srm.business.center.service.baseData;


import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataProjDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;

import com.mediway.hos.srm.business.center.model.dto.baseData.ProgramCategoryDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ProgramCategoryVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmProgramCategory;

/**
 * <p>
 * 计划类别 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmProgramCategoryService extends BaseService<SrmProgramCategory> {

    @Transactional
    Long saveOrUpdateProgramCategory(BaseDataProjDto baseDataProjDto);

    ProgramCategoryVo getDetailProgramCategory(Long RowId);
    IPage<ProgramCategoryVo> listProgramCategory(ProgramCategoryDto programCategoryDto);

    void deleteProgramCategory(BaseDto baseDto);

    Long getIdByName(String name);
}
