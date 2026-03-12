package com.mediway.hos.srm.business.center.service.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataCommonDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;

import com.mediway.hos.srm.business.center.model.dto.baseData.ProjectApprovalStatusDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ProjectApprovalStatusVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmProjectApprovalStatus;

/**
 * <p>
 * 项目申报立项状态 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmProjectApprovalStatusService extends BaseService<SrmProjectApprovalStatus> {

    @Transactional
    Long saveOrUpdateProjectApprovalStatus(BaseDataCommonDto baseDataProjDto);

    ProjectApprovalStatusVo getDetailProjectApprovalStatus(Long RowId);
    IPage<ProjectApprovalStatusVo> listProjectApprovalStatus(ProjectApprovalStatusDto projectApprovalStatusDto);

    void deleteProjectApprovalStatus(BaseDto baseDto);

    Long getIdByName(String name);
}
