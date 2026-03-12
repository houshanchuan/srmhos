package com.mediway.hos.srm.business.center.service.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataProjDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;
import java.util.List;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;

import com.mediway.hos.srm.business.center.model.dto.baseData.ProjectApplyBookTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ProjectApplyBookTypeVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmProjectApplyBookType;

/**
 * <p>
 * 项目申报类别 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmProjectApplyBookTypeService extends BaseService<SrmProjectApplyBookType> {

    @Transactional
    Long saveOrUpdateProjectApplyBookType(BaseDataProjDto baseDataProjDto);

    ProjectApplyBookTypeVo getDetailProjectApplyBookType(Long RowId);
    IPage<ProjectApplyBookTypeVo> listProjectApplyBookType(ProjectApplyBookTypeDto projectApplyBookTypeDto);

    void deleteProjectApplyBookType(BaseDto baseDto);

    Long getIdByName(String name);
    List<CombVo> getProjectApplyBookType();
}
