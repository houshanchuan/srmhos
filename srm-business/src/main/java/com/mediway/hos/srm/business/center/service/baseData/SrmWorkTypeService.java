package com.mediway.hos.srm.business.center.service.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataLearningDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;
import java.util.List;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;

import com.mediway.hos.srm.business.center.model.dto.baseData.WorkTypeDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmWorkType;
import com.mediway.hos.srm.business.center.model.vo.baseData.WorkTypeVo;


/**
 * <p>
 * 著作类别 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-07-19
 */
public interface SrmWorkTypeService extends BaseService<SrmWorkType> {
    @Transactional
    Long saveOrUpdateWorkType(BaseDataLearningDto baseDataLearningDto);

    WorkTypeVo getDetailWorkType(Long RowId);
    IPage<WorkTypeVo> listWorkType(WorkTypeDto workTypeDto);

    void deleteWorkType(BaseDto baseDto);

    Long getIdByName(String name);
    List<CombVo> getWorkType(WorkTypeDto workTypeDto);
}
