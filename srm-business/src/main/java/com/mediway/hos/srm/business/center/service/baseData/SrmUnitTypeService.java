package com.mediway.hos.srm.business.center.service.baseData;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataUserDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;
import java.util.List;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;


import com.mediway.hos.srm.business.center.model.dto.baseData.UnitTypeDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmUnitType;
import com.mediway.hos.srm.business.center.model.vo.baseData.UnitTypeVo;

/**
 * <p>
 * 单位类型代码表 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmUnitTypeService extends BaseService<SrmUnitType> {
    @Transactional
    Long saveOrUpdateUnitType(BaseDataUserDto baseDataUserDto);

    UnitTypeVo getDetailUnitType(Long RowId);
    IPage<UnitTypeVo> listUnitType(UnitTypeDto unitTypeDto);

    void deleteUnitType(BaseDto baseDto);

    Long getIdByName(String name);

    List<CombVo> getUnitType();
}
