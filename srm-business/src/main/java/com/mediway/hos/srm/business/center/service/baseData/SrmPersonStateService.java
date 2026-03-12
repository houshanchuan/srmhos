package com.mediway.hos.srm.business.center.service.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataUserDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;
import java.util.List;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;

import com.mediway.hos.srm.business.center.model.dto.baseData.PersonStateDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmPersonState;
import com.mediway.hos.srm.business.center.model.vo.baseData.PersonStateVo;

/**
 * <p>
 * 人员状态表 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmPersonStateService extends BaseService<SrmPersonState> {
    @Transactional
    Long saveOrUpdatePersonState(BaseDataUserDto baseDataUserDto);

    PersonStateVo getDetailPersonState(Long RowId);
    IPage<PersonStateVo> listPersonState(PersonStateDto personStateDto);

    void deletePersonState(BaseDto baseDto);

    Long getIdByName(String name);

    List<CombVo> getPersonState();
}
