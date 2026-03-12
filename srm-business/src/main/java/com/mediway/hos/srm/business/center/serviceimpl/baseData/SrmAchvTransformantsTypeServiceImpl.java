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

import com.mediway.hos.srm.business.center.model.dto.baseData.AchvTransformantsTypeDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmAchvTransformantsType;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmAchvTransformantsTypeMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.AchvTransformantsTypeVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmAchvTransformantsTypeService;


/**
 * <p>
 * 成果转化物类型 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-11-01
 */
@Service
public class SrmAchvTransformantsTypeServiceImpl extends BaseServiceImpl<SrmAchvTransformantsTypeMapper, SrmAchvTransformantsType> implements SrmAchvTransformantsTypeService {
    @Autowired
    private SrmAchvTransformantsTypeService  srmAchvTransformantsTypeService;
    @Autowired
    private SrmAchvTransformantsTypeMapper srmAchvTransformantsTypeMapper;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateAchvTransformantsType(BaseDataLearningDto baseDataLearningDto) {
        List<AchvTransformantsTypeDto> achvTransformantsTypeDtos =baseDataLearningDto.getAchvTransformantsTypes();

        List<SrmAchvTransformantsType> achvTransformantsTypeList=new ArrayList<>();
        for (AchvTransformantsTypeDto achvTransformantsTypeDto :achvTransformantsTypeDtos) {
            SrmAchvTransformantsType srmAchvTransformantsType = new SrmAchvTransformantsType();
            srmAchvTransformantsType.setId(achvTransformantsTypeDto.getRowId());
            srmAchvTransformantsType.setCode(achvTransformantsTypeDto.getCode());
            srmAchvTransformantsType.setName(achvTransformantsTypeDto.getName());
            srmAchvTransformantsType.setIsValid(Integer.valueOf(achvTransformantsTypeDto.getIsValid()));

            achvTransformantsTypeList.add(srmAchvTransformantsType);
            Long RowId = srmAchvTransformantsType.getId();
        }
        super.saveOrUpdateBatch(achvTransformantsTypeList);
        return RowId;
    }
    @Override
    public AchvTransformantsTypeVo getDetailAchvTransformantsType(Long RowId) {
        return null;
    }

    @Override
    public IPage<AchvTransformantsTypeVo> listAchvTransformantsType(AchvTransformantsTypeDto achvTransformantsTypeDto) {
        Page<AchvTransformantsTypeVo> page = new Page<>(achvTransformantsTypeDto.getPage(), achvTransformantsTypeDto.getRows());
        IPage<AchvTransformantsTypeVo> res= srmAchvTransformantsTypeMapper.listAchvTransformantsType(page, achvTransformantsTypeDto);
        //List<AchvTransformantsTypeVo> records=res.getRecords();
        //List<AchvTransformantsTypeVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteAchvTransformantsType(BaseDto baseDto) {
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
