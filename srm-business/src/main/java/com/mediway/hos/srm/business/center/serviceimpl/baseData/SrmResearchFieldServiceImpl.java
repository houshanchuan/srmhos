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
import com.mediway.hos.srm.business.center.model.vo.baseData.CombVo;
import com.mediway.hos.srm.business.center.model.dto.baseData.ResearchFieldDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmResearchField;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmResearchFieldMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.ResearchFieldVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmResearchFieldService;

/**
 * <p>
 * 研究领域 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmResearchFieldServiceImpl extends BaseServiceImpl<SrmResearchFieldMapper, SrmResearchField> implements SrmResearchFieldService {
    @Autowired
    private SrmResearchFieldService  srmResearchFieldService;
    @Autowired
    private SrmResearchFieldMapper srmResearchFieldMapper;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateResearchField(BaseDataLearningDto baseDataLearningDto) {
        List<ResearchFieldDto> researchFieldDtos =baseDataLearningDto.getResearchFields();

        List<SrmResearchField> researchFieldList=new ArrayList<>();
        for (ResearchFieldDto researchFieldDto :researchFieldDtos) {
            SrmResearchField srmResearchField = new SrmResearchField();
            srmResearchField.setId(researchFieldDto.getRowId());
            srmResearchField.setCode(researchFieldDto.getCode());
            srmResearchField.setName(researchFieldDto.getName());
            srmResearchField.setIsValid(Integer.valueOf(researchFieldDto.getIsValid()));

            researchFieldList.add(srmResearchField);
            Long RowId = srmResearchField.getId();
        }
        super.saveOrUpdateBatch(researchFieldList);
        return RowId;
    }
    @Override
    public ResearchFieldVo getDetailResearchField(Long RowId) {
        return null;
    }

    @Override
    public IPage<ResearchFieldVo> listResearchField(ResearchFieldDto researchFieldDto) {
        Page<ResearchFieldVo> page = new Page<>(researchFieldDto.getPage(), researchFieldDto.getRows());
        IPage<ResearchFieldVo> res= srmResearchFieldMapper.listResearchField(page, researchFieldDto);
        //List<ResearchFieldVo> records=res.getRecords();
        //List<ResearchFieldVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteResearchField(BaseDto baseDto) {
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
    public List<CombVo> getResearchField(ResearchFieldDto researchFieldDto) {
        return srmResearchFieldMapper.getResearchField(researchFieldDto);
    }

}
