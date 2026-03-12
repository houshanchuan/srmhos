package com.mediway.hos.srm.business.center.mapper.projectapply;

import org.apache.ibatis.annotations.Param;
import com.mediway.hos.srm.business.center.model.dto.projectapply.ProjectSolicitAuditDto;
import com.mediway.hos.srm.business.center.model.entity.projectapply.SrmProjectSolicitAudit;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.projectapply.ProjectSolicitAuditExpertVo;
import com.mediway.hos.srm.business.center.model.vo.projectapply.ProjectSolicitAuditVo;

import java.util.List;

/**
 * <p>
 * 项目征集权限表 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmProjectSolicitAuditMapper extends BaseMapper<SrmProjectSolicitAudit> {
    String getCurExpertList(@Param("sysNo") String sysNo, @Param("rowId") Long rowId);
    String getCurEthicExpertList(@Param("sysNo") String sysNo, @Param("rowId") Long rowId);

    List<ProjectSolicitAuditExpertVo> getNoAllotExpert();
    List<ProjectSolicitAuditExpertVo> getNoEthicAllotExpert();

    String getRowId(@Param("projectSolicitAuditDto") ProjectSolicitAuditDto projectSolicitAuditDto);
    void updateProjectSolicitAudit(@Param("sysNo") String sysNo, @Param("ywRowId") String ywRowId,@Param("type") String type,@Param("allotCount") String allotCount, @Param("expertList") String expertList, @Param("ethicExpertList") String ethicExpertList);
    ProjectSolicitAuditVo getMainInfo(@Param("projectSolicitAuditDto") ProjectSolicitAuditDto projectSolicitAuditDto);

    void updateCancel(@Param("sysNo") String sysNo, @Param("ywRowId") String ywRowId);
}

