package com.mediway.hos.srm.business.center.mapper.baseData;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import java.util.List;

import com.mediway.hos.srm.business.center.model.dto.baseData.YearDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.YearVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmYear;

/**
 * <p>
 * 年度 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-07-19
 */
public interface SrmYearMapper extends BaseMapper<SrmYear> {
    List<CombVo> getYear(@Param("yearDto") YearDto yearDto);
    void saveYear(SrmYear year);
    IPage<YearVo> listYear(@Param("page") Page<YearVo> page, @Param("yearDto") YearDto yearDto);

}
