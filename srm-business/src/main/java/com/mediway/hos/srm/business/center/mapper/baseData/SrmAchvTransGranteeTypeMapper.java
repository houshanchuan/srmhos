package com.mediway.hos.srm.business.center.mapper.baseData;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;


import com.mediway.hos.srm.business.center.model.dto.baseData.AchvTransGranteeTypeDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmAchvTransGranteeType;
import com.mediway.hos.srm.business.center.model.vo.baseData.AchvTransGranteeTypeVo;


/**
 * <p>
 * 成果转化受让单位类型 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmAchvTransGranteeTypeMapper extends BaseMapper<SrmAchvTransGranteeType> {
    IPage<AchvTransGranteeTypeVo> listAchvTransGranteeType(@Param("page") Page<AchvTransGranteeTypeVo> page, @Param("achvTransGranteeTypeDto") AchvTransGranteeTypeDto achvTransGranteeTypeDto);

}
