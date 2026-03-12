package com.mediway.hos.srm.business.center.service.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataLearningDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;
import com.mediway.hos.srm.business.center.model.dto.baseData.SoftwareCpRtTypeDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmSoftwareCprtType;
import com.mediway.hos.srm.business.center.model.vo.baseData.SoftwareCpRtTypeVo;


/**
 * <p>
 * 软著类型 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmSoftwareCprtTypeService extends BaseService<SrmSoftwareCprtType> {
    @Transactional
    Long saveOrUpdateSoftwareCprtType(BaseDataLearningDto baseDataLearningDto);

    SoftwareCpRtTypeVo getDetailSoftwareCprtType(Long RowId);
    IPage<SoftwareCpRtTypeVo> listSoftwareCprtType(SoftwareCpRtTypeDto softwareCprtTypeDto);

    void deleteSoftwareCprtType(BaseDto baseDto);

    Long getIdByName(String name);
}
