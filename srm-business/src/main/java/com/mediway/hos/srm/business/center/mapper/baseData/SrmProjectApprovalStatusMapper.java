package com.mediway.hos.srm.business.center.mapper.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;


import com.mediway.hos.srm.business.center.model.dto.baseData.ProjectApprovalStatusDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ProjectApprovalStatusVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmProjectApprovalStatus;

/**
 * <p>
 * 项目申报立项状态 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmProjectApprovalStatusMapper extends BaseMapper<SrmProjectApprovalStatus> {
    IPage<ProjectApprovalStatusVo> listProjectApprovalStatus(@Param("page") Page<ProjectApprovalStatusVo> page, @Param("projectApprovalStatusDto") ProjectApprovalStatusDto projectApprovalStatusDto);

}
