package com.mediway.hos.srm.business.center.mapper.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import java.util.List;

import com.mediway.hos.srm.business.center.model.dto.baseData.PersonTypeDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmPersonType;
import com.mediway.hos.srm.business.center.model.vo.baseData.PersonTypeVo;

/**
 * <p>
 * 人员类型 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-07-24
 */
public interface SrmPersonTypeMapper extends BaseMapper<SrmPersonType> {
    List<CombVo> getPersonType();
    IPage<PersonTypeVo> listPersonType(@Param("page") Page<PersonTypeVo> page, @Param("personTypeDto") PersonTypeDto personTypeDto);
}
