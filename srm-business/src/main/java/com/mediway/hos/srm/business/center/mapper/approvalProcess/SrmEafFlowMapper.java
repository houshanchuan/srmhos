package com.mediway.hos.srm.business.center.mapper.approvalProcess;

import org.apache.ibatis.annotations.Param;
import com.mediway.hos.srm.business.center.model.entity.approvalProcess.SrmEafFlow;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.approvalProcess.EafFlowVo;

import java.util.List;

/**
 * <p>
 * 各业务审批流定义 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-08-21
 */
public interface SrmEafFlowMapper extends BaseMapper<SrmEafFlow> {
    List<EafFlowVo> listEafFlow();
    String getEafFlow(@Param("sysNo") String sysNo, @Param("typeId") String typeId);
}
