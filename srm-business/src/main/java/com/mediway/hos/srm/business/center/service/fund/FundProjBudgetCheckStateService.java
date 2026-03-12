package com.mediway.hos.srm.business.center.service.fund;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataFundDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;

import com.mediway.hos.srm.business.center.model.dto.fund.FundProjBudgetCheckStateDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundProjBudgetCheckStateVo;
import com.mediway.hos.srm.business.center.model.entity.fund.FundProjBudgetCheckState;


/**
 * <p>
 * 项目预算审核状态 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
public interface FundProjBudgetCheckStateService extends BaseService<FundProjBudgetCheckState> {

    @Transactional
    Long saveOrUpdateFundProjBudgetCheckState(BaseDataFundDto baseDataFundDto);

    FundProjBudgetCheckStateVo getDetailFundProjBudgetCheckState(Long RowId);
    IPage<FundProjBudgetCheckStateVo> listFundProjBudgetCheckState(FundProjBudgetCheckStateDto fundProjBudgetCheckStateDto);

    void deleteFundProjBudgetCheckState(BaseDto baseDto);

    Long getIdByName(String name);
}
