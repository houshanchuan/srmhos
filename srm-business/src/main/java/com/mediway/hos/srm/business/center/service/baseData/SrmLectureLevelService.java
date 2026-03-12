package com.mediway.hos.srm.business.center.service.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataLearningDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;

import com.mediway.hos.srm.business.center.model.dto.baseData.LectureLevelDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.LectureLevelVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmLectureLevel;

import java.util.List;


/**
 * <p>
 * 讲座级别 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmLectureLevelService extends BaseService<SrmLectureLevel> {

    @Transactional
    Long saveOrUpdateLectureLevel(BaseDataLearningDto baseDataLearningDto);

    LectureLevelVo getDetailLectureLevel(Long RowId);
    IPage<LectureLevelVo> listLectureLevel(LectureLevelDto lectureLevelDto);

    void deleteLectureLevel(BaseDto baseDto);

    Long getIdByName(String name);
    List<CombVo> getLectureLevel();
}
