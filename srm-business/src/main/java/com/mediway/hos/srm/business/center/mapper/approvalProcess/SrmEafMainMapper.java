package com.mediway.hos.srm.business.center.mapper.approvalProcess;

import com.mediway.hos.srm.business.center.model.entity.approvalProcess.SrmEafMain;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.approvalProcess.EafMainVo;

import java.util.List;

/**
 * <p>
 * 审批流主表 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-08-21
 */
public interface SrmEafMainMapper extends BaseMapper<SrmEafMain> {
    List<EafMainVo> listEafMain();
}
