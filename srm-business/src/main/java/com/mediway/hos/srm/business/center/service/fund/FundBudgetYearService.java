package com.mediway.hos.srm.business.center.service.fund;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataFundDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;

import com.mediway.hos.srm.business.center.model.dto.fund.FundBudgetYearDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundBudgetYearVo;
import com.mediway.hos.srm.business.center.model.entity.fund.FundBudgetYear;

/**
 * <p>
 * 预算年度表 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
public interface FundBudgetYearService extends BaseService<FundBudgetYear> {

    @Transactional
    Long saveOrUpdateFundBudgetYear(BaseDataFundDto baseDataFundDto);

    FundBudgetYearVo getDetailFundBudgetYear(Long RowId);
    IPage<FundBudgetYearVo> listFundBudgetYear(FundBudgetYearDto fundBudgetYearDto);

    void deleteFundBudgetYear(BaseDto baseDto);

    Long getIdByName(String name);
}
