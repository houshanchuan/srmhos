package com.mediway.hos.srm.business.center.service.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataUserDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;
import java.util.List;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import com.mediway.hos.srm.business.center.model.dto.baseData.TutorTypeDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmTutorType;
import com.mediway.hos.srm.business.center.model.vo.baseData.TutorTypeVo;
/**
 * <p>
 * 指导老师类型 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmTutorTypeService extends BaseService<SrmTutorType> {
    @Transactional
    Long saveOrUpdateTutorType(BaseDataUserDto baseDataUserDto);

    TutorTypeVo getDetailTutorType(Long RowId);
    IPage<TutorTypeVo> listTutorType(TutorTypeDto tutorTypeDto);

    void deleteTutorType(BaseDto baseDto);

    Long getIdByName(String name);

    List<CombVo> getTutorType();
}
