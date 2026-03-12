package com.mediway.hos.srm.business.center.mapper.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.mediway.hos.srm.business.center.model.dto.baseData.LectureTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.LectureTypeVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmLectureType;

import java.util.List;


/**
 * <p>
 * 讲座类型 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmLectureTypeMapper extends BaseMapper<SrmLectureType> {
    IPage<LectureTypeVo> listLectureType(@Param("page") Page<LectureTypeVo> page, @Param("lectureTypeDto") LectureTypeDto lectureTypeDto);
    List<CombVo> getLectureType();
}
