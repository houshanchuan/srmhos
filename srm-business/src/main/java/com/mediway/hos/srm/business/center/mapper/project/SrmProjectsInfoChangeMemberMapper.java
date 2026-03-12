package com.mediway.hos.srm.business.center.mapper.project;

import org.apache.ibatis.annotations.Param;
import com.mediway.hos.srm.business.center.model.entity.project.SrmProjectsInfoChangeMember;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.project.ProjectsInfoChangeMemberVo;

import java.util.List;

/**
 * <p>
 * 项目变更人员信息表 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmProjectsInfoChangeMemberMapper extends BaseMapper<SrmProjectsInfoChangeMember> {

    List<ProjectsInfoChangeMemberVo> listProjectsInfoChangeAuthor(@Param("parentId") Long parentId);
    void deleteAuthorByParent(@Param("parentId") Long parentId);
}
