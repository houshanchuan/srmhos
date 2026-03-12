package com.mediway.hos.srm.business.center.mapper.baseData;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import java.util.List;

import com.mediway.hos.srm.business.center.model.dto.baseData.EduLevelDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmEduLevel;
import com.mediway.hos.srm.business.center.model.vo.baseData.EduLevelVo;

/**
 * <p>
 * 学历表 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmEduLevelMapper extends BaseMapper<SrmEduLevel> {
    List<CombVo> getEduLevel(@Param("eduLevelDto") EduLevelDto eduLevelDto);

    IPage<EduLevelVo> listEduLevel(@Param("page") Page<EduLevelVo> page, @Param("eduLevelDto") EduLevelDto eduLevelDto);
}
