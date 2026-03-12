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

import com.mediway.hos.srm.business.center.model.dto.baseData.AchvTransAgreementTypeDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmAchvTransAgreementType;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmAchvTransAgreementTypeMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.AchvTransAgreementTypeVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmAchvTransAgreementTypeService;

/**
 * <p>
 * 转化协议类型表 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-01
 */
@Service
public class SrmAchvTransAgreementTypeServiceImpl extends BaseServiceImpl<SrmAchvTransAgreementTypeMapper, SrmAchvTransAgreementType> implements SrmAchvTransAgreementTypeService {

    @Autowired
    private SrmAchvTransAgreementTypeService  srmAchvTransAgreementTypeService;
    @Autowired
    private SrmAchvTransAgreementTypeMapper srmAchvTransAgreementTypeMapper;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateAchvTransAgreementType(BaseDataLearningDto baseDataLearningDto) {
        List<AchvTransAgreementTypeDto> achvTransAgreementTypeDtos =baseDataLearningDto.getAchvTransAgreementTypes();

        List<SrmAchvTransAgreementType> achvTransAgreementTypeList=new ArrayList<>();
        for (AchvTransAgreementTypeDto achvTransAgreementTypeDto :achvTransAgreementTypeDtos) {
            SrmAchvTransAgreementType srmAchvTransAgreementType = new SrmAchvTransAgreementType();
            srmAchvTransAgreementType.setId(achvTransAgreementTypeDto.getRowId());
            srmAchvTransAgreementType.setCode(achvTransAgreementTypeDto.getCode());
            srmAchvTransAgreementType.setName(achvTransAgreementTypeDto.getName());
            srmAchvTransAgreementType.setIsValid(Integer.valueOf(achvTransAgreementTypeDto.getIsValid()));

            achvTransAgreementTypeList.add(srmAchvTransAgreementType);
            Long RowId = srmAchvTransAgreementType.getId();
        }
        super.saveOrUpdateBatch(achvTransAgreementTypeList);
        return RowId;
    }
    @Override
    public AchvTransAgreementTypeVo getDetailAchvTransAgreementType(Long RowId) {
        return null;
    }

    @Override
    public IPage<AchvTransAgreementTypeVo> listAchvTransAgreementType(AchvTransAgreementTypeDto achvTransAgreementTypeDto) {
        Page<AchvTransAgreementTypeVo> page = new Page<>(achvTransAgreementTypeDto.getPage(), achvTransAgreementTypeDto.getRows());
        IPage<AchvTransAgreementTypeVo> res= srmAchvTransAgreementTypeMapper.listAchvTransAgreementType(page, achvTransAgreementTypeDto);
        //List<AchvTransAgreementTypeVo> records=res.getRecords();
        //List<AchvTransAgreementTypeVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteAchvTransAgreementType(BaseDto baseDto) {
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
    public List<CombVo> getAchvTransAgreementType() {
        return srmAchvTransAgreementTypeMapper.getAchvTransAgreementType();
    }
}
