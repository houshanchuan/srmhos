package com.mediway.hos.srm.business.center.service.baseData;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataUserDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;


import com.mediway.hos.srm.business.center.model.dto.baseData.TitleLevelDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmTitleLevel;
import com.mediway.hos.srm.business.center.model.vo.baseData.TitleLevelVo;



/**
 * <p>
 * 职称级别 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmTitleLevelService extends BaseService<SrmTitleLevel> {
    @Transactional
    Long saveOrUpdateTitleLevel(BaseDataUserDto baseDataUserDto);

    TitleLevelVo getDetailTitleLevel(Long RowId);
    IPage<TitleLevelVo> listTitleLevel(TitleLevelDto titleLevelDto);

    void deleteTitleLevel(BaseDto baseDto);

    Long getIdByName(String name);
}
