package com.mediway.hos.srm.runner;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mediway.hos.srm.business.center.model.entity.user.SrmUser;
import com.mediway.hos.srm.business.center.service.project.SrmProjectFinalcheckService;
import com.mediway.hos.srm.business.center.service.project.SrmProjectMidcheckService;
import com.mediway.hos.srm.business.center.service.projectapply.SrmProjectSolicitAuditService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.mediway.hos.srm.business.center.mapper.user.SrmUserMapper;

@SpringBootTest
class HosSrmCenterApplicationTests {
    @Autowired
    private SrmProjectSolicitAuditService srmProjectSolicitAuditService;
    @Autowired
    private SrmProjectMidcheckService srmProjectMidcheckService;
    @Autowired
    private SrmProjectFinalcheckService srmProjectFinalcheckService;
    @Autowired
    private SrmUserMapper srmUserMapper;
    @Test
    void testY(){

        // 创建查询条件构造器
        QueryWrapper<SrmUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("account", "admin");
        // 调用selectOne方法查询单条数据
        SrmUser user = srmUserMapper.selectOne(queryWrapper);
        System.out.println(user);

    }


}
