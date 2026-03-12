package com.mediway.hos.srm.business.center.service.baseData;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataUserDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;
import java.util.List;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;

import com.mediway.hos.srm.business.center.model.dto.baseData.PersonTypeDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmPersonType;
import com.mediway.hos.srm.business.center.model.vo.baseData.PersonTypeVo;

/**
 * <p>
 * 人员类型 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-07-24
 */
public interface SrmPersonTypeService extends BaseService<SrmPersonType> {
    List<CombVo> getPersonType();
    @Transactional
    Long saveOrUpdatePersonType(BaseDataUserDto baseDataUserDto);

    PersonTypeVo getDetailPersonType(Long RowId);
    IPage<PersonTypeVo> listPersonType(PersonTypeDto personTypeDto);

    void deletePersonType(BaseDto baseDto);

    Long getIdByName(String name);
}
