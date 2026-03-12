package com.mediway.hos.srm.business.center.service.project;

import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.dto.project.ProjectsInfoMemberDto;
import com.mediway.hos.srm.business.center.model.entity.project.SrmProjectsInfoMember;
import com.mediway.hos.srm.business.base.service.BaseService;
import com.mediway.hos.srm.business.center.model.vo.project.ProjectsInfoMemberVo;

import java.util.List;

/**
 * <p>
 * 项目参与人 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmProjectsInfoMemberService extends BaseService<SrmProjectsInfoMember> {
    public List<ProjectsInfoMemberVo> listProjectInfoAuthor(BaseDto baseDto);
    void deleteAuthorByParent(Long parentId);
    void deleteAuthorById(BaseDto baseDto);
    Long saveAuthor(ProjectsInfoMemberDto projectsInfoMemberDto);
}
