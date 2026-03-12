package com.mediway.hos.srm.business.center.mapper.baseData;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.mediway.hos.srm.business.center.model.dto.baseData.PaperRewardeeTypeDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmRewardeeType;
import com.mediway.hos.srm.business.center.model.vo.baseData.PaperRewardeeTypeVo;
/**
 * <p>
 * 论文奖励作者类型 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmRewardeeTypeMapper extends BaseMapper<SrmRewardeeType> {
    IPage<PaperRewardeeTypeVo> listPaperRewardeeType(@Param("page") Page<PaperRewardeeTypeVo> page, @Param("paperRewardeeTypeDto") PaperRewardeeTypeDto paperRewardeeTypeDto);
}
