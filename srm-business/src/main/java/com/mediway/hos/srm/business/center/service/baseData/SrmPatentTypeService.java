package com.mediway.hos.srm.business.center.service.baseData;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataLearningDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;
import java.util.List;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;

import com.mediway.hos.srm.business.center.model.dto.baseData.PatentTypeDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmPatentType;
import com.mediway.hos.srm.business.center.model.vo.baseData.PatentTypeVo;
/**
 * <p>
 * 专利类型 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmPatentTypeService extends BaseService<SrmPatentType> {
	List<CombVo> getPatentType();
    @Transactional
    Long saveOrUpdatePatentType(BaseDataLearningDto baseDataLearningDto);

    PatentTypeVo getDetailPatentType(Long RowId);
    IPage<PatentTypeVo> listPatentType(PatentTypeDto patentTypeDto);

    void deletePatentType(BaseDto baseDto);

    Long getIdByName(String name);
}
