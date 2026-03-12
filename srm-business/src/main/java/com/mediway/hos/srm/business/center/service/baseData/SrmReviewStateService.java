package com.mediway.hos.srm.business.center.service.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataCommonDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;

import com.mediway.hos.srm.business.center.model.dto.baseData.ReviewStateDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ReviewStateVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmReviewState;

/**
 * <p>
 * 评审状态 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmReviewStateService extends BaseService<SrmReviewState> {
    @Transactional
    Long saveOrUpdateReviewState(BaseDataCommonDto baseDataProjDto);

    ReviewStateVo getDetailReviewState(Long RowId);
    IPage<ReviewStateVo> listReviewState(ReviewStateDto reviewStateDto);

    void deleteReviewState(BaseDto baseDto);

    Long getIdByName(String name);
}
