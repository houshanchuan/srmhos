package com.mediway.hos.srm.business.center.service.fund;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataFundDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;

import com.mediway.hos.srm.business.center.model.dto.fund.FundBudgetDeptGrantDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundBudgetDeptGrantVo;
import com.mediway.hos.srm.business.center.model.entity.fund.FundBudgetDeptGrant;


/**
 * <p>
 * 预算科室访问权限 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
public interface FundBudgetDeptGrantService extends BaseService<FundBudgetDeptGrant> {

    @Transactional
    Long saveOrUpdateFundBudgetDeptGrant(BaseDataFundDto baseDataFundDto);

    FundBudgetDeptGrantVo getDetailFundBudgetDeptGrant(Long RowId);
    IPage<FundBudgetDeptGrantVo> listFundBudgetDeptGrant(FundBudgetDeptGrantDto fundBudgetDeptGrantDto);

    void deleteFundBudgetDeptGrant(BaseDto baseDto);

    Long getIdByName(String name);
}
