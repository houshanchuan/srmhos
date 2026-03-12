package com.mediway.hos.srm.business.center.serviceimpl.projectapply;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mediway.hos.srm.business.center.mapper.projectapply.*;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.dto.projectapply.ProjectSolicitDto;
import com.mediway.hos.srm.business.center.model.dto.projectapply.ProjectSolicitMainDto;
import com.mediway.hos.srm.business.center.model.dto.projectapply.ProjectSolicitMemberDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmResearchField;
import com.mediway.hos.srm.business.center.model.entity.projectapply.*;
import com.mediway.hos.srm.business.center.model.entity.user.SrmUser;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import com.mediway.hos.srm.business.center.model.vo.projectapply.ProjectSolicitVo;
import com.mediway.hos.srm.business.center.service.approvalProcess.SrmEafRecService;
import com.mediway.hos.srm.business.center.service.baseData.SrmUploadInfoService;
import com.mediway.hos.srm.business.center.service.projectapply.SrmProjectApplyInfoService;
import com.mediway.hos.srm.business.center.service.projectapply.SrmProjectSolicitMemberService;
import com.mediway.hos.srm.business.center.service.projectapply.SrmProjectSolicitService;
import com.mediway.hos.srm.business.center.service.systemConfig.SrmSysParameterService;
import com.mediway.hos.srm.business.center.service.user.SrmUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.exception.ErrorException;

import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import com.mediway.hos.srm.business.center.utils.DateTransform;
import com.mediway.hos.srm.business.center.utils.SrmPage;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 项目征集(申报)信息表 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmProjectSolicitServiceImpl extends BaseServiceImpl<SrmProjectSolicitMapper, SrmProjectSolicit> implements SrmProjectSolicitService {
    private final String projectSolicitSysNo="P011";
    @Autowired
    private SrmProjectSolicitMemberService srmProjectSolicitMemberService;
    @Autowired
    private SrmProjectSolicitMapper srmProjectSolicitMapper;
    @Autowired
    private SrmUserService srmUserService;
    @Autowired
    private SrmEafRecService srmEafRecService;
    @Autowired
    private SrmProjectSolicitEthicAuditMapper srmProjectSolicitEthicAuditMapper;
    @Autowired
    private SrmProjectSolicitGradeMapper srmProjectSolicitGradeMapper;
    @Autowired
    private SrmProjectSolicitAuditMapper srmProjectSolicitAuditMapper;
    @Autowired
    private SrmUploadInfoService srmUploadInfoService;
    @Autowired
    private SrmProjectApplyInfoMapper srmProjectApplyInfoMapper;
    @Autowired
    private SrmSysParameterService srmSysParameterService;
    @Override
    public ProjectSolicitVo getDetail(String rowId) {
        return srmProjectSolicitMapper.getDetail(rowId);
    }

    @Override
    @Transactional
    public Long saveProjectSolicit(ProjectSolicitMainDto projectSolicitMainDto) {
        Long RowId=null;
        try{
            ProjectSolicitDto projectSolicitDto=projectSolicitMainDto.getProjectSolicitDto();
            SrmProjectSolicit srmProjectSolicit=new SrmProjectSolicit();
            srmProjectSolicit.setId(projectSolicitDto.getRowId());
            srmProjectSolicit.setSysNo(this.projectSolicitSysNo);
            String title=projectSolicitDto.getTitle();
            srmProjectSolicit.setTitle(title);
            srmProjectSolicit.setApplyId(projectSolicitDto.getApplyId());
            if(title==null||title.isEmpty()){
                throw new ErrorException("-200","项目名称不能为空");
            }

            srmProjectSolicit.setYear(projectSolicitDto.getYear());
            srmProjectSolicit.setProjectKeyword(projectSolicitDto.getProjectKeyword());
            srmProjectSolicit.setDiscipline(projectSolicitDto.getDiscipline());
            srmProjectSolicit.setProjType(projectSolicitDto.getProjType());
            srmProjectSolicit.setApplyBookType(projectSolicitDto.getApplyBookType());
            srmProjectSolicit.setClassCode(projectSolicitDto.getClassCode());
            srmProjectSolicit.setFirstUnitType(projectSolicitDto.getFirstUnitType());
            srmProjectSolicit.setHead(projectSolicitDto.getHead());
            srmProjectSolicit.setProjectApplyType(projectSolicitDto.getProjectApplyType());
            srmProjectSolicit.setProjectApplyInfo(projectSolicitDto.getProjectApplyInfo());
            srmProjectSolicit.setSubDept(projectSolicitDto.getSubDept());
            srmProjectSolicit.setPhone(projectSolicitDto.getPhone());
            srmProjectSolicit.setEmail(projectSolicitDto.getEmail());
            srmProjectSolicit.setIsEthic(projectSolicitDto.getIsEthic());
            srmProjectSolicit.setContacts(projectSolicitDto.getContacts());
            //srmProjectSolicit.setResearchField(projectSolicitDto.getResearchField());
            srmProjectSolicit.setProjectSourceUnit(projectSolicitDto.getProjectSourceUnit());
            srmProjectSolicit.setPlanedEndDate(DateTransform.getLocalDateTime(projectSolicitDto.getPlanedEndDate()));
            srmProjectSolicit.setFunds(projectSolicitDto.getFunds());
            srmProjectSolicit.setResearchField(projectSolicitDto.getResearchField());
            srmProjectSolicit.setEarlyResearchInfo(projectSolicitDto.getEarlyResearchInfo());
            srmProjectSolicit.setNote(projectSolicitDto.getNote());
            QueryWrapper<SrmProjectSolicit> srmProjectSolicitQueryWrapper=new QueryWrapper<>();
            srmProjectSolicitQueryWrapper.eq("title",title);
            List<SrmProjectSolicit> srmProjectSolicits=srmProjectSolicitMapper.selectList(srmProjectSolicitQueryWrapper);
            if(projectSolicitDto.getRowId()==null){
                if(!srmProjectSolicits.isEmpty()){
                    throw new ErrorException("-200","项目名称重复");
                }
                Long srmUserRowId= srmUserService.getUserIdByAccount(projectSolicitDto.getUserCode());
                //srmProjectSolicit.setSubUserId(String.valueOf(srmUserRowId));
                //srmProjectSolicit.setSubDate(LocalDateTime.now());
                srmProjectSolicit.setCreator(String.valueOf(srmUserRowId));
                srmProjectSolicit.setCreateTime(LocalDateTime.now());
            }else{
                if(!srmProjectSolicits.isEmpty()){
                    for(SrmProjectSolicit srmProjectSolicit1 :srmProjectSolicits){
                        Long repeatRowId=srmProjectSolicit1.getId();
                        if(!Objects.equals(repeatRowId, projectSolicitDto.getRowId())){
                            throw new ErrorException("-200","项目名称重复");
                        }
                    }

                }
            }
            super.saveOrUpdate(srmProjectSolicit);
            RowId=srmProjectSolicit.getId();
            List<ProjectSolicitMemberDto> projectSolicitMemberDtoList=projectSolicitMainDto.getProjectSolicitMemberDtoList();
            List<SrmProjectSolicitMember> srmProjectSolicitMembers=new ArrayList<>();
            for(ProjectSolicitMemberDto projectSolicitMemberDto :projectSolicitMemberDtoList){
                SrmProjectSolicitMember srmProjectSolicitMember=new SrmProjectSolicitMember();
                System.out.println(projectSolicitMemberDto);
                srmProjectSolicitMember.setId(projectSolicitMemberDto.getRowId());
                srmProjectSolicitMember.setSoliProjId(RowId);
                srmProjectSolicitMember.setMemberId(projectSolicitMemberDto.getMemberId());
                srmProjectSolicitMember.setMemberName(projectSolicitMemberDto.getMemberName());
                srmProjectSolicitMember.setRanking(projectSolicitMemberDto.getRanking());
                srmProjectSolicitMember.setAuthorTypeCode(projectSolicitMemberDto.getAuthorTypeCode());
                srmProjectSolicitMember.setWorkRatio(projectSolicitMemberDto.getWorkRatio());
                srmProjectSolicitMember.setWorkTime(projectSolicitMemberDto.getWorkTime());
                srmProjectSolicitMember.setTitleCode(projectSolicitMemberDto.getTitleCode());

                srmProjectSolicitMembers.add(srmProjectSolicitMember);
            }
            srmProjectSolicitMemberService.saveOrUpdateBatch(srmProjectSolicitMembers);

        }catch (Exception e){
            System.out.println(e.getMessage());
            throw new ErrorException("-200",e.getMessage());
        }
        return RowId;
    }

    @Override
    public IPage<ProjectSolicitVo> listProjectSolicit(ProjectSolicitDto projectSolicitDto) {
        Long srmUserRowId= srmUserService.getUserIdByAccount(projectSolicitDto.getUserCode());
        projectSolicitDto.setUserId(srmUserRowId);
        Page<ProjectSolicitVo> page = new Page<>(projectSolicitDto.getPage(), projectSolicitDto.getRows());
        System.out.println(projectSolicitDto);
        IPage<ProjectSolicitVo> res= srmProjectSolicitMapper.listProjectSolicit(page, projectSolicitDto);
        List<ProjectSolicitVo> records=res.getRecords();
        List<ProjectSolicitVo> newRecords=new ArrayList<>();
        for(ProjectSolicitVo projectSolicitVo : records){
            ProjectSolicitVo newRecord=new ProjectSolicitVo();
            newRecord=projectSolicitVo;
            Long rowId=projectSolicitVo.getRowId();
            String checkListName= srmEafRecService.getCurCheckDesc(this.projectSolicitSysNo,rowId,null);
            newRecord.setCheckList(checkListName);
            newRecords.add(newRecord);
        }
        res.setRecords(newRecords);
        return res;
    }

    @Override
    @Transactional
    public void deleteProjectSolicit(BaseDto baseDto) {
        List<Long> idList=baseDto.getIdList();
        String idStr="";
        try{
            for (Long RowId : idList) {
                //System.out.println(RowId);
                srmProjectSolicitMemberService.deleteAuthorByParent(RowId);
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
    @Transactional
    public void subMit(BaseDto baseDto) {
        //提交前先判断是否已经提交
        //提交前判断是否上传必要附件（后置）
        Long rowId=baseDto.getId();
        Boolean allowSumbit=srmUploadInfoService.getFileNessary(String.valueOf(rowId),this.projectSolicitSysNo);
        if(!allowSumbit){
            throw new ErrorException("-200","请上传必要的附件！");
        }
        String userCode=null;//baseDto.getUserCode();
        Long srmUserRowId= srmUserService.getUserIdByAccount(null);
        try {
            SrmProjectSolicit srmProjectSolicit=srmProjectSolicitMapper.selectById(rowId);
            String header=srmProjectSolicit.getHead();
            if(header!=null&&!header.isEmpty()){
                SrmUser srmUser=srmUserService.selectById(Long.valueOf(header));
                userCode=srmUser.getAccount();
            }
            Integer dataStatus=srmProjectSolicit.getDataStatus();
            if(dataStatus==null||dataStatus==1){
                throw new ErrorException("-200","已提交");

            }
            System.out.println(srmUserRowId);
            srmProjectSolicitMapper.updateStatus(rowId,1,"0","0","0",String.valueOf(srmUserRowId),LocalDateTime.now());
            srmEafRecService.generateRec(String.valueOf(rowId),this.projectSolicitSysNo,userCode,null);
            // 看配置是否主任自动审核
            String isHeadAudit=srmSysParameterService.getParamVaule("ProjectApplication","HeadAudit");
            String isRepeatAllotExpert=srmSysParameterService.getParamVaule("ProjectApplication","RepeatAllotExpert");
            if(!"Y".equals(isHeadAudit)){
                BaseDto baseDto1=new BaseDto();
                //baseDto1.setId(rowId);
                List<Long> idList=new ArrayList<>();
                idList.add(rowId);
                baseDto1.setIdList(idList);
                //baseDto1.setUserCode(baseDto.getUserCode());
                baseDto1.setAuditStatus("1");
                baseDto1.setSysNo(this.projectSolicitSysNo);
                baseDto1.setView("通过");

                this.headerAudit(baseDto1);
            }
            if("Y".equals(isRepeatAllotExpert)){
                // 将以前的分配的专家取消 包含伦理专家
                srmProjectSolicitAuditMapper.updateCancel(this.projectSolicitSysNo,String.valueOf(rowId));
                srmProjectSolicitEthicAuditMapper.updateCancel(this.projectSolicitSysNo,String.valueOf(rowId));
                srmProjectSolicitGradeMapper.updateCancel(this.projectSolicitSysNo,String.valueOf(rowId));
            }
        }catch (Exception e){

            throw new ErrorException("-200",e.getMessage());
        }

    }

    @Override
    public IPage<ProjectSolicitVo> listHeadAuditProjectSolicit(ProjectSolicitDto projectSolicitDto) {
        String userCode=projectSolicitDto.getUserCode();
        Long srmUserRowId= srmUserService.getUserIdByAccount(userCode);
        projectSolicitDto.setUserId(srmUserRowId);
        Page<ProjectSolicitVo> page = new Page<>(projectSolicitDto.getPage(), projectSolicitDto.getRows());
        IPage<ProjectSolicitVo> res= srmProjectSolicitMapper.listHeadAuditProjectSolicit(page, projectSolicitDto);
        List<ProjectSolicitVo> records=res.getRecords();
        List<ProjectSolicitVo> newRecords=new ArrayList<>();
        for(ProjectSolicitVo projectSolicitVo : records){
            ProjectSolicitVo newRecord=new ProjectSolicitVo();
            newRecord=projectSolicitVo;
            Long rowId=projectSolicitVo.getRowId();
            String checkListName= srmEafRecService.getCurCheckDesc(this.projectSolicitSysNo,rowId,null);
            newRecord.setCheckList(checkListName);
            newRecords.add(newRecord);
        }
        res.setRecords(newRecords);
        return res;
    }

    @Transactional
    @Override
    public void headerAudit(BaseDto baseDto) {
        List<Long> idList=baseDto.getIdList();
        //String userCode=baseDto.getUserCode();
        Long srmUserRowId= srmUserService.getUserIdByAccount(null);
        String sysNo=this.projectSolicitSysNo;
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
                SrmProjectSolicit srmProjectSolicit=srmProjectSolicitMapper.selectById(rowId);
                String headerAuditState=srmProjectSolicit.getHeaderAuditStatus();
                System.out.println(headerAuditState);
                if(!"0".equals(headerAuditState)){
                    throw new ErrorException("-200","该记录不在当前审批环节!");
                }
                if(resultId.equals("2")){
                    srmProjectSolicitMapper.updateStatus(rowId,1,"0","0",resultId,null,null);
                    srmEafRecService.genAudit(rowId,sysNo,srmUserRowId,resultId,view,null);
                }
                if(resultId.equals("3")){
                    srmProjectSolicitMapper.updateStatus(rowId,0,"0","0",resultId,null,null);
                    srmEafRecService.genNoAudit(rowId,sysNo,srmUserRowId,resultId,view);
                }

            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw new ErrorException("-200",e.getMessage());
        }

    }
    @Override
    public IPage<ProjectSolicitVo> listAuditProjectSolicit(ProjectSolicitDto projectSolicitDto) {
        String userCode=projectSolicitDto.getUserCode();
        Long srmUserRowId= srmUserService.getUserIdByAccount(userCode);
        projectSolicitDto.setUserId(srmUserRowId);
        Page<ProjectSolicitVo> page = new Page<>(projectSolicitDto.getPage(), projectSolicitDto.getRows());
        IPage<ProjectSolicitVo> res= srmProjectSolicitMapper.listAuditProjectSolicit(page, projectSolicitDto);
        List<ProjectSolicitVo> records=res.getRecords();
        List<ProjectSolicitVo> newRecords=new ArrayList<>();
        for(ProjectSolicitVo projectSolicitVo : records){
            ProjectSolicitVo newRecord=new ProjectSolicitVo();
            newRecord=projectSolicitVo;
            Long rowId=projectSolicitVo.getRowId();
            String checkListName= srmEafRecService.getCurCheckDesc(this.projectSolicitSysNo,rowId,null);
            newRecord.setCheckList(checkListName);
            newRecords.add(newRecord);
        }
        res.setRecords(newRecords);
        return res;
    }
    @Override
    public SrmPage<ProjectSolicitVo> listAuditProjectSolicitNew(ProjectSolicitDto projectSolicitDto) {

        String userCode=projectSolicitDto.getUserCode();
        Long srmUserRowId= srmUserService.getUserIdByAccount(userCode);
        projectSolicitDto.setUserId(srmUserRowId);
        String allotExpertFlag=projectSolicitDto.getAllotExpertFlag();
        String allotEthicExpertFlag=projectSolicitDto.getAllotEthicExpertFlag();
        System.out.println(projectSolicitDto);
        List<ProjectSolicitVo> projectSolicitVos=srmProjectSolicitMapper.listAuditProjectSolicitNew(projectSolicitDto);
        List<ProjectSolicitVo> projectSolicitVoList=new ArrayList<>();
        for (ProjectSolicitVo projectSolicitVo :projectSolicitVos ){

            Long rowId=projectSolicitVo.getRowId();
            String checkListName= srmEafRecService.getCurCheckDesc(this.projectSolicitSysNo,rowId,null);
            projectSolicitVo.setCheckList(checkListName);
            // 判断是否分配专家、判断是否分配了伦理专家
            // 判断专家审核
            QueryWrapper<SrmProjectSolicitGrade> srmProjectSolicitGradeQueryWrapper=new QueryWrapper<>();
            srmProjectSolicitGradeQueryWrapper.eq("sys_no",this.projectSolicitSysNo).eq("project_id",rowId).eq("is_cancel",0);
            //srmProjectSolicitGradeQueryWrapper.eq("project_id",rowId);
            List<SrmProjectSolicitGrade> srmProjectSolicitGradeList=srmProjectSolicitGradeMapper.selectList(srmProjectSolicitGradeQueryWrapper);
            String isAllot="0";
            String allotState="未完成";
            if(!srmProjectSolicitGradeList.isEmpty()){
                isAllot="1";
                // 分配专家且状态都提交了
                srmProjectSolicitGradeQueryWrapper.eq("data_status",0);
                List<SrmProjectSolicitGrade> srmProjectSolicitGradeList2=srmProjectSolicitGradeMapper.selectList(srmProjectSolicitGradeQueryWrapper);
                if(srmProjectSolicitGradeList2.isEmpty()){
                    allotState="已完成";
                }
            }

            if("2".equals(allotExpertFlag)&&!srmProjectSolicitGradeList.isEmpty()) continue;
            if("1".equals(allotExpertFlag)&&srmProjectSolicitGradeList.isEmpty()) continue;


            QueryWrapper<SrmProjectSolicitEthicAudit> srmProjectSolicitEthicAuditQueryWrapper=new QueryWrapper<>();
            srmProjectSolicitEthicAuditQueryWrapper.eq("sys_no",this.projectSolicitSysNo).eq("soli_project_id",rowId).eq("is_cancel",0);
            //srmProjectSolicitEthicAuditQueryWrapper.eq("soli_project_id",rowId);
            List<SrmProjectSolicitEthicAudit> srmProjectSolicitEthicAuditList=srmProjectSolicitEthicAuditMapper.selectList(srmProjectSolicitEthicAuditQueryWrapper);
            String ethicAllot="0";
            String ethicAllotState="未完成";
            if(!srmProjectSolicitEthicAuditList.isEmpty()){
                ethicAllot="1";
                // 分配专家且状态都提交了
                srmProjectSolicitEthicAuditQueryWrapper.eq("data_status",0);
                List<SrmProjectSolicitEthicAudit> srmProjectSolicitEthicAuditList2=srmProjectSolicitEthicAuditMapper.selectList(srmProjectSolicitEthicAuditQueryWrapper);
                if(srmProjectSolicitEthicAuditList2.isEmpty()){
                    ethicAllotState="已完成";
                }
            }

            if("2".equals(allotEthicExpertFlag)&&!srmProjectSolicitEthicAuditList.isEmpty()) continue;
            if("1".equals(allotEthicExpertFlag)&&srmProjectSolicitEthicAuditList.isEmpty()) continue;
            if("Y".equals(projectSolicitDto.getNeedFinalFlag())&&!allotState.equals("已完成")&&!ethicAllotState.equals("已完成")) continue;
            projectSolicitVo.setIsAllot(isAllot);
            projectSolicitVo.setAllotState(allotState);
            projectSolicitVo.setIsEthicAllot(ethicAllot);
            projectSolicitVo.setEthicAllotState(ethicAllotState);

            // 获取专家审核结果 是否所有专家都审核
            //String auditResult=srmEafRecService.getFinalResult(projectSolicitDto.getSysNo(),String.valueOf(rowId));
            projectSolicitVoList.add(projectSolicitVo);

        }
        SrmPage<ProjectSolicitVo> srmPage=new SrmPage<>(projectSolicitDto.getPage(),projectSolicitDto.getRows(),projectSolicitVoList);
        return srmPage;
    }
    @Transactional
    @Override
    public void preAudit(BaseDto baseDto) {

        List<Long> idList=baseDto.getIdList();
        //String userCode=baseDto.getUserCode();
        System.out.println(baseDto);
        Long srmUserRowId= srmUserService.getUserIdByAccount(null);
        String sysNo=this.projectSolicitSysNo;
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
                // 增加判断是否存在已经审核的

                SrmProjectSolicit srmProjectSolicit=srmProjectSolicitMapper.selectById(rowId);
                String preAuditState=srmProjectSolicit.getPreAuditState();
                if(!"0".equals(preAuditState)){
                    throw new ErrorException("-200","存在不在当前流程的数据!");
                }
                if(resultId.equals("2")){
                    srmProjectSolicitMapper.updateStatus(rowId,1,"0",resultId,null,null,null);
                    srmEafRecService.genAudit(rowId,sysNo,srmUserRowId,resultId,view,null);
                }
                if(resultId.equals("3")){
                    srmProjectSolicitMapper.updateStatus(rowId,0,"0",resultId,null,null,null);
                    srmEafRecService.genNoAudit(rowId,sysNo,srmUserRowId,resultId,view);
                }

            }
        }catch (Exception e){
            throw new ErrorException("-200",e.getMessage());
        }


    }

    @Transactional
    @Override
    public void finalAudit(BaseDto baseDto) {
        List<Long> idList=baseDto.getIdList();
        //String userCode=baseDto.getUserCode();
        Long srmUserRowId= srmUserService.getUserIdByAccount(null);
        String sysNo=this.projectSolicitSysNo;
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
                // 判断是否专家审核完成，或者没有分配专家
                // 增加判断是否存在已经审核的
                SrmProjectSolicit srmProjectSolicit=srmProjectSolicitMapper.selectById(rowId);
                String auditState=srmProjectSolicit.getAuditStatus();
                if(!"0".equals(auditState)){
                    throw new ErrorException("-200","存在不在当前流程的数据!");
                }
                // 走配置判断是否需要分配专家及审核
                String isExpertAudit=srmSysParameterService.getParamVaule("ProjectApplication","ExpertAudit");
                if ("Y".equals(isExpertAudit)) {
                    // 判断专家审核
                    QueryWrapper<SrmProjectSolicitGrade> srmProjectSolicitGradeQueryWrapper=new QueryWrapper<>();
                    srmProjectSolicitGradeQueryWrapper.eq("sys_no",this.projectSolicitSysNo).eq("project_id",rowId).eq("is_cancel",0);
                    //srmProjectSolicitGradeQueryWrapper.eq("project_id",rowId);
                    List<SrmProjectSolicitGrade> srmProjectSolicitGradeList=srmProjectSolicitGradeMapper.selectList(srmProjectSolicitGradeQueryWrapper);
                    if(srmProjectSolicitGradeList.isEmpty()){
                        throw new ErrorException("-200","未分配专家!");
                    }
                    srmProjectSolicitGradeQueryWrapper.eq("data_status",0);

                    srmProjectSolicitGradeList=srmProjectSolicitGradeMapper.selectList(srmProjectSolicitGradeQueryWrapper);
                    if(!srmProjectSolicitGradeList.isEmpty()){
                        throw new ErrorException("-200","专家未审核完成!");
                    }
                    if(srmProjectSolicit.getIsEthic()!=null&& srmProjectSolicit.getIsEthic()==1){
                        QueryWrapper<SrmProjectSolicitEthicAudit> srmProjectSolicitEthicAuditQueryWrapper=new QueryWrapper<>();
                        srmProjectSolicitEthicAuditQueryWrapper.eq("sys_no",this.projectSolicitSysNo).eq("soli_project_id",rowId).eq("is_cancel",0);
                        //srmProjectSolicitEthicAuditQueryWrapper.eq("soli_project_id",rowId);
                        List<SrmProjectSolicitEthicAudit> srmProjectSolicitEthicAuditList=srmProjectSolicitEthicAuditMapper.selectList(srmProjectSolicitEthicAuditQueryWrapper);
                        if(srmProjectSolicitEthicAuditList.isEmpty()){
                            throw new ErrorException("-200","未分配伦理专家!");
                        }
                        srmProjectSolicitEthicAuditQueryWrapper.eq("data_status",0);
                        srmProjectSolicitEthicAuditList=srmProjectSolicitEthicAuditMapper.selectList(srmProjectSolicitEthicAuditQueryWrapper);
                        if(!srmProjectSolicitEthicAuditList.isEmpty()){
                            throw new ErrorException("-200","伦理专家未审核完成!");
                        }
                    }

                }

                if(resultId.equals("2")){
                    srmProjectSolicitMapper.updateStatus(rowId,null,resultId,null,null,null,null);
                    srmEafRecService.genAudit(rowId,sysNo,srmUserRowId,resultId,view,null);
                }
                if(resultId.equals("3")){
                    srmProjectSolicitMapper.updateStatus(rowId,0,resultId,"0","0",null,null);

                    srmEafRecService.genNoAudit(rowId,sysNo,srmUserRowId,resultId,view);
                }


            }
        }catch (Exception e){
            throw new ErrorException("-200",e.getMessage());
        }
    }
    @Override
    public String getProjectSolicitStatus(String rowId){
        SrmProjectSolicit srmProjectSolicit=this.selectById(rowId);
        String preAuditState=srmProjectSolicit.getPreAuditState(); // 0 2 3
        String headAuditState=srmProjectSolicit.getHeaderAuditStatus();  // 0 1
        String auditStatus=srmProjectSolicit.getAuditStatus();   // 0 2 3
        if("0".equals(headAuditState)){
            return "headAudit";
        }
        if("0".equals(preAuditState)){
            return "preAudit";
        }
        if(Objects.equals(auditStatus, "0")){
            return  "audit";
        }
        return null;
    }
    @Override
    public List<CombVo> getApplyInfo(){
        QueryWrapper<SrmProjectApplyInfo> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("state","2");
        List<SrmProjectApplyInfo> srmProjectApplyInfos= srmProjectApplyInfoMapper.selectList(queryWrapper);
        List<CombVo> combVos=new ArrayList<>();
        for(SrmProjectApplyInfo srmProjectApplyInfo:srmProjectApplyInfos){
            CombVo combVo=new CombVo();
            combVo.setId(String.valueOf(srmProjectApplyInfo.getId()));
            combVo.setName(srmProjectApplyInfo.getName());
            combVos.add(combVo);
        }
        return combVos;

    }
}
