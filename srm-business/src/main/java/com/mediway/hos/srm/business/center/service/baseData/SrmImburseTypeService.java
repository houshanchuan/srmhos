package com.mediway.hos.srm.business.center.service.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataProjDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;

import com.mediway.hos.srm.business.center.model.dto.baseData.ImburseTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ImburseTypeVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmImburseType;


/**
 * <p>
 * 资助方式代码表 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmImburseTypeService extends BaseService<SrmImburseType> {

    @Transactional
    Long saveOrUpdateImburseType(BaseDataProjDto baseDataProjDto);

    ImburseTypeVo getDetailImburseType(Long RowId);
    IPage<ImburseTypeVo> listImburseType(ImburseTypeDto imburseTypeDto);

    void deleteImburseType(BaseDto baseDto);

    Long getIdByName(String name);
}
