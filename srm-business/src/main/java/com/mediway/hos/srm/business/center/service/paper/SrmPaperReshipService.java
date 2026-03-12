package com.mediway.hos.srm.business.center.service.paper;

import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.entity.paper.SrmPaperReship;
import com.mediway.hos.srm.business.base.service.BaseService;
import com.mediway.hos.srm.business.center.model.vo.paper.PaperEmbodyVo;
import com.mediway.hos.srm.business.center.model.vo.paper.PaperReshipVo;

import java.util.List;

/**
 * <p>
 * 论文转载表 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmPaperReshipService extends BaseService<SrmPaperReship> {
    public List<PaperReshipVo> listPaperReship(BaseDto baseDto);
    void deletePaperReshipByPaper(Long paperId);
    void deletePaperReshipByIds(BaseDto baseDto);
}
