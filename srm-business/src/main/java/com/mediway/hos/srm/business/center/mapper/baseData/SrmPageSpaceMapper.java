package com.mediway.hos.srm.business.center.mapper.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import java.util.List;

import com.mediway.hos.srm.business.center.model.dto.baseData.PageSpaceDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmPageSpace;
import com.mediway.hos.srm.business.center.model.vo.baseData.PageSpaceVo;


/**
 * <p>
 * 版面 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmPageSpaceMapper extends BaseMapper<SrmPageSpace> {
    List<CombVo> getPageSpace(@Param("pageSpaceDto") PageSpaceDto pageSpaceDto);
    IPage<PageSpaceVo> listPageSpace(@Param("page") Page<PageSpaceVo> page, @Param("pageSpaceDto") PageSpaceDto pageSpaceDto);
}
