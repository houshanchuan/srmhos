package com.mediway.hos.srm.business.center.service.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataLearningDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;
import com.mediway.hos.srm.business.center.model.dto.baseData.PublishAddressTypeDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmPublishAddressType;
import com.mediway.hos.srm.business.center.model.vo.baseData.PublishAddressTypeVo;


/**
 * <p>
 * 发表地点类型表 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmPublishAddressTypeService extends BaseService<SrmPublishAddressType> {
    @Transactional
    Long saveOrUpdatePublishAddressType(BaseDataLearningDto baseDataLearningDto);

    PublishAddressTypeVo getDetailPublishAddressType(Long RowId);
    IPage<PublishAddressTypeVo> listPublishAddressType(PublishAddressTypeDto publishAddressTypeDto);

    void deletePublishAddressType(BaseDto baseDto);

    Long getIdByName(String name);
}
