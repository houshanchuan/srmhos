package com.mediway.hos.srm.business.center.service.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataUserDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;

import com.mediway.hos.srm.business.center.model.dto.baseData.HonoraryTitleTypeDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmHonoraryTitleType;
import com.mediway.hos.srm.business.center.model.vo.baseData.HonoraryTitleTypeVo;
/**
 * <p>
 * 荣誉称号 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmHonoraryTitleTypeService extends BaseService<SrmHonoraryTitleType> {


    @Transactional
    Long saveOrUpdateHonoraryTitleType(BaseDataUserDto baseDataUserDto);

    HonoraryTitleTypeVo getDetailHonoraryTitleType(Long RowId);
    IPage<HonoraryTitleTypeVo> listHonoraryTitleType(HonoraryTitleTypeDto honoraryTitleTypeDto);

    void deleteHonoraryTitleType(BaseDto baseDto);

    Long getIdByName(String name);
}
