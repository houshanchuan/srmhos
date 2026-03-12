package com.mediway.hos.srm.business.center.service.project;

import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.entity.project.SrmProjectsInfoChangeMember;
import com.mediway.hos.srm.business.base.service.BaseService;
import com.mediway.hos.srm.business.center.model.vo.project.ProjectsInfoChangeMemberVo;

import java.util.List;

/**
 * <p>
 * 项目变更人员信息表 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmProjectsInfoChangeMemberService extends BaseService<SrmProjectsInfoChangeMember> {
    public List<ProjectsInfoChangeMemberVo> listProjectsInfoChangeAuthor(BaseDto baseDto);
    void deleteAuthorByParent(Long parentId);
    void deleteAuthorById(BaseDto baseDto);
}
