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

import com.mediway.hos.srm.business.center.model.dto.baseData.ResearchUnitKindDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ResearchUnitKindVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmResearchUnitKind;
import com.mediway.hos.srm.business.center.service.baseData.SrmResearchUnitKindService;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmResearchUnitKindMapper;

/**
 * <p>
 * 科研机构性质 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmResearchUnitKindServiceImpl extends BaseServiceImpl<SrmResearchUnitKindMapper, SrmResearchUnitKind> implements SrmResearchUnitKindService {

    @Autowired
    private SrmResearchUnitKindMapper srmResearchUnitKindMapper;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateResearchUnitKind(BaseDataPlatformDto baseDataPlatformDto) {
        List<ResearchUnitKindDto> researchUnitKindDtos =baseDataPlatformDto.getResearchUnitKinds();

        List<SrmResearchUnitKind> researchUnitKindList=new ArrayList<>();
        for (ResearchUnitKindDto researchUnitKindDto :researchUnitKindDtos) {
            SrmResearchUnitKind srmResearchUnitKind = new SrmResearchUnitKind();
            srmResearchUnitKind.setId(researchUnitKindDto.getRowId());
            srmResearchUnitKind.setCode(researchUnitKindDto.getCode());
            srmResearchUnitKind.setName(researchUnitKindDto.getName());
            srmResearchUnitKind.setIsValid(researchUnitKindDto.getIsValid());

            researchUnitKindList.add(srmResearchUnitKind);
            Long RowId = srmResearchUnitKind.getId();
        }
        super.saveOrUpdateBatch(researchUnitKindList);
        return RowId;
    }
    @Override
    public ResearchUnitKindVo getDetailResearchUnitKind(Long RowId) {
        return null;
    }

    @Override
    public IPage<ResearchUnitKindVo> listResearchUnitKind(ResearchUnitKindDto researchUnitKindDto) {
        Page<ResearchUnitKindVo> page = new Page<>(researchUnitKindDto.getPage(),researchUnitKindDto.getRows());
        IPage<ResearchUnitKindVo> res= srmResearchUnitKindMapper.listResearchUnitKind(page,researchUnitKindDto);
        return res;
    }

    @Override
    public void deleteResearchUnitKind(BaseDto baseDto) {
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
