package com.mediway.hos.srm.business.center.serviceimpl.baseData;

import org.springframework.beans.factory.annotation.Autowired;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmCommitteeInfo;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmCommitteeInfoMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmCommitteeInfoService;
import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 学会信息表 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmCommitteeInfoServiceImpl extends BaseServiceImpl<SrmCommitteeInfoMapper, SrmCommitteeInfo> implements SrmCommitteeInfoService {
    @Autowired
    private SrmCommitteeInfoMapper srmCommitteeInfoMapper;
    @Override
    public List<CombVo> getCommitteeInfo() {
        return srmCommitteeInfoMapper.getCommitteeInfo();
    }
}
