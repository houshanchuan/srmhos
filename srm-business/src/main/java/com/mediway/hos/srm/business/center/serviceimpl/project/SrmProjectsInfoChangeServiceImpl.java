package com.mediway.hos.srm.business.center.serviceimpl.project;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mediway.hos.app.core.util.SecurityUtils;
import com.mediway.hos.security.core.userdetails.HosUser;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmPersonTypeMapper;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmProductModeMapper;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmProjectStatusMapper;
import com.mediway.hos.srm.business.center.mapper.dept.SrmDeptMapper;
import com.mediway.hos.srm.business.center.mapper.project.SrmProjectsInfoChangeMapper;
import com.mediway.hos.srm.business.center.mapper.project.SrmProjectsInfoMapper;
import com.mediway.hos.srm.business.center.mapper.user.SrmUserMapper;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.dto.project.ProjectsInfoChangeDto;
import com.mediway.hos.srm.business.center.model.dto.project.ProjectsInfoChangeMainDto;
import com.mediway.hos.srm.business.center.model.dto.project.ProjectsInfoChangeMemberDto;
import com.mediway.hos.srm.business.center.model.dto.project.ProjectsInfoMemberDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmPersonType;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmProductMode;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmProjectStatus;
import com.mediway.hos.srm.business.center.model.entity.dept.SrmDept;
import com.mediway.hos.srm.business.center.model.entity.project.SrmProjectsInfo;
import com.mediway.hos.srm.business.center.model.entity.project.SrmProjectsInfoChange;
import com.mediway.hos.srm.business.center.model.entity.project.SrmProjectsInfoChangeMember;
import com.mediway.hos.srm.business.center.model.entity.project.SrmProjectsInfoMember;
import com.mediway.hos.srm.business.center.model.entity.user.SrmUser;
import com.mediway.hos.srm.business.center.model.vo.project.ProjectsInfoChangeMemberVo;
import com.mediway.hos.srm.business.center.model.vo.project.ProjectsInfoMemberVo;
import com.mediway.hos.srm.business.center.service.approvalProcess.SrmEafRecService;
import com.mediway.hos.srm.business.center.service.baseData.SrmBusinessnoService;
import com.mediway.hos.srm.business.center.service.baseData.SrmPersonTypeService;
import com.mediway.hos.srm.business.center.service.project.SrmProjectsInfoChangeMemberService;
import com.mediway.hos.srm.business.center.service.project.SrmProjectsInfoChangeService;
import com.mediway.hos.srm.business.center.service.project.SrmProjectsInfoMemberService;
import com.mediway.hos.srm.business.center.service.project.SrmProjectsInfoService;
import com.mediway.hos.srm.business.center.service.user.SrmUserService;
import com.mediway.hos.srm.business.center.utils.DateTransform;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.exception.ErrorException;

import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import com.mediway.hos.srm.business.center.model.vo.project.ProjectsInfoChangeVo;

import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 项目变更 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmProjectsInfoChangeServiceImpl extends BaseServiceImpl<SrmProjectsInfoChangeMapper, SrmProjectsInfoChange> implements SrmProjectsInfoChangeService {
    private final String sysNo="P050";
    //private final String SysNo="P050";
    @Autowired
    private SrmProjectsInfoChangeMapper srmProjectsInfoChangeMapper;
    @Autowired
    private SrmUserService srmUserService;
    @Autowired
    private SrmProjectsInfoChangeMemberService srmProjectsInfoChangeMemberService;
    @Autowired
    private SrmEafRecService srmEafRecService;
    @Autowired
    private SrmUserMapper srmUserMapper;
    @Autowired
    private SrmDeptMapper srmDeptMapper;
    @Autowired
    private SrmProductModeMapper srmProductModeMapper;
    @Autowired
    private SrmProjectStatusMapper srmProjectStatusMapper;
    @Autowired
    private SrmProjectsInfoMapper srmProjectsInfoMapper;
    @Autowired
    private SrmBusinessnoService srmBusinessnoService;
    @Autowired
    private SrmProjectsInfoMemberService srmProjectsInfoMemberService;
    @Autowired
    private SrmPersonTypeMapper srmPersonTypeMapper;
    @Override
    public ProjectsInfoChangeVo getDetail(Long rowId) {
        /*
        // 创建查询条件构造器
        QueryWrapper<SrmUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("account", "admin");
        // 调用selectOne方法查询单条数据
        SrmUser user = srmUserMapper.selectOne(queryWrapper);
        System.out.println(user);
         */
        ProjectsInfoChangeVo projectsInfoChangeVo=srmProjectsInfoChangeMapper.getDetail(rowId);
        return  this.getNewProjectsInfoChangeVo(projectsInfoChangeVo);
    }
    public ProjectsInfoChangeVo getNewProjectsInfoChangeVo(ProjectsInfoChangeVo projectsInfoChangeVo){
        String oldDesc=projectsInfoChangeVo.getOldValueDesc();
        String newDesc=projectsInfoChangeVo.getNewValueDesc();
        String oldValue=projectsInfoChangeVo.getOldValue();
        String newValue=projectsInfoChangeVo.getNewValue();
        if(projectsInfoChangeVo.getChangeitem()!=null){
            String changeItem=projectsInfoChangeVo.getChangeitem().getId();

            if("HEAD".equals(changeItem)){
                if(oldValue!=null&&!oldValue.isEmpty()){
                    QueryWrapper<SrmUser> queryWrapper1 = new QueryWrapper<>();
                    queryWrapper1.eq("id", oldValue);
                    SrmUser user1 = srmUserMapper.selectOne(queryWrapper1);
                    projectsInfoChangeVo.setNewHeadAccount(user1.getAccount());

                    String personType=user1.getPersonType();
                    QueryWrapper<SrmPersonType> srmPersonTypeQueryWrapper=new QueryWrapper<>();

                    srmPersonTypeQueryWrapper.eq("code",personType);
                    SrmPersonType srmPersonType=srmPersonTypeMapper.selectOne(srmPersonTypeQueryWrapper);
                    if(srmPersonType!=null){
                        CombVo personTypeComb=new CombVo();
                        personTypeComb.setId(personType);
                        personTypeComb.setName(srmPersonType.getName());
                        projectsInfoChangeVo.setNewHeadType(personTypeComb);
                    }

                    oldDesc=user1.getName();
                }
                if(newValue!=null&&!newValue.isEmpty()){
                    QueryWrapper<SrmUser> queryWrapper2 = new QueryWrapper<>();
                    queryWrapper2.eq("id", newValue);
                    SrmUser user2 = srmUserMapper.selectOne(queryWrapper2);
                    newDesc=user2.getName();
                }
            }
            if("NAME".equals(changeItem)){
                if(oldValue!=null&&!oldValue.isEmpty()){
                    QueryWrapper<SrmProjectsInfo> queryWrapper1 = new QueryWrapper<>();
                    queryWrapper1.eq("id", oldValue);
                    SrmProjectsInfo srmProjectsInfo = srmProjectsInfoMapper.selectOne(queryWrapper1);
                    oldDesc=srmProjectsInfo.getName();
                }
                if(newValue!=null&&!newValue.isEmpty()){
                    QueryWrapper<SrmProjectsInfo> queryWrapper2 = new QueryWrapper<>();
                    queryWrapper2.eq("id", newValue);
                    SrmProjectsInfo srmProjectsInfo = srmProjectsInfoMapper.selectOne(queryWrapper2);
                    newDesc=srmProjectsInfo.getName();
                }
            }
            if("ACHV_FORM".equals(changeItem)){
                if(oldValue!=null&&!oldValue.isEmpty()){
                    QueryWrapper<SrmProductMode> queryWrapper1 = new QueryWrapper<>();
                    queryWrapper1.eq("code", oldValue);
                    SrmProductMode srmProductMode = srmProductModeMapper.selectOne(queryWrapper1);
                    oldDesc=srmProductMode.getName();
                }
                if(newValue!=null&&!newValue.isEmpty()){
                    QueryWrapper<SrmProductMode> queryWrapper2 = new QueryWrapper<>();
                    queryWrapper2.eq("code", newValue);
                    SrmProductMode srmProductMode = srmProductModeMapper.selectOne(queryWrapper2);
                    newDesc=srmProductMode.getName();
                }
            }
            if("DEFER".equals(changeItem)){

            }
            if("CONTENT".equals(changeItem)){

            }
            if("MAN_UNIT".equals(changeItem)){
                if(oldValue!=null&&!oldValue.isEmpty()){
                    QueryWrapper<SrmDept> queryWrapper1 = new QueryWrapper<>();
                    queryWrapper1.eq("id", oldValue);
                    SrmDept srmDept = srmDeptMapper.selectOne(queryWrapper1);
                    oldDesc=srmDept.getName();
                }
                if(newValue!=null&&!newValue.isEmpty()){
                    QueryWrapper<SrmDept> queryWrapper2 = new QueryWrapper<>();
                    queryWrapper2.eq("id", newValue);
                    SrmDept srmDept = srmDeptMapper.selectOne(queryWrapper2);
                    newDesc=srmDept.getName();
                }
            }
            if("MEMBER".equals(changeItem)){

            }
            if("SUSPEND".equals(changeItem)||"CANCEL".equals(changeItem)){
                if(oldValue!=null&&!oldValue.isEmpty()){
                    QueryWrapper<SrmProjectStatus> queryWrapper1 = new QueryWrapper<>();
                    queryWrapper1.eq("code", oldValue);
                    SrmProjectStatus srmProjectStatus = srmProjectStatusMapper.selectOne(queryWrapper1);
                    oldDesc=srmProjectStatus.getName();
                }
                if(newValue!=null&&!newValue.isEmpty()){
                    QueryWrapper<SrmProjectStatus> queryWrapper2 = new QueryWrapper<>();
                    queryWrapper2.eq("code", newValue);
                    SrmProjectStatus srmProjectStatus = srmProjectStatusMapper.selectOne(queryWrapper2);
                    newDesc=srmProjectStatus.getName();

                }
            }

        }

        if(oldValue!=null&&!oldValue.isEmpty()){
            CombVo combVo1=new CombVo();
            combVo1.setId(oldValue);
            combVo1.setName(oldDesc);
            projectsInfoChangeVo.setOldValueComVo(combVo1);
        }
        if(newValue!=null&&!newValue.isEmpty()){
            CombVo combVo2=new CombVo();
            combVo2.setId(newValue);
            combVo2.setName(newDesc);
            projectsInfoChangeVo.setNewValueComVo(combVo2);
        }

        return projectsInfoChangeVo;
    }
    @Override
    public IPage<ProjectsInfoChangeVo> listProjectsInfoChange(ProjectsInfoChangeDto projectsInfoChangeDto) {
        Page<ProjectsInfoChangeVo> page = new Page<>(projectsInfoChangeDto.getPage(), projectsInfoChangeDto.getRows());
        IPage<ProjectsInfoChangeVo> res= srmProjectsInfoChangeMapper.listProjectsInfoChange(page, projectsInfoChangeDto);
        List<ProjectsInfoChangeVo> records=res.getRecords();
        List<ProjectsInfoChangeVo> newRecords=new ArrayList<>();
        for(ProjectsInfoChangeVo InfoVo : records){
            ProjectsInfoChangeVo newVo=this.getNewProjectsInfoChangeVo(InfoVo);
            ProjectsInfoChangeVo newRecord=new ProjectsInfoChangeVo();
            newRecord=newVo;
            Long rowId=newVo.getRowId();
            String sysNo=newVo.getSysNo();
            String checkListName= srmEafRecService.getCurCheckDesc(sysNo,rowId,null);
            newRecord.setChkResultList(checkListName);
            newRecords.add(newRecord);
        }
        res.setRecords(newRecords);
        return res;
    }
    //ProjectsInfoChangeMainDto


    @Override
    @Transactional
    public Long saveProjectsInfoChange(ProjectsInfoChangeMainDto projectsInfoChangeMainDto) {
        ProjectsInfoChangeDto  projectsInfoChangeDto=projectsInfoChangeMainDto.getProjectsInfoChangeDto();
         Long RowId=null;
        try{
            String userCode=projectsInfoChangeDto.getUserCode();
            Long srmUserRowId= srmUserService.getUserIdByAccount(userCode);
            SrmProjectsInfoChange srmProjectsInfoChange=new SrmProjectsInfoChange();
            srmProjectsInfoChange.setId(projectsInfoChangeDto.getRowId());
            if(projectsInfoChangeDto.getRowId()==null){
                srmProjectsInfoChange.setSubUserId(String.valueOf(srmUserRowId));
                srmProjectsInfoChange.setSubDate(LocalDateTime.now());
                String serialNo=srmBusinessnoService.getBusinessNo(this.sysNo,5,"C");
                srmProjectsInfoChange.setSerialNo(serialNo);

            }
            srmProjectsInfoChange.setSysNo(projectsInfoChangeDto.getSysNo());
            srmProjectsInfoChange.setProjId(projectsInfoChangeDto.getProjId());
            String oldValue=projectsInfoChangeDto.getOldValue();
            String oldValueDesc=projectsInfoChangeDto.getOldValueDesc();
            // 获取原来的作者
            if(projectsInfoChangeDto.getChangeitem()!=null&&"MEMBER".equals(projectsInfoChangeDto.getChangeitem())) {
                BaseDto baseDto=new BaseDto();
                baseDto.setId(projectsInfoChangeDto.getProjId());
                List<ProjectsInfoMemberVo> projectsInfoMemberVos=  srmProjectsInfoMemberService.listProjectInfoAuthor(baseDto);
                String oldMemberIds="",oldMemberNames="";
                if(!projectsInfoMemberVos.isEmpty()){
                    for(ProjectsInfoMemberVo projectsInfoMemberVo:projectsInfoMemberVos ){
                        if(oldMemberIds.isEmpty()){
                            oldMemberIds=projectsInfoMemberVo.getMember();
                        }else{
                            oldMemberIds=oldMemberIds+","+projectsInfoMemberVo.getMember();
                        }
                        if(oldMemberNames.isEmpty()){
                            oldMemberNames=projectsInfoMemberVo.getMemberName();
                        }else{
                            oldMemberNames=oldMemberNames+","+projectsInfoMemberVo.getMemberName();
                        }
                    }
                }
                oldValue=oldMemberIds;
                oldValueDesc=oldMemberNames;
            }
            srmProjectsInfoChange.setOldValue(oldValue);
            srmProjectsInfoChange.setNewValue(projectsInfoChangeDto.getNewValue());
            srmProjectsInfoChange.setOldValueDesc(oldValueDesc);
            srmProjectsInfoChange.setNewValueDesc(projectsInfoChangeDto.getNewValueDesc());
            srmProjectsInfoChange.setNote(projectsInfoChangeDto.getNote());
            srmProjectsInfoChange.setReason(projectsInfoChangeDto.getReason());
            srmProjectsInfoChange.setChangeitem(projectsInfoChangeDto.getChangeitem());
            srmProjectsInfoChange.setDataStatus(0);
            super.saveOrUpdate(srmProjectsInfoChange);
            RowId=srmProjectsInfoChange.getId();
            // 判断如果变更项目是人员，需要处理作者信息表
            if(projectsInfoChangeDto.getChangeitem()!=null&&"MEMBER".equals(projectsInfoChangeDto.getChangeitem())){
                List<ProjectsInfoChangeMemberDto> projectsInfoChangeMemberDtos=projectsInfoChangeMainDto.getProjectsInfoChangeMemberDtos();
                List<SrmProjectsInfoChangeMember> srmProjectsInfoChangeMemberList=new ArrayList<>();
                for(ProjectsInfoChangeMemberDto projectsInfoChangeMemberDto :projectsInfoChangeMemberDtos){
                    SrmProjectsInfoChangeMember srmProjectsInfoChangeMember=new SrmProjectsInfoChangeMember();
                    srmProjectsInfoChangeMember.setMember(projectsInfoChangeMemberDto.getMember());
                    srmProjectsInfoChangeMember.setChangeParrefId(RowId);
                    srmProjectsInfoChangeMember.setOrigMemberId(projectsInfoChangeMemberDto.getOrigMemberId());
                    srmProjectsInfoChangeMember.setPersonType(projectsInfoChangeMemberDto.getPersonType());
                    srmProjectsInfoChangeMember.setId(projectsInfoChangeMemberDto.getRowId());
                    srmProjectsInfoChangeMember.setRanking(projectsInfoChangeMemberDto.getRanking());
                    srmProjectsInfoChangeMember.setTitle(projectsInfoChangeMemberDto.getTitle());
                    srmProjectsInfoChangeMember.setEduLevel(projectsInfoChangeMemberDto.getEduLevel());
                    srmProjectsInfoChangeMember.setChangeType(projectsInfoChangeMemberDto.getChangeType());
                    srmProjectsInfoChangeMemberList.add(srmProjectsInfoChangeMember);
                }
                srmProjectsInfoChangeMemberService.saveOrUpdateBatch(srmProjectsInfoChangeMemberList);
            }

        }catch (Exception e){
            throw new ErrorException("-200",e.getMessage());
        }
        return RowId;
    }
    @Override
    @Transactional
    public void deleteProjectsInfoChange(BaseDto baseDto) {
        List<Long> idList=baseDto.getIdList();
        String idStr="";
        try{
            for (Long RowId : idList) {
                //System.out.println(RowId);
                //srmProjectsInfoMemberService.deleteAuthorByParent(RowId);
                ProjectsInfoChangeVo projectsInfoChangeVo=this.getDetail(RowId);
                System.out.println(projectsInfoChangeVo.getChangeitem());
                if(projectsInfoChangeVo.getChangeitem()!=null){
                    String changeItem=projectsInfoChangeVo.getChangeitem().getId();
                    if("MEMBER".equals(changeItem)){
                        srmProjectsInfoChangeMemberService.deleteAuthorByParent(RowId);
                    }
                }

                if(StringUtils.isEmpty(idStr)){
                    idStr=String.valueOf(RowId);
                }else{
                    idStr=idStr+","+String.valueOf(RowId);
                }
            }
            super.deleteByIds(idStr);
        }catch (Exception exception){
            throw  new ErrorException("-200","删除失败");
        }
    }
    @Override
    @Transactional
    public void subMitProjectsInfoChange(BaseDto baseDto) {

        //提交前先判断是否已经提交
        //提交前判断是否上传必要附件（后置）
        Long rowId=baseDto.getId();
        HosUser hosUser = SecurityUtils.getLoginUser();
        String userCode = hosUser.getAccountCode();
        try {
            ProjectsInfoChangeVo detail=this.getDetail(rowId);

            SrmProjectsInfoChange srmProjectsInfoChange=this.selectById(rowId);
            Integer dataStatus=srmProjectsInfoChange.getDataStatus();
            String sysNo=srmProjectsInfoChange.getSysNo();
            if(dataStatus==null||dataStatus==1){
                throw new ErrorException("-200","已提交");
            }
            srmProjectsInfoChangeMapper.updateStatus(rowId,1,null);
            srmEafRecService.generateRec(String.valueOf(rowId),sysNo,userCode,null);

        }catch (Exception e){
            throw new ErrorException("-200","提交失败");
        }
    }

    @Override
    public IPage<ProjectsInfoChangeVo> listAuditProjectsInfoChange(ProjectsInfoChangeDto projectsInfoChangeDto) {
        Page<ProjectsInfoChangeVo> page = new Page<>(projectsInfoChangeDto.getPage(), projectsInfoChangeDto.getRows());
        String userCode=projectsInfoChangeDto.getUserCode();
        Long srmUserRowId= srmUserService.getUserIdByAccount(userCode);
        projectsInfoChangeDto.setUserId(srmUserRowId);
        IPage<ProjectsInfoChangeVo> res= srmProjectsInfoChangeMapper.listAuditProjectsInfoChange(page, projectsInfoChangeDto);
        List<ProjectsInfoChangeVo> records=res.getRecords();
        List<ProjectsInfoChangeVo> newRecords=new ArrayList<>();
        for(ProjectsInfoChangeVo InfoVo : records){
            ProjectsInfoChangeVo newVo=this.getNewProjectsInfoChangeVo(InfoVo);
            ProjectsInfoChangeVo newRecord=new ProjectsInfoChangeVo();
            newRecord=newVo;
            Long rowId=newVo.getRowId();
            String sysNo=newVo.getSysNo();
            String checkListName= srmEafRecService.getCurCheckDesc(sysNo,rowId,null);
            newRecord.setChkResultList(checkListName);
            newRecords.add(newRecord);
        }
        res.setRecords(newRecords);
        return res;
    }

    @Override
    @Transactional
    public void auditProjectsInfoChange(BaseDto baseDto) {
        List<Long> idList=baseDto.getIdList();
        //String userCode=baseDto.getUserCode();
        Long srmUserRowId= srmUserService.getUserIdByAccount(null);
        //String sysNo=this.hroProjectSysNo;
        if(srmUserRowId==null){
            throw new ErrorException("-200","当前登录用户不存在!");
        }
        String view=baseDto.getView();
        String auditStatus=baseDto.getAuditStatus();
        String resultId="";
        if(auditStatus.equals("1")){
            resultId="2";
        }
        if(auditStatus.equals("2")){
            resultId="3";
        }
        try{
            for(Long rowId : idList){
                //SrmEafDetail srmEafDetail = srmEafRecService.getCheckStatus(sysNo,String.valueOf(rowId));
                //String auditStatus= srmEafDetail.getAuditPassStatus();

                SrmProjectsInfoChange srmProjectsInfoChange=this.selectById(rowId);
                String sysNo=srmProjectsInfoChange.getSysNo();
                Long projectId=srmProjectsInfoChange.getProjId();
                // 处理一下项目变更表
                
                srmProjectsInfoChangeMapper.updateStatus(rowId,null,resultId);
                srmEafRecService.genAudit(rowId,sysNo,srmUserRowId,resultId,view,null);
                BaseDto recBaseDto=new BaseDto();
                recBaseDto.setSysNo(sysNo);
                recBaseDto.setId(rowId);
                // 判断一下是否终审了，终审需要变更具体内容了
                String result=srmEafRecService.getFinalResult(recBaseDto);
                SrmProjectsInfo srmProjectsInfo=new SrmProjectsInfo();
                srmProjectsInfo.setId(projectId);
                if("2".equals(result)){
                    String changeItem=srmProjectsInfoChange.getChangeitem();
                    if("HEAD".equals(changeItem)){
                        srmProjectsInfo.setHead(srmProjectsInfoChange.getNewValue());
                    }
                    if("NAME".equals(changeItem)){
                        srmProjectsInfo.setName(srmProjectsInfoChange.getNewValueDesc());
                    }
                    if("ACHV_FORM".equals(changeItem)){

                    }
                    if("DEFER".equals(changeItem)){
                        srmProjectsInfo.setEndDate(DateTransform.getLocalDateTime(srmProjectsInfoChange.getNewValueDesc()));
                    }
                    if("CONTENT".equals(changeItem)){

                    }
                    if("MAN_UNIT".equals(changeItem)){
                        srmProjectsInfo.setDeptId(srmProjectsInfoChange.getNewValue());
                    }
                    if("MEMBER".equals(changeItem)){
                        // 下面处理作者，以及处理主表第一作者等等
                        // srmProjectsInfoMemberService.deleteAuthorByParent(projectId);
                        BaseDto baseDto1=new BaseDto();
                        baseDto1.setId(rowId);
                        List<ProjectsInfoChangeMemberVo> projectsInfoChangeMemberVos=srmProjectsInfoChangeMemberService.listProjectsInfoChangeAuthor(baseDto1);
                        List<SrmProjectsInfoMember> srmProjectsInfoMembers=new ArrayList<>();
                        for(ProjectsInfoChangeMemberVo projectsInfoChangeMemberVo :projectsInfoChangeMemberVos){
                            if("2".equals(projectsInfoChangeMemberVo.getChangeType())){
                                String orgMemberId=projectsInfoChangeMemberVo.getOrigMemberId();
                                srmProjectsInfoMemberService.deleteById(orgMemberId);
                            }else{
                                SrmProjectsInfoMember srmProjectsInfoMember=new SrmProjectsInfoMember();
                                srmProjectsInfoMember.setMember(projectsInfoChangeMemberVo.getMember());
                                srmProjectsInfoMember.setProjId(projectId);
                                srmProjectsInfoMember.setAuthorTypeCode(projectsInfoChangeMemberVo.getPersonType());
                                //srmProjectsInfoMember.setId(projectsInfoMemberDto.getRowId());
                                srmProjectsInfoMember.setRanking(projectsInfoChangeMemberVo.getRanking());
                                srmProjectsInfoMember.setTitleCode(projectsInfoChangeMemberVo.getTitle());
                                srmProjectsInfoMember.setWorkRatio(projectsInfoChangeMemberVo.getWorkRatio());
                                srmProjectsInfoMember.setNote(projectsInfoChangeMemberVo.getNote());
                                //srmProjectsInfoMember.setWorkTime(projectsInfoChangeMemberVo.getW);
                                srmProjectsInfoMembers.add(srmProjectsInfoMember);
                            }

                        }
                        if(!srmProjectsInfoMembers.isEmpty()){
                            srmProjectsInfoMemberService.saveOrUpdateBatch(srmProjectsInfoMembers);
                        }

                    }
                    if("SUSPEND".equals(changeItem)||"CANCEL".equals(changeItem)){

                    }


                }


            }
        }catch (Exception e){
            throw new ErrorException("-200",e.getMessage());
        }
    }
}
