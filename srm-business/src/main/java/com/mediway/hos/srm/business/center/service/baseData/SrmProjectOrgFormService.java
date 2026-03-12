package com.mediway.hos.srm.business.center.service.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataProjDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;
import java.util.List;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import com.mediway.hos.srm.business.center.model.dto.baseData.ProjectOrgFormDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ProjectOrgFormVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmProjectOrgForm;

/**
 * <p>
 * 项目组织形式 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmProjectOrgFormService extends BaseService<SrmProjectOrgForm> {
    @Transactional
    Long saveOrUpdateProjectOrgForm(BaseDataProjDto baseDataProjDto);

    ProjectOrgFormVo getDetailProjectOrgForm(Long RowId);
    IPage<ProjectOrgFormVo> listProjectOrgForm(ProjectOrgFormDto projectOrgFormDto);

    void deleteProjectOrgForm(BaseDto baseDto);

    Long getIdByName(String name);
    List<CombVo> getProjectOrgForm(ProjectOrgFormDto projectOrgFormDto);
}
