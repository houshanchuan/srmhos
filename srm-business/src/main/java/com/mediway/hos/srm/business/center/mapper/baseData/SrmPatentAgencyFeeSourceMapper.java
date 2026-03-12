package com.mediway.hos.srm.business.center.mapper.baseData;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import java.util.List;

import com.mediway.hos.srm.business.center.model.dto.baseData.PatentAgencyFeeSourceDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmPatentAgencyFeeSource;
import com.mediway.hos.srm.business.center.model.vo.baseData.PatentAgencyFeeSourceVo;

/**
 * <p>
 * 专利代理费用来源 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmPatentAgencyFeeSourceMapper extends BaseMapper<SrmPatentAgencyFeeSource> { 
	List<CombVo> getPatentAgencyFeeSource(@Param("patentAgencyFeeSourceDto") PatentAgencyFeeSourceDto patentAgencyFeeSourceDto);

    IPage<PatentAgencyFeeSourceVo> listPatentAgencyFeeSource(@Param("page") Page<PatentAgencyFeeSourceVo> page, @Param("patentAgencyFeeSourceDto") PatentAgencyFeeSourceDto patentAgencyFeeSourceDto);

}
