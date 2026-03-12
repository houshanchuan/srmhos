package com.mediway.hos.srm.business.center.service.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataLearningDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;

import com.mediway.hos.srm.business.center.model.dto.baseData.AchvAuthorTypeDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmAchvAuthorType;
import com.mediway.hos.srm.business.center.model.vo.baseData.AchvAuthorTypeVo;


/**
 * <p>
 * 科研成果作者类型 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmAchvAuthorTypeService extends BaseService<SrmAchvAuthorType> {
    @Transactional
    Long saveOrUpdateAchvAuthorType(BaseDataLearningDto baseDataLearningDto);

    AchvAuthorTypeVo getDetailAchvAuthorType(Long RowId);
    IPage<AchvAuthorTypeVo> listAchvAuthorType(AchvAuthorTypeDto achvAuthorTypeDto);

    void deleteAchvAuthorType(BaseDto baseDto);

    Long getIdByName(String name);
}
