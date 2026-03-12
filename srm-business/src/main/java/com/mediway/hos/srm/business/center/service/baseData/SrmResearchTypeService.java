package com.mediway.hos.srm.business.center.service.baseData;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataLearningDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;
import com.mediway.hos.srm.business.center.model.dto.baseData.ResearchTypeDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmResearchType;
import com.mediway.hos.srm.business.center.model.vo.baseData.ResearchTypeVo;

/**
 * <p>
 * 研究类型表 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmResearchTypeService extends BaseService<SrmResearchType> {
    @Transactional
    Long saveOrUpdateResearchType(BaseDataLearningDto baseDataLearningDto);

    ResearchTypeVo getDetailResearchType(Long RowId);
    IPage<ResearchTypeVo> listResearchType(ResearchTypeDto researchTypeDto);

    void deleteResearchType(BaseDto baseDto);

    Long getIdByName(String name);
}
