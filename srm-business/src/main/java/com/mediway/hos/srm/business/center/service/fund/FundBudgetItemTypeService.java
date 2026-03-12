package com.mediway.hos.srm.business.center.service.fund;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataFundDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;

import com.mediway.hos.srm.business.center.model.dto.fund.FundBudgetItemTypeDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundBudgetItemTypeVo;
import com.mediway.hos.srm.business.center.model.entity.fund.FundBudgetItemType;


/**
 * <p>
 * 预算项（科目）类别 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
public interface FundBudgetItemTypeService extends BaseService<FundBudgetItemType> {

    @Transactional
    Long saveOrUpdateFundBudgetItemType(BaseDataFundDto baseDataFundDto);

    FundBudgetItemTypeVo getDetailFundBudgetItemType(Long RowId);
    IPage<FundBudgetItemTypeVo> listFundBudgetItemType(FundBudgetItemTypeDto fundBudgetItemTypeDto);

    void deleteFundBudgetItemType(BaseDto baseDto);

    Long getIdByName(String name);
}
