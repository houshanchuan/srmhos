package com.mediway.hos.srm.business.center.service.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataLearningDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;
import java.util.List;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;


import com.mediway.hos.srm.business.center.model.dto.baseData.AwardLevelDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmAwardLevel;
import com.mediway.hos.srm.business.center.model.vo.baseData.AwardLevelVo;
/**
 * <p>
 * 获奖级别 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmAwardLevelService extends BaseService<SrmAwardLevel> {
	public List<CombVo> getAwardLevel();
    @Transactional
    Long saveOrUpdateAwardLevel(BaseDataLearningDto baseDataLearningDto);

    AwardLevelVo getDetailAwardLevel(Long RowId);
    IPage<AwardLevelVo> listAwardLevel(AwardLevelDto yyyyDto);

    void deleteAwardLevel(BaseDto baseDto);

    Long getIdByName(String name);
}
