package com.mediway.hos.srm.business.center.mapper.project;

import org.apache.ibatis.annotations.Param;
import com.mediway.hos.srm.business.center.model.entity.project.SrmProjectsInfoMember;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.project.ProjectsInfoMemberVo;

import java.util.List;

/**
 * <p>
 * 项目参与人 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmProjectsInfoMemberMapper extends BaseMapper<SrmProjectsInfoMember> {
    List<ProjectsInfoMemberVo> listProjectInfoAuthor(@Param("parentId") Long parentId);
    void deleteAuthorByParent(@Param("parentId") Long parentId);
}
