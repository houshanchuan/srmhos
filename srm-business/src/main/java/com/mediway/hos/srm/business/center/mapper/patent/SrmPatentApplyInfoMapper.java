package com.mediway.hos.srm.business.center.mapper.patent;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.mediway.hos.srm.business.center.model.dto.patent.PatentApplyInfoDto;
import com.mediway.hos.srm.business.center.model.entity.patent.SrmPatentApplyInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.patent.PatentApplyInfoVo;

/**
 * <p>
 * 专利申报批次 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmPatentApplyInfoMapper extends BaseMapper<SrmPatentApplyInfo> {
    PatentApplyInfoVo getDetail(@Param("rowId") Long RowId);
    IPage<PatentApplyInfoVo> listPatentApplyInfo(@Param("page") Page<PatentApplyInfoVo> page, @Param("patentApplyInfoDto") PatentApplyInfoDto patentApplyInfoDto);

}
