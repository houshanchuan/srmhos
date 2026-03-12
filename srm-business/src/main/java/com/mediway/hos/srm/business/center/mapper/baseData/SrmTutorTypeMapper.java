package com.mediway.hos.srm.business.center.mapper.baseData;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import java.util.List;

import com.mediway.hos.srm.business.center.model.dto.baseData.TutorTypeDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmTutorType;
import com.mediway.hos.srm.business.center.model.vo.baseData.TutorTypeVo;

/**
 * <p>
 * 指导老师类型 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmTutorTypeMapper extends BaseMapper<SrmTutorType> {
    IPage<TutorTypeVo> listTutorType(@Param("page") Page<TutorTypeVo> page, @Param("tutorTypeDto") TutorTypeDto tutorTypeDto);

    List<CombVo> getTutorType();
}
