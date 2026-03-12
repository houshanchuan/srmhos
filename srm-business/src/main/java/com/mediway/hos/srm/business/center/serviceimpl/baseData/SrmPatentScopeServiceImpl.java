package com.mediway.hos.srm.business.center.serviceimpl.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.alibaba.druid.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.exception.ErrorException;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataLearningDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

import com.mediway.hos.srm.business.center.model.dto.baseData.PatentScopeDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmPatentScope;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmPatentScopeMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.PatentScopeVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmPatentScopeService;
/**
 * <p>
 * 专利范围 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmPatentScopeServiceImpl extends BaseServiceImpl<SrmPatentScopeMapper, SrmPatentScope> implements SrmPatentScopeService {
    @Autowired
    private SrmPatentScopeService  srmPatentScopeService;
    @Autowired
    private SrmPatentScopeMapper srmPatentScopeMapper;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdatePatentScope(BaseDataLearningDto baseDataLearningDto) {
        List<PatentScopeDto> patentScopeDtos =baseDataLearningDto.getPatentScopes();

        List<SrmPatentScope> patentScopeList=new ArrayList<>();
        for (PatentScopeDto patentScopeDto :patentScopeDtos) {
            SrmPatentScope srmPatentScope = new SrmPatentScope();
            srmPatentScope.setId(patentScopeDto.getRowId());
            srmPatentScope.setCode(patentScopeDto.getCode());
            srmPatentScope.setName(patentScopeDto.getName());
            srmPatentScope.setIsValid(Integer.valueOf(patentScopeDto.getIsValid()));

            patentScopeList.add(srmPatentScope);
            Long RowId = srmPatentScope.getId();
        }
        super.saveOrUpdateBatch(patentScopeList);
        return RowId;
    }
    @Override
    public PatentScopeVo getDetailPatentScope(Long RowId) {
        return null;
    }

    @Override
    public IPage<PatentScopeVo> listPatentScope(PatentScopeDto patentScopeDto) {
        Page<PatentScopeVo> page = new Page<>(patentScopeDto.getPage(), patentScopeDto.getRows());
        IPage<PatentScopeVo> res= srmPatentScopeMapper.listPatentScope(page, patentScopeDto);
        //List<PatentScopeVo> records=res.getRecords();
        //List<PatentScopeVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deletePatentScope(BaseDto baseDto) {
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
