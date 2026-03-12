package com.mediway.hos.srm.business.center.serviceimpl.project;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mediway.hos.app.core.util.SecurityUtils;
import com.mediway.hos.security.core.userdetails.HosUser;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.exception.ErrorException;
import com.mediway.hos.srm.business.center.mapper.approvalProcess.SrmEafRecMapper;
import com.mediway.hos.srm.business.center.mapper.project.SrmProjectMidcheckMapper;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.dto.project.ProjectFinalcheckDto;
import com.mediway.hos.srm.business.center.model.dto.project.ProjectsInfoDto;
import com.mediway.hos.srm.business.center.model.entity.project.SrmProjectFinalcheck;
import com.mediway.hos.srm.business.center.mapper.project.SrmProjectFinalcheckMapper;
import com.mediway.hos.srm.business.center.model.entity.projectapply.SrmProjectSolicitGrade;
import com.mediway.hos.srm.business.center.model.vo.project.ProjectFinalcheckVo;
import com.mediway.hos.srm.business.center.model.vo.projectapply.ProjectSolicitGradeVo;
import com.mediway.hos.srm.business.center.model.vo.project.ProjectsInfoVo;
import com.mediway.hos.srm.business.center.service.approvalProcess.SrmEafRecService;
import com.mediway.hos.srm.business.center.service.project.SrmProjectFinalcheckService;
import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import com.mediway.hos.srm.business.center.service.user.SrmUserService;
import com.mediway.hos.srm.business.center.utils.SrmPage;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 项目验收信息表 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-12-09
 */
@Service
public class SrmProjectFinalcheckServiceImpl extends BaseServiceImpl<SrmProjectFinalcheckMapper, SrmProjectFinalcheck> implements SrmProjectFinalcheckService {
    @Autowired
    private SrmProjectFinalcheckMapper srmProjectFinalcheckMapper;
    @Autowired
    private SrmProjectMidcheckMapper srmProjectMidcheckMapper;
    @Autowired
    private SrmEafRecMapper srmEafRecMapper;
    @Autowired
    private SrmEafRecService srmEafRecService;
    @Autowired
    private SrmUserService srmUserService;
    @Override
    public SrmPage<ProjectsInfoVo> listFinalProject(ProjectsInfoDto projectsInfoDto) {
        List<ProjectsInfoVo> projectsInfoVos=srmProjectFinalcheckMapper.listFinalAuditProject(projectsInfoDto);
        List<ProjectsInfoVo> projectsInfoVoList=new ArrayList<>();
        for (ProjectsInfoVo projectsInfoVo :projectsInfoVos ){
            Long rowId=projectsInfoVo.getRowId();
            System.out.println(projectsInfoVo.getSysNo());
            String checkListName= srmEafRecService.getCurCheckDesc(projectsInfoVo.getSysNo(),rowId,null);

            projectsInfoVo.setChkResultList(checkListName);
            String auditResult=srmEafRecMapper.getFinalResult(projectsInfoDto.getSysNo(),String.valueOf(rowId));
            if(auditResult!=null&&!auditResult.isEmpty()){
                if(auditResult.equals("2")){
                    if(projectsInfoDto.getNeedCheck()!=null&&"1".equals(projectsInfoDto.getNeedCheck())){
                        // 获取中检审核结果
                        List<Long> checkRowIds=srmProjectMidcheckMapper.getCheckRowIds(rowId);
                        String allPassFlag="Y";
                        if(checkRowIds!=null){
                            for (Long checkId :checkRowIds ){

                                SrmProjectFinalcheck projectFinalcheck=this.selectById(checkId);
                                String finalSysNo=projectFinalcheck.getSysNo();
                                String checkResult=srmEafRecMapper.getFinalResult(finalSysNo,String.valueOf(checkId));
                                if(checkResult==null||!checkResult.equals("2")){
                                    allPassFlag="N";
                                }
                            }
                        }
                        if(checkRowIds!=null&&allPassFlag.equals("Y")){
                            projectsInfoVoList.add(projectsInfoVo);
                        }
                    }
                    if(projectsInfoDto.getNeedCheck()==null||projectsInfoDto.getNeedCheck().isEmpty()){
                        projectsInfoVoList.add(projectsInfoVo);
                    }
                }
            }

        }
        SrmPage<ProjectsInfoVo> srmPage=new SrmPage<>(projectsInfoDto.getPage(),projectsInfoDto.getRows(),projectsInfoVoList);
        return srmPage;
    }

    @Override
    public SrmPage<ProjectsInfoVo> listVerticalAuditFinalProject(ProjectsInfoDto projectsInfoDto) {
        List<ProjectsInfoVo> projectsInfoVos=srmProjectFinalcheckMapper.listFinalAuditProject(projectsInfoDto);
        List<ProjectsInfoVo> projectsInfoVoList=new ArrayList<>();
        for (ProjectsInfoVo projectsInfoVo :projectsInfoVos ){
            Long rowId=projectsInfoVo.getRowId();
            System.out.println(projectsInfoVo.getSysNo());
            String checkListName= srmEafRecService.getCurCheckDesc(projectsInfoVo.getSysNo(),rowId,null);

            projectsInfoVo.setChkResultList(checkListName);
            String auditResult=srmEafRecMapper.getFinalResult(projectsInfoDto.getSysNo(),String.valueOf(rowId));
            if(auditResult!=null&&!auditResult.isEmpty()){
                if(auditResult.equals("2")){
                    if(projectsInfoDto.getNeedCheck()!=null&&"1".equals(projectsInfoDto.getNeedCheck())){
                        // 获取中检审核结果
                        List<Long> checkRowIds=srmProjectMidcheckMapper.getCheckRowIds(rowId);
                        String allPassFlag="Y";
                        if(checkRowIds!=null){
                            for (Long checkId :checkRowIds ){

                                SrmProjectFinalcheck projectFinalcheck=this.selectById(checkId);
                                String finalSysNo=projectFinalcheck.getSysNo();
                                String checkResult=srmEafRecMapper.getFinalResult(finalSysNo,String.valueOf(checkId));
                                if(checkResult==null||!checkResult.equals("2")){
                                    allPassFlag="N";
                                }
                            }
                        }
                        if(checkRowIds!=null&&allPassFlag.equals("Y")){
                            projectsInfoVoList.add(projectsInfoVo);
                        }
                    }
                    if(projectsInfoDto.getNeedCheck()==null||projectsInfoDto.getNeedCheck().isEmpty()){
                        projectsInfoVoList.add(projectsInfoVo);
                    }
                }
            }

        }
        SrmPage<ProjectsInfoVo> srmPage=new SrmPage<>(projectsInfoDto.getPage(),projectsInfoDto.getRows(),projectsInfoVoList);
        return srmPage;
    }

    @Override
    public ProjectFinalcheckVo getDetail(String rowId) {
        return srmProjectFinalcheckMapper.getDetail(rowId);
    }

    @Override
    @Transactional
    public Long saveProjectFinalcheck(ProjectFinalcheckDto projectFinalcheckDto) {
        System.out.println(projectFinalcheckDto);
        String userCode=projectFinalcheckDto.getUserCode();
        Long RowId=null;
        if(userCode==null){
            throw new ErrorException("-200","保存失败");
        }
        Long userId=srmUserService.getUserIdByAccount(userCode);
        SrmProjectFinalcheck srmProjectFinalcheck=new SrmProjectFinalcheck();
        try{
            srmProjectFinalcheck.setId(projectFinalcheckDto.getRowId());
            srmProjectFinalcheck.setProjId(projectFinalcheckDto.getProjId());
            srmProjectFinalcheck.setSysNo(projectFinalcheckDto.getSysNo());

            if(projectFinalcheckDto.getRowId()==null) {
                srmProjectFinalcheck.setSubDate(LocalDateTime.now());
                srmProjectFinalcheck.setSubUser(String.valueOf(userId));
            }

            srmProjectFinalcheck.setDataStatus(0);
            srmProjectFinalcheck.setSituation1(projectFinalcheckDto.getSituation1());
            srmProjectFinalcheck.setSituation2(projectFinalcheckDto.getSituation2());
            srmProjectFinalcheck.setSituation3(projectFinalcheckDto.getSituation3());
            srmProjectFinalcheck.setSituation4(projectFinalcheckDto.getSituation4());
            srmProjectFinalcheck.setSituation5(projectFinalcheckDto.getSituation5());
            srmProjectFinalcheck.setSituation6(projectFinalcheckDto.getSituation6());
            srmProjectFinalcheck.setSituation7(projectFinalcheckDto.getSituation7());
            srmProjectFinalcheck.setSituation8(projectFinalcheckDto.getSituation8());
            srmProjectFinalcheck.setSituation9(projectFinalcheckDto.getSituation9());
            srmProjectFinalcheck.setSituation10(projectFinalcheckDto.getSituation10());
            srmProjectFinalcheck.setSituation11(projectFinalcheckDto.getSituation11());
            srmProjectFinalcheck.setSituation12(projectFinalcheckDto.getSituation12());
            srmProjectFinalcheck.setSituation13(projectFinalcheckDto.getSituation13());
            srmProjectFinalcheck.setSituation14(projectFinalcheckDto.getSituation14());
            srmProjectFinalcheck.setSituation15(projectFinalcheckDto.getSituation15());

            super.saveOrUpdate(srmProjectFinalcheck);
            RowId=srmProjectFinalcheck.getId();
        }catch (Exception e){
            throw new ErrorException("-200","保存失败");
        }
        return RowId;
    }

    @Override
    public IPage<ProjectFinalcheckVo> listProjectFinalCheck(ProjectFinalcheckDto projectFinalcheckDto) {
        String userCode=projectFinalcheckDto.getUserCode();
        if(userCode!=null&&!userCode.isEmpty()){
            Long srmUserRowId= srmUserService.getUserIdByAccount(userCode);
            projectFinalcheckDto.setUserId(srmUserRowId);
        }

        Page<ProjectFinalcheckVo> page = new Page<>(projectFinalcheckDto.getPage(), projectFinalcheckDto.getRows());
        System.out.println(projectFinalcheckDto);
        IPage<ProjectFinalcheckVo> res= srmProjectFinalcheckMapper.listProjectFinalcheck(page, projectFinalcheckDto);
        List<ProjectFinalcheckVo> records=res.getRecords();
        List<ProjectFinalcheckVo> newRecords=new ArrayList<>();
        for(ProjectFinalcheckVo projectFinalcheckVo : records){
            ProjectFinalcheckVo newRecord=new ProjectFinalcheckVo();
            newRecord=projectFinalcheckVo;
            System.out.println(projectFinalcheckVo);
            Long rowId=projectFinalcheckVo.getRowId();
            String checkListName= srmEafRecService.getCurCheckDesc(projectFinalcheckDto.getSysNo(),rowId,null);
            newRecord.setChkResultList(checkListName);
            newRecords.add(newRecord);
        }
        res.setRecords(newRecords);
        return res;
    }

    @Override
    @Transactional
    public void deleteProjectFinalCheck(BaseDto baseDto) {
        List<Long> idList=baseDto.getIdList();
        String idStr="";
        try{
            for (Long RowId : idList) {
                //System.out.println(RowId);
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
        System.out.println(baseDto);
        Long rowId=baseDto.getId();
        HosUser hosUser = SecurityUtils.getLoginUser();
        String userCode = hosUser.getAccountCode();
        try {
            ProjectFinalcheckVo projectFinalcheckVo=this.getDetail(String.valueOf(rowId));
            System.out.println(projectFinalcheckVo);
            String dataStatus=projectFinalcheckVo.getDataStatus();
            if(dataStatus==null||"1".equals(dataStatus)){
                throw new ErrorException("-200","已提交");
            }
            srmProjectFinalcheckMapper.updateStatus(rowId,"1","1");
            srmEafRecService.generateRec(String.valueOf(rowId),projectFinalcheckVo.getSysNo(),userCode,null);

        }catch (Exception e){
            throw new ErrorException("-200","提交失败");
        }
    }

    @Override
    @Transactional
    public void audit(BaseDto baseDto) {
        List<Long> idList=baseDto.getIdList();
        //String userCode=baseDto.getUserCode();
        Long srmUserRowId= srmUserService.getUserIdByAccount(null);
        //String sysNo=this.sysNo;
        if(srmUserRowId==null){
            throw new ErrorException("-200","当前登录用户不存在!");
        }
        String view=baseDto.getView();
        String auditStatus=baseDto.getAuditStatus();
        String resultId="";

        try{
            for(Long rowId : idList){
                //SrmEafDetail srmEafDetail = srmEafRecService.getCheckStatus(sysNo,String.valueOf(rowId));
                //String auditStatus= srmEafDetail.getAuditPassStatus();
                SrmProjectFinalcheck projectFinalcheck=this.selectById(rowId);
                String sysNo=projectFinalcheck.getSysNo();

                // 判断专家审核
                QueryWrapper<SrmProjectSolicitGrade> srmProjectSolicitGradeQueryWrapper=new QueryWrapper<>();
                srmProjectSolicitGradeQueryWrapper.eq("sys_no",sysNo);
                srmProjectSolicitGradeQueryWrapper.eq("project_id",rowId);
                srmProjectSolicitGradeQueryWrapper.eq("data_status",0);
                /*
                srmProjectSolicitGradeList=srmProjectSolicitGradeMapper.selectList(srmProjectSolicitGradeQueryWrapper);
                if(!srmProjectSolicitGradeList.isEmpty()){
                    throw new ErrorException("-200","专家未审核完成!");
                }
                */
                if(auditStatus.equals("1")){
                    resultId="2";
                    srmProjectFinalcheckMapper.updateStatus(rowId,"1",resultId);
                    srmEafRecService.genAudit(rowId,sysNo,srmUserRowId,resultId,view,null);
                }
                if(auditStatus.equals("2")){
                    srmProjectFinalcheckMapper.updateStatus(rowId,"0",resultId);
                    srmEafRecService.genAudit(rowId,sysNo,srmUserRowId,resultId,view,null);
                    resultId="3";
                }

            }
        }catch (Exception e){
            throw new ErrorException("-200",e.getMessage());
        }
    }

    @Override
    public IPage<ProjectsInfoVo> listAuditProjectFinalCheck(ProjectFinalcheckDto projectFinalcheckDto) {
        System.out.println(projectFinalcheckDto);
        String userCode=projectFinalcheckDto.getUserCode();
        Long srmUserRowId= srmUserService.getUserIdByAccount(userCode);
        projectFinalcheckDto.setUserId(srmUserRowId);
        Page<ProjectsInfoVo> page = new Page<>(projectFinalcheckDto.getPage(), projectFinalcheckDto.getRows());
        IPage<ProjectsInfoVo> res= srmProjectFinalcheckMapper.listAuditProjectFinalcheck(page, projectFinalcheckDto);
        /*
        List<ProjectsInfoVo> records=res.getRecords();
        List<ProjectsInfoVo> newRecords=new ArrayList<>();
        for(ProjectsInfoVo projectMidcheckVo : records){
            ProjectsInfoVo newRecord=new ProjectsInfoVo();
            newRecord=projectMidcheckVo;
            Long rowId=projectMidcheckVo.getRowId();
            String checkListName= srmEafRecService.getCurCheckDesc(this.sysNo,rowId,null);
            newRecord.setChkResultList(checkListName);
            newRecords.add(newRecord);
        }
        res.setRecords(newRecords);
        */

        return res;

    }

    @Override
    public IPage<ProjectSolicitGradeVo> listExpertAuditFinalProject(ProjectsInfoDto projectsInfoDto) {
        String userCode=projectsInfoDto.getUserCode();
        Long srmUserRowId= srmUserService.getUserIdByAccount(userCode);
        projectsInfoDto.setUserId(srmUserRowId);
        System.out.println(projectsInfoDto);
        Page<ProjectSolicitGradeVo> page = new Page<>(projectsInfoDto.getPage(), projectsInfoDto.getRows());
        IPage<ProjectSolicitGradeVo> res= srmProjectFinalcheckMapper.listExpertAuditFinalProject(page, projectsInfoDto);
        return res;
    }
}
