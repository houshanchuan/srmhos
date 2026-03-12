package com.mediway.hos.srm.business.center.service.fund;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataFundDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;

import com.mediway.hos.srm.business.center.model.dto.fund.FundBudgetItemDeptGrantDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundBudgetItemDeptGrantVo;
import com.mediway.hos.srm.business.center.model.entity.fund.FundBudgetItemDeptGrant;

/**
 * <p>
 * 科目归口科室设置 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
public interface FundBudgetItemDeptGrantService extends BaseService<FundBudgetItemDeptGrant> {

    @Transactional
    Long saveOrUpdateFundBudgetItemDeptGrant(BaseDataFundDto baseDataFundDto);

    FundBudgetItemDeptGrantVo getDetailFundBudgetItemDeptGrant(Long RowId);
    IPage<FundBudgetItemDeptGrantVo> listFundBudgetItemDeptGrant(FundBudgetItemDeptGrantDto fundBudgetItemDeptGrantDto);

    void deleteFundBudgetItemDeptGrant(BaseDto baseDto);

    Long getIdByName(String name);

}
