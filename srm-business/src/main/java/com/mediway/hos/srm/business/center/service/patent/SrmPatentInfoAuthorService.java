package com.mediway.hos.srm.business.center.service.patent;

import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.dto.patent.PatentInfoAuthorDto;
import com.mediway.hos.srm.business.center.model.entity.patent.SrmPatentInfoAuthor;
import com.mediway.hos.srm.business.base.service.BaseService;
import com.mediway.hos.srm.business.center.model.vo.patent.PatentInfoAuthorVo;

import java.util.List;

/**
 * <p>
 * 专利作者表 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmPatentInfoAuthorService extends BaseService<SrmPatentInfoAuthor> {
    public List<PatentInfoAuthorVo> listPatentInfoAuthor(BaseDto baseDto);
    void deleteAuthorByParent(Long parentId);
    void deleteAuthorById(BaseDto baseDto);
    Long saveAuthor(PatentInfoAuthorDto patentInfoAuthorDto);
}
