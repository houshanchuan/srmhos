package com.mediway.hos.srm.business.center.mapper.baseData;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.dto.baseData.EafCheckStatusDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.EafCheckStatusVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmEafCheckStatus;
/**
 * <p>
 * 审批流审核结果代码 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmEafCheckStatusMapper extends BaseMapper<SrmEafCheckStatus> {

    IPage<EafCheckStatusVo> listEafCheckStatus(@Param("page") Page<EafCheckStatusVo> page, @Param("eafCheckStatusDto") EafCheckStatusDto eafCheckStatusDto);

}
