package com.mediway.hos.srm.business.center.mapper.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.ProjTypeSubVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmProjTypeSub;
/**
 * <p>
 * 项目类型(子类) Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmProjTypeSubMapper extends BaseMapper<SrmProjTypeSub> {
    IPage<ProjTypeSubVo> listProjTypeSub(@Param("page") Page<ProjTypeSubVo> page,@Param("projTypeId") String projTypeId) ;

}
