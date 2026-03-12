package com.mediway.hos.srm.business.center.service.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataProjDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;
import java.util.List;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;

import com.mediway.hos.srm.business.center.model.dto.baseData.ProjTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ProjTypeVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmProjType;

/**
 * <p>
 * 项目分类表（父） 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmProjTypeService extends BaseService<SrmProjType> {

    @Transactional
    Long saveOrUpdateProjType(BaseDataProjDto baseDataProjDto);

    ProjTypeVo getDetailProjType(Long RowId);
    IPage<ProjTypeVo> listProjType(ProjTypeDto projTypeDto);

    void deleteProjType(BaseDto baseDto);

    Long getIdByName(String name);

    List<CombVo> getProjectType(ProjTypeDto projTypeDto);

}
