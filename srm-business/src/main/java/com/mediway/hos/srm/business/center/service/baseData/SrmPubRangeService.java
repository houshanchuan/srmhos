package com.mediway.hos.srm.business.center.service.baseData;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataLearningDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;


import com.mediway.hos.srm.business.center.model.dto.baseData.PubRangeDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmPubRange;
import com.mediway.hos.srm.business.center.model.vo.baseData.PubRangeVo;


/**
 * <p>
 * 发表范围 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmPubRangeService extends BaseService<SrmPubRange> {

    @Transactional
    Long saveOrUpdatePubRange(BaseDataLearningDto baseDataLearningDto);

    PubRangeVo getDetailPubRange(Long RowId);
    IPage<PubRangeVo> listPubRange(PubRangeDto pubRangeDto);

    void deletePubRange(BaseDto baseDto);

    Long getIdByName(String name);
}
