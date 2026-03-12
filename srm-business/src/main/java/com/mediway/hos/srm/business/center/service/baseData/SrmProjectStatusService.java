package com.mediway.hos.srm.business.center.service.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataCommonDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;


import com.mediway.hos.srm.business.center.model.dto.baseData.ProjectStatusDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ProjectStatusVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmProjectStatus;

/**
 * <p>
 * 项目状态代码 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmProjectStatusService extends BaseService<SrmProjectStatus> {

    @Transactional
    Long saveOrUpdateProjectStatus(BaseDataCommonDto baseDataProjDto);

    ProjectStatusVo getDetailProjectStatus(Long RowId);
    IPage<ProjectStatusVo> listProjectStatus(ProjectStatusDto projectStatusDto);

    void deleteProjectStatus(BaseDto baseDto);

    Long getIdByName(String name);
}
