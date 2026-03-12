package com.mediway.hos.srm.business.center.service.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataLearningDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;
import java.util.List;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;

import com.mediway.hos.srm.business.center.model.dto.baseData.PressInfoDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmPressInfo;
import com.mediway.hos.srm.business.center.model.vo.baseData.PressInfoVo;

/**
 * <p>
 * 出版社信息 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-07-24
 */
public interface SrmPressInfoService extends BaseService<SrmPressInfo> {
    @Transactional
    Long saveOrUpdatePressInfo(BaseDataLearningDto baseDataLearningDto);

    PressInfoVo getDetailPressInfo(Long RowId);
    IPage<PressInfoVo> listPressInfo(PressInfoDto pressInfoDto);

    void deletePressInfo(BaseDto baseDto);

    Long getIdByName(String name);
    List<CombVo> getPressInfo();
}
