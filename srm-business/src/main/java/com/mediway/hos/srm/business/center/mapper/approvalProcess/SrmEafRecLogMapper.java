package com.mediway.hos.srm.business.center.mapper.approvalProcess;

import org.apache.ibatis.annotations.Param;
import com.mediway.hos.srm.business.center.model.entity.approvalProcess.SrmEafRecLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.approvalProcess.EafRecLogVo;

import java.util.List;

/**
 * <p>
 * 审批记录日志 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-08-23
 */
public interface SrmEafRecLogMapper extends BaseMapper<SrmEafRecLog> {
    List<EafRecLogVo> listCheckLog(@Param("sysNo") String sysNo,@Param("rowId") String rowId);
}
