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

import com.mediway.hos.srm.business.center.model.dto.baseData.ResearchTypeDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmResearchType;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmResearchTypeMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.ResearchTypeVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmResearchTypeService;

/**
 * <p>
 * 研究类型表 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmResearchTypeServiceImpl extends BaseServiceImpl<SrmResearchTypeMapper, SrmResearchType> implements SrmResearchTypeService {
    @Autowired
    private SrmResearchTypeService  srmResearchTypeService;
    @Autowired
    private SrmResearchTypeMapper srmResearchTypeMapper;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateResearchType(BaseDataLearningDto baseDataLearningDto) {
        List<ResearchTypeDto> researchTypeDtos =baseDataLearningDto.getResearchTypes();

        List<SrmResearchType> researchTypeList=new ArrayList<>();
        for (ResearchTypeDto researchTypeDto :researchTypeDtos) {
            SrmResearchType srmResearchType = new SrmResearchType();
            srmResearchType.setId(researchTypeDto.getRowId());
            srmResearchType.setCode(researchTypeDto.getCode());
            srmResearchType.setName(researchTypeDto.getName());
            srmResearchType.setIsValid(Integer.valueOf(researchTypeDto.getIsValid()));

            researchTypeList.add(srmResearchType);
            Long RowId = srmResearchType.getId();
        }
        super.saveOrUpdateBatch(researchTypeList);
        return RowId;
    }
    @Override
    public ResearchTypeVo getDetailResearchType(Long RowId) {
        return null;
    }

    @Override
    public IPage<ResearchTypeVo> listResearchType(ResearchTypeDto researchTypeDto) {
        Page<ResearchTypeVo> page = new Page<>(researchTypeDto.getPage(), researchTypeDto.getRows());
        IPage<ResearchTypeVo> res= srmResearchTypeMapper.listResearchType(page, researchTypeDto);
        //List<ResearchTypeVo> records=res.getRecords();
        //List<ResearchTypeVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteResearchType(BaseDto baseDto) {
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
