package com.mediway.hos.srm.business.center.mapper.monograph;

import org.apache.ibatis.annotations.Param;
import com.mediway.hos.srm.business.center.model.entity.monograph.SrmMonographInfoAuthor;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.monograph.MonographAuthorVo;

import java.util.List;

/**
 * <p>
 * 著作作者表 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-07-25
 */
public interface SrmMonographInfoAuthorMapper extends BaseMapper<SrmMonographInfoAuthor> {
    List<MonographAuthorVo> ListMonographAuthor(@Param("monographId") Long monographId);
    void deleteAuthorByMon(@Param("monographId") Long monographId);

    List<Long> getIdByMon(@Param("parref") Long parref);
}
