package com.mediway.hos.srm.business.center.serviceimpl.baseData;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.alibaba.druid.util.StringUtils;
import com.mediway.hos.srm.business.center.constants.BusinessConstants;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmBusinessnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.exception.ErrorException;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataLearningDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.mediway.hos.srm.business.center.model.dto.baseData.PaperEmbodyTypeDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmEmbodyType;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmEmbodyTypeMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.PaperEmbodyTypeVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmEmbodyTypeService;

import javax.annotation.Resource;

/**
 * <p>
 * 收录类型 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-01
 */
@Service
public class SrmEmbodyTypeServiceImpl extends BaseServiceImpl<SrmEmbodyTypeMapper, SrmEmbodyType> implements SrmEmbodyTypeService {
    @Autowired
    private SrmEmbodyTypeService  srmPaperEmbodyTypeService;
    @Autowired
    private SrmEmbodyTypeMapper srmPaperEmbodyTypeMapper;
    @Resource
    private SrmBusinessnoService srmBusinessnoService;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdatePaperEmbodyType(BaseDataLearningDto baseDataLearningDto) {
        List<PaperEmbodyTypeDto> paperEmbodyTypeDtos =baseDataLearningDto.getPaperEmbodyTypes();

        List<SrmEmbodyType> paperEmbodyTypeList=new ArrayList<>();
        for (PaperEmbodyTypeDto paperEmbodyTypeDto :paperEmbodyTypeDtos) {
            SrmEmbodyType srmPaperEmbodyType = new SrmEmbodyType();
            srmPaperEmbodyType.setId(paperEmbodyTypeDto.getRowId());
            if(ObjectUtil.isEmpty(paperEmbodyTypeDto.getCode())) {
                String code = srmBusinessnoService.getBusinessNo(BusinessConstants.PT_EMBODY_TYPE, 1, "");
                srmPaperEmbodyType.setCode(code);
            }else{
                srmPaperEmbodyType.setCode(paperEmbodyTypeDto.getCode());
            }
            srmPaperEmbodyType.setName(paperEmbodyTypeDto.getName());
            srmPaperEmbodyType.setIsValid(Integer.valueOf(paperEmbodyTypeDto.getIsValid()));

            paperEmbodyTypeList.add(srmPaperEmbodyType);
            Long RowId = srmPaperEmbodyType.getId();
        }
        super.saveOrUpdateBatch(paperEmbodyTypeList);
        return RowId;
    }
    @Override
    public PaperEmbodyTypeVo getDetailPaperEmbodyType(Long RowId) {
        return null;
    }

    @Override
    public IPage<PaperEmbodyTypeVo> listPaperEmbodyType(PaperEmbodyTypeDto paperEmbodyTypeDto) {
        Page<PaperEmbodyTypeVo> page = new Page<>(paperEmbodyTypeDto.getPage(), paperEmbodyTypeDto.getRows());
        IPage<PaperEmbodyTypeVo> res= srmPaperEmbodyTypeMapper.listPaperEmbodyType(page, paperEmbodyTypeDto);
        //List<PaperEmbodyTypeVo> records=res.getRecords();
        //List<PaperEmbodyTypeVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deletePaperEmbodyType(BaseDto baseDto) {
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

    @Override
    public List<CombVo> getEmbodyType(PaperEmbodyTypeDto paperEmbodyTypeDto) {
        return srmPaperEmbodyTypeMapper.getEmbodyType(paperEmbodyTypeDto);
    }
}
