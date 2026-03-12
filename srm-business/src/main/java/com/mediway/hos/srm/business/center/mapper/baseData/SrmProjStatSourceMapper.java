package com.mediway.hos.srm.business.center.mapper.baseData;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import java.util.List;

import com.mediway.hos.srm.business.center.model.dto.baseData.ProjStatSourceDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ProjStatSourceVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmProjStatSource;


/**
 * <p>
 * 项目来源表 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmProjStatSourceMapper extends BaseMapper<SrmProjStatSource> {
    IPage<ProjStatSourceVo> listProjStatSource(@Param("page") Page<ProjStatSourceVo> page, @Param("projStatSourceDto") ProjStatSourceDto projStatSourceDto);
    List<CombVo> getProjStatSource();
}
