package com.mediway.hos.srm.business.center.service.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataLearningDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;
import com.mediway.hos.srm.business.center.model.dto.baseData.ContentRealDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmContentReal;
import com.mediway.hos.srm.business.center.model.vo.baseData.ContentRealVo;


/**
 * <p>
 * 内容真实性代码 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmContentRealService extends BaseService<SrmContentReal> {

    @Transactional
    Long saveOrUpdateContentReal(BaseDataLearningDto baseDataLearningDto);

    ContentRealVo getDetailContentReal(Long RowId);
    IPage<ContentRealVo> listContentReal(ContentRealDto contentRealDto);

    void deleteContentReal(BaseDto baseDto);

    Long getIdByName(String name);
}
