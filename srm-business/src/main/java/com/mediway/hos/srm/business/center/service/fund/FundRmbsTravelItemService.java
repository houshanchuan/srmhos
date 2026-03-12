package com.mediway.hos.srm.business.center.service.fund;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataFundDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;

import com.mediway.hos.srm.business.center.model.dto.fund.FundRmbsTravelItemDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundRmbsTravelItemVo;
import com.mediway.hos.srm.business.center.model.entity.fund.FundRmbsTravelItem;

/**
 * <p>
 * 差旅报销项目 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
public interface FundRmbsTravelItemService extends BaseService<FundRmbsTravelItem> {

    @Transactional
    Long saveOrUpdateFundRmbsTravelItem(BaseDataFundDto baseDataFundDto);

    FundRmbsTravelItemVo getDetailFundRmbsTravelItem(Long RowId);

    IPage<FundRmbsTravelItemVo> listFundRmbsTravelItem(FundRmbsTravelItemDto fundRmbsTravelItemDto);

    void deleteFundRmbsTravelItem(BaseDto baseDto);

    Long getIdByName(String name);
}
