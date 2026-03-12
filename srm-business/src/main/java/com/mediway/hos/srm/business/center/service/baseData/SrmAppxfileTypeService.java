package com.mediway.hos.srm.business.center.service.baseData;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.model.dto.baseData.AppxfileTypeDetailDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.BaseService;

import com.mediway.hos.srm.business.center.model.dto.baseData.AppxfileTypeDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.AppxfileTypeVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmAppxfileType;

/**
 * <p>
 * 附件文件类型定义表 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmAppxfileTypeService extends BaseService<SrmAppxfileType> {

    @Transactional
    Long saveOrUpdateAppxfileType(AppxfileTypeDto appxfileTypeDto);

    AppxfileTypeVo getDetailAppxfileType(Long RowId);
    IPage<AppxfileTypeVo> listAppxfileType(AppxfileTypeDetailDto appxfileTypeDetailDto);

    void deleteAppxfileType(BaseDto baseDto);

    Long getIdByName(String name);
}
