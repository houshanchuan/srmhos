package com.mediway.hos.srm.business.center.mapper.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import java.util.List;

import com.mediway.hos.srm.business.center.model.dto.baseData.TeacherTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.TeacherTypeVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmTeacherType;

/**
 * <p>
 * 教师类型代码 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmTeacherTypeMapper extends BaseMapper<SrmTeacherType> {

    IPage<TeacherTypeVo> listTeacherType(@Param("page") Page<TeacherTypeVo> page, @Param("teacherTypeDto") TeacherTypeDto teacherTypeDto);

    List<CombVo> getTeacherType();
}
