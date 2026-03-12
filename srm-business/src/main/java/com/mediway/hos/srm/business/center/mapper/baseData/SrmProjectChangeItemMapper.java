package com.mediway.hos.srm.business.center.mapper.baseData;

import com.mediway.hos.srm.business.center.model.entity.baseData.SrmProjectChangeItem;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;

import java.util.List;

/**
 * <p>
 * 项目变更内容表 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmProjectChangeItemMapper extends BaseMapper<SrmProjectChangeItem> {
    List<CombVo> getProjectChangeItem();
}
