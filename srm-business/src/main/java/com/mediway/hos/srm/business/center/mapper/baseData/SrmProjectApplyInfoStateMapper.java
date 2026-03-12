package com.mediway.hos.srm.business.center.mapper.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import java.util.List;

import com.mediway.hos.srm.business.center.model.dto.baseData.ProjectApplyInfoStateDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ProjectApplyInfoStateVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmProjectApplyInfoState;


/**
 * <p>
 * 项目申报批次状态 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmProjectApplyInfoStateMapper extends BaseMapper<SrmProjectApplyInfoState> {
    List<CombVo> getProjectApplyInfoState();

    IPage<ProjectApplyInfoStateVo> listProjectApplyInfoState(@Param("page") Page<ProjectApplyInfoStateVo> page, @Param("projectApplyInfoStateDto") ProjectApplyInfoStateDto projectApplyInfoStateDto);

}
