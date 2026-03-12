package com.mediway.hos.srm.business.center.mapper.baseData;

import org.apache.ibatis.annotations.Param;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmBusinessno;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 单号生成 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2025-02-14
 */
public interface SrmBusinessnoMapper extends BaseMapper<SrmBusinessno> {
    SrmBusinessno getSrmBusinessno(@Param("type") String type);
}
