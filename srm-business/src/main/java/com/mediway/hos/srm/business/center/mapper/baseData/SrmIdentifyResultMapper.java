package com.mediway.hos.srm.business.center.mapper.baseData;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.mediway.hos.srm.business.center.model.dto.baseData.IdentifyResultDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.IdentifyResultVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmIdentifyResult;


/**
 * <p>
 * 鉴定结果（结论） Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmIdentifyResultMapper extends BaseMapper<SrmIdentifyResult> {
    IPage<IdentifyResultVo> listIdentifyResult(@Param("page") Page<IdentifyResultVo> page, @Param("identifyResultDto") IdentifyResultDto identifyResultDto);

}
