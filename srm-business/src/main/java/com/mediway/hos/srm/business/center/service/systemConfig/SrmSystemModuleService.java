package com.mediway.hos.srm.business.center.service.systemConfig;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataCommonDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;
import java.util.List;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;

import com.mediway.hos.srm.business.center.model.dto.systemConfig.SystemModuleDto;
import com.mediway.hos.srm.business.center.model.vo.systemConfig.SystemModuleVo;
import com.mediway.hos.srm.business.center.model.entity.systemConfig.SrmSystemModule;


/**
 * <p>
 * 系统模块表 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-08-22
 */
public interface SrmSystemModuleService extends BaseService<SrmSystemModule> {
    @Transactional
    Long saveOrUpdateSystemModule(BaseDataCommonDto baseDataProjDto);

    SystemModuleVo getDetailSystemModule(Long RowId);
    IPage<SystemModuleVo> listSystemModule(SystemModuleDto systemModuleDto);

    void deleteSystemModule(BaseDto baseDto);

    Long getIdByName(String name);

    List<CombVo> getSystemModule();

}
