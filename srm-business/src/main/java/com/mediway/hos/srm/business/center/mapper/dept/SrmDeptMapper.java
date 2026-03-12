package com.mediway.hos.srm.business.center.mapper.dept;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.mediway.hos.srm.business.center.model.dto.dept.DeptDto;
import com.mediway.hos.srm.business.center.model.entity.dept.SrmDept;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import com.mediway.hos.srm.business.center.model.vo.dept.DeptVo;

import java.util.List;

/**
 * <p>
 * 科室信息表 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-07-19
 */
public interface SrmDeptMapper extends BaseMapper<SrmDept> {
    List<CombVo> getDept(@Param("deptDto") DeptDto deptDto);
    IPage<DeptVo> listDept(@Param("page") Page<DeptVo> page, @Param("deptDto") DeptDto deptDto);

    DeptVo getDetail(@Param("RowId") String RowId);

    List<CombVo> getDivision();
}
