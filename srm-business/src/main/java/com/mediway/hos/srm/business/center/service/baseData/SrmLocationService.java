package com.mediway.hos.srm.business.center.service.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataProjDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;


import com.mediway.hos.srm.business.center.model.dto.baseData.LocationDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.LocationVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmLocation;
/**
 * <p>
 * 省市县 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmLocationService extends BaseService<SrmLocation> {

    @Transactional
    Long saveOrUpdateLocation(BaseDataProjDto baseDataProjDto);

    LocationVo getDetailLocation(Long RowId);
    IPage<LocationVo> listLocation(LocationDto locationDto);

    void deleteLocation(BaseDto baseDto);

    Long getIdByName(String name);
}
