package com.mediway.hos.srm.business.center.service.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataLearningDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;

import com.mediway.hos.srm.business.center.model.dto.baseData.SchoolSignDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.SchoolSignVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmSchoolSign;


/**
 * <p>
 * 单位签名排序 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmSchoolSignService extends BaseService<SrmSchoolSign> {

    @Transactional
    Long saveOrUpdateSchoolSign(BaseDataLearningDto baseDataLearningDto);

    SchoolSignVo getDetailSchoolSign(Long RowId);
    IPage<SchoolSignVo> listSchoolSign(SchoolSignDto schoolSignDto);

    void deleteSchoolSign(BaseDto baseDto);

    Long getIdByName(String name);
}
