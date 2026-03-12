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

import com.mediway.hos.srm.business.center.model.dto.baseData.AchvTransferTypeDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmAchvTransferType;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmAchvTransferTypeMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.AchvTransferTypeVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmAchvTransferTypeService;
/**
 * <p>
 * 成果转化类型 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmAchvTransferTypeServiceImpl extends BaseServiceImpl<SrmAchvTransferTypeMapper, SrmAchvTransferType> implements SrmAchvTransferTypeService {
    @Autowired
    private SrmAchvTransferTypeService  srmAchvTransferTypeService;
    @Autowired
    private SrmAchvTransferTypeMapper srmAchvTransferTypeMapper;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateAchvTransferType(BaseDataLearningDto baseDataLearningDto) {
        List<AchvTransferTypeDto> achvTransferTypeDtos =baseDataLearningDto.getAchvTransferTypes();

        List<SrmAchvTransferType> achvTransferTypeList=new ArrayList<>();
        for (AchvTransferTypeDto achvTransferTypeDto :achvTransferTypeDtos) {
            SrmAchvTransferType srmAchvTransferType = new SrmAchvTransferType();
            srmAchvTransferType.setId(achvTransferTypeDto.getRowId());
            srmAchvTransferType.setCode(achvTransferTypeDto.getCode());
            srmAchvTransferType.setName(achvTransferTypeDto.getName());
            srmAchvTransferType.setIsValid(Integer.valueOf(achvTransferTypeDto.getIsValid()));

            achvTransferTypeList.add(srmAchvTransferType);
            Long RowId = srmAchvTransferType.getId();
        }
        super.saveOrUpdateBatch(achvTransferTypeList);
        return RowId;
    }
    @Override
    public AchvTransferTypeVo getDetailAchvTransferType(Long RowId) {
        return null;
    }

    @Override
    public IPage<AchvTransferTypeVo> listAchvTransferType(AchvTransferTypeDto achvTransferTypeDto) {
        Page<AchvTransferTypeVo> page = new Page<>(achvTransferTypeDto.getPage(), achvTransferTypeDto.getRows());
        IPage<AchvTransferTypeVo> res= srmAchvTransferTypeMapper.listAchvTransferType(page, achvTransferTypeDto);
        //List<AchvTransferTypeVo> records=res.getRecords();
        //List<AchvTransferTypeVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteAchvTransferType(BaseDto baseDto) {
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
    public List<CombVo> getAchvTransferType() {
        return srmAchvTransferTypeMapper.getAchvTransferType();
    }
}
