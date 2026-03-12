package com.mediway.hos.srm.business.center.service.baseData;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataUserDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;
import java.util.List;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;

import com.mediway.hos.srm.business.center.model.dto.baseData.EduLevelDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmEduLevel;
import com.mediway.hos.srm.business.center.model.vo.baseData.EduLevelVo;
/**
 * <p>
 * 学历表 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmEduLevelService extends BaseService<SrmEduLevel> {

    @Transactional
    Long saveOrUpdateEduLevel(BaseDataUserDto baseDataUserDto);

    EduLevelVo getDetailEduLevel(Long RowId);
    IPage<EduLevelVo> listEduLevel(EduLevelDto eduLevelDto);

    void deleteEduLevel(BaseDto baseDto);

    Long getIdByName(String name);

    List<CombVo> getEduLevel(EduLevelDto eduLevelDto);
}
