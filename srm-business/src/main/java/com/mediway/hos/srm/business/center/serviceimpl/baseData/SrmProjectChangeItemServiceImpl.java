package com.mediway.hos.srm.business.center.serviceimpl.baseData;

import org.springframework.beans.factory.annotation.Autowired;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmProjectChangeItem;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmProjectChangeItemMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmProjectChangeItemService;
import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 项目变更内容表 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmProjectChangeItemServiceImpl extends BaseServiceImpl<SrmProjectChangeItemMapper, SrmProjectChangeItem> implements SrmProjectChangeItemService {
    @Autowired
    private SrmProjectChangeItemMapper srmProjectChangeItemMapper;
    @Override
    public List<CombVo> getProjectChangeItem() {
        return srmProjectChangeItemMapper.getProjectChangeItem();
    }
}
