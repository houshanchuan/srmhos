package com.mediway.hos.srm.business.center.mapper.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import java.util.List;
import com.mediway.hos.srm.business.center.model.dto.baseData.PressInfoDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmPressInfo;
import com.mediway.hos.srm.business.center.model.vo.baseData.PressInfoVo;

/**
 * <p>
 * 出版社信息 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-07-24
 */
public interface SrmPressInfoMapper extends BaseMapper<SrmPressInfo> {
    IPage<PressInfoVo> listPressInfo(@Param("page") Page<PressInfoVo> page, @Param("pressInfoDto") PressInfoDto pressInfoDto);
    List<CombVo> getPressInfo();
}
