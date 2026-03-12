package com.mediway.hos.srm.business.center.mapper.projectapply;

import org.apache.ibatis.annotations.Param;
import com.mediway.hos.srm.business.center.model.entity.projectapply.SrmProjectSolicitMember;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.projectapply.ProjectSolicitMemberVo;

import java.util.List;

/**
 * <p>
 * 项目申报参与人 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmProjectSolicitMemberMapper extends BaseMapper<SrmProjectSolicitMember> {
    List<ProjectSolicitMemberVo> listProjectSolicitMember(@Param("parentId") Long parentId);
    void deleteAuthorByParent(@Param("parentId") Long parentId);
}
