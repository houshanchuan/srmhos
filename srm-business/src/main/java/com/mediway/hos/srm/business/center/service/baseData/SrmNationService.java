package com.mediway.hos.srm.business.center.service.baseData;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataUserDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;
import java.util.List;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;

import com.mediway.hos.srm.business.center.model.dto.baseData.NationDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmNation;
import com.mediway.hos.srm.business.center.model.vo.baseData.NationVo;
/**
 * <p>
 * 民族代码表 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmNationService extends BaseService<SrmNation> {
    @Transactional
    Long saveOrUpdateNation(BaseDataUserDto baseDataUserDto);

    NationVo getDetailNation(Long RowId);
    IPage<NationVo> listNation(NationDto nationDto);

    void deleteNation(BaseDto baseDto);

    Long getIdByName(String name);

    List<CombVo> getNation(NationDto nationDto);
}
