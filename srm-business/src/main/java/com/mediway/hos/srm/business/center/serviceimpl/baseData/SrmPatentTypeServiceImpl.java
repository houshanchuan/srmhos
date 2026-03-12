package com.mediway.hos.srm.business.center.serviceimpl.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.alibaba.druid.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.exception.ErrorException;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataLearningDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import com.mediway.hos.srm.business.center.model.dto.baseData.PatentTypeDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmPatentType;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmPatentTypeMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.PatentTypeVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmPatentTypeService;
/**
 * <p>
 * 专利类型 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmPatentTypeServiceImpl extends BaseServiceImpl<SrmPatentTypeMapper, SrmPatentType> implements SrmPatentTypeService {
    @Autowired
    private SrmPatentTypeService  srmPatentTypeService;
    @Autowired
    private SrmPatentTypeMapper srmPatentTypeMapper;
    private Long RowId;
    @Override
    public List<CombVo> getPatentType() {
        return srmPatentTypeMapper.getPatentType();
	}
    @Override
    @Transactional
    public Long saveOrUpdatePatentType(BaseDataLearningDto baseDataLearningDto) {
        List<PatentTypeDto> patentTypeDtos =baseDataLearningDto.getPatentTypes();

        List<SrmPatentType> patentTypeList=new ArrayList<>();
        for (PatentTypeDto patentTypeDto :patentTypeDtos) {
            SrmPatentType srmPatentType = new SrmPatentType();
            srmPatentType.setId(patentTypeDto.getRowId());
            srmPatentType.setCode(patentTypeDto.getCode());
            srmPatentType.setName(patentTypeDto.getName());
            srmPatentType.setIsValid(Integer.valueOf(patentTypeDto.getIsValid()));

            patentTypeList.add(srmPatentType);
            Long RowId = srmPatentType.getId();
        }
        super.saveOrUpdateBatch(patentTypeList);
        return RowId;
    }
    @Override
    public PatentTypeVo getDetailPatentType(Long RowId) {
        return null;
    }

    @Override
    public IPage<PatentTypeVo> listPatentType(PatentTypeDto patentTypeDto) {
        Page<PatentTypeVo> page = new Page<>(patentTypeDto.getPage(), patentTypeDto.getRows());
        IPage<PatentTypeVo> res= srmPatentTypeMapper.listPatentType(page, patentTypeDto);
        //List<PatentTypeVo> records=res.getRecords();
        //List<PatentTypeVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deletePatentType(BaseDto baseDto) {
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
