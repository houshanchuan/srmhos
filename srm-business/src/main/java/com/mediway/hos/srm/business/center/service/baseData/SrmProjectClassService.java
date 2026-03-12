package com.mediway.hos.srm.business.center.service.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataProjDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;
import java.util.List;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;

import com.mediway.hos.srm.business.center.model.dto.baseData.ProjectClassDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ProjectClassVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmProjectClass;

/**
 * <p>
 * 项目性质 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmProjectClassService extends BaseService<SrmProjectClass> {

    @Transactional
    Long saveOrUpdateProjectClass(BaseDataProjDto baseDataProjDto);

    ProjectClassVo getDetailProjectClass(Long RowId);
    IPage<ProjectClassVo> listProjectClass(ProjectClassDto projectClassDto);

    void deleteProjectClass(BaseDto baseDto);

    Long getIdByName(String name);

    List<CombVo> getProjClass();
}
