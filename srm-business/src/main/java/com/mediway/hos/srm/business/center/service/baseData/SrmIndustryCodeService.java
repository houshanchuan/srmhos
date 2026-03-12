package com.mediway.hos.srm.business.center.service.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataProjDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;

import com.mediway.hos.srm.business.center.model.dto.baseData.IndustryCodeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.IndustryCodeVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmIndustryCode;

/**
 * <p>
 * 行业代码 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmIndustryCodeService extends BaseService<SrmIndustryCode> {

    @Transactional
    Long saveOrUpdateIndustryCode(BaseDataProjDto baseDataProjDto);

    IndustryCodeVo getDetailIndustryCode(Long RowId);
    IPage<IndustryCodeVo> listIndustryCode(IndustryCodeDto industryCodeDto);

    void deleteIndustryCode(BaseDto baseDto);

    Long getIdByName(String name);
}
