package com.mediway.hos.srm.business.center.mapper.paper;

import com.mediway.hos.srm.business.center.model.entity.paper.SrmPaperEmbody;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.paper.PaperAuthorVo;
import com.mediway.hos.srm.business.center.model.vo.paper.PaperEmbodyVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 论文收录表 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmPaperEmbodyMapper extends BaseMapper<SrmPaperEmbody> {
    List<PaperEmbodyVo> listPaperEmbody(@Param("paperId") Long paperId);
    void deletePaperEmbodyByPaper(@Param("paperId") Long paperId);
}
