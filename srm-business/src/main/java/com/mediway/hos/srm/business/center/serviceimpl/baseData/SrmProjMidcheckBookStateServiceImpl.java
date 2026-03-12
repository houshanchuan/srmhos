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

import com.mediway.hos.srm.business.center.model.dto.baseData.ProjMidCheckBookStateDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.ProjMidCheckBookStateVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmProjMidcheckBookState;
import com.mediway.hos.srm.business.center.service.baseData.SrmProjMidcheckBookStateService;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmProjMidcheckBookStateMapper;

/**
 * <p>
 * 项目中检状态表 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmProjMidcheckBookStateServiceImpl extends BaseServiceImpl<SrmProjMidcheckBookStateMapper, SrmProjMidcheckBookState> implements SrmProjMidcheckBookStateService {

    @Autowired
    private SrmProjMidcheckBookStateService  srmProjMidCheckBookStateService;
    @Autowired
    private SrmProjMidcheckBookStateMapper srmProjMidCheckBookStateMapper;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateProjMidCheckBookState(BaseDataCommonDto baseDataProjDto) {
        List<ProjMidCheckBookStateDto> projMidCheckBookStateDtos =baseDataProjDto.getProjMidCheckBookStates();

        List<SrmProjMidcheckBookState> projMidCheckBookStateList=new ArrayList<>();
        for (ProjMidCheckBookStateDto projMidCheckBookStateDto :projMidCheckBookStateDtos) {
            SrmProjMidcheckBookState srmProjMidCheckBookState = new SrmProjMidcheckBookState();
            srmProjMidCheckBookState.setId(projMidCheckBookStateDto.getRowId());
            srmProjMidCheckBookState.setCode(projMidCheckBookStateDto.getCode());
            srmProjMidCheckBookState.setName(projMidCheckBookStateDto.getName());
            srmProjMidCheckBookState.setIsValid(Integer.valueOf(projMidCheckBookStateDto.getIsValid()));

            projMidCheckBookStateList.add(srmProjMidCheckBookState);
            Long RowId = srmProjMidCheckBookState.getId();
        }
        super.saveOrUpdateBatch(projMidCheckBookStateList);
        return RowId;
    }
    @Override
    public ProjMidCheckBookStateVo getDetailProjMidCheckBookState(Long RowId) {
        return null;
    }

    @Override
    public IPage<ProjMidCheckBookStateVo> listProjMidCheckBookState(ProjMidCheckBookStateDto projMidCheckBookStateDto) {
        Page<ProjMidCheckBookStateVo> page = new Page<>(projMidCheckBookStateDto.getPage(), projMidCheckBookStateDto.getRows());
        IPage<ProjMidCheckBookStateVo> res= srmProjMidCheckBookStateMapper.listProjMidCheckBookState(page, projMidCheckBookStateDto);
        //List<ProjMidCheckBookStateVo> records=res.getRecords();
        //List<ProjMidCheckBookStateVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteProjMidCheckBookState(BaseDto baseDto) {
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
