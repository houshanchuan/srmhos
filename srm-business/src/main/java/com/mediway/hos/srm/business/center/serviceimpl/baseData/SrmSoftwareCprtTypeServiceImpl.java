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

import com.mediway.hos.srm.business.center.model.dto.baseData.SoftwareCpRtTypeDto;
import com.mediway.hos.srm.business.center.model.entity.baseData.SrmSoftwareCprtType;
import com.mediway.hos.srm.business.center.mapper.baseData.SrmSoftwareCprtTypeMapper;
import com.mediway.hos.srm.business.center.model.vo.baseData.SoftwareCpRtTypeVo;
import com.mediway.hos.srm.business.center.service.baseData.SrmSoftwareCprtTypeService;


/**
 * <p>
 * 软著类型 服务实现类
 * </p>
 *
 * @author 代码生成器
 * @since 2024-09-25
 */
@Service
public class SrmSoftwareCprtTypeServiceImpl extends BaseServiceImpl<SrmSoftwareCprtTypeMapper, SrmSoftwareCprtType> implements SrmSoftwareCprtTypeService {
    @Autowired
    private SrmSoftwareCprtTypeService  srmSoftwareCprtTypeService;
    @Autowired
    private SrmSoftwareCprtTypeMapper srmSoftwareCprtTypeMapper;
    private Long RowId;
    @Override
    @Transactional
    public Long saveOrUpdateSoftwareCprtType(BaseDataLearningDto baseDataLearningDto) {
        List<SoftwareCpRtTypeDto> softwareCprtTypeDtos =baseDataLearningDto.getSoftwareCpRtTypes();

        List<SrmSoftwareCprtType> softwareCprtTypeList=new ArrayList<>();
        for (SoftwareCpRtTypeDto softwareCpRtTypeDto :softwareCprtTypeDtos) {
            SrmSoftwareCprtType srmSoftwareCprtType = new SrmSoftwareCprtType();
            srmSoftwareCprtType.setId(softwareCpRtTypeDto.getRowId());
            srmSoftwareCprtType.setCode(softwareCpRtTypeDto.getCode());
            srmSoftwareCprtType.setName(softwareCpRtTypeDto.getName());
            srmSoftwareCprtType.setIsValid(Integer.valueOf(softwareCpRtTypeDto.getIsValid()));

            softwareCprtTypeList.add(srmSoftwareCprtType);
            Long RowId = srmSoftwareCprtType.getId();
        }
        super.saveOrUpdateBatch(softwareCprtTypeList);
        return RowId;
    }
    @Override
    public SoftwareCpRtTypeVo getDetailSoftwareCprtType(Long RowId) {
        return null;
    }

    @Override
    public IPage<SoftwareCpRtTypeVo> listSoftwareCprtType(SoftwareCpRtTypeDto softwareCprtTypeDto) {
        Page<SoftwareCpRtTypeVo> page = new Page<>(softwareCprtTypeDto.getPage(), softwareCprtTypeDto.getRows());
        IPage<SoftwareCpRtTypeVo> res= srmSoftwareCprtTypeMapper.listSoftwareCprtType(page, softwareCprtTypeDto);
        //List<SoftwareCprtTypeVo> records=res.getRecords();
        //List<SoftwareCprtTypeVo> newRecords=new ArrayList<>();
        //res.setRecords(newRecords);
        return res;
    }

    @Override
    public void deleteSoftwareCprtType(BaseDto baseDto) {
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
