package com.mediway.hos.srm.business.center.service.baseData;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataCommonDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;

import com.mediway.hos.srm.business.center.model.dto.baseData.ProjMidCheckListInfoStateDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ProjMidCheckListInfoStateVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmProjMidcheckListInfoState;

/**
 * <p>
 * 项目中检批次状态表 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmProjMidcheckListInfoStateService extends BaseService<SrmProjMidcheckListInfoState> {

    @Transactional
    Long saveOrUpdateProjMidCheckListInfoState(BaseDataCommonDto baseDataProjDto);

    ProjMidCheckListInfoStateVo getDetailProjMidCheckListInfoState(Long RowId);
    IPage<ProjMidCheckListInfoStateVo> listProjMidCheckListInfoState(ProjMidCheckListInfoStateDto projMidCheckListInfoStateDto);

    void deleteProjMidCheckListInfoState(BaseDto baseDto);

    Long getIdByName(String name);
}
