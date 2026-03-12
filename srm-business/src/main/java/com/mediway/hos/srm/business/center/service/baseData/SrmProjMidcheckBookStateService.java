package com.mediway.hos.srm.business.center.service.baseData;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataCommonDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;


import com.mediway.hos.srm.business.center.model.dto.baseData.ProjMidCheckBookStateDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ProjMidCheckBookStateVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmProjMidcheckBookState;
/**
 * <p>
 * 项目中检状态表 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmProjMidcheckBookStateService extends BaseService<SrmProjMidcheckBookState> {

    @Transactional
    Long saveOrUpdateProjMidCheckBookState(BaseDataCommonDto baseDataProjDto);

    ProjMidCheckBookStateVo getDetailProjMidCheckBookState(Long RowId);
    IPage<ProjMidCheckBookStateVo> listProjMidCheckBookState(ProjMidCheckBookStateDto projMidCheckBookStateDto);

    void deleteProjMidCheckBookState(BaseDto baseDto);

    Long getIdByName(String name);
}
