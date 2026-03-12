package com.mediway.hos.srm.business.center.mapper.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import java.util.List;

import com.mediway.hos.srm.business.center.model.dto.baseData.PaperAuthorOrderDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmPaperAuthorOrder;
import com.mediway.hos.srm.business.center.model.vo.baseData.PaperAuthorOrderVo;
/**
 * <p>
 * 论文作者排序 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-07-24
 */
public interface SrmPaperAuthorOrderMapper extends BaseMapper<SrmPaperAuthorOrder> {
    List<CombVo> getPaperAuthorOrder();
    IPage<PaperAuthorOrderVo> listPaperAuthorOrder(@Param("page") Page<PaperAuthorOrderVo> page, @Param("paperAuthorOrderDto") PaperAuthorOrderDto paperAuthorOrderDto);

}
