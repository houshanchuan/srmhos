package com.mediway.hos.srm.business.center.service.paper;

import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.entity.paper.SrmPaperEmbody;
import com.mediway.hos.srm.business.base.service.BaseService;
import com.mediway.hos.srm.business.center.model.vo.paper.PaperAuthorVo;
import com.mediway.hos.srm.business.center.model.vo.paper.PaperEmbodyVo;

import java.util.List;

/**
 * <p>
 * 论文收录表 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmPaperEmbodyService extends BaseService<SrmPaperEmbody> {
    public List<PaperEmbodyVo> listPaperEmbody(BaseDto baseDto);
    void deletePaperEmbodyByPaper(Long paperId);
    void deletePaperEmbodyByIds(BaseDto baseDto);
}
