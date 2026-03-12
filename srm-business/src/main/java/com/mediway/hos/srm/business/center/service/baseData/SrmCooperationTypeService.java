package com.mediway.hos.srm.business.center.service.baseData;


import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataProjDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;

import com.mediway.hos.srm.business.center.model.dto.baseData.CooperationTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.CooperationTypeVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmCooperationType;


/**
 * <p>
 * 合作类型 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmCooperationTypeService extends BaseService<SrmCooperationType> {

    @Transactional
    Long saveOrUpdateCooperationType(BaseDataProjDto baseDataProjDto);

    CooperationTypeVo getDetailCooperationType(Long RowId);
    IPage<CooperationTypeVo> listCooperationType(CooperationTypeDto cooperationTypeDto);

    void deleteCooperationType(BaseDto baseDto);

    Long getIdByName(String name);
}
