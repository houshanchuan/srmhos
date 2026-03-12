package com.mediway.hos.srm.business.center.service.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataUserDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;
import java.util.List;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;

import com.mediway.hos.srm.business.center.model.dto.baseData.OccupationCategoryDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmOccupationCategory;
import com.mediway.hos.srm.business.center.model.vo.baseData.OccupationCategoryVo;

/**
 * <p>
 * 职业类别 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmOccupationCategoryService extends BaseService<SrmOccupationCategory> {
    @Transactional
    Long saveOrUpdateOccupationCategory(BaseDataUserDto baseDataUserDto);

    OccupationCategoryVo getDetailOccupationCategory(Long RowId);
    IPage<OccupationCategoryVo> listOccupationCategory(OccupationCategoryDto occupationCategoryDto);

    void deleteOccupationCategory(BaseDto baseDto);

    Long getIdByName(String name);

    List<CombVo> getOccupationCategory(OccupationCategoryDto occupationCategoryDto);
}
