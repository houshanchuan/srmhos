package com.mediway.hos.srm.business.center.mapper.academic;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.mediway.hos.srm.business.center.model.dto.academic.AcParttimeApplyDto;
import com.mediway.hos.srm.business.center.model.entity.academic.SrmAcParttimeApply;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.academic.AcParttimeApplyVo;

/**
 * <p>
 * 兼职申请表 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmAcParttimeApplyMapper extends BaseMapper<SrmAcParttimeApply> {
    AcParttimeApplyVo getDetail(@Param("rowId") Long rowId);
    IPage<AcParttimeApplyVo> listAcParttimeApply(@Param("page") Page<AcParttimeApplyVo> page, @Param("acParttimeApplyDto") AcParttimeApplyDto acParttimeApplyDto);
    void updateStatus(@Param("rowId") Long rowId,@Param("status") Integer status,@Param("checkStatus") String checkStatus);
    IPage<AcParttimeApplyVo> listAuditAcParttimeApply(@Param("page") Page<AcParttimeApplyVo> page, @Param("acParttimeApplyDto") AcParttimeApplyDto acParttimeApplyDto);

}
