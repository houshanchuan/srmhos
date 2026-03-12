package com.mediway.hos.srm.business.center.service.baseData;


import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataCommonDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;
import java.util.List;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;

import com.mediway.hos.srm.business.center.model.dto.baseData.GroupAuthConfigDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.GroupAuthConfigVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmGroupAuthConfig;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmGroupAuthConfigService extends BaseService<SrmGroupAuthConfig> {

    List<CombVo> getGroup();

    @Transactional
    Long saveOrUpdateGroupAuthConfig(BaseDataCommonDto baseDataProjDto);

    GroupAuthConfigVo getDetailGroupAuthConfig(Long RowId);
    IPage<GroupAuthConfigVo> listGroupAuthConfig(GroupAuthConfigDto groupAuthConfigDto);

    void deleteGroupAuthConfig(BaseDto baseDto);

    Long getIdByName(String name);
}
