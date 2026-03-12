package com.mediway.hos.srm.business.center.serviceimpl.dept;

import org.springframework.beans.factory.annotation.Autowired;
import com.mediway.hos.srm.business.center.model.entity.dept.SrmDeptUser;
import com.mediway.hos.srm.business.center.mapper.dept.SrmDeptUserMapper;
import com.mediway.hos.srm.business.center.model.vo.dept.DeptUserVo;
import com.mediway.hos.srm.business.center.service.dept.SrmDeptUserService;
import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 组织关系定义 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-08-23
 */
@Service
public class SrmDeptUserServiceImpl extends BaseServiceImpl<SrmDeptUserMapper, SrmDeptUser> implements SrmDeptUserService {
    @Autowired
    private SrmDeptUserMapper srmDeptUserMapper;
    @Override
    public String getAuditUser(String userId, String deptId, String isDirector, String isSecretary) {
        List<String> list= srmDeptUserMapper.getAuditUser(userId,deptId,isDirector,isSecretary);
        String result=String.join(",",list);
        return result;
    }

    @Override
    public String getDirectorByDept(String deptId) {
        List<String> list= srmDeptUserMapper.getDirectorByDept(deptId);
        String result=String.join(",",list);
        return result;
    }

    @Override
    public String getDirectorByUser(String userId) {
        List<String> list= srmDeptUserMapper.getDirectorByUser(userId);
        String result=String.join(",",list);
        return result;
    }

    @Override
    public DeptUserVo getTeacher(String userId) {
        DeptUserVo deptUserVo= srmDeptUserMapper.getTeacher(userId);
        return deptUserVo;
    }

    @Override
    public DeptUserVo getRowIdByDeptUser(String deptId, String userId) {
        return srmDeptUserMapper.getRowIdByDeptUser(deptId,userId);
    }

    @Override
    public void saveDeptUser(SrmDeptUser srmDeptUser) {
        super.saveOrUpdate(srmDeptUser);
    }
}
