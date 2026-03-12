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

import com.mediway.hos.srm.business.center.model.dto.baseData.ProjMidCheckListInfoStateDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ProjMidCheckListInfoStateVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmProjMidcheckListInfoState;
import com.mediway.hos.srm.business.center.service.baseData.SrmProjMidcheckListInfoStateService;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmProjMidcheckListInfoStateMapper;

/**
 * <p>
 * 项目中检批次状态表 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmProjMidcheckListInfoStateServiceImpl extends BaseServiceImpl<SrmProjMidcheckListInfoStateMapper, SrmProjMidcheckListInfoState> implements SrmProjMidcheckListInfoStateService {

    @Autowired
    private SrmProjMidcheckListInfoStateService  srmProjMidCheckListInfoStateService;
    @Autowired
    private SrmProjMidcheckListInfoStateMapper srmProjMidCheckListInfoStateMapper;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateProjMidCheckListInfoState(BaseDataCommonDto baseDataProjDto) {
        List<ProjMidCheckListInfoStateDto> projMidCheckListInfoStateDtos =baseDataProjDto.getProjMidCheckListInfoStates();

        List<SrmProjMidcheckListInfoState> projMidCheckListInfoStateList=new ArrayList<>();
        for (ProjMidCheckListInfoStateDto projMidCheckListInfoStateDto :projMidCheckListInfoStateDtos) {
            SrmProjMidcheckListInfoState srmProjMidCheckListInfoState = new SrmProjMidcheckListInfoState();
            srmProjMidCheckListInfoState.setId(projMidCheckListInfoStateDto.getRowId());
            srmProjMidCheckListInfoState.setCode(projMidCheckListInfoStateDto.getCode());
            srmProjMidCheckListInfoState.setName(projMidCheckListInfoStateDto.getName());
            srmProjMidCheckListInfoState.setIsValid(Integer.valueOf(projMidCheckListInfoStateDto.getIsValid()));

            projMidCheckListInfoStateList.add(srmProjMidCheckListInfoState);
            Long RowId = srmProjMidCheckListInfoState.getId();
        }
        super.saveOrUpdateBatch(projMidCheckListInfoStateList);
        return RowId;
    }
    @Override
    public ProjMidCheckListInfoStateVo getDetailProjMidCheckListInfoState(Long RowId) {
        return null;
    }

    @Override
    public IPage<ProjMidCheckListInfoStateVo> listProjMidCheckListInfoState(ProjMidCheckListInfoStateDto projMidCheckListInfoStateDto) {
        Page<ProjMidCheckListInfoStateVo> page = new Page<>(projMidCheckListInfoStateDto.getPage(), projMidCheckListInfoStateDto.getRows());
        IPage<ProjMidCheckListInfoStateVo> res= srmProjMidCheckListInfoStateMapper.listProjMidCheckListInfoState(page, projMidCheckListInfoStateDto);
        //List<ProjMidCheckListInfoStateVo> records=res.getRecords();
        //List<ProjMidCheckListInfoStateVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteProjMidCheckListInfoState(BaseDto baseDto) {
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
