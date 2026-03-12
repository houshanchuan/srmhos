package com.mediway.hos.srm.business.center.mapper.projectapply;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.mediway.hos.srm.business.center.model.dto.projectapply.ProjectSolicitDto;
import com.mediway.hos.srm.business.center.model.entity.projectapply.SrmProjectSolicit;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.projectapply.ProjectSolicitVo;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 项目征集(申报)信息表 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmProjectSolicitMapper extends BaseMapper<SrmProjectSolicit> {
    ProjectSolicitVo getDetail(@Param("rowId") String rowId);
    IPage<ProjectSolicitVo> listProjectSolicit(@Param("page") Page<ProjectSolicitVo> page, @Param("projectSolicitDto") ProjectSolicitDto projectSolicitDto);
    void updateStatus(@Param("rowId") Long rowId,@Param("status") Integer status,@Param("auditStatus") String auditStatus,@Param("preAuditState") String preAuditState,@Param("headerAuditStatus") String headerAuditStatus,@Param("subUserId") String subUserId,@Param("subDate") LocalDateTime subDate);

    IPage<ProjectSolicitVo> listHeadAuditProjectSolicit(@Param("page") Page<ProjectSolicitVo> page, @Param("projectSolicitDto") ProjectSolicitDto projectSolicitDto);
    IPage<ProjectSolicitVo> listAuditProjectSolicit(@Param("page") Page<ProjectSolicitVo> page, @Param("projectSolicitDto") ProjectSolicitDto projectSolicitDto);
    List<ProjectSolicitVo> listAuditProjectSolicitNew(@Param("projectSolicitDto") ProjectSolicitDto projectSolicitDto);
}
