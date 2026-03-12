package com.mediway.hos.srm.business.center.service.academic;

import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataLearningDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataUserDto;
import com.mediway.hos.srm.business.center.model.entity.academic.SrmAcPersonAcademicTitle;
import com.mediway.hos.srm.business.base.service.BaseService;

/**
 * <p>
 * 学术称号表 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmAcPersonAcademicTitleService extends BaseService<SrmAcPersonAcademicTitle> {

    public Long saveOrUpdateAcPersonAcademicTitle(BaseDataUserDto baseDataUserDto);
}
