package com.mediway.hos.srm.business.center.service.fund;


import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataFundDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;

import com.mediway.hos.srm.business.center.model.dto.fund.FundBudgetBalanceTypeDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundBudgetBalanceTypeVo;
import com.mediway.hos.srm.business.center.model.entity.fund.FundBudgetBalanceType;
/**
 * <p>
 * 预算结余计算方式  服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
public interface FundBudgetBalanceTypeService extends BaseService<FundBudgetBalanceType> {

    @Transactional
    Long saveOrUpdateFundBudgetBalanceType(BaseDataFundDto baseDataFundDto);

    FundBudgetBalanceTypeVo getDetailFundBudgetBalanceType(Long RowId);
    IPage<FundBudgetBalanceTypeVo> listFundBudgetBalanceType(FundBudgetBalanceTypeDto fundBudgetBalanceTypeDto);

    void deleteFundBudgetBalanceType(BaseDto baseDto);

    Long getIdByName(String name);
}
