package com.mediway.hos.srm.business.center.serviceimpl.project;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.exception.ErrorException;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.entity.project.SrmProjectsInfoChangeMember;
import com.mediway.hos.srm.business.center.mapper.project.SrmProjectsInfoChangeMemberMapper;
import com.mediway.hos.srm.business.center.model.vo.project.ProjectsInfoChangeMemberVo;
import com.mediway.hos.srm.business.center.service.project.SrmProjectsInfoChangeMemberService;
import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 项目变更人员信息表 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmProjectsInfoChangeMemberServiceImpl extends BaseServiceImpl<SrmProjectsInfoChangeMemberMapper, SrmProjectsInfoChangeMember> implements SrmProjectsInfoChangeMemberService {
    @Autowired
    private SrmProjectsInfoChangeMemberMapper srmProjectsInfoChangeMemberMapper;
    @Override
    public List<ProjectsInfoChangeMemberVo> listProjectsInfoChangeAuthor(BaseDto baseDto) {
        return srmProjectsInfoChangeMemberMapper.listProjectsInfoChangeAuthor(baseDto.getId());
    }

    @Override
    public void deleteAuthorByParent(Long parentId) {
        srmProjectsInfoChangeMemberMapper.deleteAuthorByParent(parentId);
    }

    @Override
    @Transactional
    public void deleteAuthorById(BaseDto baseDto) {
        List<Long> idList=baseDto.getIdList();
        String idStr="";
        try{
            for (Long RowId : idList) {
                if(StringUtils.isEmpty(idStr)){
                    idStr=String.valueOf(RowId);
                }else{
                    idStr=idStr+","+String.valueOf(RowId);
                }
            }
            super.deleteByIds(idStr);
        }catch (Exception exception){
            throw  new ErrorException("-200",exception.getMessage());
        }
    }
}
