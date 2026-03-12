package com.mediway.hos.srm.business.center.service.academic;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.srm.business.center.model.dto.academic.AcParttimeApplyDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.entity.academic.SrmAcParttimeApply;
import com.mediway.hos.srm.business.base.service.BaseService;
import com.mediway.hos.srm.business.center.model.vo.academic.AcParttimeApplyVo;

/**
 * <p>
 * 兼职申请表 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmAcParttimeApplyService extends BaseService<SrmAcParttimeApply> {
    Long saveAcParttimeApply(AcParttimeApplyDto acParttimeApplyDto);
    AcParttimeApplyVo getDetail(Long rowId);
    IPage<AcParttimeApplyVo> listAcParttimeApply(AcParttimeApplyDto acParttimeApplyDto);

    void deleteAcParttimeApply(BaseDto baseDto);
    void subMit(BaseDto baseDto);

    void audit(BaseDto baseDto);
    IPage<AcParttimeApplyVo> listAuditAcParttimeApply(AcParttimeApplyDto acParttimeApplyDto);
}
