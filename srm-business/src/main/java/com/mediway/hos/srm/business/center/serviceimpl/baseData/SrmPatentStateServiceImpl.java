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
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import com.mediway.hos.srm.business.center.model.dto.baseData.PatentStateDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.PatentStateVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmPatentState;
import com.mediway.hos.srm.business.center.service.baseData.SrmPatentStateService;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmPatentStateMapper;

/**
 * <p>
 * 专利状态 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmPatentStateServiceImpl extends BaseServiceImpl<SrmPatentStateMapper, SrmPatentState> implements SrmPatentStateService {

    @Autowired
    private SrmPatentStateService  srmPatentStateService;
    @Autowired
    private SrmPatentStateMapper srmPatentStateMapper;
    private Long RowId;	 
    @Override
    public List<CombVo> getPatentState() {
        return srmPatentStateMapper.getPatentState();
    }
    @Override
    @Transactional
    public Long saveOrUpdatePatentState(BaseDataCommonDto baseDataProjDto) {
        List<PatentStateDto> patentStateDtos =baseDataProjDto.getPatentStates();

        List<SrmPatentState> patentStateList=new ArrayList<>();
        for (PatentStateDto patentStateDto :patentStateDtos) {
            SrmPatentState srmPatentState = new SrmPatentState();
            srmPatentState.setId(patentStateDto.getRowId());
            srmPatentState.setCode(patentStateDto.getCode());
            srmPatentState.setName(patentStateDto.getName());
            srmPatentState.setIsValid(Integer.valueOf(patentStateDto.getIsValid()));

            patentStateList.add(srmPatentState);
            Long RowId = srmPatentState.getId();
        }
        super.saveOrUpdateBatch(patentStateList);
        return RowId;
    }
    @Override
    public PatentStateVo getDetailPatentState(Long RowId) {
        return null;
    }

    @Override
    public IPage<PatentStateVo> listPatentState(PatentStateDto patentStateDto) {
        Page<PatentStateVo> page = new Page<>(patentStateDto.getPage(), patentStateDto.getRows());
        IPage<PatentStateVo> res= srmPatentStateMapper.listPatentState(page, patentStateDto);
        //List<PatentStateVo> records=res.getRecords();
        //List<PatentStateVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deletePatentState(BaseDto baseDto) {
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
