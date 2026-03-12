package com.mediway.hos.srm.business.center.service.patent;

import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.dto.patent.PatentApplyAuthorDto;
import com.mediway.hos.srm.business.center.model.entity.patent.SrmPatentApplyAuthor;
import com.mediway.hos.srm.business.base.service.BaseService;
import com.mediway.hos.srm.business.center.model.vo.patent.PatentApplyAuthorVo;

import java.util.List;

/**
 * <p>
 * 专利申报作者表 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmPatentApplyAuthorService extends BaseService<SrmPatentApplyAuthor> {
    void deleteAuthorByApplyId(Long patentApplyId);
    public List<PatentApplyAuthorVo> listPatentApplyAuthor(BaseDto baseDto);
    void deleteAuthorById(BaseDto baseDto);
    Long saveAuthor(PatentApplyAuthorDto patentApplyAuthorDto);
}
