package com.mediway.hos.srm.business.center.mapper.dept;

import org.apache.ibatis.annotations.Param;
import com.mediway.hos.srm.business.center.model.entity.dept.SrmDeptUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.dept.DeptUserVo;

import java.util.List;

/**
 * <p>
 * 组织关系定义 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-08-23
 */
public interface SrmDeptUserMapper extends BaseMapper<SrmDeptUser> {
    List<String> getAuditUser(@Param("userId") String userId,@Param("deptId") String deptId,@Param("isDirector") String isDirector,@Param("isSecretary") String isSecretary);
    DeptUserVo getTeacher(@Param("userId") String userId);

    DeptUserVo getRowIdByDeptUser(@Param("deptId") String deptId,@Param("userId") String userId);
    List<String> getDirectorByDept(@Param("deptId") String deptId);
    List<String> getDirectorByUser(@Param("userId") String userId);

}
