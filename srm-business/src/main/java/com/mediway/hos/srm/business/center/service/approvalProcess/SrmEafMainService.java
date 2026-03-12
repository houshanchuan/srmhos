package com.mediway.hos.srm.business.center.service.approvalProcess;

import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.dto.approvalProcess.EafMainDto;
import com.mediway.hos.srm.business.center.model.entity.approvalProcess.SrmEafMain;
import com.mediway.hos.srm.business.base.service.BaseService;
import com.mediway.hos.srm.business.center.model.vo.approvalProcess.EafMainVo;

import java.util.List;

/**
 * <p>
 * 审批流主表 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-08-21
 */
public interface SrmEafMainService extends BaseService<SrmEafMain> {
    void saveeafMain(List<EafMainDto> eafMainDtos);
    List<EafMainVo> listEafMain();
    void delete(BaseDto baseDto);
}
