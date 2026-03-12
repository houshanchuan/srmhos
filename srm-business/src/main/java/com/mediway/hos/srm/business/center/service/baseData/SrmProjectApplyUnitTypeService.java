package com.mediway.hos.srm.business.center.service.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataProjDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;

import com.mediway.hos.srm.business.center.model.dto.baseData.ProjectApplyUnitTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ProjectApplyUnitTypeVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmProjectApplyUnitType;

/**
 * <p>
 * 项目申报部门类型 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmProjectApplyUnitTypeService extends BaseService<SrmProjectApplyUnitType> {

    @Transactional
    Long saveOrUpdateProjectApplyUnitType(BaseDataProjDto baseDataProjDto);

    ProjectApplyUnitTypeVo getDetailProjectApplyUnitType(Long RowId);
    IPage<ProjectApplyUnitTypeVo> listProjectApplyUnitType(ProjectApplyUnitTypeDto projectApplyUnitTypeDto);

    void deleteProjectApplyUnitType(BaseDto baseDto);

    Long getIdByName(String name);
}
