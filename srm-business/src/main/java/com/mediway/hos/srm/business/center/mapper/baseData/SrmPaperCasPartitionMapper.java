package com.mediway.hos.srm.business.center.mapper.baseData;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.dto.baseData.PaperCASPartitionDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmPaperCasPartition;
import com.mediway.hos.srm.business.center.model.vo.baseData.PaperCASPartitionVo;


/**
 * <p>
 * 中科院论文分区 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmPaperCasPartitionMapper extends BaseMapper<SrmPaperCasPartition> {
    IPage<PaperCASPartitionVo> listPaperCasPartition(@Param("page") Page<PaperCASPartitionVo> page, @Param("paperCASPartitionDto") PaperCASPartitionDto paperCASPartitionDto);

}
