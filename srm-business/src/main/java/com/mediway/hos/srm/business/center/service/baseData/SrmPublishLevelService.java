package com.mediway.hos.srm.business.center.service.baseData;


import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataLearningDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;
import java.util.List;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;

import com.mediway.hos.srm.business.center.model.dto.baseData.PublishLevelDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmPublishLevel;
import com.mediway.hos.srm.business.center.model.vo.baseData.PublishLevelVo;
/**
 * <p>
 * 出版级别 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmPublishLevelService extends BaseService<SrmPublishLevel> {
    @Transactional
    Long saveOrUpdatePublishLevel(BaseDataLearningDto baseDataLearningDto);

    PublishLevelVo getDetailPublishLevel(Long RowId);
    IPage<PublishLevelVo> listPublishLevel(PublishLevelDto publishLevelDto);

    void deletePublishLevel(BaseDto baseDto);

    Long getIdByName(String name);
    List<CombVo> getPublishLevel();
}
