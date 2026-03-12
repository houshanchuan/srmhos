package com.mediway.hos.srm.business.center.mapper.baseData;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.mediway.hos.srm.business.center.model.dto.baseData.ProjectStatusDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ProjectStatusVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmProjectStatus;
/**
 * <p>
 * 项目状态代码 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmProjectStatusMapper extends BaseMapper<SrmProjectStatus> {
    IPage<ProjectStatusVo> listProjectStatus(@Param("page") Page<ProjectStatusVo> page, @Param("projectStatusDto") ProjectStatusDto projectStatusDto);
}
