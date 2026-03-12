package com.mediway.hos.srm.business.center.service.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataProjDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;
import java.util.List;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;

import com.mediway.hos.srm.business.center.model.dto.baseData.ProjectApplyTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ProjectApplyTypeVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmProjectApplyType;
/**
 * <p>
 * 项目申报类型 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmProjectApplyTypeService extends BaseService<SrmProjectApplyType> {

    @Transactional
    Long saveOrUpdateProjectApplyType(BaseDataProjDto baseDataProjDto);

    ProjectApplyTypeVo getDetailProjectApplyType(Long RowId);
    IPage<ProjectApplyTypeVo> listProjectApplyType(ProjectApplyTypeDto projectApplyTypeDto);

    void deleteProjectApplyType(BaseDto baseDto);

    Long getIdByName(String name);
    List<CombVo> getProjectApplyType();
}
