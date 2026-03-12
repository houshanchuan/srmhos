package com.mediway.hos.srm.business.center.service.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataUserDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;
import java.util.List;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;

import com.mediway.hos.srm.business.center.model.dto.baseData.EduDegreeDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmEduDegree;
import com.mediway.hos.srm.business.center.model.vo.baseData.EduDegreeVo;

/**
 * <p>
 * 学位表 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmEduDegreeService extends BaseService<SrmEduDegree> {
    @Transactional
    Long saveOrUpdateEduDegree(BaseDataUserDto baseDataUserDto);

    EduDegreeVo getDetailEduDegree(Long RowId);
    IPage<EduDegreeVo> listEduDegree(EduDegreeDto eduDegreeDto);

    void deleteEduDegree(BaseDto baseDto);

    Long getIdByName(String name);

    List<CombVo> getEduDegree(EduDegreeDto eduDegreeDto);

}
