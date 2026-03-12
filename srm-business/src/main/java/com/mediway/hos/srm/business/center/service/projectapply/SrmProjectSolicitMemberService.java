package com.mediway.hos.srm.business.center.service.projectapply;

import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.dto.projectapply.ProjectSolicitMemberDto;
import com.mediway.hos.srm.business.center.model.entity.projectapply.SrmProjectSolicitMember;
import com.mediway.hos.srm.business.base.service.BaseService;
import com.mediway.hos.srm.business.center.model.vo.projectapply.ProjectSolicitMemberVo;

import java.util.List;

/**
 * <p>
 * 项目申报参与人 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmProjectSolicitMemberService extends BaseService<SrmProjectSolicitMember> {
    public List<ProjectSolicitMemberVo> listProjectSolicitMember(BaseDto baseDto);
    void deleteAuthorByParent(Long parentId);
    void deleteAuthorById(BaseDto baseDto);
    Long saveAuthor(ProjectSolicitMemberDto projectSolicitMemberDto);
}
