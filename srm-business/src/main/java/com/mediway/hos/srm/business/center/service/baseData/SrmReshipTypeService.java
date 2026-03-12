package com.mediway.hos.srm.business.center.service.baseData;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataLearningDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;
import com.mediway.hos.srm.business.center.model.dto.baseData.PaperReshipTypeDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmReshipType;
import com.mediway.hos.srm.business.center.model.vo.baseData.PaperReshipTypeVo;

import java.util.List;


/**
 * <p>
 * 转载类型 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmReshipTypeService extends BaseService<SrmReshipType> {
    @Transactional
    Long saveOrUpdatePaperReshipType(BaseDataLearningDto baseDataLearningDto);

    PaperReshipTypeVo getDetailPaperReshipType(Long RowId);
    IPage<PaperReshipTypeVo> listPaperReshipType(PaperReshipTypeDto paperReshipTypeDto);

    void deletePaperReshipType(BaseDto baseDto);

    Long getIdByName(String name);

    List<CombVo> getPaperReshipType(PaperReshipTypeDto paperReshipTypeDto);
}
