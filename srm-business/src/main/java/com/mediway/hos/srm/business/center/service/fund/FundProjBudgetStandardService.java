package com.mediway.hos.srm.business.center.service.fund;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataFundDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;

import com.mediway.hos.srm.business.center.model.dto.fund.FundProjBudgetStandardDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundProjBudgetStandardVo;
import com.mediway.hos.srm.business.center.model.entity.fund.FundProjBudgetStandard;

/**
 * <p>
 * 项目分类预算标准 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
public interface FundProjBudgetStandardService extends BaseService<FundProjBudgetStandard> {

    @Transactional
    Long saveOrUpdateFundProjBudgetStandard(BaseDataFundDto baseDataFundDto);

    FundProjBudgetStandardVo getDetailFundProjBudgetStandard(Long RowId);
    IPage<FundProjBudgetStandardVo> listFundProjBudgetStandard(FundProjBudgetStandardDto fundProjBudgetStandardDto);

    void deleteFundProjBudgetStandard(BaseDto baseDto);

    Long getIdByName(String name);
}
