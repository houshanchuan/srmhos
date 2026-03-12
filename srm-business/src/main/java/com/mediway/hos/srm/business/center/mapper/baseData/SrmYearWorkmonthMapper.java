package com.mediway.hos.srm.business.center.mapper.baseData;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.dto.baseData.YearWorkMonthDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.YearWorkMonthVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmYearWorkmonth;

/**
 * <p>
 * 年工作量 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmYearWorkmonthMapper extends BaseMapper<SrmYearWorkmonth> {
    IPage<YearWorkMonthVo> listYearWorkMonth(@Param("page") Page<YearWorkMonthVo> page, @Param("yearWorkMonthDto") YearWorkMonthDto yearWorkMonthDto);

}
