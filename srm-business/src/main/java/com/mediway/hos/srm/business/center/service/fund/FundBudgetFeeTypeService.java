package com.mediway.hos.srm.business.center.service.fund;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataFundDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;

import com.mediway.hos.srm.business.center.model.dto.fund.FundBudgetFeeTypeDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundBudgetFeeTypeVo;
import com.mediway.hos.srm.business.center.model.entity.fund.FundBudgetFeeType;


/**
 * <p>
 * 预算资金类型 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
public interface FundBudgetFeeTypeService extends BaseService<FundBudgetFeeType> {

    @Transactional
    Long saveOrUpdateFundBudgetFeeType(BaseDataFundDto baseDataFundDto);

    FundBudgetFeeTypeVo getDetailFundBudgetFeeType(Long RowId);
    IPage<FundBudgetFeeTypeVo> listFundBudgetFeeType(FundBudgetFeeTypeDto fundBudgetFeeTypeDto);

    void deleteFundBudgetFeeType(BaseDto baseDto);

    Long getIdByName(String name);
}
