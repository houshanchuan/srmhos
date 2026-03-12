package com.mediway.hos.srm.business.center.mapper.baseData;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.mediway.hos.srm.business.center.model.dto.baseData.ProjectApplyStateDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ProjectApplyStateVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmProjectApplyState;

/**
 * <p>
 * 项目申报状态 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmProjectApplyStateMapper extends BaseMapper<SrmProjectApplyState> {
    IPage<ProjectApplyStateVo> listProjectApplyState(@Param("page") Page<ProjectApplyStateVo> page, @Param("projectApplyStateDto") ProjectApplyStateDto projectApplyStateDto);

}
