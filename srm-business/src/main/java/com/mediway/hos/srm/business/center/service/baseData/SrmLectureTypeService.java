package com.mediway.hos.srm.business.center.service.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataLearningDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;

import com.mediway.hos.srm.business.center.model.dto.baseData.LectureTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.LectureTypeVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmLectureType;

import java.util.List;


/**
 * <p>
 * 讲座类型 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmLectureTypeService extends BaseService<SrmLectureType> {

    @Transactional
    Long saveOrUpdateLectureType(BaseDataLearningDto baseDataLearningDto);

    LectureTypeVo getDetailLectureType(Long RowId);
    IPage<LectureTypeVo> listLectureType(LectureTypeDto lectureTypeDto);

    void deleteLectureType(BaseDto baseDto);

    Long getIdByName(String name);
    List<CombVo> getLectureType();
}
