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
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.dto.project.ProjectMidcheckDto;
import com.mediway.hos.srm.business.center.model.entity.project.SrmProjectMidcheck;
import com.mediway.hos.srm.business.center.mapper.project.SrmProjectMidcheckMapper;
import com.mediway.hos.srm.business.center.model.vo.project.ProjectMidcheckVo;
import com.mediway.hos.srm.business.center.model.vo.project.ProjectsInfoVo;
import com.mediway.hos.srm.business.center.service.approvalProcess.SrmEafRecService;

import com.mediway.hos.srm.business.center.service.project.SrmProjectMidcheckService;
import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import com.mediway.hos.srm.business.center.service.user.SrmUserService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 中检信息表 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmProjectMidcheckServiceImpl extends BaseServiceImpl<SrmProjectMidcheckMapper, SrmProjectMidcheck> implements SrmProjectMidcheckService {

    private final String sysNo="C007";
    @Autowired
    private SrmProjectMidcheckMapper srmProjectMidcheckMapper;

    @Autowired
    private SrmEafRecService srmEafRecService;
    @Autowired
    private SrmUserService srmUserService;
    @Override
    public ProjectMidcheckVo getDetail(String rowId) {
        return srmProjectMidcheckMapper.getDetail(rowId);
    }

    @Override
    @Transactional
    public Long saveProjectMidcheck(ProjectMidcheckDto projectMidcheckDto) {
        System.out.println(projectMidcheckDto);
        String userCode=projectMidcheckDto.getUserCode();
        Long RowId=null;
        if(userCode==null){
            throw new ErrorException("-200","保存失败");
        }
        Long userId=srmUserService.getUserIdByAccount(userCode);
        SrmProjectMidcheck srmProjectMidcheck=new SrmProjectMidcheck();
        try{
            srmProjectMidcheck.setId(projectMidcheckDto.getRowId());
            srmProjectMidcheck.setMidcheckInfoId(projectMidcheckDto.getMidcheckInfoId());

            srmProjectMidcheck.setProjId(projectMidcheckDto.getProjId());
            srmProjectMidcheck.setMidcheckState("0");
            if(projectMidcheckDto.getRowId()==null){
                srmProjectMidcheck.setApply(String.valueOf(userId));
                srmProjectMidcheck.setMidDate(LocalDateTime.now());
            }

            srmProjectMidcheck.setSysNo(projectMidcheckDto.getSysNo());
            srmProjectMidcheck.setMidcheckOpinion(projectMidcheckDto.getMidcheckOpinion());

            srmProjectMidcheck.setMidcheckOpinion2(projectMidcheckDto.getMidcheckOpinion2());
            srmProjectMidcheck.setMidcheckOpinion3(projectMidcheckDto.getMidcheckOpinion3());
            srmProjectMidcheck.setMidcheckOpinion4(projectMidcheckDto.getMidcheckOpinion4());
            super.saveOrUpdate(srmProjectMidcheck);
            RowId=srmProjectMidcheck.getId();
        }catch (Exception e){
            throw new ErrorException("-200","保存失败");
        }
        return RowId;
    }

    @Override
    public IPage<ProjectMidcheckVo> listProjectMidcheck(ProjectMidcheckDto projectMidcheckDto) {
        String userCode=projectMidcheckDto.getUserCode();
        if(userCode!=null&&!userCode.isEmpty()){
            Long srmUserRowId= srmUserService.getUserIdByAccount(userCode);
            projectMidcheckDto.setUserId(srmUserRowId);
        }

        Page<ProjectMidcheckVo> page = new Page<>(projectMidcheckDto.getPage(), projectMidcheckDto.getRows());

        IPage<ProjectMidcheckVo> res= srmProjectMidcheckMapper.listProjectMidcheck(page, projectMidcheckDto);
        List<ProjectMidcheckVo> records=res.getRecords();
        List<ProjectMidcheckVo> newRecords=new ArrayList<>();
        for(ProjectMidcheckVo projectMidcheckVo : records){
            ProjectMidcheckVo newRecord=new ProjectMidcheckVo();
            newRecord=projectMidcheckVo;
            Long rowId=projectMidcheckVo.getRowId();
            String sysNo=projectMidcheckVo.getSysNo();
            String checkListName= srmEafRecService.getCurCheckDesc(sysNo,rowId,null);
            newRecord.setChkResultList(checkListName);
            newRecords.add(newRecord);
        }
        res.setRecords(newRecords);
        return res;
    }

    @Override
    @Transactional
    public void deleteProjectMidcheck(BaseDto baseDto) {
        List<Long> idList=baseDto.getIdList();
        String idStr="";
        try{
            for (Long RowId : idList) {
                //System.out.println(RowId);
                // 判断是否可以删除

                SrmProjectMidcheck srmProjectMidcheck=this.selectById(RowId);
                String checkState=srmProjectMidcheck.getMidcheckState();
                if("1".equals(checkState)){
                    throw new ErrorException("-200","已提交,不允许删除");
                }
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
            ProjectMidcheckVo projectMidcheckVo=this.getDetail(String.valueOf(rowId));
            SrmProjectMidcheck srmProjectMidcheck=this.selectById(rowId);
            String dataStatus=srmProjectMidcheck.getMidcheckState();
            String sysNo=srmProjectMidcheck.getSysNo();
            if(dataStatus==null||"1".equals(dataStatus)){
                throw new ErrorException("-200","已提交");
            }
            srmProjectMidcheckMapper.updateStatus(rowId,"1","1");
            srmEafRecService.generateRec(String.valueOf(rowId),sysNo,userCode,null);

        }catch (Exception e){
            throw new ErrorException("-200",e.getMessage());
        }
    }

    @Override
    @Transactional
    public void audit(BaseDto baseDto) {
        List<Long> idList=baseDto.getIdList();
       // String userCode=baseDto.getUserCode();
        Long srmUserRowId= srmUserService.getUserIdByAccount(null);

        if(srmUserRowId==null){
            throw new ErrorException("-200","当前登录用户不存在!");
        }
        String view=baseDto.getView();
        String auditStatus=baseDto.getAuditStatus();
        String resultId="";

        try{
            for(Long rowId : idList){
                SrmProjectMidcheck srmProjectMidcheck=this.selectById(rowId);
                String sysNo=srmProjectMidcheck.getSysNo();
                //SrmEafDetail srmEafDetail = srmEafRecService.getCheckStatus(sysNo,String.valueOf(rowId));
                //String auditStatus= srmEafDetail.getAuditPassStatus();
                if(auditStatus.equals("1")){
                    resultId="2";
                    srmProjectMidcheckMapper.updateStatus(rowId,"1",resultId);
                    srmEafRecService.genAudit(rowId,sysNo,srmUserRowId,resultId,view,null);
                }
                if(auditStatus.equals("2")){
                    resultId="3";
                    srmProjectMidcheckMapper.updateStatus(rowId,"0",resultId);
                    srmEafRecService.genAudit(rowId,sysNo,srmUserRowId,resultId,view,null);
                }

            }
        }catch (Exception e){
            throw new ErrorException("-200",e.getMessage());
        }
    }

    @Override
    public IPage<ProjectsInfoVo> listAuditProjectMidcheck(ProjectMidcheckDto projectMidcheckDto) {
        System.out.println(projectMidcheckDto);
        String userCode=projectMidcheckDto.getUserCode();
        Long srmUserRowId= srmUserService.getUserIdByAccount(userCode);
        projectMidcheckDto.setUserId(srmUserRowId);
        Page<ProjectsInfoVo> page = new Page<>(projectMidcheckDto.getPage(), projectMidcheckDto.getRows());
        IPage<ProjectsInfoVo> res= srmProjectMidcheckMapper.listAuditProjectMidcheck(page, projectMidcheckDto);
        List<ProjectsInfoVo> records=res.getRecords();
        List<ProjectsInfoVo> newRecords=new ArrayList<>();
        for(ProjectsInfoVo projectsInfoVo : records){
            ProjectsInfoVo newRecord=new ProjectsInfoVo();
            newRecord=projectsInfoVo;
            Long rowId=projectsInfoVo.getRowId();
            String sysNo=projectsInfoVo.getSysNo();
            String checkListName= srmEafRecService.getCurCheckDesc(sysNo,rowId,null);
            newRecord.setChkResultList(checkListName);
            newRecords.add(newRecord);
        }
        res.setRecords(newRecords);
        return res;
    }
}
