package com.mediway.hos.srm.business.center.service.fund;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataFundDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;

import com.mediway.hos.srm.business.center.model.dto.fund.FundFeeBelongDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundFeeBelongVo;
import com.mediway.hos.srm.business.center.model.entity.fund.FundFeeBelong;


/**
 * <p>
 * 经费归属 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
public interface FundFeeBelongService extends BaseService<FundFeeBelong> {

    @Transactional
    Long saveOrUpdateFundFeeBelong(BaseDataFundDto baseDataFundDto);
    FundFeeBelongVo getDetailFundFeeBelong(Long RowId);
    IPage<FundFeeBelongVo> listFundFeeBelong(FundFeeBelongDto fundFeeBelongDto);
    void deleteFundFeeBelong(BaseDto baseDto);
    Long getIdByName(String name);
}
