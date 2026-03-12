package com.mediway.hos.srm.business.center.mapper.baseData;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.dto.baseData.PubRangeDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmPubRange;
import com.mediway.hos.srm.business.center.model.vo.baseData.PubRangeVo;

/**
 * <p>
 * 发表范围 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmPubRangeMapper extends BaseMapper<SrmPubRange> {
    IPage<PubRangeVo> listPubRange(@Param("page") Page<PubRangeVo> page, @Param("pubRangeDto") PubRangeDto pubRangeDto);

}
