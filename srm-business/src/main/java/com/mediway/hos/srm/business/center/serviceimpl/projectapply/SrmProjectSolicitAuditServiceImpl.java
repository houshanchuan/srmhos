package com.mediway.hos.srm.business.center.serviceimpl.projectapply;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.exception.ErrorException;
import com.mediway.hos.srm.business.center.model.dto.projectapply.ProjectSolicitAuditDto;
import com.mediway.hos.srm.business.center.model.dto.projectapply.ProjectSolicitEthicAuditDto;
import com.mediway.hos.srm.business.center.model.dto.projectapply.ProjectSolicitGradeDto;
import com.mediway.hos.srm.business.center.model.entity.projectapply.SrmProjectSolicitAudit;
import com.mediway.hos.srm.business.center.mapper.projectapply.SrmProjectSolicitAuditMapper;
import com.mediway.hos.srm.business.center.model.vo.projectapply.ProjectSolicitAuditExpertVo;
import com.mediway.hos.srm.business.center.model.vo.projectapply.ProjectSolicitAuditVo;
import com.mediway.hos.srm.business.center.service.projectapply.SrmProjectSolicitAuditService;
import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import com.mediway.hos.srm.business.center.service.projectapply.SrmProjectSolicitEthicAuditService;
import com.mediway.hos.srm.business.center.service.projectapply.SrmProjectSolicitGradeService;
import com.mediway.hos.srm.business.center.service.user.SrmUserService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 项目征集权限表 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmProjectSolicitAuditServiceImpl extends BaseServiceImpl<SrmProjectSolicitAuditMapper, SrmProjectSolicitAudit> implements SrmProjectSolicitAuditService {
    @Autowired
    private SrmProjectSolicitAuditMapper srmProjectSolicitAuditMapper;
    @Autowired
    private SrmProjectSolicitGradeService srmProjectSolicitGradeService;
    @Autowired
    private SrmProjectSolicitEthicAuditService srmProjectSolicitEthicAuditService;
    @Autowired
    private SrmUserService srmUserService;
    @Override
    public List<ProjectSolicitAuditExpertVo> getNoAllotExpert(ProjectSolicitAuditDto projectSolicitAuditDto) {
        //String expertStr = srmProjectSolicitAuditMapper.getCurExpertList(projectSolicitAuditDto.getSysNo(), projectSolicitAuditDto.getYwRowId());
        ProjectSolicitAuditVo projectSolicitAuditVo=srmProjectSolicitAuditMapper.getMainInfo(projectSolicitAuditDto);
        String expertStr=null;
        if(projectSolicitAuditVo!=null){
            expertStr=projectSolicitAuditVo.getExpertList();
        }
        List<String> expertList = null;
        if(expertStr!=null&&!expertStr.isEmpty()){
            expertList=Arrays.asList(expertStr.split(","));
        }
        List<ProjectSolicitAuditExpertVo> userVos = srmProjectSolicitAuditMapper.getNoAllotExpert();
        List<ProjectSolicitAuditExpertVo> result=new ArrayList<>();
        for(ProjectSolicitAuditExpertVo userVo :userVos){
            Long userId=userVo.getRowId();
            if(expertList!=null){
                if(!expertList.contains(String.valueOf(userId))){
                    result.add(userVo);
                }

            }else{
                result.add(userVo);
            }
        }
        return result;
    }

    @Override
    public List<ProjectSolicitAuditExpertVo> getNoEthicAllotExpert(ProjectSolicitAuditDto projectSolicitAuditDto) {
        //String expertStr = srmProjectSolicitAuditMapper.getCurEthicExpertList(projectSolicitAuditDto.getSysNo(), projectSolicitAuditDto.getYwRowId());
        System.out.println(projectSolicitAuditDto);
        ProjectSolicitAuditVo projectSolicitAuditVo=srmProjectSolicitAuditMapper.getMainInfo(projectSolicitAuditDto);
        String expertStr=null;
        if(projectSolicitAuditVo!=null){
            expertStr=projectSolicitAuditVo.getEthicExpertList();
        }
        List<String> expertList = null;
        if(expertStr!=null&&!expertStr.isEmpty()){
            expertList=Arrays.asList(expertStr.split(","));
        }
        List<ProjectSolicitAuditExpertVo> userVos = srmProjectSolicitAuditMapper.getNoAllotExpert();
        List<ProjectSolicitAuditExpertVo> result=new ArrayList<>();
        for(ProjectSolicitAuditExpertVo userVo :userVos){
            Long userId=userVo.getRowId();
            if(expertList!=null){
                if(!expertList.contains(String.valueOf(userId))){
                    result.add(userVo);
                }
            }else{
                result.add(userVo);
            }
        }
        return result;
    }

    @Override
    public List<ProjectSolicitAuditExpertVo> getAllotExpert(ProjectSolicitAuditDto projectSolicitAuditDto) {
        //System.out.println(projectSolicitAuditDto);
        ProjectSolicitGradeDto projectSolicitGradeDto=new ProjectSolicitGradeDto();
        projectSolicitGradeDto.setAllotCount(projectSolicitAuditDto.getAllotCount());
        projectSolicitGradeDto.setSysNo(projectSolicitAuditDto.getSysNo());
        projectSolicitGradeDto.setProjectId(String.valueOf(projectSolicitAuditDto.getYwRowId()));
        //projectSolicitGradeDto.set
        List<ProjectSolicitAuditExpertVo> projectSolicitAuditExpertVos=srmProjectSolicitGradeService.listProjectSolicitGrade(projectSolicitGradeDto);

        //String expertStr = srmProjectSolicitAuditMapper.getCurExpertList(projectSolicitAuditDto.getSysNo(), projectSolicitAuditDto.getYwRowId());
        //List<String> expertList = Arrays.asList(expertStr.split(","));

        List<ProjectSolicitAuditExpertVo> result=new ArrayList<>();
        for(ProjectSolicitAuditExpertVo solicitAuditExpertVo :projectSolicitAuditExpertVos){
            String userId=solicitAuditExpertVo.getExpert();
            ProjectSolicitAuditExpertVo projectSolicitAuditExpertVo=new ProjectSolicitAuditExpertVo();
            projectSolicitAuditExpertVo.setRowId(solicitAuditExpertVo.getRowId());
            projectSolicitAuditExpertVo.setName(solicitAuditExpertVo.getName());
            projectSolicitAuditExpertVo.setExpert(userId);
            projectSolicitAuditExpertVo.setAccount(solicitAuditExpertVo.getAccount());
            result.add(projectSolicitAuditExpertVo);
        }
        return result;

    }

    @Override
    public List<ProjectSolicitAuditExpertVo> getEthicAllotExpert(ProjectSolicitAuditDto projectSolicitAuditDto) {

        ProjectSolicitEthicAuditDto projectSolicitEthicAuditDto=new ProjectSolicitEthicAuditDto();

        projectSolicitEthicAuditDto.setSysNo(projectSolicitAuditDto.getSysNo());
        projectSolicitEthicAuditDto.setSoliProjectId(projectSolicitAuditDto.getYwRowId());
        projectSolicitEthicAuditDto.setEthicAllotCount(projectSolicitAuditDto.getAllotCount());
        List<ProjectSolicitAuditExpertVo> projectSolicitAuditExpertVos=srmProjectSolicitEthicAuditService.listProjectSolicitEthicAudit(projectSolicitEthicAuditDto);
        //String expertStr = srmProjectSolicitAuditMapper.getCurExpertList(projectSolicitAuditDto.getSysNo(), projectSolicitAuditDto.getYwRowId());
        //List<String> expertList = Arrays.asList(expertStr.split(","));

        List<ProjectSolicitAuditExpertVo> result=new ArrayList<>();
        for(ProjectSolicitAuditExpertVo solicitAuditExpertVo :projectSolicitAuditExpertVos){
            String userId=solicitAuditExpertVo.getExpert();
            ProjectSolicitAuditExpertVo projectSolicitAuditExpertVo=new ProjectSolicitAuditExpertVo();
            projectSolicitAuditExpertVo.setRowId(solicitAuditExpertVo.getRowId());
            projectSolicitAuditExpertVo.setName(solicitAuditExpertVo.getName());
            projectSolicitAuditExpertVo.setExpert(userId);
            projectSolicitAuditExpertVo.setAccount(solicitAuditExpertVo.getAccount());
            result.add(projectSolicitAuditExpertVo);
        }
        return result;
    }

    @Override
    @Transactional
    public void allotExpert(ProjectSolicitAuditDto projectSolicitAuditDto) {
        //System.out.println(projectSolicitAuditDto);
        Long rowId=projectSolicitAuditDto.getRowId();
        Long ywRowId = projectSolicitAuditDto.getYwRowId();
        String sysNo = projectSolicitAuditDto.getSysNo();
        if(sysNo==null||sysNo.isEmpty()){
            throw new ErrorException("-200","模块号不能为空！");
        }
        String type = projectSolicitAuditDto.getType();
        String allotCount = projectSolicitAuditDto.getAllotCount();
        String userStr = projectSolicitAuditDto.getUserStr();
        if(userStr.isEmpty()){
            throw new ErrorException("-200","请选择专家！");
        }
        Long RowId=null;
        try {
            ProjectSolicitAuditDto projectSolicitAuditDto1=new ProjectSolicitAuditDto();
            projectSolicitAuditDto1.setYwRowId(ywRowId);
            projectSolicitAuditDto1.setSysNo(sysNo);
            projectSolicitAuditDto1.setType(type);
            projectSolicitAuditDto1.setAllotCount(allotCount);
            String expertStr=null;
            String curRowId=null;
            ProjectSolicitAuditVo projectSolicitAuditVo=srmProjectSolicitAuditMapper.getMainInfo(projectSolicitAuditDto1);
            if(projectSolicitAuditVo!=null){
                expertStr=projectSolicitAuditVo.getExpertList();
                curRowId=projectSolicitAuditVo.getRowId();

            }

            List<String> expertList=null;
            if(expertStr!=null&&!expertStr.isEmpty()){
                expertList = Arrays.asList(expertStr.split(","));
                expertStr=expertStr+","+userStr;
            }else{

                expertStr=userStr;
            }
            //List<String> expertList = Arrays.asList(expertStr.split(","));
            List<String> userList = Arrays.asList(userStr.split(","));

            SrmProjectSolicitAudit srmProjectSolicitAudit=new SrmProjectSolicitAudit();
            if(curRowId!=null){
                srmProjectSolicitAudit.setId(Long.valueOf(curRowId));
            }

            srmProjectSolicitAudit.setSoliProjectId(ywRowId);
            srmProjectSolicitAudit.setSysNo(sysNo);
            srmProjectSolicitAudit.setExpertList(expertStr);
            srmProjectSolicitAudit.setType(type);
            srmProjectSolicitAudit.setAllotCount(allotCount);
            srmProjectSolicitAudit.setIsCancel(0);
            System.out.println("11111111111111111");
            super.saveOrUpdate(srmProjectSolicitAudit);
            System.out.println("2222222222222222");
            RowId=srmProjectSolicitAudit.getId();
            for(String expertId : userList){
                if(expertList!=null&&expertList.contains(expertId)) {
                    throw new ErrorException("-200","存在已分配的专家！");
                }
                ProjectSolicitGradeDto projectSolicitGradeDto=new ProjectSolicitGradeDto();
                //projectSolicitGradeDto.setRowId(null);
                projectSolicitGradeDto.setExpert(expertId);
                projectSolicitGradeDto.setSysNo(sysNo);
                projectSolicitGradeDto.setDataStatus(0);
                projectSolicitGradeDto.setAuditStatus("0");
                projectSolicitGradeDto.setProjectId(String.valueOf(ywRowId));
                projectSolicitGradeDto.setPrjType(type);
                projectSolicitGradeDto.setAllotCount(allotCount);

                srmProjectSolicitGradeService.saveProjectSolictitGrade(projectSolicitGradeDto);
            }
        }catch (Exception e){
            throw new ErrorException("-200",e.getMessage());
        }
    }
    @Override
    @Transactional
    public void allotEthicExpert(ProjectSolicitAuditDto projectSolicitAuditDto) {
        Long rowId=projectSolicitAuditDto.getRowId();
        Long ywRowId = projectSolicitAuditDto.getYwRowId();
        String sysNo = projectSolicitAuditDto.getSysNo();
        String type = projectSolicitAuditDto.getType();
        String allotCount = projectSolicitAuditDto.getAllotCount();
        String userStr = projectSolicitAuditDto.getUserStr();
        if(sysNo==null||sysNo.isEmpty()){
            throw new ErrorException("-200","模块号不能为空！");
        }
        if(userStr.isEmpty()){
            throw new ErrorException("-200","请选择专家！");
        }
        Long RowId=null;
        try {
            ProjectSolicitAuditDto projectSolicitAuditDto1=new ProjectSolicitAuditDto();
            projectSolicitAuditDto1.setYwRowId(ywRowId);
            projectSolicitAuditDto1.setSysNo(sysNo);
            projectSolicitAuditDto1.setType(type);
            projectSolicitAuditDto1.setAllotCount(allotCount);
            String expertStr=null;
            String curRowId=null;
            ProjectSolicitAuditVo projectSolicitAuditVo=srmProjectSolicitAuditMapper.getMainInfo(projectSolicitAuditDto1);
            if(projectSolicitAuditVo!=null){
                expertStr=projectSolicitAuditVo.getEthicExpertList();
                curRowId=projectSolicitAuditVo.getRowId();
            }

            List<String> expertList=null;
            if(expertStr!=null&&!expertStr.isEmpty()){
                expertList = Arrays.asList(expertStr.split(","));

                expertStr=expertStr+","+userStr;
            }else{
                expertStr=userStr;
            }
            List<String> userList = Arrays.asList(userStr.split(","));

            SrmProjectSolicitAudit srmProjectSolicitAudit=new SrmProjectSolicitAudit();
            if(curRowId!=null){
                srmProjectSolicitAudit.setId(Long.valueOf(curRowId));
            }

            srmProjectSolicitAudit.setSoliProjectId(ywRowId);
            srmProjectSolicitAudit.setSysNo(sysNo);
            //srmProjectSolicitAudit.setExpertList(expertStr);
            srmProjectSolicitAudit.setEthicExpertList(expertStr);
            srmProjectSolicitAudit.setType(type);
            srmProjectSolicitAudit.setAllotCount(allotCount);
            srmProjectSolicitAudit.setIsCancel(0);
            super.saveOrUpdate(srmProjectSolicitAudit);
            RowId=srmProjectSolicitAudit.getId();
            for(String expertId : userList){
                if(expertList!=null&&expertList.contains(expertId)) {
                    throw new ErrorException("-200","存在已分配的专家！");
                }
                ProjectSolicitEthicAuditDto projectSolicitEthicAuditDto=new ProjectSolicitEthicAuditDto();
                //projectSolicitGradeDto.setRowId(null);
                projectSolicitEthicAuditDto.setEthicExpert(expertId);
                projectSolicitEthicAuditDto.setSysNo(sysNo);
                projectSolicitEthicAuditDto.setDataStatus(0);
                projectSolicitEthicAuditDto.setEthicAllotCount(allotCount);
                projectSolicitEthicAuditDto.setSoliProjectId(ywRowId);

                srmProjectSolicitEthicAuditService.saveProjectSolicitEthicAudit(projectSolicitEthicAuditDto);
            }
        }catch (Exception e){
            throw new ErrorException("-200",e.getMessage());
        }
    }
    @Override
    @Transactional
    public void deleteExpert(ProjectSolicitGradeDto projectSolicitGradeDto) {
        // 通过专家明细Id，找到模块和SYSNO
        //System.out.println(projectSolicitGradeDto);
        Long rowId=projectSolicitGradeDto.getRowId();
        String sysNo=projectSolicitGradeDto.getSysNo();
        String expertId=projectSolicitGradeDto.getExpert();
        String ywRowId=projectSolicitGradeDto.getProjectId();
        String allotCount=projectSolicitGradeDto.getAllotCount();
        String type="allot";

        try{
            // 获取当前已分配的专家
            String newExpertStr=null;
            //String expertStr = srmProjectSolicitAuditMapper.getCurExpertList(sysNo,Long.valueOf(ywRowId));

            ProjectSolicitAuditDto projectSolicitAuditDto1=new ProjectSolicitAuditDto();
            projectSolicitAuditDto1.setYwRowId(Long.valueOf(ywRowId));
            projectSolicitAuditDto1.setSysNo(sysNo);
            projectSolicitAuditDto1.setType(type);
            projectSolicitAuditDto1.setAllotCount(allotCount);
            ProjectSolicitAuditVo projectSolicitAuditVo=srmProjectSolicitAuditMapper.getMainInfo(projectSolicitAuditDto1);
            String expertStr=null;
            if(projectSolicitAuditVo!=null){
                expertStr=projectSolicitAuditVo.getExpertList();
            }

            List<String> expertList = Arrays.asList(expertStr.split(","));
            expertList = expertList.stream().filter(obj -> !obj.equals(expertId)).collect(Collectors.toList());
            if(!expertList.isEmpty()){
                newExpertStr=String.join(",",expertList);
            }
            srmProjectSolicitAuditMapper.updateProjectSolicitAudit(sysNo,ywRowId,type,allotCount,newExpertStr,null);
            srmProjectSolicitGradeService.deleteById(rowId);
        }catch (Exception e){
            throw new ErrorException("-200",e.getMessage());
        }

    }
    @Override
    @Transactional
    public void deleteEthicExpert(ProjectSolicitEthicAuditDto projectSolicitEthicAuditDto) {
        // 通过专家明细Id，找到模块和SYSNO
        Long rowId=projectSolicitEthicAuditDto.getRowId();
        String sysNo=projectSolicitEthicAuditDto.getSysNo();
        String expertId=projectSolicitEthicAuditDto.getEthicExpert();
        Long ywRowId=projectSolicitEthicAuditDto.getSoliProjectId();
        String allotCount=projectSolicitEthicAuditDto.getAllotCount();
        String type="allotEthic";
        try{
            // 获取当前已分配的专家
            String newExpertStr=null;
            ProjectSolicitAuditDto projectSolicitAuditDto1=new ProjectSolicitAuditDto();
            projectSolicitAuditDto1.setYwRowId(Long.valueOf(ywRowId));
            projectSolicitAuditDto1.setSysNo(sysNo);
            projectSolicitAuditDto1.setType(type);
            projectSolicitAuditDto1.setAllotCount(allotCount);
            ProjectSolicitAuditVo projectSolicitAuditVo=srmProjectSolicitAuditMapper.getMainInfo(projectSolicitAuditDto1);
            String expertStr=null;
            if(projectSolicitAuditVo!=null){
                expertStr=projectSolicitAuditVo.getEthicExpertList();
            }
            List<String> expertList = Arrays.asList(expertStr.split(","));
            expertList = expertList.stream().filter(obj -> !obj.equals(expertId)).collect(Collectors.toList());
            if(!expertList.isEmpty()){
                newExpertStr=String.join(",",expertList);
            }
            srmProjectSolicitAuditMapper.updateProjectSolicitAudit(sysNo,String.valueOf(ywRowId),type,allotCount,null,newExpertStr);
            srmProjectSolicitEthicAuditService.deleteById(rowId);
        }catch (Exception e){
            throw new ErrorException("-200",e.getMessage());
        }

    }


}

