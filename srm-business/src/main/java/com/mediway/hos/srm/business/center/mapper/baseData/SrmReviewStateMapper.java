package com.mediway.hos.srm.business.center.mapper.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.mediway.hos.srm.business.center.model.dto.baseData.ReviewStateDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ReviewStateVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmReviewState;


/**
 * <p>
 * 评审状态 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmReviewStateMapper extends BaseMapper<SrmReviewState> {

    IPage<ReviewStateVo> listReviewState(@Param("page") Page<ReviewStateVo> page, @Param("ReviewStateDto") ReviewStateDto ReviewStateDto);

}
