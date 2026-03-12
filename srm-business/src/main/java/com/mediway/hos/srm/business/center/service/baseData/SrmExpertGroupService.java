package com.mediway.hos.srm.business.center.service.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataUserDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;
import java.util.List;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;

import com.mediway.hos.srm.business.center.model.dto.baseData.ExpertGroupDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ExpertGroupVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmExpertGroup;


/**
 * <p>
 * 专家组 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmExpertGroupService extends BaseService<SrmExpertGroup> {

    @Transactional
    Long saveOrUpdateSrmExpertGroup(BaseDataUserDto baseDataUserDto);

    ExpertGroupVo getDetailSrmExpertGroup(Long RowId);
    IPage<ExpertGroupVo> listSrmExpertGroup(ExpertGroupDto expertGroupDto);

    void deleteSrmExpertGroup(BaseDto baseDto);

    Long getIdByName(String name);

    List<CombVo> getExpertGroup();
}
