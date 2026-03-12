package com.mediway.hos.srm.business.center.service.baseData;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataUserDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;

import com.mediway.hos.srm.business.center.model.dto.baseData.LanguageDegreeDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmLanguageDegree;
import com.mediway.hos.srm.business.center.model.vo.baseData.LanguageDegreeVo;

/**
 * <p>
 * 语言等级代码表 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmLanguageDegreeService extends BaseService<SrmLanguageDegree> {
    @Transactional
    Long saveOrUpdateLanguageDegree(BaseDataUserDto baseDataUserDto);

    LanguageDegreeVo getDetailLanguageDegree(Long RowId);
    IPage<LanguageDegreeVo> listLanguageDegree(LanguageDegreeDto languageDegreeDto);

    void deleteLanguageDegree(BaseDto baseDto);

    Long getIdByName(String name);
}
