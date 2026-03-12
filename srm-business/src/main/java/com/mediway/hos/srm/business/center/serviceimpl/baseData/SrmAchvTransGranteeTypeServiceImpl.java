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

import com.mediway.hos.srm.business.center.model.dto.baseData.AchvTransGranteeTypeDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmAchvTransGranteeType;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmAchvTransGranteeTypeMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.AchvTransGranteeTypeVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmAchvTransGranteeTypeService;

/**
 * <p>
 * 成果转化受让单位类型 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmAchvTransGranteeTypeServiceImpl extends BaseServiceImpl<SrmAchvTransGranteeTypeMapper, SrmAchvTransGranteeType> implements SrmAchvTransGranteeTypeService {
    @Autowired
    private SrmAchvTransGranteeTypeService  srmAchvTransGranteeTypeService;
    @Autowired
    private SrmAchvTransGranteeTypeMapper srmAchvTransGranteeTypeMapper;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateAchvTransGranteeType(BaseDataLearningDto baseDataLearningDto) {
        List<AchvTransGranteeTypeDto> achvTransGranteeTypeDtos =baseDataLearningDto.getAchvTransGranteeTypes();

        List<SrmAchvTransGranteeType> achvTransGranteeTypeList=new ArrayList<>();
        for (AchvTransGranteeTypeDto achvTransGranteeTypeDto :achvTransGranteeTypeDtos) {
            SrmAchvTransGranteeType srmAchvTransGranteeType = new SrmAchvTransGranteeType();
            srmAchvTransGranteeType.setId(achvTransGranteeTypeDto.getRowId());
            srmAchvTransGranteeType.setCode(achvTransGranteeTypeDto.getCode());
            srmAchvTransGranteeType.setName(achvTransGranteeTypeDto.getName());
            srmAchvTransGranteeType.setIsValid(Integer.valueOf(achvTransGranteeTypeDto.getIsValid()));

            achvTransGranteeTypeList.add(srmAchvTransGranteeType);
            Long RowId = srmAchvTransGranteeType.getId();
        }
        super.saveOrUpdateBatch(achvTransGranteeTypeList);
        return RowId;
    }
    @Override
    public AchvTransGranteeTypeVo getDetailAchvTransGranteeType(Long RowId) {
        return null;
    }

    @Override
    public IPage<AchvTransGranteeTypeVo> listAchvTransGranteeType(AchvTransGranteeTypeDto achvTransGranteeTypeDto) {
        Page<AchvTransGranteeTypeVo> page = new Page<>(achvTransGranteeTypeDto.getPage(), achvTransGranteeTypeDto.getRows());
        IPage<AchvTransGranteeTypeVo> res= srmAchvTransGranteeTypeMapper.listAchvTransGranteeType(page, achvTransGranteeTypeDto);
        //List<AchvTransGranteeTypeVo> records=res.getRecords();
        //List<AchvTransGranteeTypeVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteAchvTransGranteeType(BaseDto baseDto) {
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
