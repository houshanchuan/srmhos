package com.mediway.hos.srm.business.center.mapper.approvalProcess;

import org.apache.ibatis.annotations.Param;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.dto.approvalProcess.EafRecDto;
import com.mediway.hos.srm.business.center.model.entity.approvalProcess.SrmEafDetail;
import com.mediway.hos.srm.business.center.model.entity.approvalProcess.SrmEafRec;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.approvalProcess.EafRecVo;

/**
 * <p>
 * 审批记录 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-08-21
 */
public interface SrmEafRecMapper extends BaseMapper<SrmEafRec> {
    void deleteRec(@Param("sysNo") String sysNo,@Param("recId") String recId);
    EafRecVo getEafRecDetail(@Param("eafRecDto")EafRecDto eafRecDto);

    void updateRec(@Param("eafRecDto")EafRecDto eafRecDto);

    String getCurCheckUserStr(@Param("baseDto")BaseDto baseDto);
    SrmEafDetail getCheckStatus(@Param("sysNo") String sysNo, @Param("rowId") String rowId);

    Integer getMaxStepNo(@Param("sysNo") String sysNo,@Param("rowId") String rowId);

    String getFinalResult(@Param("sysNo") String sysNo,@Param("rowId") String rowId);
}
