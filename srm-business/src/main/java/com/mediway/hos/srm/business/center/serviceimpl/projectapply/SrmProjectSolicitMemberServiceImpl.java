package com.mediway.hos.srm.business.center.serviceimpl.projectapply;

import com.mediway.hos.srm.business.center.model.dto.projectapply.ProjectSolicitMemberDto;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.exception.ErrorException;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.entity.projectapply.SrmProjectSolicitMember;
import com.mediway.hos.srm.business.center.mapper.projectapply.SrmProjectSolicitMemberMapper;
import com.mediway.hos.srm.business.center.model.vo.projectapply.ProjectSolicitMemberVo;
import com.mediway.hos.srm.business.center.service.projectapply.SrmProjectSolicitMemberService;
import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 项目申报参与人 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmProjectSolicitMemberServiceImpl extends BaseServiceImpl<SrmProjectSolicitMemberMapper, SrmProjectSolicitMember> implements SrmProjectSolicitMemberService {
    @Autowired
    private SrmProjectSolicitMemberMapper srmProjectSolicitMemberMapper;
    @Override
    public List<ProjectSolicitMemberVo> listProjectSolicitMember(BaseDto baseDto) {
        return srmProjectSolicitMemberMapper.listProjectSolicitMember(baseDto.getId());
    }

    @Override
    public void deleteAuthorByParent(Long parentId) {
        srmProjectSolicitMemberMapper.deleteAuthorByParent(parentId);
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
    public Long saveAuthor(ProjectSolicitMemberDto projectSolicitMemberDto) {
        SrmProjectSolicitMember srmProjectSolicitMember=new SrmProjectSolicitMember();
        srmProjectSolicitMember.setSoliProjId(projectSolicitMemberDto.getSoliProjId());
        srmProjectSolicitMember.setId(projectSolicitMemberDto.getRowId());
        srmProjectSolicitMember.setAuthorTypeCode(projectSolicitMemberDto.getAuthorTypeCode());
        srmProjectSolicitMember.setMemberId(projectSolicitMemberDto.getMemberId());
        srmProjectSolicitMember.setMemberName(projectSolicitMemberDto.getMemberName());
        srmProjectSolicitMember.setDeptCode(projectSolicitMemberDto.getDeptCode());
        srmProjectSolicitMember.setEduLevelCode(projectSolicitMemberDto.getEduLevelCode());
        srmProjectSolicitMember.setRanking(projectSolicitMemberDto.getRanking());
        srmProjectSolicitMember.setNote(projectSolicitMemberDto.getNote());
        srmProjectSolicitMember.setTitleCode(projectSolicitMemberDto.getTitleCode());
        srmProjectSolicitMember.setWorkRatio(projectSolicitMemberDto.getWorkRatio());
        srmProjectSolicitMember.setWorkTime(projectSolicitMemberDto.getWorkTime());
        this.saveOrUpdate(srmProjectSolicitMember);
        return srmProjectSolicitMember.getId();
    }
}
