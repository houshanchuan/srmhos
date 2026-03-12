package com.mediway.hos.srm.business.center.service.paper;

import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.dto.paper.PaperAuthorDto;
import com.mediway.hos.srm.business.center.model.entity.paper.SrmPaperAuthor;
import com.mediway.hos.srm.business.base.service.BaseService;
import com.mediway.hos.srm.business.center.model.vo.paper.PaperAuthorVo;

import java.util.List;

/**
 * <p>
 * 论文作者表 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmPaperAuthorService extends BaseService<SrmPaperAuthor> {
    public PaperAuthorVo getPaperAuthor(String rankCode,String corrAuthorFlag,String authorType);
    public int getAuthorCount(String paperId);
    public List<PaperAuthorVo> listPaperAuthor(BaseDto baseDto);
    void deleteAuthorByPaper(Long paperId);
    void deleteAuthorById(BaseDto baseDto);
    Long saveAuthor(PaperAuthorDto srmPaperAuthorDto);
}
