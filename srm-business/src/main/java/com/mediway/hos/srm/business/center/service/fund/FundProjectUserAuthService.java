package com.mediway.hos.srm.business.center.service.fund;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataFundDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;

import com.mediway.hos.srm.business.center.model.dto.fund.FundProjectUserAuthDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundProjectUserAuthVo;
import com.mediway.hos.srm.business.center.model.entity.fund.FundProjectUserAuth;

/**
 * <p>
 * 预算项目授权 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
public interface FundProjectUserAuthService extends BaseService<FundProjectUserAuth> {

    @Transactional
    Long saveOrUpdateFundProjectUserAuth(BaseDataFundDto baseDataFundDto);

    FundProjectUserAuthVo getDetailFundProjectUserAuth(Long RowId);
    IPage<FundProjectUserAuthVo> listFundProjectUserAuth(FundProjectUserAuthDto fundProjectUserAuthDto);

    void deleteFundProjectUserAuth(BaseDto baseDto);

    Long getIdByName(String name);
}
