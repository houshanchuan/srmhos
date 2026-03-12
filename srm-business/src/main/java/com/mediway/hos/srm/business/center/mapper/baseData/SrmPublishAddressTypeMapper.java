package com.mediway.hos.srm.business.center.mapper.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.mediway.hos.srm.business.center.model.dto.baseData.PublishAddressTypeDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmPublishAddressType;
import com.mediway.hos.srm.business.center.model.vo.baseData.PublishAddressTypeVo;
/**
 * <p>
 * 发表地点类型表 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmPublishAddressTypeMapper extends BaseMapper<SrmPublishAddressType> {
    IPage<PublishAddressTypeVo> listPublishAddressType(@Param("page") Page<PublishAddressTypeVo> page, @Param("publishAddressTypeDto") PublishAddressTypeDto publishAddressTypeDto);

}
