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

import com.mediway.hos.srm.business.center.model.dto.baseData.PaperReshipTypeDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmReshipType;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmReshipTypeMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.PaperReshipTypeVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmReshipTypeService;

import javax.annotation.Resource;

/**
 * <p>
 * 转载类型 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmReshipTypeServiceImpl extends BaseServiceImpl<SrmReshipTypeMapper, SrmReshipType> implements SrmReshipTypeService {
    @Autowired
    private SrmReshipTypeService  srmReshipTypeService;
    @Autowired
    private SrmReshipTypeMapper srmReshipTypeMapper;
    @Resource
    private SrmBusinessnoService srmBusinessnoService;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdatePaperReshipType(BaseDataLearningDto baseDataLearningDto) {
        List<PaperReshipTypeDto> paperReshipTypeDtos =baseDataLearningDto.getPaperReshipTypes();

        List<SrmReshipType> paperReshipTypeList=new ArrayList<>();
        for (PaperReshipTypeDto paperReshipTypeDto :paperReshipTypeDtos) {
            SrmReshipType srmPaperReshipType = new SrmReshipType();
            srmPaperReshipType.setId(paperReshipTypeDto.getRowId());
            if(ObjectUtil.isEmpty(paperReshipTypeDto.getCode())) {
                String code = srmBusinessnoService.getBusinessNo(BusinessConstants.PT_RESHIP_TYPE, 1, "");
                srmPaperReshipType.setCode(code);
            }else{
                srmPaperReshipType.setCode(paperReshipTypeDto.getCode());
            }
            srmPaperReshipType.setName(paperReshipTypeDto.getName());
            srmPaperReshipType.setIsValid(Integer.valueOf(paperReshipTypeDto.getIsValid()));

            paperReshipTypeList.add(srmPaperReshipType);
            Long RowId = srmPaperReshipType.getId();
        }
        super.saveOrUpdateBatch(paperReshipTypeList);
        return RowId;
    }
    @Override
    public PaperReshipTypeVo getDetailPaperReshipType(Long RowId) {
        return null;
    }

    @Override
    public IPage<PaperReshipTypeVo> listPaperReshipType(PaperReshipTypeDto paperReshipTypeDto) {
        Page<PaperReshipTypeVo> page = new Page<>(paperReshipTypeDto.getPage(), paperReshipTypeDto.getRows());
        IPage<PaperReshipTypeVo> res= srmReshipTypeMapper.listPaperReshipType(page, paperReshipTypeDto);
        //List<PaperReshipTypeVo> records=res.getRecords();
        //List<PaperReshipTypeVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deletePaperReshipType(BaseDto baseDto) {
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
    public List<CombVo> getPaperReshipType(PaperReshipTypeDto paperReshipTypeDto) {
        return srmReshipTypeMapper.getPaperReshipType(paperReshipTypeDto);
    }
}
