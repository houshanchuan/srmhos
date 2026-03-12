package com.mediway.hos.srm.business.center.service.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataProjDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;

import com.mediway.hos.srm.business.center.model.dto.baseData.IdentifyResultDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.IdentifyResultVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmIdentifyResult;

/**
 * <p>
 * 鉴定结果（结论） 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmIdentifyResultService extends BaseService<SrmIdentifyResult> {

    @Transactional
    Long saveOrUpdateIdentifyResult(BaseDataProjDto baseDataProjDto);

    IdentifyResultVo getDetailIdentifyResult(Long RowId);
    IPage<IdentifyResultVo> listIdentifyResult(IdentifyResultDto identifyResultDto);

    void deleteIdentifyResult(BaseDto baseDto);

    Long getIdByName(String name);
}
