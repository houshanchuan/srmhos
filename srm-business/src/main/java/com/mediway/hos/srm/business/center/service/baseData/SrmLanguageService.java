package com.mediway.hos.srm.business.center.service.baseData;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataUserDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;
import java.util.List;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;

import com.mediway.hos.srm.business.center.model.dto.baseData.LanguageDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmLanguage;
import com.mediway.hos.srm.business.center.model.vo.baseData.LanguageVo;

/**
 * <p>
 * 语言代码表 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-07-24
 */
public interface SrmLanguageService extends BaseService<SrmLanguage> {
    List<CombVo> getLanguage(LanguageDto languageDto);
    Long saveOrUpdateLanguage(BaseDataUserDto baseDataUserDto);

    LanguageVo getDetailLanguage(Long RowId);
    IPage<LanguageVo> listLanguage(LanguageDto languageDto);

    void deleteLanguage(BaseDto baseDto);

    Long getIdByName(String name);
}
