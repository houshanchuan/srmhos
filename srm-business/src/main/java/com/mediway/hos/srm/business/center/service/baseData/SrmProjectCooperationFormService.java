package com.mediway.hos.srm.business.center.service.baseData;


import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataProjDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;
import java.util.List;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import com.mediway.hos.srm.business.center.model.dto.baseData.ProjectCooprateFormDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ProjectCooprateFormVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmProjectCooperationForm;

/**
 * <p>
 * 项目合作形式 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmProjectCooperationFormService extends BaseService<SrmProjectCooperationForm> {

    @Transactional
    Long saveOrUpdateProjectCooprateForm(BaseDataProjDto baseDataProjDto);

    ProjectCooprateFormVo getDetailProjectCooprateForm(Long RowId);
    IPage<ProjectCooprateFormVo> listProjectCooprateForm(ProjectCooprateFormDto projectCooprateFormDto);

    void deleteProjectCooprateForm(BaseDto baseDto);

    Long getIdByName(String name);
    List<CombVo> getProjectCooprateForm(ProjectCooprateFormDto projectCooprateFormDto);
}
