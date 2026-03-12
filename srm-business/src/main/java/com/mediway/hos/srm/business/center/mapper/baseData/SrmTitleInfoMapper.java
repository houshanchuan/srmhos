package com.mediway.hos.srm.business.center.mapper.baseData;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import java.util.List;


import com.mediway.hos.srm.business.center.model.dto.baseData.TitleInfoDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmTitleInfo;
import com.mediway.hos.srm.business.center.model.vo.baseData.TitleInfoVo;

/**
 * <p>
 * 职称表 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmTitleInfoMapper extends BaseMapper<SrmTitleInfo> {
    List<CombVo> getUserTitle(@Param("titleInfoDto")  TitleInfoDto titleInfoDto);
    IPage<TitleInfoVo> listTitleInfo(@Param("page") Page<TitleInfoVo> page, @Param("titleInfoDto") TitleInfoDto titleInfoDto);
}
