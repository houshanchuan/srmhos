package com.mediway.hos.srm.business.center.service.dept;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.srm.business.center.model.dto.dept.DeptDto;
import com.mediway.hos.srm.business.center.model.entity.dept.SrmDept;
import com.mediway.hos.srm.business.base.service.BaseService;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import com.mediway.hos.srm.business.center.model.vo.dept.DeptVo;

import java.util.List;

/**
 * <p>
 * 科室信息表 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-07-19
 */
public interface SrmDeptService extends BaseService<SrmDept> {
    List<CombVo> getDept(DeptDto deptDto);

    IPage<DeptVo> listDept(DeptDto deptDto);

    DeptVo getDetail(String rowId);

    String saveDept(DeptDto deptDto);

    List<CombVo>  getDivision();
}
