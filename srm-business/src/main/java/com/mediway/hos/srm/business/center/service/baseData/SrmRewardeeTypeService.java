package com.mediway.hos.srm.business.center.service.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataLearningDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;
import com.mediway.hos.srm.business.center.model.dto.baseData.PaperRewardeeTypeDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmRewardeeType;
import com.mediway.hos.srm.business.center.model.vo.baseData.PaperRewardeeTypeVo;

/**
 * <p>
 * 论文奖励作者类型 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmRewardeeTypeService extends BaseService<SrmRewardeeType> {
    @Transactional
    Long saveOrUpdatePaperRewardeeType(BaseDataLearningDto baseDataLearningDto);

    PaperRewardeeTypeVo getDetailPaperRewardeeType(Long RowId);
    IPage<PaperRewardeeTypeVo> listPaperRewardeeType(PaperRewardeeTypeDto paperRewardeeTypeDto);

    void deletePaperRewardeeType(BaseDto baseDto);

    Long getIdByName(String name);
}
