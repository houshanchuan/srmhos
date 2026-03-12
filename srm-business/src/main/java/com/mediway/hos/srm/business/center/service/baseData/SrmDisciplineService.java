package com.mediway.hos.srm.business.center.service.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataLearningDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;
import java.util.List;

import com.mediway.hos.srm.business.center.model.dto.baseData.DisciplineDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmDiscipline;
import com.mediway.hos.srm.business.center.model.vo.baseData.DisciplineVo;

/**
 * <p>
 * 学科表 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-07-19
 */
public interface SrmDisciplineService extends BaseService<SrmDiscipline> {
    @Transactional
    Long saveOrUpdateDiscipLine(BaseDataLearningDto baseDataLearningDto);

    DisciplineVo getDetailDiscipLine(Long RowId);
    IPage<DisciplineVo> listDiscipLine(DisciplineDto disciplineDto);

    void deleteDiscipLine(BaseDto baseDto);

    Long getIdByName(String name);

    List<CombVo> getDiscipline(String upCode,String classcode);
    List<CombVo> getDisciplineNew(DisciplineDto disciplineDto);
}
