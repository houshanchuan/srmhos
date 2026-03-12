package com.mediway.hos.srm.business.center.service.fund;


import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataFundDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;

import com.mediway.hos.srm.business.center.model.dto.fund.FundProjectCategoryDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundProjectCategoryVo;
import com.mediway.hos.srm.business.center.model.entity.fund.FundProjectCategory;

/**
 * <p>
 * 项目属性 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
public interface FundProjectCategoryService extends BaseService<FundProjectCategory> {

    @Transactional
    Long saveOrUpdateFundProjectCategory(BaseDataFundDto baseDataFundDto);

    FundProjectCategoryVo getDetailFundProjectCategory(Long RowId);
    IPage<FundProjectCategoryVo> listFundProjectCategory(FundProjectCategoryDto fundProjectCategoryDto);

    void deleteFundProjectCategory(BaseDto baseDto);

    Long getIdByName(String name);
}
