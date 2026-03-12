package com.mediway.hos.srm.business.center.mapper.projectapply;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.mediway.hos.srm.business.center.model.dto.projectapply.ProjectSolicitDto;
import com.mediway.hos.srm.business.center.model.dto.projectapply.ProjectSolicitEthicAuditDto;
import com.mediway.hos.srm.business.center.model.entity.projectapply.SrmProjectSolicitEthicAudit;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.projectapply.ProjectSolicitAuditExpertVo;
import com.mediway.hos.srm.business.center.model.vo.projectapply.ProjectSolicitEthicAuditVo;

import java.util.List;

/**
 * <p>
 * 项目征集伦理审批表 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmProjectSolicitEthicAuditMapper extends BaseMapper<SrmProjectSolicitEthicAudit> {

    List<ProjectSolicitAuditExpertVo> listProjectSolicitEthicAudit(@Param("projectSolicitEthicAuditDto") ProjectSolicitEthicAuditDto projectSolicitEthicAuditDto);
    IPage<ProjectSolicitEthicAuditVo> listEthicAuditProjectSolicit(@Param("page") Page<ProjectSolicitEthicAuditVo> page, @Param("projectSolicitDto") ProjectSolicitDto projectSolicitDto);
    List<ProjectSolicitEthicAuditVo> listEthicAuditProjectSolicitDetail(@Param("projectSolicitEthicAuditDto") ProjectSolicitEthicAuditDto projectSolicitEthicAuditDto);
    void updateCancel(@Param("sysNo") String sysNo, @Param("ywRowId") String ywRowId);

}
