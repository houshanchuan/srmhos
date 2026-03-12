package com.mediway.hos.srm.business.center.service.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataLearningDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;

import com.mediway.hos.srm.business.center.model.dto.baseData.PaperEmbodyTypeDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmEmbodyType;
import com.mediway.hos.srm.business.center.model.vo.baseData.PaperEmbodyTypeVo;

import java.util.List;

/**
 * <p>
 * 收录类型 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-01
 */
public interface SrmEmbodyTypeService extends BaseService<SrmEmbodyType> {
    @Transactional
    Long saveOrUpdatePaperEmbodyType(BaseDataLearningDto baseDataLearningDto);

    PaperEmbodyTypeVo getDetailPaperEmbodyType(Long RowId);
    IPage<PaperEmbodyTypeVo> listPaperEmbodyType(PaperEmbodyTypeDto paperEmbodyTypeDto);

    void deletePaperEmbodyType(BaseDto baseDto);

    Long getIdByName(String name);
    List<CombVo> getEmbodyType(PaperEmbodyTypeDto paperEmbodyTypeDto);
}
