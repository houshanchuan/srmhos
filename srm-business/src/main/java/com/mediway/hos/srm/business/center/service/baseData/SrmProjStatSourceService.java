package com.mediway.hos.srm.business.center.service.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataProjDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;
import java.util.List;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;


import com.mediway.hos.srm.business.center.model.dto.baseData.ProjStatSourceDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ProjStatSourceVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmProjStatSource;

/**
 * <p>
 * 项目来源表 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmProjStatSourceService extends BaseService<SrmProjStatSource> {
    @Transactional
    Long saveOrUpdateProjStatSource(BaseDataProjDto baseDataProjDto);

    ProjStatSourceVo getDetailProjStatSource(Long RowId);
    IPage<ProjStatSourceVo> listProjStatSource(ProjStatSourceDto projStatSourceDto);

    void deleteProjStatSource(BaseDto baseDto);

    Long getIdByName(String name);
    List<CombVo> getProjStatSource();

}
