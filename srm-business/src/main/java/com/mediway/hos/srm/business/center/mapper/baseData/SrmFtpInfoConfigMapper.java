package com.mediway.hos.srm.business.center.mapper.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.mediway.hos.srm.business.center.model.dto.baseData.FtpInfoConfigDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.FtpInfoConfigVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmFtpInfoConfig;
/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmFtpInfoConfigMapper extends BaseMapper<SrmFtpInfoConfig> {

    IPage<FtpInfoConfigVo> listFtpInfoConfig(@Param("page") Page<FtpInfoConfigVo> page, @Param("ftpInfoConfigDto") FtpInfoConfigDto ftpInfoConfigDto);


}
