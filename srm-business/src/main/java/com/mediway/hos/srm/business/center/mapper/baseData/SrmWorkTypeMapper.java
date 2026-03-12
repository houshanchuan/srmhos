package com.mediway.hos.srm.business.center.mapper.baseData;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import java.util.List;

import com.mediway.hos.srm.business.center.model.dto.baseData.WorkTypeDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmWorkType;
import com.mediway.hos.srm.business.center.model.vo.baseData.WorkTypeVo;

/**
 * <p>
 * 著作类别 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-07-19
 */
public interface SrmWorkTypeMapper extends BaseMapper<SrmWorkType> {
    List<CombVo> getWorkType(@Param("workTypeDto") WorkTypeDto workTypeDto);
    IPage<WorkTypeVo> listWorkType(@Param("page") Page<WorkTypeVo> page, @Param("workTypeDto") WorkTypeDto workTypeDto);
}
