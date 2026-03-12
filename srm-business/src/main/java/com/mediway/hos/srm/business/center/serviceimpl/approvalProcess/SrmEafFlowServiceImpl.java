package com.mediway.hos.srm.business.center.serviceimpl.approvalProcess;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.exception.ErrorException;
import com.mediway.hos.srm.business.center.model.dto.approvalProcess.EafFlowDto;
import com.mediway.hos.srm.business.center.model.entity.approvalProcess.SrmEafFlow;
import com.mediway.hos.srm.business.center.mapper.approvalProcess.SrmEafFlowMapper;
import com.mediway.hos.srm.business.center.model.vo.approvalProcess.EafFlowVo;
import com.mediway.hos.srm.business.center.service.approvalProcess.SrmEafFlowService;
import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 各业务审批流定义 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-08-21
 */
@Service
public class SrmEafFlowServiceImpl extends BaseServiceImpl<SrmEafFlowMapper, SrmEafFlow> implements SrmEafFlowService {
    @Autowired
    private SrmEafFlowMapper srmEafFlowMapper;
    @Override
    public List<EafFlowVo> listEafFlow() {
        return srmEafFlowMapper.listEafFlow();
    }

    @Override
    @Transactional
    public void saveEafFlow(List<EafFlowDto> eafFlowDtos) {
        try{
            List<SrmEafFlow> srmEafFlowList =new ArrayList<>();
            for (EafFlowDto eafFlowDto :eafFlowDtos){
                SrmEafFlow srmEafFlow =new SrmEafFlow();
                srmEafFlow.setId(eafFlowDto.getRowId());
                srmEafFlow.setEafMainId(eafFlowDto.getEafMainId());
                srmEafFlow.setSysType(eafFlowDto.getSysType());
                srmEafFlow.setSysModuleId(eafFlowDto.getSysModuleId());
                srmEafFlowList.add(srmEafFlow);
            }
            super.saveOrUpdateBatch(srmEafFlowList);
        }catch (Exception exception){
            throw new ErrorException("-200",exception.getMessage());
        }
    }

    @Override
    public String getEafFlow(String sysNo, String typeId) {
        return srmEafFlowMapper.getEafFlow(sysNo,typeId);
    }
}
