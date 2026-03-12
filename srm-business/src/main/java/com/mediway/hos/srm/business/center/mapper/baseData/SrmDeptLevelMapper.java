package com.mediway.hos.srm.business.center.mapper.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.mediway.hos.srm.business.center.model.dto.baseData.DeptLevelDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.DeptLevelVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmDeptLevel;

/**
 * <p>
 * 部门级别 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmDeptLevelMapper extends BaseMapper<SrmDeptLevel> {
    IPage<DeptLevelVo> listDeptLevel(@Param("page") Page<DeptLevelVo> page, @Param("deptLevelDto") DeptLevelDto deptLevelDto);
}
