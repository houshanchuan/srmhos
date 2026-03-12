package com.mediway.hos.srm.business.center.service.baseData;

import com.mediway.hos.srm.business.center.model.dto.baseData.FieldInputSetupDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.FieldInputSetupListDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmFieldInputSetup;
import com.mediway.hos.srm.business.base.service.BaseService;
import com.mediway.hos.srm.business.center.model.vo.baseData.FieldInputSetUpVo;

import java.util.List;

/**
 * <p>
 * 字段输入属性设置 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-13
 */
public interface SrmFieldInputSetupService extends BaseService<SrmFieldInputSetup> {

    void initFieldInputSetup(FieldInputSetupListDto fieldInputSetupListDto);
    void saveFieldInputSetup(FieldInputSetupListDto fieldInputSetupListDto);

    List<FieldInputSetUpVo> getFieldInputSetup(FieldInputSetupDto fieldInputSetupDto);

    void deleteFieldInputSet(FieldInputSetupDto fieldInputSetupDto);
}
