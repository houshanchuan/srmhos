package com.mediway.hos.srm.business.center.service.project;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;

import com.mediway.hos.srm.business.center.model.dto.project.ProjectMidcheckDto;
import com.mediway.hos.srm.business.center.model.entity.project.SrmProjectMidcheck;
import com.mediway.hos.srm.business.base.service.BaseService;

import com.mediway.hos.srm.business.center.model.vo.project.ProjectMidcheckVo;
import com.mediway.hos.srm.business.center.model.vo.project.ProjectsInfoVo;

/**
 * <p>
 * 中检信息表 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmProjectMidcheckService extends BaseService<SrmProjectMidcheck> {
    ProjectMidcheckVo getDetail(String rowId);
    Long saveProjectMidcheck(ProjectMidcheckDto projectMidcheckDto);

    IPage<ProjectMidcheckVo> listProjectMidcheck(ProjectMidcheckDto projectMidcheckDto);

    void deleteProjectMidcheck(BaseDto baseDto);
    void subMit(BaseDto baseDto);

    void audit(BaseDto baseDto);
    IPage<ProjectsInfoVo> listAuditProjectMidcheck(ProjectMidcheckDto projectMidcheckDto);
}
