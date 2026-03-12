package com.mediway.hos.srm.business.center.serviceimpl.paper;

import com.mediway.hos.srm.business.center.model.dto.paper.PaperSubmissionAuditorDto;
import com.mediway.hos.srm.business.center.model.dto.paper.PaperSubmissionGradeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.exception.ErrorException;

import com.mediway.hos.srm.business.center.model.entity.paper.SrmPaperSubmissionAuditor;
import com.mediway.hos.srm.business.center.mapper.paper.SrmPaperSubmissionAuditorMapper;
import com.mediway.hos.srm.business.center.model.entity.paper.SrmPaperSubmissionGrade;
import com.mediway.hos.srm.business.center.model.vo.paper.PaperSubmissionAuditorVo;
import com.mediway.hos.srm.business.center.service.paper.SrmPaperSubmissionAuditorService;
import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import com.mediway.hos.srm.business.center.service.paper.SrmPaperSubmissionGradeService;
import com.mediway.hos.srm.business.center.service.user.SrmUserService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 论文投稿评审专家表 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmPaperSubmissionAuditorServiceImpl extends BaseServiceImpl<SrmPaperSubmissionAuditorMapper, SrmPaperSubmissionAuditor> implements SrmPaperSubmissionAuditorService {
    @Autowired
    private SrmUserService srmUserService;
    @Autowired
    private SrmPaperSubmissionAuditorMapper srmPaperSubmissionAuditorMapper;
    @Autowired
    private SrmPaperSubmissionGradeService srmPaperSubmissionGradeService;
    @Override
    public List<PaperSubmissionAuditorVo> getNoAllotExpert(PaperSubmissionAuditorDto paperSubmissionAuditorDto) {

        PaperSubmissionAuditorVo paperSubmissionAuditorVo=srmPaperSubmissionAuditorMapper.getMainInfo(paperSubmissionAuditorDto);
        String expertStr=null;
        if(paperSubmissionAuditorVo!=null){
            expertStr=paperSubmissionAuditorVo.getExpertList();
        }
        List<String> expertList = null;
        if(expertStr!=null&&!expertStr.isEmpty()){
            expertList= Arrays.asList(expertStr.split(","));
        }
        List<PaperSubmissionAuditorVo> userVos = srmPaperSubmissionAuditorMapper.getNoAllotExpert();
        List<PaperSubmissionAuditorVo> result=new ArrayList<>();
        for(PaperSubmissionAuditorVo userVo :userVos){
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
    public List<PaperSubmissionAuditorVo> getAllotExpert(PaperSubmissionAuditorDto paperSubmissionAuditorDto) {
        PaperSubmissionGradeDto paperSubmissionGradeDto=new PaperSubmissionGradeDto();

        paperSubmissionGradeDto.setSysNo(paperSubmissionAuditorDto.getSysNo());
        paperSubmissionGradeDto.setAppRowId(paperSubmissionAuditorDto.getAppRowId());

        List<PaperSubmissionAuditorVo> paperSubmissionAuditorVos=srmPaperSubmissionGradeService.listPaperSubmissionGrade(paperSubmissionGradeDto);

        System.out.println(paperSubmissionAuditorVos);
        List<PaperSubmissionAuditorVo> result=new ArrayList<>();
        for(PaperSubmissionAuditorVo paperSubmissionAuditorVo :paperSubmissionAuditorVos){
            String userId=paperSubmissionAuditorVo.getExpert();
            PaperSubmissionAuditorVo paperSubmissionAuditorVo1=new PaperSubmissionAuditorVo();
            paperSubmissionAuditorVo1.setRowId(paperSubmissionAuditorVo.getRowId());
            paperSubmissionAuditorVo1.setName(paperSubmissionAuditorVo.getName());
            paperSubmissionAuditorVo1.setExpert(userId);
            paperSubmissionAuditorVo1.setAccount(paperSubmissionAuditorVo.getAccount());
            result.add(paperSubmissionAuditorVo1);
        }
        return result;
    }

    @Override
    @Transactional
    public void allotExpert(PaperSubmissionAuditorDto paperSubmissionAuditorDto) {
        Long rowId=paperSubmissionAuditorDto.getRowId();
        String appRowId = paperSubmissionAuditorDto.getAppRowId();
        String sysNo = paperSubmissionAuditorDto.getSysNo();
        String userStr = paperSubmissionAuditorDto.getExpertList();
        if(userStr.isEmpty()){
            throw new ErrorException("-200","请选择专家！");
        }
        Long RowId=null;
        try {
            PaperSubmissionAuditorDto paperSubmissionAuditorDto1=new PaperSubmissionAuditorDto();
            paperSubmissionAuditorDto1.setAppRowId(appRowId);
            paperSubmissionAuditorDto1.setSysNo(sysNo);
            String expertStr=null;
            String curRowId=null;
            PaperSubmissionAuditorVo paperSubmissionAuditorVo=srmPaperSubmissionAuditorMapper.getMainInfo(paperSubmissionAuditorDto1);
            if(paperSubmissionAuditorVo!=null){
                expertStr=paperSubmissionAuditorVo.getExpertList();
                curRowId=String.valueOf(paperSubmissionAuditorVo.getRowId());
            }

            List<String> expertList=null;
            if(expertStr!=null&&!expertStr.isEmpty()){
                expertList = Arrays.asList(expertStr.split(","));

                expertStr=expertStr+","+userStr;
            }else{
                expertStr=userStr;
            }
            List<String> userList = Arrays.asList(userStr.split(","));

            SrmPaperSubmissionAuditor srmPaperSubmissionAuditor=new SrmPaperSubmissionAuditor();
            if(curRowId!=null){
                srmPaperSubmissionAuditor.setId(Long.valueOf(curRowId));
            }

            srmPaperSubmissionAuditor.setAppRowId(Long.valueOf(appRowId));
            srmPaperSubmissionAuditor.setSysNo(sysNo);
            srmPaperSubmissionAuditor.setExpertList(expertStr);
            System.out.println(srmPaperSubmissionAuditor);
            super.saveOrUpdate(srmPaperSubmissionAuditor);
            RowId=srmPaperSubmissionAuditor.getId();
            for(String expertId : userList){
                if(expertList!=null&&expertList.contains(expertId)) {
                    throw new ErrorException("-200","存在已分配的专家！");
                }
                PaperSubmissionGradeDto paperSubmissionGradeDto=new PaperSubmissionGradeDto();
                //projectSolicitGradeDto.setRowId(null);
                paperSubmissionGradeDto.setExpert(expertId);
                paperSubmissionGradeDto.setSysNo(sysNo);
                paperSubmissionGradeDto.setDataStatus(0);
                paperSubmissionGradeDto.setAppRowId(appRowId);

                srmPaperSubmissionGradeService.savePaperSubmissionGrade(paperSubmissionGradeDto);
            }
        }catch (Exception e){
            throw new ErrorException("-200",e.getMessage());
        }
    }

    @Override
    @Transactional
    public void deleteExpert(PaperSubmissionGradeDto paperSubmissionGradeDto) {
        // 通过专家明细Id，找到模块和SYSNO
        System.out.println(paperSubmissionGradeDto);
        Long rowId=paperSubmissionGradeDto.getRowId();
        SrmPaperSubmissionGrade srmPaperSubmissionGrade=srmPaperSubmissionGradeService.selectById(rowId);

        String sysNo=srmPaperSubmissionGrade.getSysNo();
        String expertId=srmPaperSubmissionGrade.getExpert();
        String appRowId=String.valueOf(srmPaperSubmissionGrade.getAppRowId());


        try{
            // 获取当前已分配的专家
            String newExpertStr=null;

            PaperSubmissionAuditorDto paperSubmissionAuditorDto1=new PaperSubmissionAuditorDto();
            paperSubmissionAuditorDto1.setAppRowId(appRowId);
            paperSubmissionAuditorDto1.setSysNo(sysNo);

            PaperSubmissionAuditorVo paperSubmissionAuditorVo=srmPaperSubmissionAuditorMapper.getMainInfo(paperSubmissionAuditorDto1);

            String expertStr=null;
            if(paperSubmissionAuditorVo!=null){
                expertStr=paperSubmissionAuditorVo.getExpertList();
            }
            System.out.println(expertId);
            System.out.println(expertStr);
            List<String> expertList = Arrays.asList(expertStr.split(","));
            expertList = expertList.stream().filter(obj -> !obj.equals(expertId)).collect(Collectors.toList());
            if(!expertList.isEmpty()){
                newExpertStr=String.join(",",expertList);
            }
            System.out.println(newExpertStr);
            srmPaperSubmissionAuditorMapper.updateExpertAudit(sysNo,appRowId,newExpertStr);
            srmPaperSubmissionGradeService.deleteById(rowId);
        }catch (Exception e){
            throw new ErrorException("-200",e.getMessage());
        }
    }
}
