package com.mediway.hos.srm.business.center.mapper.baseData;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import java.util.List;

import com.mediway.hos.srm.business.center.model.dto.baseData.PolityDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmPolity;
import com.mediway.hos.srm.business.center.model.vo.baseData.PolityVo;


/**
 * <p>
 * 政治面貌 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmPolityMapper extends BaseMapper<SrmPolity> {
    IPage<PolityVo> listPolity(@Param("page") Page<PolityVo> page, @Param("polityDto") PolityDto polityDto);

    List<CombVo> getPolity();

}
