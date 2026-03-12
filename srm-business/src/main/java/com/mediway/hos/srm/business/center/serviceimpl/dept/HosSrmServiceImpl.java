package com.mediway.hos.srm.business.center.serviceimpl.dept;

import com.mediway.hos.app.org.model.organization.entity.HosOrgOrganization;
import com.mediway.hos.app.org.model.pos.entity.HosOrgPositionDict;
import com.mediway.hos.app.org.model.post.entity.HosOrgPost;
import com.mediway.hos.app.org.service.organization.HosOrganizationService;
import com.mediway.hos.app.org.service.pos.HosPositionDictService;
import com.mediway.hos.app.org.service.post.HosPostService;
import com.mediway.hos.srm.business.center.constants.SrmConstants;
import com.mediway.hos.srm.business.center.service.dept.HosSrmService;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.List;

/**
 *
 * className srm.business.center.service.impl.HosSrmUserServiceImpl
 * description 科研组织机构同步Hos系统服务类
 * @author baiyingjie
 * @version 1.0
 * @company 东华医为科技有限公司
 * @date 2025-03-24 15:39 */
@Service
public class HosSrmServiceImpl implements HosSrmService {

    @Resource
    private HosOrganizationService hosOrganizationService;
    @Resource
    private HosPositionDictService hosPositionDictService;
    @Resource
    private HosPostService hosPostService;

    @Override
    public List<HosOrgOrganization> getHosOrgOrganizationList(){
        List<HosOrgOrganization> organizationList = hosOrganizationService.selectAll();
        return organizationList;
    }

    @Override
    public HosOrgPositionDict getHosDefaultPositionDit() {
        HosOrgPositionDict dict=new HosOrgPositionDict();
        dict.setCode(SrmConstants.DEFAULT_POSITION);
        List<HosOrgPositionDict> positionDictList=hosPositionDictService.selectList(dict);
        if(positionDictList!=null&&positionDictList.size()>0){
            return positionDictList.get(0);
        }else {
            return null;
        }
    }

    @Override
    public HosOrgPost getDefaultHosOrgPost(String deptCode) {
        HosOrgPost orgPost=new HosOrgPost();
        orgPost.setDeptCode(deptCode);
        orgPost.setPostcCode(SrmConstants.DEFAULT_POST_CODE);
        orgPost.setBuCode(SrmConstants.DEFAULT_BUSINESS_UNIT_CODE);
        List<HosOrgPost> list= hosPostService.selectList(orgPost);
        if(list!=null&&list.size()>0)
            return list.get(0);
        else
            return null;
    }
}
