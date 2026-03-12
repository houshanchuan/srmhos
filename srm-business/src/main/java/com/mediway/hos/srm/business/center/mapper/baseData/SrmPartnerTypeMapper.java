package com.mediway.hos.srm.business.center.mapper.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import java.util.List;

import com.mediway.hos.srm.business.center.model.dto.baseData.PartnerTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.PartnerTypeVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmPartnerType;
/**
 * <p>
 * 对方类型表 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmPartnerTypeMapper extends BaseMapper<SrmPartnerType> {
    IPage<PartnerTypeVo> listPartnerType(@Param("page") Page<PartnerTypeVo> page, @Param("partnerTypeDto") PartnerTypeDto partnerTypeDto);
    List<CombVo> getPartnerType();
}
