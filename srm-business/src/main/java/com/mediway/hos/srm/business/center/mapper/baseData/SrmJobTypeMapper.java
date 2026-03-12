package com.mediway.hos.srm.business.center.mapper.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import java.util.List;


import com.mediway.hos.srm.business.center.model.dto.baseData.JobTypeDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmJobType;
import com.mediway.hos.srm.business.center.model.vo.baseData.JobTypeVo;

/**
 * <p>
 * 科研人员岗位性质 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmJobTypeMapper extends BaseMapper<SrmJobType> {
    IPage<JobTypeVo> listJobType (@Param("page") Page<JobTypeVo> page, @Param("jobType Dto") JobTypeDto jobTypeDto);

    List<CombVo> getJobType(@Param("jobTypeDto") JobTypeDto jobTypeDto);
}
