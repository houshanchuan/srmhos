package com.mediway.hos.srm.business.center.service.monograph;

import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.center.model.dto.monograph.MonographAuthorDto;
import com.mediway.hos.srm.business.center.model.entity.monograph.SrmMonographInfoAuthor;
import com.mediway.hos.srm.business.base.service.BaseService;
import com.mediway.hos.srm.business.center.model.vo.monograph.MonographAuthorVo;

import java.util.List;

/**
 * <p>
 * 著作作者表 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-07-25
 */
public interface SrmMonographInfoAuthorService extends BaseService<SrmMonographInfoAuthor> {
    Long saveOrUpdateMonographAuthor(SrmMonographInfoAuthor monographInfoAuthor);
    List<MonographAuthorVo> ListMonographAuthor(Long monographId);
    void deleteAuthorByMon(Long monographId);
    void deleteMonographAuthor(BaseDto baseDto);
    List<Long> getIdByMon(Long parref);
    Long saveAuthor(MonographAuthorDto monographAuthorDto);
}
