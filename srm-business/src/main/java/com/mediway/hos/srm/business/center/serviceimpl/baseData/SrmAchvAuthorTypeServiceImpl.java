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

import com.mediway.hos.srm.business.center.model.dto.baseData.AchvAuthorTypeDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmAchvAuthorType;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmAchvAuthorTypeMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.AchvAuthorTypeVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmAchvAuthorTypeService;
/**
 * <p>
 * 科研成果作者类型 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmAchvAuthorTypeServiceImpl extends BaseServiceImpl<SrmAchvAuthorTypeMapper, SrmAchvAuthorType> implements SrmAchvAuthorTypeService {
    @Autowired
    private SrmAchvAuthorTypeService  srmAchvAuthorTypeService;
    @Autowired
    private SrmAchvAuthorTypeMapper srmAchvAuthorTypeMapper;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateAchvAuthorType(BaseDataLearningDto baseDataLearningDto) {
        List<AchvAuthorTypeDto> achvAuthorTypeDtos =baseDataLearningDto.getAchvAuthorTypes();

        List<SrmAchvAuthorType> achvAuthorTypeList=new ArrayList<>();
        for (AchvAuthorTypeDto achvAuthorTypeDto :achvAuthorTypeDtos) {
            SrmAchvAuthorType srmAchvAuthorType = new SrmAchvAuthorType();
            srmAchvAuthorType.setId(achvAuthorTypeDto.getRowId());
            srmAchvAuthorType.setCode(achvAuthorTypeDto.getCode());
            srmAchvAuthorType.setName(achvAuthorTypeDto.getName());
            srmAchvAuthorType.setIsValid(Integer.valueOf(achvAuthorTypeDto.getIsValid()));

            achvAuthorTypeList.add(srmAchvAuthorType);
            Long RowId = srmAchvAuthorType.getId();
        }
        super.saveOrUpdateBatch(achvAuthorTypeList);
        return RowId;
    }
    @Override
    public AchvAuthorTypeVo getDetailAchvAuthorType(Long RowId) {
        return null;
    }

    @Override
    public IPage<AchvAuthorTypeVo> listAchvAuthorType(AchvAuthorTypeDto achvAuthorTypeDto) {
        Page<AchvAuthorTypeVo> page = new Page<>(achvAuthorTypeDto.getPage(), achvAuthorTypeDto.getRows());
        IPage<AchvAuthorTypeVo> res= srmAchvAuthorTypeMapper.listAchvAuthorType(page, achvAuthorTypeDto);
        //List<AchvAuthorTypeVo> records=res.getRecords();
        //List<AchvAuthorTypeVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteAchvAuthorType(BaseDto baseDto) {
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
