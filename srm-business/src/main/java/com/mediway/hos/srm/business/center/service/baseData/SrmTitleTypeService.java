package com.mediway.hos.srm.business.center.service.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataUserDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;

import com.mediway.hos.srm.business.center.model.dto.baseData.TitleTypeDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmTitleType;
import com.mediway.hos.srm.business.center.model.vo.baseData.TitleTypeVo;

/**
 * <p>
 * 职称类型 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmTitleTypeService extends BaseService<SrmTitleType> {
    @Transactional
    Long saveOrUpdateTitleType(BaseDataUserDto baseDataUserDto);

    TitleTypeVo getDetailTitleType(Long RowId);
    IPage<TitleTypeVo> listTitleType(TitleTypeDto titleTypeDto);

    void deleteTitleType(BaseDto baseDto);

    Long getIdByName(String name);
}
