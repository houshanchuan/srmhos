package com.mediway.hos.srm.business.center.mapper.baseData;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import java.util.List;

import com.mediway.hos.srm.business.center.model.dto.baseData.ProjTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ProjTypeVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmProjType;
/**
 * <p>
 * 项目分类表（父） Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmProjTypeMapper extends BaseMapper<SrmProjType> {
    IPage<ProjTypeVo> listProjType(@Param("page") Page<ProjTypeVo> page, @Param("projTypeDto") ProjTypeDto projTypeDto);

    List<CombVo> getProjectType(@Param("projTypeDto") ProjTypeDto projTypeDto);
}
