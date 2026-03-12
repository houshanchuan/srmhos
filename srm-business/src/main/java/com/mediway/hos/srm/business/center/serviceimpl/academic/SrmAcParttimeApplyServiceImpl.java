package com.mediway.hos.srm.business.center.serviceimpl.academic;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mediway.hos.app.core.util.SecurityUtils;
import com.mediway.hos.security.core.userdetails.HosUser;
import com.mediway.hos.srm.business.center.aspect.DataChangeLog;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.exception.ErrorException;
import com.mediway.hos.srm.business.center.mapper.user.SrmUserMapper;
import com.mediway.hos.srm.business.center.model.dto.academic.AcParttimeApplyDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.entity.academic.SrmAcParttimeApply;
import com.mediway.hos.srm.business.center.mapper.academic.SrmAcParttimeApplyMapper;
import com.mediway.hos.srm.business.center.model.entity.approvalProcess.SrmEafDetail;
import com.mediway.hos.srm.business.center.model.vo.academic.AcParttimeApplyVo;
import com.mediway.hos.srm.business.center.service.academic.SrmAcParttimeApplyService;
import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import com.mediway.hos.srm.business.center.service.approvalProcess.SrmEafRecService;
import com.mediway.hos.srm.business.center.service.user.SrmUserService;
import com.mediway.hos.srm.business.center.utils.DateTransform;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 兼职申请表 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmAcParttimeApplyServiceImpl extends BaseServiceImpl<SrmAcParttimeApplyMapper, SrmAcParttimeApply> implements SrmAcParttimeApplyService {
    private final String sysNo="P051";
    private final String tableName="srm_ac_parttime_apply";
    private final String logTitle="社会兼职申请";
    @Autowired
    private SrmAcParttimeApplyMapper srmAcParttimeApplyMapper;
    @Autowired
    private SrmUserService srmUserService;
    @Autowired
    private SrmUserMapper srmUserMapper;
    @Autowired
    private SrmEafRecService srmEafRecService;

    @Override
    @DataChangeLog(sysNo=sysNo,title = logTitle, tableName=tableName)
    public Long saveAcParttimeApply(AcParttimeApplyDto acParttimeApplyDto) {
        System.out.println(acParttimeApplyDto);
        SrmAcParttimeApply srmAcParttimeApply=new SrmAcParttimeApply();
        srmAcParttimeApply.setId(acParttimeApplyDto.getRowId());
        srmAcParttimeApply.setUserId(acParttimeApplyDto.getUserId());
        srmAcParttimeApply.setCommittee(acParttimeApplyDto.getCommittee());
        srmAcParttimeApply.setCommitteeBranch(acParttimeApplyDto.getCommitteeBranch());
        srmAcParttimeApply.setBranch(acParttimeApplyDto.getBranch());
        srmAcParttimeApply.setDeptId(acParttimeApplyDto.getDeptId());
        srmAcParttimeApply.setPartTimeType(acParttimeApplyDto.getPartTimeType());
        srmAcParttimeApply.setPosition(acParttimeApplyDto.getPosition());
        srmAcParttimeApply.setYear(acParttimeApplyDto.getYear());
        srmAcParttimeApply.setSysNo(this.sysNo);
        srmAcParttimeApply.setStartDate(DateTransform.getLocalDateTime(acParttimeApplyDto.getStartDate()));
        srmAcParttimeApply.setEndDate(DateTransform.getLocalDateTime(acParttimeApplyDto.getEndDate()));
        srmAcParttimeApply.setDataStatus(0);
        Long rowId=null;
        try{
            if(acParttimeApplyDto.getRowId()==null){
                String userCode=acParttimeApplyDto.getUserCode();
                Long srmUserRowId= srmUserService.getUserIdByAccount(userCode);
                srmAcParttimeApply.setCreateUserId(String.valueOf(srmUserRowId));
                srmAcParttimeApply.setCreateDate(LocalDateTime.now());
            }
            super.saveOrUpdate(srmAcParttimeApply);
            rowId=srmAcParttimeApply.getId();

        }catch (Exception exception){
            throw new ErrorException("-200",exception.getMessage());
        }
        return rowId;
    }

    @Override
    public AcParttimeApplyVo getDetail(Long rowId) {
        System.out.println(rowId);
        return srmAcParttimeApplyMapper.getDetail(rowId);
    }

    @Override
    public IPage<AcParttimeApplyVo> listAcParttimeApply(AcParttimeApplyDto acParttimeApplyDto) {
        String userCode=acParttimeApplyDto.getUserCode();
        Long srmUserRowId= srmUserService.getUserIdByAccount(userCode);
        acParttimeApplyDto.setUserId(String.valueOf(srmUserRowId));
        Page<AcParttimeApplyVo> page = new Page<>(acParttimeApplyDto.getPage(), acParttimeApplyDto.getRows());
        IPage<AcParttimeApplyVo> res= srmAcParttimeApplyMapper.listAcParttimeApply(page, acParttimeApplyDto);
        List<AcParttimeApplyVo> records=res.getRecords();
        List<AcParttimeApplyVo> newRecords=new ArrayList<>();
        for(AcParttimeApplyVo acParttimeApplyVo : records){
            AcParttimeApplyVo newRecord=new AcParttimeApplyVo();
            newRecord=acParttimeApplyVo;
            Long rowId=acParttimeApplyVo.getRowId();
            String checkListName= srmEafRecService.getCurCheckDesc("P051",rowId,null);
            newRecord.setChkResultlist(checkListName);
            newRecords.add(newRecord);
        }
        res.setRecords(newRecords);
        return res;
    }

    @Override
    @Transactional
    @DataChangeLog(sysNo=sysNo,title = logTitle, tableName=tableName)
    public void deleteAcParttimeApply(BaseDto baseDto) {
        System.out.println(baseDto);
        List<Long> idList=baseDto.getIdList();
        String idStr="";
        try{
            for (Long RowId : idList) {
                //System.out.println(RowId);
                QueryWrapper<SrmAcParttimeApply> srmAcLectureQueryWrapper=new QueryWrapper<>();
                srmAcLectureQueryWrapper.eq("id",RowId);
                SrmAcParttimeApply srmAcParttimeApply=srmAcParttimeApplyMapper.selectOne(srmAcLectureQueryWrapper);
                Integer dataStatus=srmAcParttimeApply.getDataStatus();
                if(dataStatus==1){
                    throw new ErrorException("-200","已提交不允许删除");
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
        System.out.println(baseDto);
        //提交前先判断是否已经提交
        //提交前判断是否上传必要附件（后置）
        Long rowId=baseDto.getId();
        HosUser hosUser = SecurityUtils.getLoginUser();
        String userCode = hosUser.getAccountCode();
        try {
            AcParttimeApplyVo acParttimeApplyVo=this.getDetail(rowId);
            Integer dataStatus=acParttimeApplyVo.getDataStatus();
            if(dataStatus==1){
                throw new ErrorException("-200","已提交");
            }
            Long srmUserRowId= srmUserService.getUserIdByAccount(userCode);
            SrmAcParttimeApply parttimeApply=new SrmAcParttimeApply();
            parttimeApply.setSubUserId(srmUserRowId.toString());
            parttimeApply.setSubDate(LocalDateTime.now());
            parttimeApply.setId(acParttimeApplyVo.getRowId());
            parttimeApply.setDataStatus(1);
            srmAcParttimeApplyMapper.updateById(parttimeApply);
            srmAcParttimeApplyMapper.updateStatus(rowId,1,null);
            //System.out.println(rowId+","+userCode);
            srmEafRecService.generateRec(String.valueOf(rowId),this.sysNo,userCode,null);

        }catch (Exception e){
            e.printStackTrace();
            throw new ErrorException("-200",e.getMessage());
        }
    }

    @Override
    @Transactional
    public void audit(BaseDto baseDto) {
        System.out.println(baseDto);
        System.out.println(11111);
        List<Long> idList=baseDto.getIdList();
        System.out.println(idList);

        Long srmUserRowId= srmUserService.getUserIdByAccount(null);
        String sysNo="P051";
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
                System.out.println(rowId);
                SrmEafDetail srmEafDetail = srmEafRecService.getCheckStatus(sysNo,String.valueOf(rowId));
                System.out.println(33333);
                String realAuditStatus= srmEafDetail.getAuditPassStatus();
                srmAcParttimeApplyMapper.updateStatus(rowId,null,realAuditStatus);
                srmEafRecService.genAudit(rowId,sysNo,srmUserRowId,resultId,view,null);
            }
        }catch (Exception e){
            throw new ErrorException("-200",e.getMessage());
        }
    }

    @Override
    public IPage<AcParttimeApplyVo> listAuditAcParttimeApply(AcParttimeApplyDto acParttimeApplyDto) {
        String userCode=acParttimeApplyDto.getUserCode();
        Long srmUserRowId= srmUserService.getUserIdByAccount(userCode);
        acParttimeApplyDto.setUserId(String.valueOf(srmUserRowId));
        System.out.println(acParttimeApplyDto);
        Page<AcParttimeApplyVo> page = new Page<>(acParttimeApplyDto.getPage(), acParttimeApplyDto.getRows());
        IPage<AcParttimeApplyVo> res= srmAcParttimeApplyMapper.listAuditAcParttimeApply(page, acParttimeApplyDto);
        List<AcParttimeApplyVo> records=res.getRecords();
        List<AcParttimeApplyVo> newRecords=new ArrayList<>();
        for(AcParttimeApplyVo acParttimeApplyVo : records){
            AcParttimeApplyVo newRecord=new AcParttimeApplyVo();
            newRecord=acParttimeApplyVo;
            Long rowId=acParttimeApplyVo.getRowId();
            String checkListName= srmEafRecService.getCurCheckDesc("P051",rowId,null);
            newRecord.setChkResultlist(checkListName);
            newRecords.add(newRecord);
        }
        res.setRecords(newRecords);
        return res;
    }
}
