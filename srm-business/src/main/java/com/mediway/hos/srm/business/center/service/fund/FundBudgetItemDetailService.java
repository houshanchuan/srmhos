package com.mediway.hos.srm.business.center.service.fund;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataFundDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;

import com.mediway.hos.srm.business.center.model.dto.fund.FundBudgetItemDetailDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundBudgetItemDetailVo;
import com.mediway.hos.srm.business.center.model.entity.fund.FundBudgetItemDetail;


/**
 * <p>
 * 预算科目明细项 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
public interface FundBudgetItemDetailService extends BaseService<FundBudgetItemDetail> {

    @Transactional
    Long saveOrUpdateFundBudgetItemDetail(BaseDataFundDto baseDataFundDto);

    FundBudgetItemDetailVo getDetailFundBudgetItemDetail(Long RowId);
    IPage<FundBudgetItemDetailVo> listFundBudgetItemDetail(FundBudgetItemDetailDto fundBudgetItemDetailDto);

    void deleteFundBudgetItemDetail(BaseDto baseDto);

    Long getIdByName(String name);
}
