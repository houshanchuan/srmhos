package com.mediway.hos.srm.business.center.mapper.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.mediway.hos.srm.business.center.model.dto.baseData.PaperSciPartitionDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmPaperSciPartition;
import com.mediway.hos.srm.business.center.model.vo.baseData.PaperSciPartitionVo;
/**
 * <p>
 * SCI论文分区 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmPaperSciPartitionMapper extends BaseMapper<SrmPaperSciPartition> {

    IPage<PaperSciPartitionVo> listPaperSciPartition(@Param("page") Page<PaperSciPartitionVo> page, @Param("paperSciPartitionDto") PaperSciPartitionDto paperSciPartitionDto);
}
