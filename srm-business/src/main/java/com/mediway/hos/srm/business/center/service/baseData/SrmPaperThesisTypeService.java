package com.mediway.hos.srm.business.center.service.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataLearningDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;
import com.mediway.hos.srm.business.center.model.dto.baseData.PaperThesisTypeDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmPaperThesisType;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import com.mediway.hos.srm.business.center.model.vo.baseData.PaperThesisTypeVo;

import java.util.List;

/**
 * <p>
 * 论文形式类别表 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmPaperThesisTypeService extends BaseService<SrmPaperThesisType> {
    @Transactional
    Long saveOrUpdatePaperThesisType(BaseDataLearningDto baseDataLearningDto);

    PaperThesisTypeVo getDetailPaperThesisType(Long RowId);
    IPage<PaperThesisTypeVo> listPaperThesisType(PaperThesisTypeDto paperThesisTypeDto);
    void deletePaperThesisType(BaseDto baseDto);
    Long getIdByName(String name);
    List<CombVo> getPaperThesisType();
}
