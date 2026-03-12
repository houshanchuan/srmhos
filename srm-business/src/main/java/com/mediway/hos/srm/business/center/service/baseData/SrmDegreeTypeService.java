package com.mediway.hos.srm.business.center.service.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataUserDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;

import com.mediway.hos.srm.business.center.model.dto.baseData.DegreeTypeDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmDegreeType;
import com.mediway.hos.srm.business.center.model.vo.baseData.DegreeTypeVo;

/**
 * <p>
 * 学位点类型 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmDegreeTypeService extends BaseService<SrmDegreeType> {
    @Transactional
    Long saveOrUpdateDegreeType(BaseDataUserDto baseDataUserDto);

    DegreeTypeVo getDetailDegreeType(Long RowId);
    IPage<DegreeTypeVo> listDegreeType(DegreeTypeDto degreeTypeDto);

    void deleteDegreeType(BaseDto baseDto);

    Long getIdByName(String name);
}
