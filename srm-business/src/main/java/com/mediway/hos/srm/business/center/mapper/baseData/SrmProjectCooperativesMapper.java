package com.mediway.hos.srm.business.center.mapper.baseData;

import com.mediway.hos.srm.business.center.model.entity.baseData.SrmProjectCooperatives;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.ProjectCooperativesVo;
import com.mediway.hos.srm.business.center.model.vo.paper.PaperAuthorVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 项目合作单位表 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmProjectCooperativesMapper extends BaseMapper<SrmProjectCooperatives> {
    List<ProjectCooperativesVo> listProjectCooperatives(@Param("projectId") Long projectId);
    void deleteProjectCooperatives(@Param("projectId") Long projectId);
}
