package com.mediway.hos.srm.business.center.mapper.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import java.util.List;

import com.mediway.hos.srm.business.center.model.dto.baseData.ProjectApplyTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ProjectApplyTypeVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmProjectApplyType;


/**
 * <p>
 * 项目申报类型 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmProjectApplyTypeMapper extends BaseMapper<SrmProjectApplyType> {
    IPage<ProjectApplyTypeVo> listProjectApplyType(@Param("page") Page<ProjectApplyTypeVo> page, @Param("projectApplyTypeDto") ProjectApplyTypeDto projectApplyTypeDto);
    List<CombVo> getProjectApplyType();
}
