package com.mediway.hos.srm.business.center.service.baseData;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataLearningDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;

import com.mediway.hos.srm.business.center.model.dto.baseData.PaperReshipNameDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmReshipName;
import com.mediway.hos.srm.business.center.model.vo.baseData.PaperReshipNameVo;

import java.util.List;

/**
 * <p>
 * 转载名称 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmReshipNameService extends BaseService<SrmReshipName> {
    @Transactional
    Long saveOrUpdatePaperReshipName(BaseDataLearningDto baseDataLearningDto);

    PaperReshipNameVo getDetailPaperReshipName(Long RowId);
    IPage<PaperReshipNameVo> listPaperReshipName(PaperReshipNameDto paperReshipNameDto);

    void deletePaperReshipName(BaseDto baseDto);

    Long getIdByName(String name);
    List<CombVo> getPaperReshipName(PaperReshipNameDto paperReshipNameDto);
}
