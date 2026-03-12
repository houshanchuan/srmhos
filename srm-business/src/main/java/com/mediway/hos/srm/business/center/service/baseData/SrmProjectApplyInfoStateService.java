package com.mediway.hos.srm.business.center.service.baseData;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataCommonDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;
import java.util.List;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;

import com.mediway.hos.srm.business.center.model.dto.baseData.ProjectApplyInfoStateDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ProjectApplyInfoStateVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmProjectApplyInfoState;


/**
 * <p>
 * 项目申报批次状态 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmProjectApplyInfoStateService extends BaseService<SrmProjectApplyInfoState> {
	
	public List<CombVo> getProjectApplyInfoState();		 

    @Transactional
    Long saveOrUpdateProjectApplyInfoState(BaseDataCommonDto baseDataProjDto);

    ProjectApplyInfoStateVo getDetailProjectApplyInfoState(Long RowId);
    IPage<ProjectApplyInfoStateVo> listProjectApplyInfoState(ProjectApplyInfoStateDto projectApplyInfoStateDto);

    void deleteProjectApplyInfoState(BaseDto baseDto);

    Long getIdByName(String name);
}
