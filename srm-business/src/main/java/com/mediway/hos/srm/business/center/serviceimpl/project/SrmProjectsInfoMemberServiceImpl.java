package com.mediway.hos.srm.business.center.serviceimpl.project;

import com.mediway.hos.srm.business.center.model.dto.project.ProjectsInfoMemberDto;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.exception.ErrorException;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.entity.project.SrmProjectsInfoMember;
import com.mediway.hos.srm.business.center.mapper.project.SrmProjectsInfoMemberMapper;
import com.mediway.hos.srm.business.center.model.vo.project.ProjectsInfoMemberVo;
import com.mediway.hos.srm.business.center.service.project.SrmProjectsInfoMemberService;
import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 项目参与人 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmProjectsInfoMemberServiceImpl extends BaseServiceImpl<SrmProjectsInfoMemberMapper, SrmProjectsInfoMember> implements SrmProjectsInfoMemberService {
    @Autowired
    private SrmProjectsInfoMemberMapper srmProjectsInfoMemberMapper;
    @Override
    public List<ProjectsInfoMemberVo> listProjectInfoAuthor(BaseDto baseDto) {
        Long parentId=baseDto.getId();
        return srmProjectsInfoMemberMapper.listProjectInfoAuthor(parentId);
    }

    @Override
    public void deleteAuthorByParent(Long parentId) {
        srmProjectsInfoMemberMapper.deleteAuthorByParent(parentId);
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

    @Override
    public Long saveAuthor(ProjectsInfoMemberDto projectsInfoMemberDto) {
        SrmProjectsInfoMember srmProjectsInfoMember=new SrmProjectsInfoMember();
        srmProjectsInfoMember.setMember(projectsInfoMemberDto.getMember());
        srmProjectsInfoMember.setMemberName(projectsInfoMemberDto.getMemberName());
        srmProjectsInfoMember.setAuthorTypeCode(projectsInfoMemberDto.getAuthorTypeCode());
        srmProjectsInfoMember.setRanking(projectsInfoMemberDto.getRanking());
        srmProjectsInfoMember.setTitleCode(projectsInfoMemberDto.getTitleCode());
        srmProjectsInfoMember.setDeptCode(projectsInfoMemberDto.getDeptCode());
        srmProjectsInfoMember.setNote(projectsInfoMemberDto.getNote());
        srmProjectsInfoMember.setProjId(projectsInfoMemberDto.getProjId());
        srmProjectsInfoMember.setNote(projectsInfoMemberDto.getNote());
        srmProjectsInfoMember.setWorkRatio(projectsInfoMemberDto.getWorkRatio());
        srmProjectsInfoMember.setWorkTime(projectsInfoMemberDto.getWorkTime());
        this.saveOrUpdate(srmProjectsInfoMember);
        return srmProjectsInfoMember.getId();
    }
}
