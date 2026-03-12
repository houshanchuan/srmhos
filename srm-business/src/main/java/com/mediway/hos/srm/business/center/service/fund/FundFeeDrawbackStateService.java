package com.mediway.hos.srm.business.center.service.fund;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataFundDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;

import com.mediway.hos.srm.business.center.model.dto.fund.FundFeeDrawbackStateDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundFeeDrawbackStateVo;
import com.mediway.hos.srm.business.center.model.entity.fund.FundFeeDrawbackState;

/**
 * <p>
 * 费用退税状态 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
public interface FundFeeDrawbackStateService extends BaseService<FundFeeDrawbackState> {

    @Transactional
    Long saveOrUpdateFundFeeDrawbackState(BaseDataFundDto baseDataFundDto);

    FundFeeDrawbackStateVo getDetailFundFeeDrawbackState(Long RowId);
    IPage<FundFeeDrawbackStateVo> listFundFeeDrawbackState(FundFeeDrawbackStateDto fundFeeDrawbackStateDto);

    void deleteFundFeeDrawbackState(BaseDto baseDto);

    Long getIdByName(String name);
}
