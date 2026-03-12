package com.mediway.hos.srm.business.center.mapper.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import java.util.List;

import com.mediway.hos.srm.business.center.model.dto.baseData.AchvTransferTypeDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmAchvTransferType;
import com.mediway.hos.srm.business.center.model.vo.baseData.AchvTransferTypeVo;


/**
 * <p>
 * 成果转化类型 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmAchvTransferTypeMapper extends BaseMapper<SrmAchvTransferType> {
    IPage<AchvTransferTypeVo> listAchvTransferType(@Param("page") Page<AchvTransferTypeVo> page, @Param("achvTransferTypeDto") AchvTransferTypeDto achvTransferTypeDto);
    List<CombVo> getAchvTransferType();
}
