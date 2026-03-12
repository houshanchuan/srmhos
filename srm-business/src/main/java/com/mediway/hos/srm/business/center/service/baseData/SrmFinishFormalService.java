package com.mediway.hos.srm.business.center.service.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataProjDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;

import com.mediway.hos.srm.business.center.model.dto.baseData.FinishFormalDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.FinishFormalVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmFinishFormal;

/**
 * <p>
 * 完成形式代码 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmFinishFormalService extends BaseService<SrmFinishFormal> {
    @Transactional
    Long saveOrUpdateFinishFormal(BaseDataProjDto baseDataProjDto);

    FinishFormalVo getDetailFinishFormal(Long RowId);
    IPage<FinishFormalVo> listFinishFormal(FinishFormalDto finishFormalDto);

    void deleteFinishFormal(BaseDto baseDto);

    Long getIdByName(String name);
}
