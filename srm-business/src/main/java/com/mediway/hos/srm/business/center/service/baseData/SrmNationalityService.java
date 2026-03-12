package com.mediway.hos.srm.business.center.service.baseData;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataUserDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;
import java.util.List;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;

import com.mediway.hos.srm.business.center.model.dto.baseData.NationalityDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmNationality;
import com.mediway.hos.srm.business.center.model.vo.baseData.NationalityVo;

/**
 * <p>
 * 国籍代码表 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmNationalityService extends BaseService<SrmNationality> {
    @Transactional
    Long saveOrUpdateNationality(BaseDataUserDto baseDataUserDto);

    NationalityVo getDetailNationality(Long RowId);
    IPage<NationalityVo> listNationality(NationalityDto nationalityDto);

    void deleteNationality(BaseDto baseDto);

    Long getIdByName(String name);

    List<CombVo> getNationality(NationalityDto nationalityDto);


}
