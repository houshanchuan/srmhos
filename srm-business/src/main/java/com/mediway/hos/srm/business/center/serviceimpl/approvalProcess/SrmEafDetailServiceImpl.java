package com.mediway.hos.srm.business.center.serviceimpl.approvalProcess;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.exception.ErrorException;
import com.mediway.hos.srm.business.center.mapper.user.SrmUserMapper;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.dto.approvalProcess.EafDetailDto;
import com.mediway.hos.srm.business.center.model.entity.approvalProcess.SrmEafDetail;
import com.mediway.hos.srm.business.center.mapper.approvalProcess.SrmEafDetailMapper;
import com.mediway.hos.srm.business.center.model.vo.approvalProcess.EafDetailVo;
import com.mediway.hos.srm.business.center.service.approvalProcess.SrmEafDetailService;
import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 审批流明细表 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-08-21
 */
@Service
public class SrmEafDetailServiceImpl extends BaseServiceImpl<SrmEafDetailMapper, SrmEafDetail> implements SrmEafDetailService {
    @Autowired
    private SrmEafDetailMapper srmEafDetailMapper;
    @Autowired
    private SrmUserMapper srmUserMapper;
    @Override
    public Integer getMaxStepNo(Long parref) {
        return srmEafDetailMapper.getMaxStepNo(parref);
    }

    @Override
    @Transactional
    public Long saveEafDetail(EafDetailDto eafDetailDto) {
        SrmEafDetail srmEafDetail =new SrmEafDetail();
        srmEafDetail.setId(eafDetailDto.getId());
        srmEafDetail.setEafMain(eafDetailDto.getEafMain());
        srmEafDetail.setDept(eafDetailDto.getDept());
        srmEafDetail.setCheckerString(eafDetailDto.getCheckerString());
        srmEafDetail.setChkProcdesc(eafDetailDto.getChkProcdesc());
        srmEafDetail.setAuditNopassStatus(eafDetailDto.getAuditNopassStatus());
        srmEafDetail.setAuditPassStatus(eafDetailDto.getAuditPassStatus());
        srmEafDetail.setIsCorrAuthor(eafDetailDto.getIsCorrAuthor());
        srmEafDetail.setIsDirector(eafDetailDto.getIsDirector());
        srmEafDetail.setIsHead(eafDetailDto.getIsHead());
        srmEafDetail.setIsSecretary(eafDetailDto.getIsSecretary());
        srmEafDetail.setIsMentor(eafDetailDto.getIsMentor());
        Long RowId=null;
        try{
            Integer stepno=null;
            if(eafDetailDto.getId()==null){
                stepno=getMaxStepNo(eafDetailDto.getEafMain());
                System.out.println(stepno);
                if(stepno==null){
                    stepno=1;
                }else{
                    stepno=stepno+1;
                }
                srmEafDetail.setStepNo(stepno);
            }

            super.saveOrUpdate(srmEafDetail);
            RowId= srmEafDetail.getId();
        }catch (Exception exception){
            throw new ErrorException("-200","保存失败");
        }
        return RowId;

    }

    @Override
    public EafDetailVo getDetail(Long rowId) {
        return srmEafDetailMapper.getDetail(rowId);
    }

    @Override
    public List<EafDetailVo> listDetail(Long parref) {
        List<EafDetailVo> eafDetailVos= srmEafDetailMapper.listDetail(parref);
        List<EafDetailVo> neweafDetailVos=new ArrayList<>();
        for (EafDetailVo eafDetailVo :eafDetailVos){
            String ids=eafDetailVo.getCheckerString();
            String checkers="";
            // System.out.println(StringUtils.isEmpty(checkers));
            if(!StringUtils.isEmpty(ids)){
               // System.out.println(ids);
                List<String> list = Arrays.stream(ids.split(",")).collect(Collectors.toList());
                List<String> checkerslist= srmUserMapper.getUserNamesByIds(list);
                checkers=String.join(",",checkerslist);
                //System.out.println(checkers);
                eafDetailVo.setCheckerName(checkers);
            }
            neweafDetailVos.add(eafDetailVo);
        }
        return neweafDetailVos;
    }

    @Override
    public List<EafDetailVo> listChecker(Long rowId) {
        EafDetailVo eafDetailVo= srmEafDetailMapper.getDetail(rowId);
        String ids=eafDetailVo.getCheckerString();
        List<EafDetailVo> eafDetailVolist=new ArrayList<>();
        if(!StringUtils.isEmpty(ids)){
            List<String> list = Arrays.stream(ids.split(",")).collect(Collectors.toList());
            eafDetailVolist= srmEafDetailMapper.getUserNamesByIds(list);

        }
        return eafDetailVolist;
    }

    @Override
    @Transactional
    public void deleteDetail(BaseDto baseDto) {
        Long rowId=baseDto.getId();
        String idStr="";
        try{
            SrmEafDetail srmEafDetail=srmEafDetailMapper.selectById(rowId);
            int curStepNo=srmEafDetail.getStepNo();
            int lastStepNo=curStepNo+1;
            QueryWrapper<SrmEafDetail> queryWrapper=new QueryWrapper<>();
            queryWrapper.eq("step_no",lastStepNo);
            queryWrapper.eq("eaf_main",srmEafDetail.getEafMain());

            List<SrmEafDetail> srmEafDetails=srmEafDetailMapper.selectList(queryWrapper);
            if(!srmEafDetails.isEmpty()){
                throw new ErrorException("-200","请先删除下级审批流");
            }
            // 先判断是否有上级
            super.deleteById(rowId);
        }catch (Exception exception){
            throw  new ErrorException("-200",exception.getMessage());
        }
    }
}
