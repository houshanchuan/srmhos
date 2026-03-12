package com.mediway.hos.srm.business.center.mapper.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import java.util.List;

import com.mediway.hos.srm.business.center.model.dto.baseData.ParttimeJobDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmParttimeJob;
import com.mediway.hos.srm.business.center.model.vo.baseData.ParttimeJobVo;

/**
 * <p>
 * 兼职职位表(职务类型) Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmParttimeJobMapper extends BaseMapper<SrmParttimeJob> {
    IPage<ParttimeJobVo> listParttimeJob(@Param("page") Page<ParttimeJobVo> page, @Param("parttimeJobDto") ParttimeJobDto parttimeJobDto);
    List<CombVo> getPartTimeJob(@Param("parttimeJobDto") ParttimeJobDto parttimeJobDto);
}
