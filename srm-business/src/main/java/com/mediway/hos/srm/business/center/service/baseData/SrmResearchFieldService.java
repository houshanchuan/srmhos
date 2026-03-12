package com.mediway.hos.srm.business.center.service.baseData;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataLearningDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;
import java.util.List;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;

import com.mediway.hos.srm.business.center.model.dto.baseData.ResearchFieldDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmResearchField;
import com.mediway.hos.srm.business.center.model.vo.baseData.ResearchFieldVo;


/**
 * <p>
 * 研究领域 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmResearchFieldService extends BaseService<SrmResearchField> {
    @Transactional
    Long saveOrUpdateResearchField(BaseDataLearningDto baseDataLearningDto);

    ResearchFieldVo getDetailResearchField(Long RowId);
    IPage<ResearchFieldVo> listResearchField(ResearchFieldDto researchFieldDto);

    void deleteResearchField(BaseDto baseDto);

    Long getIdByName(String name);
    List<CombVo> getResearchField(ResearchFieldDto researchFieldDto);
}
