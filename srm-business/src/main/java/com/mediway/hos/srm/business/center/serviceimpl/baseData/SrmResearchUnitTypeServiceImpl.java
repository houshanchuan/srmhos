package com.mediway.hos.srm.business.center.serviceimpl.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.alibaba.druid.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.exception.ErrorException;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataPlatformDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

import com.mediway.hos.srm.business.center.model.dto.baseData.ResearchUnitTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ResearchUnitTypeVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmResearchUnitType;
import com.mediway.hos.srm.business.center.service.baseData.SrmResearchUnitTypeService;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmResearchUnitTypeMapper;

/**
 * <p>
 * 科研机构类型 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmResearchUnitTypeServiceImpl extends BaseServiceImpl<SrmResearchUnitTypeMapper, SrmResearchUnitType> implements SrmResearchUnitTypeService {

    @Autowired
    private SrmResearchUnitTypeMapper srmResearchUnitTypeMapper;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateResearchUnitType(BaseDataPlatformDto baseDataPlatformDto) {
        List<ResearchUnitTypeDto> researchUnitTypeDtos =baseDataPlatformDto.getResearchUnitTypes();

        List<SrmResearchUnitType> researchUnitTypeList=new ArrayList<>();
        for (ResearchUnitTypeDto researchUnitTypeDto :researchUnitTypeDtos) {
            SrmResearchUnitType researchUnitType = new SrmResearchUnitType();
            researchUnitType.setId(researchUnitTypeDto.getRowId());
            researchUnitType.setCode(researchUnitTypeDto.getCode());
            researchUnitType.setName(researchUnitTypeDto.getName());
            researchUnitType.setIsValid(researchUnitTypeDto.getIsValid());

            researchUnitTypeList.add(researchUnitType);
            Long RowId = researchUnitType.getId();
        }
        super.saveOrUpdateBatch(researchUnitTypeList);
        return RowId;
    }
    @Override
    public ResearchUnitTypeVo getDetailResearchUnitType(Long RowId) {
        return null;
    }

    @Override
    public IPage<ResearchUnitTypeVo> listResearchUnitType(ResearchUnitTypeDto researchUnitTypeDto) {
        Page<ResearchUnitTypeVo> page = new Page<>(researchUnitTypeDto.getPage(),researchUnitTypeDto.getRows());
        IPage<ResearchUnitTypeVo> res= srmResearchUnitTypeMapper.listResearchUnitType(page,researchUnitTypeDto);
        return res;
    }

    @Override
    public void deleteResearchUnitType(BaseDto baseDto) {
        List<Long> idList=baseDto.getIdList();
        String idStr="";
        try{
            for (Long RowId : idList) {
                //System.out.println(RowId);
                if(StringUtils.isEmpty(idStr)){
                    idStr=String.valueOf(RowId);
                }else{
                    idStr=idStr+""+String.valueOf(RowId);
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
