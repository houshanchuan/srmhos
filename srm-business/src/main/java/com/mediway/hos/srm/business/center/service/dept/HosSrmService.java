package com.mediway.hos.srm.business.center.service.dept;

import com.mediway.hos.app.org.model.organization.entity.HosOrgOrganization;
import com.mediway.hos.app.org.model.pos.entity.HosOrgPositionDict;
import com.mediway.hos.app.org.model.post.entity.HosOrgPost;

import java.util.List;

public interface HosSrmService {

    /**
     *
     * @description 获取HOS平台组织机构对象
     * @method getHosDefaultOrgOrganization
     * @return HosOrgOrganization
     * @author baiyingjie
     * @version 1.0
     * @company 东华医为科技有限公司
     * @date 2025-03-24 15:44
     * */
    public List<HosOrgOrganization> getHosOrgOrganizationList();

    /**
     *
     * @description 获取系统默认职位
     * @method getHosDefaultPositionDit
     * @return HosOrgPositionDict
     * @author baiyingjie
     * @version 1.0
     * @company 东华医为科技有限公司
     * @date 2025-03-24 16:06     */
    public HosOrgPositionDict getHosDefaultPositionDit();

    /**
     *
     * @description 根据机构编码查询组织岗位
     * @method getDefaultHosOrgPostList
     * @return List<HosOrgPost>
     * @author baiyingjie
     * @version 1.0
     * @company 东华医为科技有限公司
     * @date 2025-03-27 15:29     */
    public HosOrgPost getDefaultHosOrgPost(String deptCode);
}
