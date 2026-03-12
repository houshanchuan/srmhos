package com.mediway.hos.srm.business.center.mapper.paper;

import org.apache.ibatis.annotations.Param;
import com.mediway.hos.srm.business.center.model.entity.paper.SrmPaperAuthor;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.paper.PaperAuthorVo;

import java.util.List;

/**
 * <p>
 * 论文作者表 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmPaperAuthorMapper extends BaseMapper<SrmPaperAuthor> {
    PaperAuthorVo getPaperAuthor(@Param("rankCode") String rankCode,@Param("corrAuthorFlag") String corrAuthorFlag,@Param("authorType") String authorType);
    int getAuthorCount(@Param("paperId") String paperId);

    List<PaperAuthorVo> listPaperAuthor(@Param("paperId") Long paperId);
    void deleteAuthorByPaper(@Param("paperId") Long paperId);

}
