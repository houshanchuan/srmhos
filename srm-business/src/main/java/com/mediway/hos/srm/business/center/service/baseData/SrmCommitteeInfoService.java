package com.mediway.hos.srm.business.center.service.baseData;

import com.mediway.hos.srm.business.center.model.entity.baseData.SrmCommitteeInfo;
import com.mediway.hos.srm.business.base.service.BaseService;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;

import java.util.List;

/**
 * <p>
 * 学会信息表 服务类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmCommitteeInfoService extends BaseService<SrmCommitteeInfo> {
    List<CombVo> getCommitteeInfo();
}
