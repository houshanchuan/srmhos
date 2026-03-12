package com.mediway.hos.srm.business.center.mapper.baseData;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import java.util.List;
import com.mediway.hos.srm.business.center.model.dto.baseData.EduDegreeDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmEduDegree;
import com.mediway.hos.srm.business.center.model.vo.baseData.EduDegreeVo;
/**
 * <p>
 * 学位表 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmEduDegreeMapper extends BaseMapper<SrmEduDegree> {
    List<CombVo> getEduDegree(@Param("eduDegreeDto") EduDegreeDto eduDegreeDto);
    IPage<EduDegreeVo> listEduDegree(@Param("page") Page<EduDegreeVo> page, @Param("eduDegreeDto") EduDegreeDto eduDegreeDto);
}
