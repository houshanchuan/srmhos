package com.mediway.hos.srm.business.center.service.fund;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataFundDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;

import com.mediway.hos.srm.business.center.model.dto.fund.FundExpTypeDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundExpTypeVo;
import com.mediway.hos.srm.business.center.model.entity.fund.FundExpType;

/**
 * <p>
 * 支出业务类型 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
public interface FundExpTypeService extends BaseService<FundExpType> {

    @Transactional
    Long saveOrUpdateFundExpType(BaseDataFundDto baseDataFundDto);

    FundExpTypeVo getDetailFundExpType(Long RowId);
    IPage<FundExpTypeVo> listFundExpType(FundExpTypeDto fundExpTypeDto);

    void deleteFundExpType(BaseDto baseDto);

    Long getIdByName(String name);
}
