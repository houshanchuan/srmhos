package com.mediway.hos.srm.business.center.service.project;

import com.baomidou.mybatisplus.core.metadata.IPage;

import com.mediway.hos.srm.business.center.model.dto.project.ProjectMidcheckListInfoDto;
import com.mediway.hos.srm.business.center.model.entity.project.SrmProjectMidcheckListInfo;
import com.mediway.hos.srm.business.base.service.BaseService;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import com.mediway.hos.srm.business.center.model.vo.project.ProjectMidcheckListInfoVo;

import java.util.List;

/**
 * <p>
 * 中检批次信息表 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmProjectMidcheckListInfoService extends BaseService<SrmProjectMidcheckListInfo> {
    ProjectMidcheckListInfoVo getDetail(String rowId);
    IPage<ProjectMidcheckListInfoVo> listProjectMidCheckListInfo(ProjectMidcheckListInfoDto projectMidcheckListInfoDto);
    Long saveProjectMidCheckListInfo(ProjectMidcheckListInfoDto projectMidcheckListInfoDto);
    List<CombVo> getprojectMidcheckListInfo(String name);
}
