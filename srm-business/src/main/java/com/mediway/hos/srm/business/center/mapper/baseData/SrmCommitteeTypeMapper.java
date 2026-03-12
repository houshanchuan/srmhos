package com.mediway.hos.srm.business.center.mapper.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.mediway.hos.srm.business.center.model.dto.baseData.CommitteeTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.CommitteeTypeVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmCommitteeType;


/**
 * <p>
 * 学会类型 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmCommitteeTypeMapper extends BaseMapper<SrmCommitteeType> {


    IPage<CommitteeTypeVo> listCommitteeType(@Param("page") Page<CommitteeTypeVo> page, @Param("committeeTypeDto") CommitteeTypeDto committeeTypeDto);


}
