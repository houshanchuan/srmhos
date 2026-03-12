package com.mediway.hos.srm.business.center.mapper.baseData;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.mediway.hos.srm.business.center.model.dto.baseData.LectureLevelDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.LectureLevelVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmLectureLevel;

import java.util.List;

/**
 * <p>
 * 讲座级别 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmLectureLevelMapper extends BaseMapper<SrmLectureLevel> {

    IPage<LectureLevelVo> listLectureLevel(@Param("page") Page<LectureLevelVo> page, @Param("lectureLevelDto") LectureLevelDto lectureLevelDto);

    List<CombVo> getLectureLevel();
}
