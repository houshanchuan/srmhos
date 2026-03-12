package com.mediway.hos.srm.business.center.mapper.baseData;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import java.util.List;

import com.mediway.hos.srm.business.center.model.dto.baseData.JobLevelDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmJobLevel;
import com.mediway.hos.srm.business.center.model.vo.baseData.JobLevelVo;

/**
 * <p>
 * 科研人员岗位层级 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmJobLevelMapper extends BaseMapper<SrmJobLevel> {
    IPage<JobLevelVo> listJobLevel (@Param("page") Page<JobLevelVo> page, @Param("jobLevelDto") JobLevelDto jobLevelDto);

    List<CombVo> getJobLevel();
}
