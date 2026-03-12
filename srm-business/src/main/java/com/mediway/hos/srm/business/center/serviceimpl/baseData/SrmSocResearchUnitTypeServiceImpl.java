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

import com.mediway.hos.srm.business.center.model.dto.baseData.SocResearchUnitTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.SocResearchUnitTypeVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmSocResearchUnitType;
import com.mediway.hos.srm.business.center.service.baseData.SrmSocResearchUnitTypeService;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmSocResearchUnitTypeMapper;

/**
 * <p>
 * 机构类型（社科统计） 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmSocResearchUnitTypeServiceImpl extends BaseServiceImpl<SrmSocResearchUnitTypeMapper, SrmSocResearchUnitType> implements SrmSocResearchUnitTypeService {

    @Autowired
    private SrmSocResearchUnitTypeMapper srmSocResearchUnitTypeMapper;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateSocResearchUnitType(BaseDataPlatformDto baseDataPlatformDto) {
        List<SocResearchUnitTypeDto> socResearchUnitTypeDtos =baseDataPlatformDto.getSocResearchUnitTypes();

        List<SrmSocResearchUnitType> socResearchUnitTypeList=new ArrayList<>();
        for (SocResearchUnitTypeDto socResearchUnitTypeDto :socResearchUnitTypeDtos) {
            SrmSocResearchUnitType srmSocResearchUnitType = new SrmSocResearchUnitType();
            srmSocResearchUnitType.setId(socResearchUnitTypeDto.getRowId());
            srmSocResearchUnitType.setCode(socResearchUnitTypeDto.getCode());
            srmSocResearchUnitType.setName(socResearchUnitTypeDto.getName());
            srmSocResearchUnitType.setIsValid(socResearchUnitTypeDto.getIsValid());

            socResearchUnitTypeList.add(srmSocResearchUnitType);
            Long RowId = srmSocResearchUnitType.getId();
        }
        super.saveOrUpdateBatch(socResearchUnitTypeList);
        return RowId;
    }
    @Override
    public SocResearchUnitTypeVo getDetailSocResearchUnitType(Long RowId) {
        return null;
    }

    @Override
    public IPage<SocResearchUnitTypeVo> listSocResearchUnitType(SocResearchUnitTypeDto socResearchUnitTypeDto) {
        Page<SocResearchUnitTypeVo> page = new Page<>(socResearchUnitTypeDto.getPage(),socResearchUnitTypeDto.getRows());
        IPage<SocResearchUnitTypeVo> res= srmSocResearchUnitTypeMapper.listSocResearchUnitType(page,socResearchUnitTypeDto);
        return res;
    }

    @Override
    public void deleteSocResearchUnitType(BaseDto baseDto) {
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
