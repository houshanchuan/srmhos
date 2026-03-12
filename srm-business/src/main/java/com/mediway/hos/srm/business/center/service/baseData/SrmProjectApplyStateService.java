package com.mediway.hos.srm.business.center.service.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataCommonDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;

import com.mediway.hos.srm.business.center.model.dto.baseData.ProjectApplyStateDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ProjectApplyStateVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmProjectApplyState;

/**
 * <p>
 * 项目申报状态 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmProjectApplyStateService extends BaseService<SrmProjectApplyState> {

    @Transactional
    Long saveOrUpdateProjectApplyState(BaseDataCommonDto baseDataProjDto);

    ProjectApplyStateVo getDetailProjectApplyState(Long RowId);
    IPage<ProjectApplyStateVo> listProjectApplyState(ProjectApplyStateDto projectApplyStateDto);

    void deleteProjectApplyState(BaseDto baseDto);

    Long getIdByName(String name);
}
