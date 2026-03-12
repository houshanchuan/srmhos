package com.mediway.hos.srm.business.center.mapper.baseData;

import com.mediway.hos.srm.business.center.model.entity.baseData.SrmCommitteeInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;

import java.util.List;

/**
 * <p>
 * 学会信息表 Mapper 接口
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
public interface SrmCommitteeInfoMapper extends BaseMapper<SrmCommitteeInfo> {
    List<CombVo> getCommitteeInfo();
}
