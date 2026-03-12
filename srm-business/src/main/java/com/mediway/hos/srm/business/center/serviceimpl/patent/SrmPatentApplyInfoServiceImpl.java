package com.mediway.hos.srm.business.center.serviceimpl.patent;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.exception.ErrorException;
import com.mediway.hos.srm.business.center.model.dto.patent.PatentApplyInfoDto;
import com.mediway.hos.srm.business.center.model.entity.patent.SrmPatentApplyInfo;
import com.mediway.hos.srm.business.center.mapper.patent.SrmPatentApplyInfoMapper;
import com.mediway.hos.srm.business.center.model.vo.patent.PatentApplyInfoVo;
import com.mediway.hos.srm.business.center.service.patent.SrmPatentApplyInfoService;
import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import com.mediway.hos.srm.business.center.service.user.SrmUserService;
import com.mediway.hos.srm.business.center.utils.DateTransform;

import java.time.LocalDateTime;

/**
 * <p>
 * 专利申报批次 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmPatentApplyInfoServiceImpl extends BaseServiceImpl<SrmPatentApplyInfoMapper, SrmPatentApplyInfo> implements SrmPatentApplyInfoService {
    @Autowired
    private SrmPatentApplyInfoMapper srmPatentApplyInfoMapper;
    @Autowired
    private SrmUserService srmUserService;
    @Override
    @Transactional
    public Long savePatentApplyInfo(PatentApplyInfoDto patentApplyInfoDto) {
        SrmPatentApplyInfo srmPatentApplyInfo=new SrmPatentApplyInfo();
        srmPatentApplyInfo.setId(patentApplyInfoDto.getRowId());
        srmPatentApplyInfo.setApplyInfoName(patentApplyInfoDto.getApplyInfoName());
        srmPatentApplyInfo.setApplyInfoState(patentApplyInfoDto.getApplyInfoState());
        srmPatentApplyInfo.setPatentState(patentApplyInfoDto.getPatentState());
        srmPatentApplyInfo.setPatentType(patentApplyInfoDto.getPatentType());
        srmPatentApplyInfo.setNote(patentApplyInfoDto.getNote());

        Long RowId=null;
        try{
            String userCode=patentApplyInfoDto.getUserCode();
            Long srmUserRowId= srmUserService.getUserIdByAccount(userCode);
            srmPatentApplyInfo.setCreatorId(String.valueOf(srmUserRowId));
            srmPatentApplyInfo.setOperateTime(LocalDateTime.now());
            srmPatentApplyInfo.setStartDate(DateTransform.getLocalDateTime(patentApplyInfoDto.getStartDate()));
            srmPatentApplyInfo.setEndDate(DateTransform.getLocalDateTime(patentApplyInfoDto.getEndDate()));
            super.saveOrUpdate(srmPatentApplyInfo);
            RowId=srmPatentApplyInfo.getId();

        }catch (Exception exception){
            throw new ErrorException("-200",exception.getMessage());
        }
        return RowId;
    }

    @Override
    public PatentApplyInfoVo getDetail(Long rowId) {
        return srmPatentApplyInfoMapper.getDetail(rowId);
    }

    @Override
    public IPage<PatentApplyInfoVo> listPatentApplyInfo(PatentApplyInfoDto patentApplyInfoDto) {
        System.out.println(patentApplyInfoDto);
        Page<PatentApplyInfoVo> page = new Page<>(patentApplyInfoDto.getPage(), patentApplyInfoDto.getRows());
        IPage<PatentApplyInfoVo> res= srmPatentApplyInfoMapper.listPatentApplyInfo(page, patentApplyInfoDto);
        return res;
    }

    @Override
    @Transactional
    public void delete(Long rowId) {
        PatentApplyInfoVo patentApplyInfoVo=srmPatentApplyInfoMapper.getDetail(rowId);
        System.out.println(patentApplyInfoVo);
        String applyStatue=patentApplyInfoVo.getApplyInfoState();
        if(applyStatue!=null&&!applyStatue.equals("0")){
            throw new ErrorException("-200","当前状态不允许删除");
        }
        try {
            super.deleteById(rowId);
        }catch (Exception exception){
            throw new ErrorException("-200",exception.getMessage());
        }
    }
}
