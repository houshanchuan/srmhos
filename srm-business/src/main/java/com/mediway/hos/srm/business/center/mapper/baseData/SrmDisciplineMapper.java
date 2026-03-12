package com.mediway.hos.srm.business.center.mapper.baseData;

import org.apache.ibatis.annotations.Param;
import com.mediway.hos.srm.business.center.model.dto.baseData.DisciplineDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmDiscipline;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;

import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mediway.hos.srm.business.center.model.vo.baseData.DisciplineVo;

/**
 * <p>
 * 学科表 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-07-19
 */
public interface SrmDisciplineMapper extends BaseMapper<SrmDiscipline> {
    List<CombVo> getDiscipline(@Param("upCode") String upCode,@Param("classcode") String classcode);
    IPage<DisciplineVo> listDiscipline(@Param("page") Page<DisciplineVo> page, @Param("disciplineDto") DisciplineDto disciplineDto);
    List<CombVo> getDisciplineNew(@Param("disciplineDto") DisciplineDto disciplineDto);
}
