package com.mediway.hos.srm.business.center.mapper.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import java.util.List;

import com.mediway.hos.srm.business.center.model.dto.baseData.HospitalDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.HospitalVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmHospital;

/**
 * <p>
 * 医疗机构(医院)表 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-25
 */
public interface SrmHospitalMapper extends BaseMapper<SrmHospital> {

    IPage<HospitalVo> listSrmHospital(@Param("page") Page<HospitalVo> page, @Param("srmHospitalDto") HospitalDto srmHospitalDto);

    List<CombVo> getHospital();
}
