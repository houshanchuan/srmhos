package com.mediway.hos.srm.business.center.service.approvalProcess;

import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.dto.approvalProcess.EafDetailDto;
import com.mediway.hos.srm.business.center.model.entity.approvalProcess.SrmEafDetail;
import com.mediway.hos.srm.business.base.service.BaseService;
import com.mediway.hos.srm.business.center.model.vo.approvalProcess.EafDetailVo;

import java.util.List;

/**
 * <p>
 * 审批流明细表 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-08-21
 */
public interface SrmEafDetailService extends BaseService<SrmEafDetail> {
    Integer getMaxStepNo(Long parref);
    Long saveEafDetail(EafDetailDto eafDetailDto);

    EafDetailVo getDetail(Long rowId);
    List<EafDetailVo> listDetail(Long parref);

    List<EafDetailVo> listChecker(Long rowId);

    void deleteDetail(BaseDto baseDto);
}
