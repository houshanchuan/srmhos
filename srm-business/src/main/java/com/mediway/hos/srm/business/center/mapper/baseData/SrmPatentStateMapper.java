package com.mediway.hos.srm.business.center.mapper.baseData;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import java.util.List;

import com.mediway.hos.srm.business.center.model.dto.baseData.PatentStateDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.PatentStateVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmPatentState;

/**
 * <p>
 * 专利状态 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmPatentStateMapper extends BaseMapper<SrmPatentState> {
	List<CombVo> getPatentState();

    IPage<PatentStateVo> listPatentState(@Param("page") Page<PatentStateVo> page, @Param("patentStateDto") PatentStateDto patentStateDto);

}
