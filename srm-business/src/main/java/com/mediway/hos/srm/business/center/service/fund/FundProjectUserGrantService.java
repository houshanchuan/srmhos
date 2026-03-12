package com.mediway.hos.srm.business.center.service.fund;


import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataFundDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;

import com.mediway.hos.srm.business.center.model.dto.fund.FundProjectUserGrantDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundProjectUserGrantVo;
import com.mediway.hos.srm.business.center.model.entity.fund.FundProjectUserGrant;
/**
 * <p>
 * 项目授权分析 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
public interface FundProjectUserGrantService extends BaseService<FundProjectUserGrant> {

    @Transactional
    Long saveOrUpdateFundProjectUserGrant(BaseDataFundDto baseDataFundDto);

    FundProjectUserGrantVo getDetailFundProjectUserGrant(Long RowId);
    IPage<FundProjectUserGrantVo> listFundProjectUserGrant(FundProjectUserGrantDto fundProjectUserGrantDto);

    void deleteFundProjectUserGrant(BaseDto baseDto);

    Long getIdByName(String name);
}
