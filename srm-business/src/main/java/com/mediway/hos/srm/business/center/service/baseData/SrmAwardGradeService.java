package com.mediway.hos.srm.business.center.service.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataLearningDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;
import java.util.List;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;

import com.mediway.hos.srm.business.center.model.dto.baseData.AwardGradeDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmAwardGrade;
import com.mediway.hos.srm.business.center.model.vo.baseData.AwardGradeVo;


/**
 * <p>
 * 获奖等次 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmAwardGradeService extends BaseService<SrmAwardGrade> {		  
	public List<CombVo> getAwardGrade();
    @Transactional
    Long saveOrUpdateAwardGrade(BaseDataLearningDto baseDataLearningDto);

    AwardGradeVo getDetailAwardGrade(Long RowId);
    IPage<AwardGradeVo> listAwardGrade(AwardGradeDto awardGradeDto);

    void deleteAwardGrade(BaseDto baseDto);

    Long getIdByName(String name);
}
