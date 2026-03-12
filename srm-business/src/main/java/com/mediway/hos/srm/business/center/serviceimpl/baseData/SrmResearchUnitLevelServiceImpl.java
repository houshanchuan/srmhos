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

import com.mediway.hos.srm.business.center.model.dto.baseData.ResearchUnitLevelDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ResearchUnitLevelVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmResearchUnitLevel;
import com.mediway.hos.srm.business.center.service.baseData.SrmResearchUnitLevelService;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmResearchUnitLevelMapper;
/**
 * <p>
 * 科研机构级别 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmResearchUnitLevelServiceImpl extends BaseServiceImpl<SrmResearchUnitLevelMapper, SrmResearchUnitLevel> implements SrmResearchUnitLevelService {

    @Autowired
    private SrmResearchUnitLevelMapper srmResearchUnitLevelMapper;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateResearchUnitLevel(BaseDataPlatformDto baseDataPlatformDto) {
        List<ResearchUnitLevelDto> researchUnitLevelDtos =baseDataPlatformDto.getResearchUnitLevels();

        List<SrmResearchUnitLevel> researchUnitLevelList=new ArrayList<>();
        for (ResearchUnitLevelDto researchUnitLevelDto :researchUnitLevelDtos) {
            SrmResearchUnitLevel srmResearchUnitLevel = new SrmResearchUnitLevel();
            srmResearchUnitLevel.setId(researchUnitLevelDto.getRowId());
            srmResearchUnitLevel.setCode(researchUnitLevelDto.getCode());
            srmResearchUnitLevel.setName(researchUnitLevelDto.getName());
            srmResearchUnitLevel.setIsValid(researchUnitLevelDto.getIsValid());

            researchUnitLevelList.add(srmResearchUnitLevel);
            Long RowId = srmResearchUnitLevel.getId();
        }
        super.saveOrUpdateBatch(researchUnitLevelList);
        return RowId;
    }
    @Override
    public ResearchUnitLevelVo getDetailResearchUnitLevel(Long RowId) {
        return null;
    }

    @Override
    public IPage<ResearchUnitLevelVo> listResearchUnitLevel(ResearchUnitLevelDto researchUnitLevelDto) {
        Page<ResearchUnitLevelVo> page = new Page<>(researchUnitLevelDto.getPage(),researchUnitLevelDto.getRows());
        IPage<ResearchUnitLevelVo> res= srmResearchUnitLevelMapper.listResearchUnitLevel(page,researchUnitLevelDto);
        return res;
    }

    @Override
    public void deleteResearchUnitLevel(BaseDto baseDto) {
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
