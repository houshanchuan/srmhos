package com.mediway.hos.srm.business.center.mapper.paper;

import com.mediway.hos.srm.business.center.model.entity.paper.SrmPaperReship;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.paper.PaperEmbodyVo;
import com.mediway.hos.srm.business.center.model.vo.paper.PaperReshipVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 论文转载表 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmPaperReshipMapper extends BaseMapper<SrmPaperReship> {
    List<PaperReshipVo> listPaperReship(@Param("paperId") Long paperId);
    void deletePaperReshipByPaper(@Param("paperId") Long paperId);
}
