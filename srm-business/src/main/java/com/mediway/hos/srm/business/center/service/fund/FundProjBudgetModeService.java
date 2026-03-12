package com.mediway.hos.srm.business.center.service.fund;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataFundDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;

import com.mediway.hos.srm.business.center.model.dto.fund.FundProjBudgetModeDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundProjBudgetModeVo;
import com.mediway.hos.srm.business.center.model.entity.fund.FundProjBudgetMode;




/**
 * <p>
 * 项目预算编制模式 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
public interface FundProjBudgetModeService extends BaseService<FundProjBudgetMode> {

    @Transactional
    Long saveOrUpdateFundProjBudgetMode(BaseDataFundDto baseDataFundDto);

    FundProjBudgetModeVo getDetailFundProjBudgetMode(Long RowId);
    IPage<FundProjBudgetModeVo> listFundProjBudgetMode(FundProjBudgetModeDto fundProjBudgetModeDto);

    void deleteFundProjBudgetMode(BaseDto baseDto);

    Long getIdByName(String name);
}
