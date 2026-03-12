package com.mediway.hos.srm.business.center.mapper.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import java.util.List;

import com.mediway.hos.srm.business.center.model.dto.baseData.ProjectApplyBookTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ProjectApplyBookTypeVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmProjectApplyBookType;

/**
 * <p>
 * 项目申报类别 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmProjectApplyBookTypeMapper extends BaseMapper<SrmProjectApplyBookType> {
    IPage<ProjectApplyBookTypeVo> listProjectApplyBookType(@Param("page") Page<ProjectApplyBookTypeVo> page, @Param("projectApplyBookTypeDto") ProjectApplyBookTypeDto projectApplyBookTypeDto);
    List<CombVo> getProjectApplyBookType();
}
