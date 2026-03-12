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

import com.mediway.hos.srm.business.center.model.dto.baseData.ComponentTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ComponentTypeVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmComponentType;
import com.mediway.hos.srm.business.center.service.baseData.SrmComponentTypeService;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmComponentTypeMapper;


/**
 * <p>
 * 机构组成类型 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmComponentTypeServiceImpl extends BaseServiceImpl<SrmComponentTypeMapper, SrmComponentType> implements SrmComponentTypeService {

    @Autowired
    private SrmComponentTypeMapper srmComponentTypeMapper;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateComponentType(BaseDataPlatformDto baseDataPlatformDto) {
        List<ComponentTypeDto> componentTypeDtos =baseDataPlatformDto.getComponentTypes();

        List<SrmComponentType> componentTypeList=new ArrayList<>();
        for (ComponentTypeDto componentTypeDto :componentTypeDtos) {
            SrmComponentType srmComponentType = new SrmComponentType();
            srmComponentType.setId(componentTypeDto.getRowId());
            srmComponentType.setCode(componentTypeDto.getCode());
            srmComponentType.setName(componentTypeDto.getName());
            srmComponentType.setIsValid(componentTypeDto.getIsValid());

            componentTypeList.add(srmComponentType);
            Long RowId = srmComponentType.getId();
        }
        super.saveOrUpdateBatch(componentTypeList);
        return RowId;
    }
    @Override
    public ComponentTypeVo getDetailComponentType(Long RowId) {
        return null;
    }

    @Override
    public IPage<ComponentTypeVo> listComponentType(ComponentTypeDto componentTypeDto) {
        Page<ComponentTypeVo> page = new Page<>(componentTypeDto.getPage(),componentTypeDto.getRows());
        IPage<ComponentTypeVo> res= srmComponentTypeMapper.listComponentType(page,componentTypeDto);
        return res;
    }

    @Override
    public void deleteComponentType(BaseDto baseDto) {
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
