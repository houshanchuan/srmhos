package com.mediway.hos.srm.business.center.service.fund;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataFundDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;

import com.mediway.hos.srm.business.center.model.dto.fund.FundBudgetYearMonthDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundBudgetYearMonthVo;
import com.mediway.hos.srm.business.center.model.entity.fund.FundBudgetYearMonth;

/**
 * <p>
 * 预算年月定义表 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
public interface FundBudgetYearMonthService extends BaseService<FundBudgetYearMonth> {

    @Transactional
    Long saveOrUpdateFundBudgetYearMonth(BaseDataFundDto baseDataFundDto);

    FundBudgetYearMonthVo getDetailFundBudgetYearMonth(Long RowId);
    IPage<FundBudgetYearMonthVo> listFundBudgetYearMonth(FundBudgetYearMonthDto fundBudgetYearMonthDto);

    void deleteFundBudgetYearMonth(BaseDto baseDto);

    Long getIdByName(String name);
}
