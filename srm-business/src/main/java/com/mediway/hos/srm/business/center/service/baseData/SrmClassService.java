package com.mediway.hos.srm.business.center.service.baseData;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataLearningDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;
import java.util.List;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;

import com.mediway.hos.srm.business.center.model.dto.baseData.SubjectClassDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmClass;
import com.mediway.hos.srm.business.center.model.vo.baseData.SubjectClassVo;
/**
 * <p>
 * 学科门类 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-07-25
 */
public interface SrmClassService extends BaseService<SrmClass> {
    @Transactional
    Long saveOrUpdateSubjectClass(BaseDataLearningDto baseDataLearningDto);

    SubjectClassVo getDetailSubjectClass(Long RowId);
    IPage<SubjectClassVo> listSubjectClass(SubjectClassDto subjectClassDto);

    void deleteSubjectClass(BaseDto baseDto);

    Long getIdByName(String name);
    List<CombVo> getSubjectClass();
}
