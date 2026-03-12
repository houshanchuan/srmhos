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

import com.mediway.hos.srm.business.center.model.dto.baseData.EquipArrangeStateDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.EquipArrangeStateVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmEquipArrangeState;
import com.mediway.hos.srm.business.center.service.baseData.SrmEquipArrangeStateService;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmEquipArrangeStateMapper;


/**
 * <p>
 * 设备排班状态 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-12-09
 */
@Service
public class SrmEquipArrangeStateServiceImpl extends BaseServiceImpl<SrmEquipArrangeStateMapper, SrmEquipArrangeState> implements SrmEquipArrangeStateService {

    @Autowired
    private SrmEquipArrangeStateMapper srmEquipArrangeStateMapper;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateEquipArrangeState(BaseDataPlatformDto baseDataPlatformDto) {
        List<EquipArrangeStateDto> equipArrangeStateDtos =baseDataPlatformDto.getEquipArrangeStates();

        List<SrmEquipArrangeState> equipArrangeStateList=new ArrayList<>();
        for (EquipArrangeStateDto equipArrangeStateDto :equipArrangeStateDtos) {
            SrmEquipArrangeState srmEquipArrangeState = new SrmEquipArrangeState();
            srmEquipArrangeState.setId(equipArrangeStateDto.getRowId());
            srmEquipArrangeState.setCode(equipArrangeStateDto.getCode());
            srmEquipArrangeState.setName(equipArrangeStateDto.getName());
            srmEquipArrangeState.setIsValid(equipArrangeStateDto.getIsValid());

            equipArrangeStateList.add(srmEquipArrangeState);
            Long RowId = srmEquipArrangeState.getId();
        }
        super.saveOrUpdateBatch(equipArrangeStateList);
        return RowId;
    }
    @Override
    public EquipArrangeStateVo getDetailEquipArrangeState(Long RowId) {
        return null;
    }

    @Override
    public IPage<EquipArrangeStateVo> listEquipArrangeState(EquipArrangeStateDto equipArrangeStateDto) {
        Page<EquipArrangeStateVo> page = new Page<>(equipArrangeStateDto.getPage(),equipArrangeStateDto.getRows());
        IPage<EquipArrangeStateVo> res= srmEquipArrangeStateMapper.listEquipArrangeState(page,equipArrangeStateDto);
        return res;
    }

    @Override
    public void deleteEquipArrangeState(BaseDto baseDto) {
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
