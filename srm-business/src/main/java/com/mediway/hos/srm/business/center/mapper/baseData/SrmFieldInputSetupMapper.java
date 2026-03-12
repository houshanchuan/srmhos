package com.mediway.hos.srm.business.center.mapper.baseData;

import org.apache.ibatis.annotations.Param;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmFieldInputSetup;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.FieldInputSetUpVo;

import java.util.List;

/**
 * <p>
 * 字段输入属性设置 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-13
 */
public interface SrmFieldInputSetupMapper extends BaseMapper<SrmFieldInputSetup> {
    List<FieldInputSetUpVo> getFieldInputSetup(@Param("sysNo") String sysNo);
    Long getRowIdBySysField(@Param("sysNo") String sysNo,@Param("fieldId") String fieldId);
    void deleteFieldInputSet(@Param("sysNo") String sysNo);
}
