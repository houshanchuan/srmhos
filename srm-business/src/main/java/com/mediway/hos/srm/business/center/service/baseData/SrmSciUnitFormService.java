package com.mediway.hos.srm.business.center.service.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataPlatformDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;

import com.mediway.hos.srm.business.center.model.dto.baseData.SciUnitFormDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.SciUnitFormVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmSciUnitForm;


/**
 * <p>
 * 组织形式(科技统计用) 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmSciUnitFormService extends BaseService<SrmSciUnitForm> {

    @Transactional
    Long saveOrUpdateSciUnitForm(BaseDataPlatformDto baseDataPlatformDto);

    SciUnitFormVo getDetailSciUnitForm(Long RowId);
    IPage<SciUnitFormVo> listSciUnitForm(SciUnitFormDto sciUnitFormDto);

    void deleteSciUnitForm(BaseDto baseDto);

    Long getIdByName(String name);
}
