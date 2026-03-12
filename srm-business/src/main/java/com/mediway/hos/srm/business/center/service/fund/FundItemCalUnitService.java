package com.mediway.hos.srm.business.center.service.fund;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataFundDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;

import com.mediway.hos.srm.business.center.model.dto.fund.FundItemCalUnitDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundItemCalUnitVo;
import com.mediway.hos.srm.business.center.model.entity.fund.FundItemCalUnit;



/**
 * <p>
 * 预算项计量单位 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
public interface FundItemCalUnitService extends BaseService<FundItemCalUnit> {

    @Transactional
    Long saveOrUpdateFundItemCalUnit(BaseDataFundDto baseDataFundDto);

    FundItemCalUnitVo getDetailFundItemCalUnit(Long RowId);
    IPage<FundItemCalUnitVo> listFundItemCalUnit(FundItemCalUnitDto fundItemCalUnitDto);

    void deleteFundItemCalUnit(BaseDto baseDto);

    Long getIdByName(String name);
}
