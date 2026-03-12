package com.mediway.hos.srm.business.center.service.baseData;

import com.mediway.hos.srm.business.center.model.entity.baseData.SrmBusinessno;
import com.mediway.hos.srm.business.base.service.BaseService;

/**
 * <p>
 * 单号生成 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2025-02-14
 */
public interface SrmBusinessnoService extends BaseService<SrmBusinessno> {
    String getBusinessNo(String type, int size, String prefix);

    String test(String type, int size, String prefix1);
}
