package com.mediway.hos.srm.business.center.mapper.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.dto.baseData.DeptTypeDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmDeptType;
import com.mediway.hos.srm.business.center.model.vo.baseData.DeptTypeVo;

/**
 * <p>
 * 部门类型 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmDeptTypeMapper extends BaseMapper<SrmDeptType> {
    IPage<DeptTypeVo> listDeptType(@Param("page") Page<DeptTypeVo> page, @Param("deptTypeDto") DeptTypeDto deptTypeDto);

}
