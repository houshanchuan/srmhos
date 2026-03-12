package com.mediway.hos.srm.business.center.serviceimpl.baseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.alibaba.druid.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.mediway.hos.srm.business.center.exception.ErrorException;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDataProjDto;
import com.mediway.hos.srm.business.center.model.dto.baseData.BaseDto;
import com.mediway.hos.srm.business.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;

import com.mediway.hos.srm.business.center.model.dto.baseData.NationalEconomyIndustryDto;
import com.mediway.hos.srm.business.center.model.vo.baseData.NationalEconomyIndustryVo;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmNationalEconomyIndustry;
import com.mediway.hos.srm.business.center.service.baseData.SrmNationalEconomyIndustryService;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmNationalEconomyIndustryMapper;

/**
 * <p>
 * 国民经济行业 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmNationalEconomyIndustryServiceImpl extends BaseServiceImpl<SrmNationalEconomyIndustryMapper, SrmNationalEconomyIndustry> implements SrmNationalEconomyIndustryService {

    @Autowired
    private SrmNationalEconomyIndustryService  srmNationalEconomyIndustryService;
    @Autowired
    private SrmNationalEconomyIndustryMapper srmNationalEconomyIndustryMapper;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateNationalEconomyIndustry(BaseDataProjDto baseDataProjDto) {
        List<NationalEconomyIndustryDto> nationalEconomyIndustryDtos =baseDataProjDto.getNationalEconomyIndustrys();

        List<SrmNationalEconomyIndustry> nationalEconomyIndustryList=new ArrayList<>();
        for (NationalEconomyIndustryDto nationalEconomyIndustryDto :nationalEconomyIndustryDtos) {
            SrmNationalEconomyIndustry srmNationalEconomyIndustry = new SrmNationalEconomyIndustry();
            srmNationalEconomyIndustry.setId(nationalEconomyIndustryDto.getRowId());
            srmNationalEconomyIndustry.setCode(nationalEconomyIndustryDto.getCode());
            srmNationalEconomyIndustry.setName(nationalEconomyIndustryDto.getName());
            srmNationalEconomyIndustry.setIsValid(Integer.valueOf(nationalEconomyIndustryDto.getIsValid()));

            nationalEconomyIndustryList.add(srmNationalEconomyIndustry);
            Long RowId = srmNationalEconomyIndustry.getId();
        }
        super.saveOrUpdateBatch(nationalEconomyIndustryList);
        return RowId;
    }
    @Override
    public NationalEconomyIndustryVo getDetailNationalEconomyIndustry(Long RowId) {
        return null;
    }

    @Override
    public IPage<NationalEconomyIndustryVo> listNationalEconomyIndustry(NationalEconomyIndustryDto nationalEconomyIndustryDto) {
        Page<NationalEconomyIndustryVo> page = new Page<>(nationalEconomyIndustryDto.getPage(), nationalEconomyIndustryDto.getRows());
        IPage<NationalEconomyIndustryVo> res= srmNationalEconomyIndustryMapper.listNationalEconomyIndustry(page, nationalEconomyIndustryDto);
        //List<NationalEconomyIndustryVo> records=res.getRecords();
        //List<NationalEconomyIndustryVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteNationalEconomyIndustry(BaseDto baseDto) {
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

    @Override
    public List<CombVo> getNationalEconomyIndustry(String upCode) {
        return srmNationalEconomyIndustryMapper.getNationalEconomyIndustry(upCode);
    }

    @Override
    public List<CombVo> getNationalEconomyIndustryNew(NationalEconomyIndustryDto nationalEconomyIndustryDto) {
        return srmNationalEconomyIndustryMapper.getNationalEconomyIndustryNew(nationalEconomyIndustryDto);
    }
}
