package com.mediway.hos.srm.business.center.service.baseData;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataLearningDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;

import com.mediway.hos.srm.business.center.model.dto.baseData.ProductTypeDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmProductType;
import com.mediway.hos.srm.business.center.model.vo.baseData.ProductTypeVo;


/**
 * <p>
 * 成果类型 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmProductTypeService extends BaseService<SrmProductType> {
    @Transactional
    Long saveOrUpdateProductType(BaseDataLearningDto baseDataLearningDto);

    ProductTypeVo getDetailProductType(Long RowId);
    IPage<ProductTypeVo> listProductType(ProductTypeDto productTypeDto);

    void deleteProductType(BaseDto baseDto);

    Long getIdByName(String name);
}
