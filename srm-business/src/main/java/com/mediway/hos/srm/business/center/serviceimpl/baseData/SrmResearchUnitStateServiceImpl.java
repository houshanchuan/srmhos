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

import com.mediway.hos.srm.business.center.model.dto.baseData.ResearchUnitStateDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ResearchUnitStateVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmResearchUnitState;
import com.mediway.hos.srm.business.center.service.baseData.SrmResearchUnitStateService;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmResearchUnitStateMapper;

/**
 * <p>
 * 机构状态 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmResearchUnitStateServiceImpl extends BaseServiceImpl<SrmResearchUnitStateMapper, SrmResearchUnitState> implements SrmResearchUnitStateService {

    @Autowired
    private SrmResearchUnitStateMapper srmResearchUnitStateMapper;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateResearchUnitState(BaseDataPlatformDto baseDataPlatformDto) {
        List<ResearchUnitStateDto> researchUnitStateDtos =baseDataPlatformDto.getResearchUnitStates();

        List<SrmResearchUnitState> researchUnitStateList=new ArrayList<>();
        for (ResearchUnitStateDto researchUnitStateDto :researchUnitStateDtos) {
            SrmResearchUnitState srmResearchUnitState = new SrmResearchUnitState();
            srmResearchUnitState.setId(researchUnitStateDto.getRowId());
            srmResearchUnitState.setCode(researchUnitStateDto.getCode());
            srmResearchUnitState.setName(researchUnitStateDto.getName());
            srmResearchUnitState.setIsValid(researchUnitStateDto.getIsValid());

            researchUnitStateList.add(srmResearchUnitState);
            Long RowId = srmResearchUnitState.getId();
        }
        super.saveOrUpdateBatch(researchUnitStateList);
        return RowId;
    }
    @Override
    public ResearchUnitStateVo getDetailResearchUnitState(Long RowId) {
        return null;
    }

    @Override
    public IPage<ResearchUnitStateVo> listResearchUnitState(ResearchUnitStateDto researchUnitStateDto) {
        Page<ResearchUnitStateVo> page = new Page<>(researchUnitStateDto.getPage(),researchUnitStateDto.getRows());
        IPage<ResearchUnitStateVo> res= srmResearchUnitStateMapper.listResearchUnitState(page,researchUnitStateDto);
        return res;
    }

    @Override
    public void deleteResearchUnitState(BaseDto baseDto) {
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
