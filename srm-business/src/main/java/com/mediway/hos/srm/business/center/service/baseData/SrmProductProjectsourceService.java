package com.mediway.hos.srm.business.center.service.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataProjDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;
import java.util.List;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;

import com.mediway.hos.srm.business.center.model.dto.baseData.ProductProjectSourceDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ProductProjectSourceVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmProductProjectsource;

/**
 * <p>
 * 成果的项目来源表 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-07-24
 */
public interface SrmProductProjectsourceService extends BaseService<SrmProductProjectsource> {
    List<CombVo> getProjectsource();

    @Transactional
    Long saveOrUpdateProductProjectSource(BaseDataProjDto baseDataProjDto);

    ProductProjectSourceVo getDetailProductProjectSource(Long RowId);
    IPage<ProductProjectSourceVo> listProductProjectSource(ProductProjectSourceDto productProjectSourceDto);

    void deleteProductProjectSource(BaseDto baseDto);

    Long getIdByName(String name);
}
