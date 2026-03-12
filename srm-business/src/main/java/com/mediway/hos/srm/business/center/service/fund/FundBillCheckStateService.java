package com.mediway.hos.srm.business.center.service.fund;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataFundDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;

import com.mediway.hos.srm.business.center.model.dto.fund.FundBillCheckStateDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundBillCheckStateVo;
import com.mediway.hos.srm.business.center.model.entity.fund.FundBillCheckState;

/**
 * <p>
 * 单据审核状态 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
public interface FundBillCheckStateService extends BaseService<FundBillCheckState> {

    @Transactional
    Long saveOrUpdateFundBillCheckState(BaseDataFundDto baseDataFundDto);

    FundBillCheckStateVo getDetailFundBillCheckState(Long RowId);
    IPage<FundBillCheckStateVo> listFundBillCheckState(FundBillCheckStateDto fundBillCheckStateDto);

    void deleteFundBillCheckState(BaseDto baseDto);

    Long getIdByName(String name);
}
