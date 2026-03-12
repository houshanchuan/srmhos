package com.mediway.hos.srm.business.center.service.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataUserDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;

import com.mediway.hos.srm.business.center.model.dto.baseData.CommitteeTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.CommitteeTypeVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmCommitteeType;

/**
 * <p>
 * 学会类型 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmCommitteeTypeService extends BaseService<SrmCommitteeType> {

    @Transactional
    Long saveOrUpdateCommitteeType(BaseDataUserDto baseDataUserDto);

    CommitteeTypeVo getDetailCommitteeType(Long RowId);
    IPage<CommitteeTypeVo> listCommitteeType(CommitteeTypeDto committeeTypeDto);

    void deleteCommitteeType(BaseDto baseDto);

    Long getIdByName(String name);
}
