package com.mediway.hos.srm.business.center.serviceimpl.baseData;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.alibaba.druid.util.StringUtils;
import com.mediway.hos.srm.business.center.constants.BusinessConstants;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataProjDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.CooperateUnitTypeDto;
import com.mediway.hos.srm.business.center.service.baseData.SrmBusinessnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.exception.ErrorException;


import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

import com.mediway.hos.srm.business.center.model.vo.baseData.CooperateUnitTypeVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmCooperateUnitType;
import com.mediway.hos.srm.business.center.service.baseData.SrmCooperateUnitTypeService;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmCooperateUnitTypeMapper;


/**
 * <p>
 * 合作单位类型 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmCooperateUnitTypeServiceImpl extends BaseServiceImpl<SrmCooperateUnitTypeMapper, SrmCooperateUnitType> implements SrmCooperateUnitTypeService {
    @Autowired
    private SrmCooperateUnitTypeMapper srmCooperateUnitTypeMapper;
    @Autowired
    private SrmBusinessnoService srmBusinessnoService;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateCooperateUnitType(BaseDataProjDto baseDataProjDto) {
        List<CooperateUnitTypeDto> cooperateUnitTypeDtos =baseDataProjDto.getCooperateUnitTypes();

        List<SrmCooperateUnitType> cooperateUnitTypeList=new ArrayList<>();
        for (CooperateUnitTypeDto cooperateUnitTypeDto :cooperateUnitTypeDtos) {
            SrmCooperateUnitType srmCooperateUnitType = new SrmCooperateUnitType();
            srmCooperateUnitType.setId(cooperateUnitTypeDto.getRowId());
            if(ObjectUtil.isEmpty(cooperateUnitTypeDto.getCode())) {
                String code = srmBusinessnoService.getBusinessNo(BusinessConstants.COOP_UNIT_TYPE, 2, "");
                srmCooperateUnitType.setCode(code);
            }else{
                srmCooperateUnitType.setCode(cooperateUnitTypeDto.getCode());
            }
            srmCooperateUnitType.setName(cooperateUnitTypeDto.getName());
            srmCooperateUnitType.setIsValid(cooperateUnitTypeDto.getIsValid());

            cooperateUnitTypeList.add(srmCooperateUnitType);
            Long RowId = srmCooperateUnitType.getId();
        }
        super.saveOrUpdateBatch(cooperateUnitTypeList);
        return RowId;
    }
    @Override
    public CooperateUnitTypeVo getDetailCooperateUnitType(Long RowId) {
        return null;
    }

    @Override
    public IPage<CooperateUnitTypeVo> listCooperateUnitType(CooperateUnitTypeDto cooperateUnitTypeDto) {
        Page<CooperateUnitTypeVo> page = new Page<>(cooperateUnitTypeDto.getPage(),cooperateUnitTypeDto.getRows());
        IPage<CooperateUnitTypeVo> res= srmCooperateUnitTypeMapper.listCooperateUnitType(page,cooperateUnitTypeDto);
        return res;
    }

    @Override
    public void deleteCooperateUnitType(BaseDto baseDto) {
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
