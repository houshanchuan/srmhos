package com.mediway.hos.srm.business.center.service.projectapply;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.dto.projectapply.ProjectApplyInfoDto;
import com.mediway.hos.srm.business.center.model.entity.projectapply.SrmProjectApplyInfo;
import com.mediway.hos.srm.business.base.service.BaseService;
import com.mediway.hos.srm.business.center.model.vo.projectapply.ProjectApplyInfoVo;

/**
 * <p>
 * 项目申报批次 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-23
 */
public interface SrmProjectApplyInfoService extends BaseService<SrmProjectApplyInfo> {
    IPage<ProjectApplyInfoVo> listProjectApplyPlan(ProjectApplyInfoDto projectApplyInfoDto);
    void deleteProjectApplyPlan(BaseDto baseDto);

    Long saveProjectApplyPlan(ProjectApplyInfoDto projectApplyInfoDto);

    ProjectApplyInfoVo getDetail(Long rowId);
}
