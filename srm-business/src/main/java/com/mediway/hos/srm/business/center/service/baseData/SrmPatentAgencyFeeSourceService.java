package com.mediway.hos.srm.business.center.service.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataLearningDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;
import java.util.List;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;

import com.mediway.hos.srm.business.center.model.dto.baseData.PatentAgencyFeeSourceDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmPatentAgencyFeeSource;
import com.mediway.hos.srm.business.center.model.vo.baseData.PatentAgencyFeeSourceVo;

/**
 * <p>
 * 专利代理费用来源 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmPatentAgencyFeeSourceService extends BaseService<SrmPatentAgencyFeeSource> {
	public List<CombVo> getPatentAgencyFeeSource(PatentAgencyFeeSourceDto patentAgencyFeeSourceDto);
    @Transactional
    Long saveOrUpdatePatentAgencyFeeSource(BaseDataLearningDto baseDataLearningDto);

    PatentAgencyFeeSourceVo getDetailPatentAgencyFeeSource(Long RowId);
    IPage<PatentAgencyFeeSourceVo> listPatentAgencyFeeSource(PatentAgencyFeeSourceDto patentAgencyFeeSourceDto);

    void deletePatentAgencyFeeSource(BaseDto baseDto);

    Long getIdByName(String name);
}
