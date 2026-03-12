package com.mediway.hos.srm.business.center.serviceimpl.baseData;

import com.mediway.hos.srm.business.center.model.entity.baseData.SrmEquipBookexeState;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmEquipBookexeStateMapper;
import com.mediway.hos.srm.business.center.service.baseData.SrmEquipBookexeStateService;
import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.alibaba.druid.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.exception.ErrorException;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataPlatformDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;

import java.util.ArrayList;
import java.util.List;

import com.mediway.hos.srm.business.center.model.dto.baseData.EquipBookexeStateDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.EquipBookexeStateVo;

/**
 * <p>
 * 设备预约执行状态 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-12-09
 */
@Service
public class SrmEquipBookexeStateServiceImpl extends BaseServiceImpl<SrmEquipBookexeStateMapper, SrmEquipBookexeState> implements SrmEquipBookexeStateService {

    @Autowired
    private SrmEquipBookexeStateMapper srmEquipBookexeStateMapper;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateEquipBookexeState(BaseDataPlatformDto baseDataPlatformDto) {
        List<EquipBookexeStateDto> equipBookexeStateDtos =baseDataPlatformDto.getEquipBookexeStates();

        List<SrmEquipBookexeState> equipBookexeStateList=new ArrayList<>();
        for (EquipBookexeStateDto equipBookexeStateDto :equipBookexeStateDtos) {
            SrmEquipBookexeState srmEquipBookexeState = new SrmEquipBookexeState();
            srmEquipBookexeState.setId(equipBookexeStateDto.getRowId());
            srmEquipBookexeState.setCode(equipBookexeStateDto.getCode());
            srmEquipBookexeState.setName(equipBookexeStateDto.getName());
            srmEquipBookexeState.setIsValid(equipBookexeStateDto.getIsValid());

            equipBookexeStateList.add(srmEquipBookexeState);
            Long RowId = srmEquipBookexeState.getId();
        }
        super.saveOrUpdateBatch(equipBookexeStateList);
        return RowId;
    }
    @Override
    public EquipBookexeStateVo getDetailEquipBookexeState(Long RowId) {
        return null;
    }

    @Override
    public IPage<EquipBookexeStateVo> listEquipBookexeState(EquipBookexeStateDto equipBookexeStateDto) {
        Page<EquipBookexeStateVo> page = new Page<>(equipBookexeStateDto.getPage(),equipBookexeStateDto.getRows());
        IPage<EquipBookexeStateVo> res= srmEquipBookexeStateMapper.listEquipBookexeState(page,equipBookexeStateDto);
        return res;
    }

    @Override
    public void deleteEquipBookexeState(BaseDto baseDto) {
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
