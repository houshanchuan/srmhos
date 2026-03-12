package com.mediway.hos.srm.business.center.mapper.patent;

import org.apache.ibatis.annotations.Param;
import com.mediway.hos.srm.business.center.model.entity.patent.SrmPatentInfoAuthor;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.patent.PatentInfoAuthorVo;

import java.util.List;

/**
 * <p>
 * 专利作者表 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmPatentInfoAuthorMapper extends BaseMapper<SrmPatentInfoAuthor> {
    List<PatentInfoAuthorVo> listPatentInfoAuthor(@Param("parentId") Long parentId);
    void deleteAuthorByParent(@Param("parentId") Long parentId);
}
