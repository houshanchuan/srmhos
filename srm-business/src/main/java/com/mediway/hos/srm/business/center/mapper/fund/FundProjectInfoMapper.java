package com.mediway.hos.srm.business.center.mapper.fund;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import java.util.List;

import com.mediway.hos.srm.business.center.model.dto.fund.FundProjectInfoDto;
import com.mediway.hos.srm.business.center.model.vo.fund.FundProjectInfoVo;
import com.mediway.hos.srm.business.center.model.entity.fund.FundProjectInfo;

/**
 * <p>
 * 项目字典表 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-25
 */
public interface FundProjectInfoMapper extends BaseMapper<FundProjectInfo> {
    IPage<FundProjectInfoVo> listFundProjectInfo(@Param("page") Page<FundProjectInfoVo> page, @Param("fundProjectInfoDto") FundProjectInfoDto fundProjectInfoDto);
    List<CombVo> getProject() ;
}
