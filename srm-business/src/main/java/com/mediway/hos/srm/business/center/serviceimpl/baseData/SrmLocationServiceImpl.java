package com.mediway.hos.srm.business.center.serviceimpl.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.alibaba.druid.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.exception.ErrorException;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataProjDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

import com.mediway.hos.srm.business.center.model.dto.baseData.LocationDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.LocationVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmLocation;
import com.mediway.hos.srm.business.center.service.baseData.SrmLocationService;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmLocationMapper;

/**
 * <p>
 * 省市县 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmLocationServiceImpl extends BaseServiceImpl<SrmLocationMapper, SrmLocation> implements SrmLocationService {

    @Autowired
    private SrmLocationService  srmLocationService;
    @Autowired
    private SrmLocationMapper srmLocationMapper;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateLocation(BaseDataProjDto baseDataProjDto) {
        List<LocationDto> locationDtos =baseDataProjDto.getLocations();

        List<SrmLocation> locationList=new ArrayList<>();
        for (LocationDto locationDto :locationDtos) {
            SrmLocation srmLocation = new SrmLocation();
            srmLocation.setId(locationDto.getRowId());
            srmLocation.setCode(locationDto.getCode());
            srmLocation.setName(locationDto.getName());
            srmLocation.setIsValid(Integer.valueOf(locationDto.getIsValid()));

            locationList.add(srmLocation);
            Long RowId = srmLocation.getId();
        }
        super.saveOrUpdateBatch(locationList);
        return RowId;
    }
    @Override
    public LocationVo getDetailLocation(Long RowId) {
        return null;
    }

    @Override
    public IPage<LocationVo> listLocation(LocationDto locationDto) {
        Page<LocationVo> page = new Page<>(locationDto.getPage(), locationDto.getRows());
        IPage<LocationVo> res= srmLocationMapper.listLocation(page, locationDto);
        //List<LocationVo> records=res.getRecords();
        //List<LocationVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteLocation(BaseDto baseDto) {
        List<Long> idList=baseDto.getIdList();
        String idStr="";
        try{
            for (Long RowId : idList) {
                //System.out.println(RowId);
                if(StringUtils.isEmpty(idStr)){
                    idStr=String.valueOf(RowId);
                }else{
                    idStr=idStr+","+String.valueOf(RowId);
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
