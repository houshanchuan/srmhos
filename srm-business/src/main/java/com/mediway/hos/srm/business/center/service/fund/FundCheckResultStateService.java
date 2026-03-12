package com.mediway.hos.srm.business.center.service.fund;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataFundDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;

import com.mediway.hos.srm.business.center.model.dto.fund.FundCheckResultStateDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundCheckResultStateVo;
import com.mediway.hos.srm.business.center.model.entity.fund.FundCheckResultState;

/**
 * <p>
 * 审批结果状态代码表 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
public interface FundCheckResultStateService extends BaseService<FundCheckResultState> {

    @Transactional
    Long saveOrUpdateFundCheckResultState(BaseDataFundDto baseDataFundDto);

    FundCheckResultStateVo getDetailFundCheckResultState(Long RowId);
    IPage<FundCheckResultStateVo> listFundCheckResultState(FundCheckResultStateDto fundCheckResultStateDto);

    void deleteFundCheckResultState(BaseDto baseDto);

    Long getIdByName(String name);
}
