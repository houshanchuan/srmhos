package com.mediway.hos.srm.business.center.serviceimpl.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.alibaba.druid.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.exception.ErrorException;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataCommonDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


import com.mediway.hos.srm.business.center.model.dto.baseData.EafCheckStatusDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.EafCheckStatusVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmEafCheckStatus;
import com.mediway.hos.srm.business.center.service.baseData.SrmEafCheckStatusService;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmEafCheckStatusMapper;

/**
 * <p>
 * 审批流审核结果代码 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmEafCheckStatusServiceImpl extends BaseServiceImpl<SrmEafCheckStatusMapper, SrmEafCheckStatus> implements SrmEafCheckStatusService {
    @Autowired
    private SrmEafCheckStatusMapper srmEafCheckStatusMapper;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateEafCheckStatus(BaseDataCommonDto baseDataProjDto) {
        List<EafCheckStatusDto> eafCheckStatusDtos =baseDataProjDto.getEafCheckStatuss();

        List<SrmEafCheckStatus> eafCheckStatusList=new ArrayList<>();
        for (EafCheckStatusDto eafCheckStatusDto :eafCheckStatusDtos) {
            SrmEafCheckStatus srmEafCheckStatus = new SrmEafCheckStatus();
            srmEafCheckStatus.setId(eafCheckStatusDto.getRowId());
            srmEafCheckStatus.setCode(eafCheckStatusDto.getCode());
            srmEafCheckStatus.setName(eafCheckStatusDto.getName());
            srmEafCheckStatus.setIsValid(Integer.valueOf(eafCheckStatusDto.getIsValid()));

            eafCheckStatusList.add(srmEafCheckStatus);
            Long RowId = srmEafCheckStatus.getId();
        }
        super.saveOrUpdateBatch(eafCheckStatusList);
        return RowId;
    }
    @Override
    public EafCheckStatusVo getDetailEafCheckStatus(Long RowId) {
        return null;
    }

    @Override
    public IPage<EafCheckStatusVo> listEafCheckStatus(EafCheckStatusDto eafCheckStatusDto) {
        Page<EafCheckStatusVo> page = new Page<>(eafCheckStatusDto.getPage(), eafCheckStatusDto.getRows());
        IPage<EafCheckStatusVo> res= srmEafCheckStatusMapper.listEafCheckStatus(page, eafCheckStatusDto);
        //List<EafCheckStatusVo> records=res.getRecords();
        //List<EafCheckStatusVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteEafCheckStatus(BaseDto baseDto) {
        List<Long> idList=baseDto.getIdList();
        String idStr="";
        try{
            for (Long RowId : idList) {
                //System.out.println(RowId);
                if(StringUtils.isEmpty(idStr)){
                    idStr=String.valueOf(RowId);
                }else{
                    idStr=idStr+","+String.valueOf(RowId);
                }
            }
            super.deleteByIds(idStr);
        }catch (Exception exception){
            throw  new ErrorException("-200",exception.getMessage());
        }
    }

    @Override
    public Long getIdByName(String name) {
        return null;
    }
}
