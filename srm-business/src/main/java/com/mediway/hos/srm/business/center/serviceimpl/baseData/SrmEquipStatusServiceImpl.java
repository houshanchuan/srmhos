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

import com.mediway.hos.srm.business.center.model.dto.baseData.EquipStatusDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.EquipStatusVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmEquipStatus;
import com.mediway.hos.srm.business.center.service.baseData.SrmEquipStatusService;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmEquipStatusMapper;

/**
 * <p>
 * 机构设备状态 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmEquipStatusServiceImpl extends BaseServiceImpl<SrmEquipStatusMapper, SrmEquipStatus> implements SrmEquipStatusService {

    @Autowired
    private SrmEquipStatusMapper srmEquipStatusMapper;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateEquipStatus(BaseDataPlatformDto baseDataPlatformDto) {
        List<EquipStatusDto> equipStatusDtos =baseDataPlatformDto.getEquipStatuss();

        List<SrmEquipStatus> equipStatusList=new ArrayList<>();
        for (EquipStatusDto equipStatusDto :equipStatusDtos) {
            SrmEquipStatus srmEquipStatus = new SrmEquipStatus();
            srmEquipStatus.setId(equipStatusDto.getRowId());
            srmEquipStatus.setCode(equipStatusDto.getCode());
            srmEquipStatus.setName(equipStatusDto.getName());
            srmEquipStatus.setIsValid(equipStatusDto.getIsValid());

            equipStatusList.add(srmEquipStatus);
            Long RowId = srmEquipStatus.getId();
        }
        super.saveOrUpdateBatch(equipStatusList);
        return RowId;
    }
    @Override
    public EquipStatusVo getDetailEquipStatus(Long RowId) {
        return null;
    }

    @Override
    public IPage<EquipStatusVo> listEquipStatus(EquipStatusDto equipStatusDto) {
        Page<EquipStatusVo> page = new Page<>(equipStatusDto.getPage(),equipStatusDto.getRows());
        IPage<EquipStatusVo> res= srmEquipStatusMapper.listEquipStatus(page,equipStatusDto);
        return res;
    }

    @Override
    public void deleteEquipStatus(BaseDto baseDto) {
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
