package com.mediway.hos.srm.business.center.service.fund;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataFundDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;

import com.mediway.hos.srm.business.center.model.dto.fund.FundBillStateDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundBillStateVo;
import com.mediway.hos.srm.business.center.model.entity.fund.FundBillState;
/**
 * <p>
 * 经费单据状态 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
public interface FundBillStateService extends BaseService<FundBillState> {

    @Transactional
    Long saveOrUpdateFundBillState(BaseDataFundDto baseDataFundDto);

    FundBillStateVo getDetailFundBillState(Long RowId);
    IPage<FundBillStateVo> listFundBillState(FundBillStateDto fundBillStateDto);

    void deleteFundBillState(BaseDto baseDto);

    Long getIdByName(String name);
}
