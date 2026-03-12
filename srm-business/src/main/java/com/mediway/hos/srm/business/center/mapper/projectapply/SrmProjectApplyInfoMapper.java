package com.mediway.hos.srm.business.center.mapper.projectapply;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.mediway.hos.srm.business.center.model.dto.projectapply.ProjectApplyInfoDto;
import com.mediway.hos.srm.business.center.model.entity.projectapply.SrmProjectApplyInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.projectapply.ProjectApplyInfoVo;

/**
 * <p>
 * 项目申报批次 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-23
 */
public interface SrmProjectApplyInfoMapper extends BaseMapper<SrmProjectApplyInfo> {
    IPage<ProjectApplyInfoVo> listProjectApplyPlan(@Param("page") Page<ProjectApplyInfoVo> page, @Param("projectApplyInfoDto") ProjectApplyInfoDto projectApplyInfoDto);
    ProjectApplyInfoVo getDetail(@Param("rowId") Long rowId);
}
