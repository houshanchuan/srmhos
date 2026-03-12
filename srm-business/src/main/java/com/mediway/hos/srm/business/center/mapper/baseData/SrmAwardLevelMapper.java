package com.mediway.hos.srm.business.center.mapper.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import java.util.List;
import com.mediway.hos.srm.business.center.model.dto.baseData.AwardLevelDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmAwardLevel;
import com.mediway.hos.srm.business.center.model.vo.baseData.AwardLevelVo;

/**
 * <p>
 * 获奖级别 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmAwardLevelMapper extends BaseMapper<SrmAwardLevel> { 
 	List<CombVo> getAwardLevel();

    IPage<AwardLevelVo> listAwardLevel(@Param("page") Page<AwardLevelVo> page, @Param("awardLevelDto") AwardLevelDto awardLevelDto);

}
