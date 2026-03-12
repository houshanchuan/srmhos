package com.mediway.hos.srm.business.center.service.baseData;

import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmProjectCooperatives;
import com.mediway.hos.srm.business.base.service.BaseService;
import com.mediway.hos.srm.business.center.model.vo.baseData.ProjectCooperativesVo;

import java.util.List;

/**
 * <p>
 * 项目合作单位表 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmProjectCooperativesService extends BaseService<SrmProjectCooperatives> {
    List<ProjectCooperativesVo> listProjectCooperatives(BaseDto baseDto);
    void deleteProjectCooperativesById(BaseDto baseDto);
}
