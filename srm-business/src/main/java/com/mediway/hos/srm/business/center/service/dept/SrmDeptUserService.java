package com.mediway.hos.srm.business.center.service.dept;

import com.mediway.hos.srm.business.center.model.entity.dept.SrmDeptUser;
import com.mediway.hos.srm.business.base.service.BaseService;
import com.mediway.hos.srm.business.center.model.vo.dept.DeptUserVo;

/**
 * <p>
 * 组织关系定义 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-08-23
 */
public interface SrmDeptUserService extends BaseService<SrmDeptUser> {
    String getAuditUser(String userId,String deptId,String isDirector,String isSecretary);
    DeptUserVo getTeacher(String userId);

    String getDirectorByDept(String deptId);
    String getDirectorByUser(String userId);
    DeptUserVo getRowIdByDeptUser(String deptId,String userid);
    void saveDeptUser(SrmDeptUser srmDeptUser);
}
