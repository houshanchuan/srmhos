package com.mediway.hos.srm.business.center.mapper.baseData;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import java.util.List;

import com.mediway.hos.srm.business.center.model.dto.baseData.ReimbursementWayDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmReimbursementWay;
import com.mediway.hos.srm.business.center.model.vo.baseData.ReimbursementWayVo;


/**
 * <p>
 * 报销途径 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmReimbursementWayMapper extends BaseMapper<SrmReimbursementWay> {
    List<CombVo> getReimbursementWay();
    IPage<ReimbursementWayVo> listReimbursementWay(@Param("page") Page<ReimbursementWayVo> page, @Param("reimbursementWayDto") ReimbursementWayDto reimbursementWayDto);

}
