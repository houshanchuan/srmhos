package com.mediway.hos.srm.business.center.mapper.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.dto.baseData.ProjMidCheckBookStateDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ProjMidCheckBookStateVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmProjMidcheckBookState;

/**
 * <p>
 * 项目中检状态表 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmProjMidcheckBookStateMapper extends BaseMapper<SrmProjMidcheckBookState> {
    IPage<ProjMidCheckBookStateVo> listProjMidCheckBookState(@Param("page") Page<ProjMidCheckBookStateVo> page, @Param("projMidCheckBookStateDto") ProjMidCheckBookStateDto projMidCheckBookStateDto);

}
