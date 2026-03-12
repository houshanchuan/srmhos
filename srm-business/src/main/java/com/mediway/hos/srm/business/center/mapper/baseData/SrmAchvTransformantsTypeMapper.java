package com.mediway.hos.srm.business.center.mapper.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.dto.baseData.AchvTransformantsTypeDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmAchvTransformantsType;
import com.mediway.hos.srm.business.center.model.vo.baseData.AchvTransformantsTypeVo;

/**
 * <p>
 * 成果转化物类型 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-01
 */
public interface SrmAchvTransformantsTypeMapper extends BaseMapper<SrmAchvTransformantsType> {
    IPage<AchvTransformantsTypeVo> listAchvTransformantsType(@Param("page") Page<AchvTransformantsTypeVo> page, @Param("achvTransformantsTypeDto") AchvTransformantsTypeDto achvTransformantsTypeDto);

}
