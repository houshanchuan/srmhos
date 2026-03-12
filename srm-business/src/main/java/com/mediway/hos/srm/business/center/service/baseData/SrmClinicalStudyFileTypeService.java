package com.mediway.hos.srm.business.center.service.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataProjDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;
import com.mediway.hos.srm.business.center.model.dto.baseData.ClinicalStudyFileTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ClinicalStudyFileTypeVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmClinicalStudyFileType;


/**
 * <p>
 * 临床试验研究项目附件类型表 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmClinicalStudyFileTypeService extends BaseService<SrmClinicalStudyFileType> {
    @Transactional
    Long saveOrUpdateClinicalStudyFileType(BaseDataProjDto baseDataProjDto);

    ClinicalStudyFileTypeVo getDetailClinicalStudyFileType(Long RowId);
    IPage<ClinicalStudyFileTypeVo> listClinicalStudyFileType(ClinicalStudyFileTypeDto clinicalStudyFileTypeDto);

    void deleteClinicalStudyFileType(BaseDto baseDto);

    Long getIdByName(String name);
}
