package com.mediway.hos.srm.business.center.service.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataLearningDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;
import java.util.List;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;

import com.mediway.hos.srm.business.center.model.dto.baseData.ParttimeTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ParttimeTypeVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmParttimeType;

/**
 * <p>
 * 兼职类型 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmParttimeTypeService extends BaseService<SrmParttimeType> {

    @Transactional
    Long saveOrUpdateParttimeType(BaseDataLearningDto baseDataLearningDto);

    ParttimeTypeVo getDetailParttimeType(Long RowId);
    IPage<ParttimeTypeVo> listParttimeType(ParttimeTypeDto parttimeTypeDto);

    void deleteParttimeType(BaseDto baseDto);

    Long getIdByName(String name);

    List<CombVo> getParttimeType();
}
