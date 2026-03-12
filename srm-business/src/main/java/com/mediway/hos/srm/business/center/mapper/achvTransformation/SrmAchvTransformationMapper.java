package com.mediway.hos.srm.business.center.mapper.achvTransformation;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.mediway.hos.srm.business.center.model.dto.achvTransformation.AchvTransformationDto;
import com.mediway.hos.srm.business.center.model.entity.achvTransformation.SrmAchvTransformation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.achvTransformation.AchvTransformationVo;

/**
 * <p>
 * 成果转化申请表 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmAchvTransformationMapper extends BaseMapper<SrmAchvTransformation> {
    AchvTransformationVo getDetail(@Param("rowId") String rowId);
    IPage<AchvTransformationVo> listAchvTransformation(@Param("page") Page<AchvTransformationVo> page, @Param("achvTransformationDto") AchvTransformationDto achvTransformationDto);
    void updateStatus(@Param("rowId") Long rowId,@Param("status") Integer status,@Param("transformNo") String transformNo);
    IPage<AchvTransformationVo> listAuditAchvTransformation(@Param("page") Page<AchvTransformationVo> page, @Param("achvTransformationDto") AchvTransformationDto achvTransformationDto);

}
