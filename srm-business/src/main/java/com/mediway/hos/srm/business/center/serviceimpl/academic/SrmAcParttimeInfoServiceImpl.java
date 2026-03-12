package com.mediway.hos.srm.business.center.serviceimpl.academic;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mediway.hos.app.core.util.SecurityUtils;
import com.mediway.hos.security.core.userdetails.HosUser;
import com.mediway.hos.srm.business.center.aspect.DataChangeLog;
import com.mediway.hos.srm.business.center.model.entity.academic.SrmAcLecture;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.exception.ErrorException;
import com.mediway.hos.srm.business.center.mapper.user.SrmUserMapper;
import com.mediway.hos.srm.business.center.model.dto.academic.AcParttimeInfoDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.entity.academic.SrmAcParttimeInfo;
import com.mediway.hos.srm.business.center.mapper.academic.SrmAcParttimeInfoMapper;
import com.mediway.hos.srm.business.center.model.entity.approvalProcess.SrmEafDetail;
import com.mediway.hos.srm.business.center.model.vo.academic.AcParttimeInfoVo;
import com.mediway.hos.srm.business.center.service.academic.SrmAcParttimeInfoService;
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
 * 兼职信息表 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
@Slf4j
public class SrmAcParttimeInfoServiceImpl extends BaseServiceImpl<SrmAcParttimeInfoMapper, SrmAcParttimeInfo> implements SrmAcParttimeInfoService {
    private final String sysNo="T001";
    private final String tableName="srm_ac_parttime_info";
    private final String logTitle="社会兼职维护";
    @Autowired
    private SrmAcParttimeInfoMapper srmAcParttimeInfoMapper;
    @Autowired
    private SrmUserService srmUserService;
    @Autowired
    private SrmUserMapper srmUserMapper;
    @Autowired
    private SrmEafRecService srmEafRecService;

    @Override
    @DataChangeLog(sysNo=sysNo,title = logTitle, tableName=tableName)
    public Long saveAcParttimeInfo(AcParttimeInfoDto acParttimeInfoDto) {
        SrmAcParttimeInfo srmAcParttimeInfo=new SrmAcParttimeInfo();
        srmAcParttimeInfo.setId(acParttimeInfoDto.getRowId());
        srmAcParttimeInfo.setUserId(acParttimeInfoDto.getUserId());
        srmAcParttimeInfo.setCommittee(acParttimeInfoDto.getCommittee());
        srmAcParttimeInfo.setCommitteeBranch(acParttimeInfoDto.getCommitteeBranch());
        srmAcParttimeInfo.setBranch(acParttimeInfoDto.getBranch());
        srmAcParttimeInfo.setDeptId(acParttimeInfoDto.getDeptId());
        srmAcParttimeInfo.setCommitteeType(acParttimeInfoDto.getCommitteeType());
        srmAcParttimeInfo.setParttimeType(acParttimeInfoDto.getParttimeType());
        srmAcParttimeInfo.setPosition(acParttimeInfoDto.getPosition());
        srmAcParttimeInfo.setYear(acParttimeInfoDto.getYear());
        srmAcParttimeInfo.setSysNo(this.sysNo);
        srmAcParttimeInfo.setStartDate(DateTransform.getLocalDateTime(acParttimeInfoDto.getStartDate()));
        srmAcParttimeInfo.setEndDate(DateTransform.getLocalDateTime(acParttimeInfoDto.getEndDate()));
        srmAcParttimeInfo.setDataStatus(0);
        Long rowId=null;
        try{
            if(acParttimeInfoDto.getRowId()==null){
                String userCode=acParttimeInfoDto.getUserCode();
                Long srmUserRowId= srmUserService.getUserIdByAccount(userCode);
                srmAcParttimeInfo.setCreatorId(srmUserRowId);
                srmAcParttimeInfo.setCreateTime(LocalDateTime.now());

            }
            super.saveOrUpdate(srmAcParttimeInfo);
            rowId=srmAcParttimeInfo.getId();

        }catch (Exception exception){
            log.error("保存错误",exception);
            throw new ErrorException("-200",exception.getMessage());
        }
        return rowId;
    }

    @Override
    public AcParttimeInfoVo getDetail(Long rowId) {
        return srmAcParttimeInfoMapper.getDetail(rowId);
    }

    @Override
    public IPage<AcParttimeInfoVo> listAcParttimeInfo(AcParttimeInfoDto acParttimeInfoDto) {
        String userCode=acParttimeInfoDto.getUserCode();
        Long srmUserRowId= srmUserService.getUserIdByAccount(userCode);
        acParttimeInfoDto.setUserId(String.valueOf(srmUserRowId));
        System.out.println(acParttimeInfoDto);
        Page<AcParttimeInfoVo> page = new Page<>(acParttimeInfoDto.getPage(), acParttimeInfoDto.getRows());
        IPage<AcParttimeInfoVo> res= srmAcParttimeInfoMapper.listAcParttimeInfo(page, acParttimeInfoDto);
        List<AcParttimeInfoVo> records=res.getRecords();
        List<AcParttimeInfoVo> newRecords=new ArrayList<>();
        for(AcParttimeInfoVo acParttimeInfoVo : records){
            AcParttimeInfoVo newRecord=new AcParttimeInfoVo();
            newRecord=acParttimeInfoVo;
            Long rowId=acParttimeInfoVo.getRowId();
            String checkListName= srmEafRecService.getCurCheckDesc(this.sysNo,rowId,null);
            newRecord.setChkResultlist(checkListName);
            newRecords.add(newRecord);
        }
        res.setRecords(newRecords);
        return res;
    }

    @Override
    @Transactional
    @DataChangeLog(sysNo=sysNo,title = logTitle, tableName=tableName)
    public void deleteAcParttimeInfo(BaseDto baseDto) {
        System.out.println(baseDto);
        List<Long> idList=baseDto.getIdList();
        String idStr="";
        try{
            for (Long RowId : idList) {
                //System.out.println(RowId);
                QueryWrapper<SrmAcParttimeInfo> srmAcParttimeInfoQueryWrapper=new QueryWrapper<>();
                srmAcParttimeInfoQueryWrapper.eq("id",RowId);
                SrmAcParttimeInfo srmAcParttimeInfo=srmAcParttimeInfoMapper.selectOne(srmAcParttimeInfoQueryWrapper);
                Integer dataStatus=srmAcParttimeInfo.getDataStatus();
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
            //AcParttimeInfoVo parttimeInfoVo=this.getDetail(rowId);

            SrmAcParttimeInfo srmAcParttimeInfo=this.selectById(rowId);
            Integer dataStatus=0;
            if(srmAcParttimeInfo!=null){
                dataStatus=srmAcParttimeInfo.getDataStatus();
            }

            if(dataStatus==1){
                throw new ErrorException("-200","已提交");
            }
            Long srmUserRowId= srmUserService.getUserIdByAccount(userCode);
            UpdateWrapper<SrmAcParttimeInfo> wrapper = new UpdateWrapper<>();
            wrapper.eq("id", srmAcParttimeInfo.getId())
                    .set("sub_user_id", srmUserRowId.toString())
                    .set("sub_date", LocalDateTime.now())
                    .set("data_status", "1");
            srmAcParttimeInfoMapper.update(null, wrapper);
            //srmAcParttimeInfoMapper.updateStatus(rowId,1,null);
            srmEafRecService.generateRec(String.valueOf(rowId),this.sysNo,userCode,null);

        }catch (Exception e){
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
        String sysNo=this.sysNo;
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
                srmAcParttimeInfoMapper.updateStatus(rowId,null,realAuditStatus);
                srmEafRecService.genAudit(rowId,sysNo,srmUserRowId,resultId,view,null);
            }
        }catch (Exception e){
            throw new ErrorException("-200",e.getMessage());
        }
    }

    @Override
    public IPage<AcParttimeInfoVo> listAuditAcParttimeInfo(AcParttimeInfoDto acParttimeInfoDto) {
        String userCode=acParttimeInfoDto.getUserCode();
        Long srmUserRowId= srmUserService.getUserIdByAccount(userCode);
        acParttimeInfoDto.setUserId(String.valueOf(srmUserRowId));
        System.out.println(acParttimeInfoDto);
        Page<AcParttimeInfoVo> page = new Page<>(acParttimeInfoDto.getPage(), acParttimeInfoDto.getRows());
        IPage<AcParttimeInfoVo> res= srmAcParttimeInfoMapper.listAuditAcParttimeInfo(page, acParttimeInfoDto);
        List<AcParttimeInfoVo> records=res.getRecords();
        List<AcParttimeInfoVo> newRecords=new ArrayList<>();
        for(AcParttimeInfoVo acParttimeInfoVo : records){
            AcParttimeInfoVo newRecord=new AcParttimeInfoVo();
            newRecord=acParttimeInfoVo;
            Long rowId=acParttimeInfoVo.getRowId();
            String checkListName= srmEafRecService.getCurCheckDesc("T001",rowId,null);
            newRecord.setChkResultlist(checkListName);
            newRecords.add(newRecord);
        }
        res.setRecords(newRecords);
        return res;
    }
}
