package com.mediway.hos.srm.business.center.serviceimpl.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.alibaba.druid.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.exception.ErrorException;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataProjDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


import com.mediway.hos.srm.business.center.model.dto.baseData.ProjTypeSubDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ProjTypeSubVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmProjTypeSub;
import com.mediway.hos.srm.business.center.service.baseData.SrmProjTypeSubService;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmProjTypeSubMapper;

/**
 * <p>
 * 项目类型(子类) 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmProjTypeSubServiceImpl extends BaseServiceImpl<SrmProjTypeSubMapper, SrmProjTypeSub> implements SrmProjTypeSubService {

    @Autowired
    private SrmProjTypeSubService  srmProjTypeSubService;
    @Autowired
    private SrmProjTypeSubMapper srmProjTypeSubMapper;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateProjTypeSub(BaseDataProjDto baseDataProjDto) {
        List<ProjTypeSubDto> projTypeSubDtos =baseDataProjDto.getProjTypeSubs();
        String mainId=baseDataProjDto.getMainId();

        List<SrmProjTypeSub> projTypeSubList=new ArrayList<>();
        for (ProjTypeSubDto projTypeSubDto :projTypeSubDtos) {
            SrmProjTypeSub srmProjTypeSub = new SrmProjTypeSub();
            srmProjTypeSub.setId(projTypeSubDto.getRowId());
            srmProjTypeSub.setCode(projTypeSubDto.getCode());
            srmProjTypeSub.setName(projTypeSubDto.getName());
            srmProjTypeSub.setIsValid(projTypeSubDto.getIsValid());
            srmProjTypeSub.setParrefType(projTypeSubDto.getParrefType());
            if (srmProjTypeSub.getParrefType()==null || srmProjTypeSub.getParrefType()==""){
                srmProjTypeSub.setParrefType(mainId);
            }

            projTypeSubList.add(srmProjTypeSub);
            Long RowId = srmProjTypeSub.getId();
        }
        super.saveOrUpdateBatch(projTypeSubList);
        return RowId;
    }
    @Override
    public ProjTypeSubVo getDetailProjTypeSub(Long RowId) {
        return null;
    }

    @Override
    public IPage<ProjTypeSubVo> listProjTypeSub(ProjTypeSubDto projTypeSubDto) {
        Page<ProjTypeSubVo> page = new Page<>(projTypeSubDto.getPage(), projTypeSubDto.getRows());
        String projTypeId=projTypeSubDto.getParrefType();
        IPage<ProjTypeSubVo> res= srmProjTypeSubMapper.listProjTypeSub(page, projTypeId);
        return  res;
    }

    @Override
    public void deleteProjTypeSub(BaseDto baseDto) {
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
    public Long getIdByName(String name) {
        return null;
    }
}
