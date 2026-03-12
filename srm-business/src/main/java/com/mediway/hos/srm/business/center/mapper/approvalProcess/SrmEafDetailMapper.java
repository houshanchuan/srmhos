package com.mediway.hos.srm.business.center.mapper.approvalProcess;

import org.apache.ibatis.annotations.Param;
import com.mediway.hos.srm.business.center.model.entity.approvalProcess.SrmEafDetail;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.approvalProcess.EafDetailVo;
import java.util.List;
/**
 * <p>
 * 审批流明细表 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-08-21
 */
public interface SrmEafDetailMapper extends BaseMapper<SrmEafDetail> {
    Integer getMaxStepNo(@Param("parref") Long parref);
    EafDetailVo getDetail(@Param("rowId") Long rowId);
    List<EafDetailVo> listDetail(@Param("parref") Long parref);
    List<EafDetailVo> getUserNamesByIds(@Param("ids") List<String> ids);
}
