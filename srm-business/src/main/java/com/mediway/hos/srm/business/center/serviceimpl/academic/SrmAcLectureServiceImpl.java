package com.mediway.hos.srm.business.center.serviceimpl.academic;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
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
import com.mediway.hos.srm.business.center.model.dto.academic.AcLectureDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.entity.academic.SrmAcLecture;
import com.mediway.hos.srm.business.center.mapper.academic.SrmAcLectureMapper;
import com.mediway.hos.srm.business.center.model.entity.approvalProcess.SrmEafDetail;
import com.mediway.hos.srm.business.center.model.vo.academic.AcLectureVo;
import com.mediway.hos.srm.business.center.service.academic.SrmAcLectureService;
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
 * 学术讲座 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmAcLectureServiceImpl extends BaseServiceImpl<SrmAcLectureMapper, SrmAcLecture> implements SrmAcLectureService {
    private final String sysNo="P041";
    private final String tableName="srm_ac_lecture";
    private final String logTitle="学术讲座";
    @Autowired
    private SrmAcLectureMapper srmAcLectureMapper;
    @Autowired
    private SrmUserService srmUserService;
    @Autowired
    private SrmUserMapper srmUserMapper;
    @Autowired
    private SrmEafRecService srmEafRecService;

    @Override
    @DataChangeLog(sysNo=sysNo,title = logTitle, tableName=tableName)
    public Long saveAcLecture(AcLectureDto acLectureDto) {
        SrmAcLecture srmAcLecture=new SrmAcLecture();
        srmAcLecture.setId(acLectureDto.getRowId());
        srmAcLecture.setName(acLectureDto.getName());
        srmAcLecture.setStartDate(DateTransform.getLocalDateTime(acLectureDto.getStartDate()));
        srmAcLecture.setLecType(acLectureDto.getLecType());
        srmAcLecture.setLecLevel(acLectureDto.getLecLevel());
        srmAcLecture.setDeptId(acLectureDto.getDeptId());
        srmAcLecture.setDivision(acLectureDto.getDivision());
        srmAcLecture.setLecAddress(acLectureDto.getLecAddress());
        srmAcLecture.setIntro(acLectureDto.getIntro());
        srmAcLecture.setListenersNum(acLectureDto.getListenersNum());
        srmAcLecture.setLecturer(acLectureDto.getLecturer());
        srmAcLecture.setLecturerUnit(acLectureDto.getLecturerUnit());
        srmAcLecture.setLecturerDuty(acLectureDto.getLecturerDuty());
        srmAcLecture.setLecturerTitle(acLectureDto.getLecturerTitle());
        srmAcLecture.setLecturerInfo(acLectureDto.getLecturerInfo());
        srmAcLecture.setRelatedSubject(acLectureDto.getRelatedSubject());
        srmAcLecture.setCommend(acLectureDto.getCommend());
        srmAcLecture.setCompere(acLectureDto.getCompere());
        srmAcLecture.setSubFlag("0");
        Long rowId=null;
        try{
            if(acLectureDto.getRowId()==null){
                String userCode=acLectureDto.getUserCode();
                Long srmUserRowId= srmUserService.getUserIdByAccount(userCode);
                srmAcLecture.setCreatorId(String.valueOf(srmUserRowId));
                srmAcLecture.setCreateTime(LocalDateTime.now());

            }
            srmAcLecture.setOperateTime(LocalDateTime.now());
            super.saveOrUpdate(srmAcLecture);
            rowId=srmAcLecture.getId();

        }catch (Exception exception){
            throw new ErrorException("-200",exception.getMessage());
        }
        return rowId;
    }

    @Override
    public AcLectureVo getDetail(Long rowId) {
        return srmAcLectureMapper.getDetail(rowId);
    }

    @Override
    public IPage<AcLectureVo> listAcLecture(AcLectureDto acLectureDto) {
        String userCode=acLectureDto.getUserCode();
        Long srmUserRowId= srmUserService.getUserIdByAccount(userCode);
        acLectureDto.setUserId(srmUserRowId);
        System.out.println(acLectureDto);
        Page<AcLectureVo> page = new Page<>(acLectureDto.getPage(), acLectureDto.getRows());
        IPage<AcLectureVo> res= srmAcLectureMapper.listAcLecture(page, acLectureDto);
        List<AcLectureVo> records=res.getRecords();
        List<AcLectureVo> newRecords=new ArrayList<>();
        for(AcLectureVo acLectureVo : records){
            AcLectureVo newRecord=new AcLectureVo();
            newRecord=acLectureVo;
            Long rowId=acLectureVo.getRowId();
            String checkListName= srmEafRecService.getCurCheckDesc("P041",rowId,null);
            newRecord.setChkResultlist(checkListName);
            newRecords.add(newRecord);
        }
        res.setRecords(newRecords);
        return res;
    }

    @Override
    @Transactional
    @DataChangeLog(sysNo=sysNo,title = logTitle, tableName=tableName)
    public void deleteAcLecture(BaseDto baseDto) {
        List<Long> idList=baseDto.getIdList();
        String idStr="";
        try{
            for (Long RowId : idList) {
                //System.out.println(RowId);
                QueryWrapper<SrmAcLecture> srmAcLectureQueryWrapper=new QueryWrapper<>();
                srmAcLectureQueryWrapper.eq("id",RowId);
                SrmAcLecture srmAcLecture=srmAcLectureMapper.selectOne(srmAcLectureQueryWrapper);
                String dataStatus=srmAcLecture.getSubFlag();
                if("1".equals(dataStatus)){
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
            AcLectureVo acLectureVo=this.getDetail(rowId);
            String dataStatus=acLectureVo.getSubFlag();
            if("1".equals(dataStatus)){
                throw new ErrorException("-200","已提交");
            }
            Long srmUserRowId= srmUserService.getUserIdByAccount(userCode);
            UpdateWrapper<SrmAcLecture> wrapper = new UpdateWrapper<>();
            wrapper.eq("id", acLectureVo.getRowId())
                    .set("sub_user_id", srmUserRowId.toString())
                    .set("sub_date", LocalDateTime.now())
                    .set("sub_flag", "1");
            srmAcLectureMapper.update(null, wrapper);
            //srmAcLectureMapper.updateStatus(rowId,1,null);
            //System.out.println(rowId+","+userCode);
            srmEafRecService.generateRec(String.valueOf(rowId),"P041",userCode,null);

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

        Long userId=srmUserService.getUserIdByAccount(null);
        String sysNo="P041";
        if(userId==null){
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
                srmAcLectureMapper.updateStatus(rowId,null,realAuditStatus);
                srmEafRecService.genAudit(rowId,sysNo,userId,resultId,view,null);
            }
        }catch (Exception e){
            throw new ErrorException("-200",e.getMessage());
        }
    }

    @Override
    public IPage<AcLectureVo> listAuditAcLecture(AcLectureDto acLectureDto) {
        String userCode=acLectureDto.getUserCode();
        Long srmUserRowId= srmUserService.getUserIdByAccount(userCode);
        acLectureDto.setUserId(srmUserRowId);
        System.out.println(acLectureDto);
        Page<AcLectureVo> page = new Page<>(acLectureDto.getPage(), acLectureDto.getRows());
        IPage<AcLectureVo> res= srmAcLectureMapper.listAuditAcLecture(page, acLectureDto);
        List<AcLectureVo> records=res.getRecords();
        List<AcLectureVo> newRecords=new ArrayList<>();
        for(AcLectureVo acLectureVo : records){
            AcLectureVo newRecord=new AcLectureVo();
            newRecord=acLectureVo;
            Long rowId=acLectureVo.getRowId();
            String checkListName= srmEafRecService.getCurCheckDesc("P041",rowId,null);
            newRecord.setChkResultlist(checkListName);
            newRecords.add(newRecord);
        }
        res.setRecords(newRecords);
        return res;
    }

}
