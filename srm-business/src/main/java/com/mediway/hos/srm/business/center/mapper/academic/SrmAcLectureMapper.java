package com.mediway.hos.srm.business.center.mapper.academic;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import com.mediway.hos.srm.business.center.model.dto.academic.AcLectureDto;
import com.mediway.hos.srm.business.center.model.entity.academic.SrmAcLecture;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.academic.AcLectureVo;

/**
 * <p>
 * 学术讲座 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmAcLectureMapper extends BaseMapper<SrmAcLecture> {
    AcLectureVo getDetail(@Param("rowId") Long rowId);
    IPage<AcLectureVo> listAcLecture(@Param("page") Page<AcLectureVo> page, @Param("acLectureDto") AcLectureDto acLectureDto);
    void updateStatus(@Param("rowId") Long rowId,@Param("status") Integer status,@Param("checkStatus") String checkStatus);
    IPage<AcLectureVo> listAuditAcLecture(@Param("page") Page<AcLectureVo> page, @Param("acLectureDto") AcLectureDto acLectureDto);

}
