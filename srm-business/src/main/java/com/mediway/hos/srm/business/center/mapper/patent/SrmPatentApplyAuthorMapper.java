package com.mediway.hos.srm.business.center.mapper.patent;

import org.apache.ibatis.annotations.Param;
import com.mediway.hos.srm.business.center.model.entity.patent.SrmPatentApplyAuthor;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.patent.PatentApplyAuthorVo;

import java.util.List;

/**
 * <p>
 * 专利申报作者表 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmPatentApplyAuthorMapper extends BaseMapper<SrmPatentApplyAuthor> {
    List<PatentApplyAuthorVo> listPatentApplyAuthor(@Param("patentApplyId") Long patentApplyId);
    void deleteAuthorByApplyId(@Param("patentApplyId") Long patentApplyId);
}
