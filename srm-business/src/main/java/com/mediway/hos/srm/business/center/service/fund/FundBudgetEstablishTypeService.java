package com.mediway.hos.srm.business.center.service.fund;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataFundDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;
import com.mediway.hos.srm.business.center.model.dto.fund.FundBudgetEstablishTypeDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundBudgetEstablishTypeVo;
import com.mediway.hos.srm.business.center.model.entity.fund.FundBudgetEstablishType;

/**
 * <p>
 * 预算编制类型 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
public interface FundBudgetEstablishTypeService extends BaseService<FundBudgetEstablishType> {

    @Transactional
    Long saveOrUpdateFundBudgetEstablishType(BaseDataFundDto baseDataFundDto);

    FundBudgetEstablishTypeVo getDetailFundBudgetEstablishType(Long RowId);
    IPage<FundBudgetEstablishTypeVo> listFundBudgetEstablishType(FundBudgetEstablishTypeDto fundBudgetEstablishTypeDto);

    void deleteFundBudgetEstablishType(BaseDto baseDto);

    Long getIdByName(String name);
}
