package com.mediway.hos.srm.business.center.service.fund;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataFundDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;

import com.mediway.hos.srm.business.center.model.dto.fund.FundCheckIdentityDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundCheckIdentityVo;
import com.mediway.hos.srm.business.center.model.entity.fund.FundCheckIdentity;




/**
 * <p>
 * 审批流角色身份标识名称表 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-22
 */
public interface FundCheckIdentityService extends BaseService<FundCheckIdentity> {

    @Transactional
    Long saveOrUpdateFundCheckIdentity(BaseDataFundDto baseDataFundDto);

    FundCheckIdentityVo getDetailFundCheckIdentity(Long RowId);
    IPage<FundCheckIdentityVo> listFundCheckIdentity(FundCheckIdentityDto fundCheckIdentityDto);

    void deleteFundCheckIdentity(BaseDto baseDto);

    Long getIdByName(String name);
}
